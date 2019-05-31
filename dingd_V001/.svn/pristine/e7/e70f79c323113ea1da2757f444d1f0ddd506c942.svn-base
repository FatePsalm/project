package cn.dingd.dd.biz.backgroud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import cn.dingd.dd.biz.backgroud.service.OrganizationInfoService;
import cn.dingd.dd.biz.common.entity.StaffInfo;
import cn.dingd.dd.common.entity.StaffInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dingd.dd.biz.backgroud.dao.DataRangeMapper;
import cn.dingd.dd.biz.backgroud.service.BizCommonService;
import cn.dingd.dd.biz.backgroud.service.StaffService;
import cn.dingd.dd.biz.common.entity.DataRange;
import cn.dingd.dd.biz.common.entity.DataRangeExample;
import cn.dingd.dd.biz.common.entity.OrganizationInfo;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
* @author ZC
* @date 2018年4月28日上午11:28:50
*/
@Service
public class BizCommonServiceImpl implements BizCommonService{
	
	@Autowired
	private DataRangeMapper dataRangeMapper;
	
	@Autowired
	private StaffService staffService;

	@Autowired
	private OrganizationInfoService organizationInfoService;
	/**
	 * 数据范围id对应的员工id
	 */
	@Override
	public List<Integer> staffIdsInDataRange(List<Integer> orgIds) {
		DataRangeExample dataRangeExample = new DataRangeExample();
		dataRangeExample.createCriteria().andOrgIdIn(orgIds);
		List<DataRange> dataRanges = dataRangeMapper.selectByExample(dataRangeExample);
		List<Integer> staffIds = dataRanges.stream().map(DataRange::getStaffId).distinct().collect(Collectors.toList());
		return staffIds;
	}

    /**
	 * 是否为区域负责人
	 */
	public Boolean isAreaManager(Integer orgId,Integer staffId) {
        Map<String, List<StaffInfoEntity>> stringListMap = organizationInfoService.selectHead(null, orgId);//获取节点下负责人
        List<StaffInfoEntity> right = stringListMap.get("right");//获取右侧负责人页面
        if (right==null)
            return false;
        for (StaffInfoEntity index:right
             ) {
            if (staffId==index.getId()){
                return true;
            }
        }
        return false;
	}


	
	@Override
	public List<Integer> orgIdsInStaff(Integer staffId) {
		//
		DataRangeExample dataRangeExample = new DataRangeExample();
		dataRangeExample.createCriteria().andStaffIdEqualTo(staffId);
		//员工对应的数据范围id集合
		List<DataRange> selectByExample = dataRangeMapper.selectByExample(dataRangeExample);
		//员工对应的数据范围id集合
		List<Integer> orgIds = selectByExample.stream().map(DataRange::getOrgId).collect(Collectors.toList());
		List<Integer> orgIdsInStaff = new ArrayList<>();
		//数据范围集合
		List<OrganizationInfo> dataRange = staffService.dataRange();
		Map<Integer, List<OrganizationInfo>> collect = dataRange.stream().collect(Collectors.groupingBy(OrganizationInfo::getParentId));
		Set<Integer> keySet = collect.keySet();
		for (Integer integer : orgIds) {
			if (isAreaManager(integer,staffId)) {
				//循环组织id
				recursionAddId(collect, keySet, orgIdsInStaff, orgIds);
			}else {
				orgIdsInStaff.add(integer);
			}
		}
		return staffIdsInDataRange(orgIdsInStaff);
	}
	
	public void recursionAddId(Map<Integer, List<OrganizationInfo>> collect,Set<Integer> keySet,
			List<Integer> orgIdsInStaff,List<Integer> orgIds) {
		for (Integer integer : orgIds) {
			//如果有子集
			if (keySet.contains(integer)) {
				List<Integer> orgList = collect.get(integer).stream().map(OrganizationInfo::getId).collect(Collectors.toList());
				orgIdsInStaff.addAll(orgList);
				recursionAddId(collect, keySet, orgIdsInStaff, orgList);
			}else {
				orgIdsInStaff.add(integer);
			}
		}
	}
}
