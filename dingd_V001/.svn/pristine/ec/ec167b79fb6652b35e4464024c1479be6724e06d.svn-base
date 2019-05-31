package cn.dingd.dd.biz.backgroud.dao;

import cn.dingd.dd.biz.common.entity.StaffInfo;
import cn.dingd.dd.biz.common.entity.StaffInfoExample;
import cn.dingd.dd.biz.common.view.StaffInfoView;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffInfoMapper {
    int countByExample(StaffInfoExample example);

    int deleteByExample(StaffInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StaffInfo record);

    int insertSelective(StaffInfo record);

    List<StaffInfo> selectByExample(StaffInfoExample example);

    StaffInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StaffInfo record, @Param("example") StaffInfoExample example);

    int updateByExample(@Param("record") StaffInfo record, @Param("example") StaffInfoExample example);

    int updateByPrimaryKeySelective(StaffInfo record);

    int updateByPrimaryKey(StaffInfo record);
    
    /**
     * 根据查询参数获取账号信息列表
     * @return
     */
	List<StaffInfoView> selectByQuaryParam(@Param("quaryParam")String quaryParam);
	
	/**
	 * 启停账号
	 * @param staffId
	 * @return
	 */
	int disableorEnableAccount(Integer staffId);
}