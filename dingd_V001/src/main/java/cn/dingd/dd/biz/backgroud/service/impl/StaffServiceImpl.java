package cn.dingd.dd.biz.backgroud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.dingd.dd.biz.backgroud.dao.AccountRoleMapper;
import cn.dingd.dd.biz.backgroud.dao.DataRangeMapper;
import cn.dingd.dd.biz.backgroud.dao.OrganizationInfoMapper;
import cn.dingd.dd.biz.backgroud.dao.StaffInfoMapper;
import cn.dingd.dd.biz.backgroud.service.StaffService;
import cn.dingd.dd.biz.common.entity.AccountRole;
import cn.dingd.dd.biz.common.entity.AccountRoleExample;
import cn.dingd.dd.biz.common.entity.DataRange;
import cn.dingd.dd.biz.common.entity.DataRangeExample;
import cn.dingd.dd.biz.common.entity.OrganizationInfo;
import cn.dingd.dd.biz.common.entity.StaffInfo;
import cn.dingd.dd.biz.common.entity.StaffInfoExample;
import cn.dingd.dd.biz.common.view.AccountRoleView;
import cn.dingd.dd.biz.common.view.StaffInfoView;
import cn.dingd.dd.common.util.MD5Util;
import cn.dingd.dd.common.util.StringUtils;

