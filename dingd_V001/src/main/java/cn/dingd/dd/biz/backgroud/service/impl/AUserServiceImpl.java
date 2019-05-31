package cn.dingd.dd.biz.backgroud.service.impl;

import cn.dingd.dd.biz.backgroud.dao.AuserMapper;
import cn.dingd.dd.biz.backgroud.dao.DictionaryDao;
import cn.dingd.dd.biz.backgroud.service.AUserService;
import cn.dingd.dd.biz.common.entity.Auser;
import cn.dingd.dd.biz.common.entity.AuserExample;
import cn.dingd.dd.common.entity.CarDominantEntity;
import cn.dingd.dd.common.util.EX;
import cn.dingd.dd.common.util.Variable;
import cn.dingd.dd.common.web.PageObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AUserServiceImpl implements AUserService {
    @Autowired
    private AuserMapper auserMapper;
    @Autowired
    private DictionaryDao dictionaryDao;

    @Override
    public int countByExample(AuserExample example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteByExample(AuserExample example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int deleteByPrimaryKey = 0;
        try {
            deleteByPrimaryKey = auserMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        return deleteByPrimaryKey;
    }

    @Override
    public int insert(Auser record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insertSelective(Auser record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Auser> selectByExample(AuserExample example) {
        List<Auser> selectByExample = null;
        try {
            selectByExample = auserMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        return selectByExample;
    }

    @Override
    public Auser selectByPrimaryKey(Integer id) {

        return auserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Auser record, AuserExample example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateByExample(Auser record, AuserExample example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Auser record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Auser record) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public Map<String, Object> selectFind(Auser auser, PageObject pageObject) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        List<Map<String, Object>> selectFind = null;
        Page<Object> objects = null;
        try {
            objects = PageHelper.startPage(pageObject.getPageCurrent(), pageObject.getPageSize());
            selectFind = auserMapper.selectFind(auser);
            pageObject.setRowCount((int) objects.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        stringObjectHashMap.put("list", selectFind);
        stringObjectHashMap.put("pageObject", pageObject);
        return stringObjectHashMap;
    }

    /**
     * 获取商户详细信息
     */
    @SuppressWarnings("rawtypes")
    @Override
    public List getAuserAddres(int id) {
        List selectFind = null;
        try {
            selectFind = auserMapper.getAuserAddres(id);
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        return selectFind;
    }

}
