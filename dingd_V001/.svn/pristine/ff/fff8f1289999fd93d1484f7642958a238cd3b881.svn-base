package cn.dingd.dd.biz.backgroud.dao;

import cn.dingd.dd.biz.common.entity.DataRange;
import cn.dingd.dd.biz.common.entity.DataRangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataRangeMapper {
    int countByExample(DataRangeExample example);

    int deleteByExample(DataRangeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DataRange record);

    int insertSelective(DataRange record);

    List<DataRange> selectByExample(DataRangeExample example);

    DataRange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DataRange record, @Param("example") DataRangeExample example);

    int updateByExample(@Param("record") DataRange record, @Param("example") DataRangeExample example);

    int updateByPrimaryKeySelective(DataRange record);

    int updateByPrimaryKey(DataRange record);
    
    /**
     * 添加账号=对应的数据范围
     * @param dataRanges
     * @return
     */
	int addDataRanges(List<DataRange> dataRanges);
	
	List<Integer> selectIdsByStaffId(Integer staffId);
}