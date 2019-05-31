package cn.dingd.dd.biz.backgroud.controller;

import java.math.BigDecimal;
import java.util.*;

import cn.dingd.dd.common.entity.StaffInfoEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cn.dingd.dd.biz.backgroud.service.OrganizationInfoService;
import cn.dingd.dd.biz.common.entity.OrganizationInfo;
import cn.dingd.dd.common.util.CF;
import cn.dingd.dd.common.web.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Action;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年4月24日 下午4:20:09 类说明
*/
@CrossOrigin
@RestController
@Controller
@RequestMapping("/zzjg/")
public class OrganizationInfoController {
@Autowired
private OrganizationInfoService organizationInfoService;
/**
 * 时间: 2018/4/28 10:25
 * 功能描述:修改负责人
 */
@RequestMapping("updateHead")
public JsonResult updateHead(Integer id, HttpServletRequest request){
    String str =request.getParameter("list");
    List<Integer> list=new ArrayList<>();
    if (str!=null&&!str.equals("")){
        List<String> strings = Arrays.asList(str.split(","));
        for (String index: strings) {
            try {
                list.add(Integer.parseInt(index));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                throw new NullPointerException("负责人ID参数类型不正确!");
            }
        }
    }
    if (CF.isNum(id))
        throw  new NullPointerException("组织架构ID为NULL");
    organizationInfoService.updateHead(id, list);//保存数据
    return new JsonResult("保存完成!");
}

/**
 * 时间: 2018/4/27 16:40
 * 功能描述:查询编辑负责人
 */
@RequestMapping("selectHead")
public JsonResult selectHead(StaffInfoEntity staffInfoEntity,Integer id) {
    if (CF.isNum(id))
        throw new NullPointerException("组织架构ID为NULL!");
    Map<String, List<StaffInfoEntity>> stringListMap = organizationInfoService.selectHead(staffInfoEntity, id);
    return new JsonResult(stringListMap);
}
/**
 * 时间: 2018/5/3 12:00
 * 功能描述:更具树形图ID查询负责人
 */
@RequestMapping("selectOrgId")
public JsonResult selectOrgId(Integer id) {
    if (CF.isNum(id))
        throw new NullPointerException("组织架构ID为NULL!");
    List<StaffInfoEntity> staffInfoEntities = organizationInfoService.selectHeadRight(id);
    return new JsonResult(staffInfoEntities);
}
/**
 * 查询所有组织结构
 */
@RequestMapping("selectFull")
public JsonResult selectFull(OrganizationInfo or) {
    List<OrganizationInfo> selectFull = organizationInfoService.selectFull(or);
    return new JsonResult(selectFull);
}

/**
 * 更新组织结构
 */
@RequestMapping("updateByPrimaryKey")
public JsonResult updateByPrimaryKey(OrganizationInfo or) {
    if (CF.isNum(or.getId())) {
        throw new NullPointerException("组织ID为NULL!");
    } else if (CF.isStr(or.getName())) {
        throw new NullPointerException("组织名字为NULL!");
    } else if (CF.isStr(or.getOrgDesc())) {
        throw new NullPointerException("组织描述为NULL!");
    } else if (CF.isNum(or.getUpdAccountId()))
        throw new NullPointerException("操作员ID为NULL!");
    OrganizationInfo organizationInfo = new OrganizationInfo();
    organizationInfo.setId(or.getId());
    organizationInfo.setName(or.getName());
    organizationInfo.setOrgDesc(or.getOrgDesc());
    organizationInfo.setUpdAccountId(or.getUpdAccountId());
    organizationInfo.setUpdateTime(new Date());
    if (CF.mysqlSave(organizationInfoService.updateByPrimaryKey(organizationInfo)))
        throw new NullPointerException("更新失败!");
    return new JsonResult("更新成功!");
}

/**
 * 根据ID查询组织架构
 */
@RequestMapping("selectByPrimaryKey")
public JsonResult selectByPrimaryKey(Integer id) {
    if (CF.isNum(id))
        throw new NullPointerException("查询ID为NULL");
    OrganizationInfo selectByPrimaryKey = organizationInfoService.selectByPrimaryKey(id);
    return new JsonResult(selectByPrimaryKey);
}

/**
 * 新增组织架构
 */
@RequestMapping("insert")
public JsonResult insert(OrganizationInfo organizationInfo) {
    if (CF.isStr(organizationInfo.getName())) {
        throw new NullPointerException("组织名字为null!");
    } else if (CF.isNumZ(organizationInfo.getParentId())) {
        throw new NullPointerException("组织父级为null!");
    } else if (CF.isNum(organizationInfo.getAccountId()))
        throw new NullPointerException("创建人为null!");
    if (CF.mysqlSave(organizationInfoService.insert(organizationInfo)))
        throw new NullPointerException("保存失败!");
    return new JsonResult("保存成功!");
}

/**
 * 查询组织架构--Tree树
 */
@RequestMapping("selectTree")
public JsonResult selectTree() {
    List<OrganizationInfo> selectTree = organizationInfoService.selectTree();
    return new JsonResult(selectTree);
}
}
