package cn.dingd.dd.biz.backgroud.controller;

import cn.dingd.dd.biz.backgroud.service.SjOderService;
import cn.dingd.dd.biz.common.entity.StaffInfo;
import cn.dingd.dd.common.entity.CheckBillEntity;
import cn.dingd.dd.common.util.CF;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 作者:CG
 * 时间:2018年4月26日
 * 作用:商家订单
 */
@CrossOrigin
@RestController
@Controller
@RequestMapping("/sjdd/")
public class SjOderController {
    @Autowired
    private SjOderService sjOderService;
    /**
     * 时间: 2018/5/7 19:01
     * 功能描述:根据车辆ID查询-证件及其他票据
     */
    @RequestMapping("selectCarImg")
    public JsonResult selectCarImg(Integer id) {
        if (CF.isNum(id))
            throw new NullPointerException("车辆ID参数不正确!");
        Map<String, Object> map = sjOderService.selectCarImgGroup(id, null);
        return new JsonResult(map);
    }
    /**
     * 时间: 2018/5/7 15:21
     * 功能描述:根据车辆ID查询显性损伤
     */
    @RequestMapping("selectCarY")
    public JsonResult selectCarY(Integer id) {
        if (CF.isNum(id))
            throw new NullPointerException("车辆ID参数不正确!");
        Map<String, Object> map = sjOderService.selectCarY(id);
        return new JsonResult(map);
    }
    /**
     * 时间: 2018/5/7 15:21
     * 功能描述:根据车辆ID查询显性损伤
     */
    @RequestMapping("selectCarX")
    public JsonResult selectCarX(Integer id) {
        if (CF.isNum(id))
            throw new NullPointerException("车辆ID参数不正确!");
        Map<String, Object> map = sjOderService.selectCarX(id);
        return new JsonResult(map);
    }
    /**
     * 时间: 2018/5/4 14:11
     * 功能描述:根据车辆ID查询车辆综合评价和保留价
     */
    @RequestMapping("selectCarZH")
    public JsonResult selectCarZH(Integer carID) {
        if (CF.isNum(carID))
            throw new NullPointerException("车辆ID为NULL!");
        Map<String, Object> map = sjOderService.selectCarZH(carID);
        return new JsonResult(map);
    }

    /**
     * 时间: 2018/4/28 16:08
     * 功能描述:根据商家ID查询商家所有订单
     */
    @RequestMapping("selectIdALL")
    public JsonResult selectIdALL(Integer id ) {
        if (CF.isNum(id))
            throw new NullPointerException("商家ID为NULL!");
        List<CheckBillEntity> checkBillEntities = sjOderService.selectIdALL(id);
        return new JsonResult(checkBillEntities);
    }

    /**
     * 时间: 2018/4/28 14:22
     * 功能描述:检测订单详细
     */
    @RequestMapping("selectId")
    public JsonResult selectId(Integer id) {
        if (CF.isNum(id))
            throw new NullPointerException("查询订单ID为NULL!");
        Map<String, Object> stringObjectMap = sjOderService.selectId(id);
        return new JsonResult(stringObjectMap);
    }

    /**
     * 时间: 2018/4/27 16:32
     * 功能描述:查询商家端订单
     */
    @RequestMapping("selectFind")
    public JsonResult selectFind(CheckBillEntity checkBillEntity, PageObject pageObject, HttpServletRequest request) {
        HttpSession session = request.getSession();
        StaffInfo attribute = (StaffInfo) session.getAttribute("bizAccount");
        System.out.println(attribute.getId());
        if (attribute==null)
            throw new NullPointerException("未获取到登陆用户信息!");
        if (CF.isPage(pageObject))
            throw new NullPointerException("分页信息参数不正确!");
        if (CF.isNum(checkBillEntity.getCheckType()))
            throw new NullPointerException("订单来源为NULL!");
        Map<String, Object> map = sjOderService.selectFind(checkBillEntity, pageObject,attribute);
        return new JsonResult(map);
    }
}
