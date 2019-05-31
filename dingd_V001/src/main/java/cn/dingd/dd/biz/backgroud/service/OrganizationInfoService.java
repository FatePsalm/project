package cn.dingd.dd.biz.backgroud.service;

import cn.dingd.dd.biz.common.entity.OrganizationInfo;
import cn.dingd.dd.biz.common.entity.OrganizationInfoExample;
import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.web.JsonResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrganizationInfoService {
    List<StaffInfoEntity> selectHeadRight(Integer id);

    int updateHead(Integer id, List<Integer> list);

    Map<String, List<StaffInfoEntity>> selectHead(StaffInfoEntity staffInfoEntity, Integer id);

    int countByExample(OrganizationInfoExample example);

    int deleteByExample(OrganizationInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrganizationInfo record);

    int insertSelective(OrganizationInfo record);

    List<OrganizationInfo> selectByExample(OrganizationInfoExample example);

    OrganizationInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrganizationInfo record, @Param("example") OrganizationInfoExample example);

    int updateByExample(@Param("record") OrganizationInfo record, @Param("example") OrganizationInfoExample example);

    int updateByPrimaryKeySelective(OrganizationInfo record);

    int updateByPrimaryKey(OrganizationInfo record);

    List<OrganizationInfo> selectTree();

    List<OrganizationInfo> selectFull(OrganizationInfo or);

}