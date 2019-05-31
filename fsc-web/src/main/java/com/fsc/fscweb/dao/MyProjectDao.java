package com.fsc.fscweb.dao;

import com.fsc.fscweb.entity.MyProject;

import java.util.List;
import java.util.Map;

public interface MyProjectDao {
    /**
     * 作者: Solace
     * 时间: 2018/7/1 23:28
     * 功能: 每天定时递减项目天数
     * 参数:
     */
    void updateDays ();
    /**
      * 作者:  CG
      * 时间： 2018/7/4 16:31
      * 功能描述:查询项目参与信息
      */
    List<Map<String,Object>> participate(MyProject myProject);
}