/**
* @author ZC
* @date 2018年4月27日上午10:36:49
*/
@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	private StaffInfoMapper staffInfoMapper;
	
	@Autowired
	private AccountRoleMapper accountRoleMapper;
	
	@Autowired
	private DataRangeMapper dataRangeMapper;
	
	@Autowired
	private OrganizationInfoMapper organizationInfo;

	@Value("#{configProperties['salt']}")
	private String salt;
	
	
	/**
	 * 新增员工
	 */
	@Override
	@Transactional(rollbackFor={Exception.class})
	public void addStaff(StaffInfo staffInfo, String  roles, String datas) {
		staffInfo.setuPassword(MD5Util.shiroMd5Salt(staffInfo.getuPassword(), salt));
		int flag = staffInfoMapper.insertSelective(staffInfo);		
		if (flag==1) {
			List<AccountRole> accountRoles = new ArrayList<>();
			List<DataRange> dataRanges = new ArrayList<>();
			dataMap(staffInfo, roles, datas, accountRoles, dataRanges);
			accountRoleMapper.addAccountRoles(accountRoles);
			dataRangeMapper.addDataRanges(dataRanges);
		}
	}
	
	/**
	 * 编辑
	 */
	@Override
	@Transactional(rollbackFor={Exception.class})
	public void updateStaff(StaffInfo staffInfo, String  roles, String datas) {
		int flag = staffInfoMapper.updateByPrimaryKeySelective(staffInfo);		
		if (flag==1) {
			List<AccountRole> accountRoles = new ArrayList<>();
			List<DataRange> dataRanges = new ArrayList<>();
			dataMap(staffInfo, roles, datas, accountRoles, dataRanges);
			AccountRoleExample accountRoleExample = new AccountRoleExample();
			accountRoleExample.createCriteria().andStaffIdEqualTo(staffInfo.getId());
			DataRangeExample dataRangeExample = new DataRangeExample();
			dataRangeExample.createCriteria().andStaffIdEqualTo(staffInfo.getId());
			accountRoleMapper.deleteByExample(accountRoleExample);
			accountRoleMapper.addAccountRoles(accountRoles);
			dataRangeMapper.deleteByExample(dataRangeExample);
			dataRangeMapper.addDataRanges(dataRanges);
		}
	}

	
	/**
	 * 获取账号信息列表
	 */
	@Override
	public List<StaffInfoView> getStaffInfos(String quaryParam) {
		if (StringUtils.isNotNullApp(quaryParam)) {
			quaryParam = "%"+quaryParam+"%";
		}
		//PageHelper.startPage(1, 1);
		List<StaffInfoView> accountInfos = staffInfoMapper.selectByQuaryParam(quaryParam);
		//PageInfo<StaffInfoView> pageInfo = new PageInfo<>(accountInfos);
		//accountInfos = pageInfo.getList();
		List<AccountRoleView> accountRoleMap = accountRoleMapper.accountRoleMap();
		Map<Integer, List<AccountRoleView>> collect = accountRoleMap.stream().collect(Collectors.groupingBy(AccountRoleView::getStaffId));
		for (StaffInfoView staffInfoView : accountInfos) {
			List<AccountRoleView> list = collect.get(staffInfoView.getId());
			String roleName = "";
			for (AccountRoleView AccountRoleView : list) {
				roleName =roleName + AccountRoleView.getRoleName()+"; ";
			}
			staffInfoView.setRoleName(roleName.substring(0, roleName.lastIndexOf("; ")));
		}
		//pageInfo.setList(accountInfos);
		
		return accountInfos;
	}
	
	@Override
	public StaffInfo staffByAccount(String account) {
		StaffInfoExample example = new StaffInfoExample() ;
		example.createCriteria().andAccountEqualTo(account);
		List<StaffInfo> selectByExample = staffInfoMapper.selectByExample(example);
		if (selectByExample.size()==1) {
			return selectByExample.get(0);
		}
		return null;
	}

	@Override
	public Boolean accountIsExist(String account) {
		StaffInfo staffByAccount = staffByAccount(account);
		if (staffByAccount==null) {
			return false;
		}
		return true;
	}
	
	/**
	 * 启停账号
	 */
	@Override
	public Integer disableorEnableAccount(Integer staffId) {
		return staffInfoMapper.disableorEnableAccount(staffId);
	}

	@Override
	public StaffInfoView staffByPrimaryKey(Integer staffId) {
		List<Integer> datas = dataRangeMapper.selectIdsByStaffId(staffId);
		StaffInfo staffInfo = staffInfoMapper.selectByPrimaryKey(staffId);
		List<Integer> roles = accountRoleMapper.selectRolesByStaff(staffId);
		StaffInfoView staffInfoView = new StaffInfoView();
		staffInfoView.setId(staffInfo.getId());
		staffInfoView.setAccount(staffInfo.getAccount());
		staffInfoView.setMailBox(staffInfo.getMailbox());
		staffInfoView.setuName(staffInfo.getuName());
		staffInfoView.setuPhone(staffInfo.getuPhone());
		staffInfoView.setuSex(staffInfo.getuSex());
		staffInfoView.setDatas(datas);
		staffInfoView.setRoles(roles);
		return staffInfoView;
	}
	
	@Override
	public List<OrganizationInfo> dataRange() {
		List<OrganizationInfo> selectByExample = organizationInfo.selectTree();
		Map<Integer, List<OrganizationInfo>> collect = selectByExample.stream().collect(Collectors.groupingBy(OrganizationInfo::getParentId));
		List<OrganizationInfo> list = collect.get(10000);
		Set<Integer> keySet = collect.keySet();
		Tree(collect, list, keySet);
		return list;
	}
	
	public void Tree(Map<Integer, List<OrganizationInfo>> collect, List<OrganizationInfo> list, Set<Integer> keySet) {
		for (OrganizationInfo index : list) {
			if (keySet.contains(index.getId())) {// 如果集合中有包含当前index的ID则获取集合为子节点
				index.setTreeList(collect.get(index.getId()));
				Tree(collect, index.getTreeList(), keySet);
			}
		}
	}
	
	/**
	 * 数据映射
	 * @param staffInfo
	 * @param roles
	 * @param datas
	 * @param accountRoles
	 * @param dataRanges
	 */
	private void dataMap(StaffInfo staffInfo, String roles, String datas, List<AccountRole> accountRoles,
			List<DataRange> dataRanges) {
		String[] split = roles.split(",");
		String[] split2 = datas.split(",");
		for (int i = 0; i < split.length; i++) {
			AccountRole accountRole = new AccountRole(staffInfo.getId(),Integer.valueOf(split[i]));
			accountRoles.add(accountRole);
		}
		for (int i = 0; i < split2.length; i++) {
			DataRange dataRange = new DataRange(staffInfo.getId(),Integer.valueOf(split2[i]));
			dataRanges.add(dataRange);
		}
	}

}
