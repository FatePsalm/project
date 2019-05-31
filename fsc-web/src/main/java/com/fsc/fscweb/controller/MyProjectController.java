package com.fsc.fscweb.controller;


import com.fsc.fscweb.entity.MyProject;
import com.fsc.fscweb.entity.UserName;
import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.service.MyProjectService;
import com.fsc.fscweb.service.TokenService;
import com.fsc.fscweb.util.CommonUtil;
import com.fsc.fscweb.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 作者: Solace
 * 时间: 2018/7/1 17:03
 * 功能: 项目相关
 * 参数:
 */
@RestController
@CrossOrigin
@RequestMapping("ZcPUkjyzGrjyNhU1HXQz7GP7Y8jXeeAINmxaPm6RySKO4C3GQ5VXZV2glpW9xABrBkjNn3Ya16mnTQ2vrYhUJVMtZDePZ6jIXST")
public class MyProjectController {
    @Autowired
    private MyProjectService myProjectService;
    @Autowired
    private TokenService tokenService;
    /**
      * 作者:  CG
      * 时间： 2018/7/4 16:27
      * 功能描述:参与记录
      */
    @RequestMapping("participate")
    public JsonResult participate(){
        List<Map<String, Object>> participate = myProjectService.participate();
        return new JsonResult(participate);
    }
    /**
     * 作者: Solace
     * 时间: 2018/7/3 23:42
     * 功能: 认购代币(认购最新一期的项目)
     * 参数:
     */
    @RequestMapping("mySubscription")
    public JsonResult  mySubscription(Integer myNumber){
        if (CommonUtil.checkNumber(myNumber))
            throw new IsConformException("认购数量不正确!");
        UserName userLogin = tokenService.getUserLogin();
        MyProject newProject = myProjectService.getNewProject();
        if (newProject.getProjectTarget()<myNumber)
            throw new IsConformException("筹集目标剩余数量不足!");
        Boolean aBoolean = myProjectService.mySubscription(userLogin, newProject, myNumber);
        return new JsonResult(aBoolean);
    }
    /**
     * 作者: Solace
     * 时间: 2018/7/1 17:39
     * 功能: 获取最新项目
     * 参数:
     */
    @RequestMapping("getNewProject")
    public JsonResult getNewProject() {
        MyProject newProject = myProjectService.getNewProject();
        return new JsonResult(newProject);
    }
/**
 * 作者: Solace
 * 时间: 2018/7/1 17:07
 * 功能: 新增项目信息
 * 参数:
 */
@RequestMapping("addProject")
public JsonResult addProject(MyProject myProject) {
    if (CommonUtil.checkStr(myProject.getProjectName()))
        throw new IsConformException("项目名称不正确!");
    if (CommonUtil.checkStr(myProject.getMoneyType()))
        throw new IsConformException("货币类型不正确!");
    if (CommonUtil.checkNumber(myProject.getProjectTarget()))
        throw new IsConformException("筹集目标不正确!");
    if (CommonUtil.checkNumber(myProject.getRemainingDays()))
        throw new IsConformException("剩余天数不正确!");
    if (CommonUtil.checkNumber(myProject.getRemainingDays()))
        throw new IsConformException("剩余天数不正确!");
    myProject.setSupportNumber(0);
    myProject.setCollectionNumber(0);
    myProject.setCreationTime(new Date());
    Boolean aBoolean = myProjectService.addProject(myProject);
    return new JsonResult(aBoolean);
}
@RequestMapping("updateProject")
public JsonResult updateProject(MyProject myProject) {
    if (CommonUtil.checkNumber(myProject.getId()))
        throw new IsConformException("项目ID不正确!");
    /*if (CommonUtil.checkStr(myProject.getProjectName()))
        throw new IsConformException("项目名称不正确!");
    if (CommonUtil.checkStr(myProject.getMoneyType()))
        throw new IsConformException("货币类型不正确!");
    if (CommonUtil.checkNumber(myProject.getProjectTarget()))
        throw new IsConformException("筹集目标不正确!");
    if (CommonUtil.checkNumber(myProject.getRemainingDays()))
        throw new IsConformException("剩余天数不正确!");
    if (CommonUtil.checkNumber(myProject.getSupportNumber()))
        throw new IsConformException("支持人数不正确!");
    if (CommonUtil.checkNumber(myProject.getCollectionNumber()))
        throw new IsConformException("募捐数不正确!");*/
    Boolean aBoolean = myProjectService.updateProject(myProject);
    return new JsonResult(aBoolean);
}
}
