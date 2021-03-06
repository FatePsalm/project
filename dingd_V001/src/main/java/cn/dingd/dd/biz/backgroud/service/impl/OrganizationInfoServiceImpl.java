package cn.dingd.dd.biz.backgroud.service.impl;

import cn.dingd.dd.biz.backgroud.dao.OrganizationInfoMapper;
import cn.dingd.dd.biz.backgroud.service.OrganizationInfoService;
import cn.dingd.dd.biz.common.entity.OrganizationInfo;
import cn.dingd.dd.biz.common.entity.OrganizationInfoExample;
import cn.dingd.dd.biz.common.entity.OrganizationInfoExample.Criteria;
import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.util.CF;
import cn.dingd.dd.common.util.EX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年4月24日 下午4:35:07 类说明
 */
@Service
public class OrganizationInfoServiceImpl implements OrganizationInfoService {
    private Integer Level = 0;

    @Autowired
    private OrganizationInfoMapper organizationInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHead(Integer id, List<Integer> list) {
        int updateInt=0;
        try {
             organizationInfoMapper.deleteHead(id);
            if (list.size()!=0) {//插入负责人数据
                updateInt = organizationInfoMapper.updateHead(id,list);
            }else {//如果负责人等于零则不插入数据
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        if (updateInt!=list.size())
            throw new NullPointerException("保存信息不完整!");
        return 1;
    }

    @Override
    /**
     * 时间: 2018/4/27 18:32
     * 功能描述:查询左边
     */
    public Map<String, List<StaffInfoEntity>> selectHead(StaffInfoEntity staffInfoEntity, Integer id) {
        HashMap<String, List<StaffInfoEntity>> stringListHashMap = new HashMap<>();
        List<StaffInfoEntity> left = null;//左边
        List<StaffInfoEntity> right = null;//右边
        try {
            left = organizationInfoMapper.selectHead(staffInfoEntity);//查询左边
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        right = selectHeadRight(id);
        if(right!=null){
            Set<Integer> collect = right.stream()
                    .map(StaffInfoEntity::getId).collect(Collectors.toSet());
            for(int i=0;i<left.size();i++){
                if (collect.contains(left.get(i).getId())) {
                    left.remove(i);
                }
            }
        }
        stringListHashMap.put("left", left);
        stringListHashMap.put("right", right);
        return stringListHashMap;
    }

    /**
     * 时间: 2018/4/27 18:32
     * 功能描述:查询右边
     */
    public List<StaffInfoEntity> selectHeadRight(Integer id) {
        List<StaffInfoEntity> integers = null;
        try {
            integers = organizationInfoMapper.selectHeadRight(id);
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        return integers;
    }

    @Override
    public int countByExample(OrganizationInfoExample example) {
        // 2018年4月24日TODO
        return 0;
    }

    @Override
    public int deleteByExample(OrganizationInfoExample example) {
        // 2018年4月24日TODO
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        // 2018年4月24日TODO
        return 0;
    }

    @Override
    public int insert(OrganizationInfo record) {
        int insert = 0;
        try {
            insert = organizationInfoMapper.insert(record);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            EX.mysqlE();
        }
        return insert;
    }

    @Override
    public int insertSelective(OrganizationInfo record) {
        // 2018年4月24日TODO
        return 0;
    }

    @Override
    public List<OrganizationInfo> selectByExample(OrganizationInfoExample example) {
        List<OrganizationInfo> selectByExample = null;
        try {
            selectByExample = organizationInfoMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        return selectByExample;
    }

    @Override
    public OrganizationInfo selectByPrimaryKey(Integer id) {
        OrganizationInfo selectByPrimaryKey = null;
        try {
            selectByPrimaryKey = organizationInfoMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        return selectByPrimaryKey;
    }

    @Override
    public int updateByExampleSelective(OrganizationInfo record, OrganizationInfoExample example) {
        // 2018年4月24日TODO
        return 0;
    }

    @Override
    public int updateByExample(OrganizationInfo record, OrganizationInfoExample example) {
        // 2018年4月24日TODO
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(OrganizationInfo record) {
        // 2018年4月24日TODO
        return 0;
    }

    @Override
    public int updateByPrimaryKey(OrganizationInfo record) {
        int updateByPrimaryKey = 0;
        try {
            updateByPrimaryKey = organizationInfoMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        return updateByPrimaryKey;
    }

    @Override
    public List<OrganizationInfo> selectTree() {
        List<OrganizationInfo> selectTree = null;
        try {
            selectTree = organizationInfoMapper.selectTree();
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        if (selectTree == null) {
            return new ArrayList<OrganizationInfo>();
        }
        ArrayList<OrganizationInfo> arrayList = new ArrayList<OrganizationInfo>();
        Map<Integer, List<OrganizationInfo>> collect = selectTree.stream()
                .collect(Collectors.groupingBy(OrganizationInfo::getParentId));
        Set<Integer> keySet = collect.keySet();
        List<OrganizationInfo> father = collect.get(0);// 父节点
        Tree(collect, father, keySet);
        List<OrganizationInfo> peersTree = peersTree(father, arrayList);
        return peersTree;
    }

    /**
     * @param collect 全部集合
     * @param list    父节点
     * @param keySet  分组集合 生成树形图
     */
    public void Tree(Map<Integer, List<OrganizationInfo>> collect, List<OrganizationInfo> list, Set<Integer> keySet) {
        for (OrganizationInfo index : list) {
            if (keySet.contains(index.getId())) {// 如果集合中有包含当前index的ID则获取集合为子节点
                index.setTreeList(collect.get(index.getId()));
                Tree(collect, index.getTreeList(), keySet);
            }
        }
    }

    /**
     * @param father    父节点
     * @param arrayList 平级节点
     * @return 生成平级树形图
     */
    public List<OrganizationInfo> peersTree(List<OrganizationInfo> father, List<OrganizationInfo> arrayList) {
        for (OrganizationInfo tree : father) {
            StringBuffer string = new StringBuffer("|");
            for (int i = 0; i < Level; i++) {
                string.append("-");
            }
            OrganizationInfo or = null;
            try {
                or = (OrganizationInfo) tree.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                throw new NullPointerException("克隆对象失败!");
            }
            or.setTreeList(null);// 去掉子节点
            if (tree.getParentId() != 0) {
                or.setName(string + tree.getName());
            } else {
                or.setName(tree.getName());
            }
            arrayList.add(or);
            if (tree.getTreeList() != null) {
                ++Level;
                peersTree(tree.getTreeList(), arrayList);
                --Level;
            }
        }
        return arrayList;
    }

    @Override
    public List<OrganizationInfo> selectFull(OrganizationInfo or) {
        OrganizationInfoExample example = new OrganizationInfoExample();// 生成查找实体
        Criteria criteria = example.createCriteria();// 生成查找条件
        criteria.andNameLike("%" + CF.isNullS(or.getFind()) + "%").andParentIdIsNotNull();// 查询条件拼接
        List<OrganizationInfo> selectFull = null;
        Set<Integer> collect = null;
        OrganizationInfoExample findAllExample = new OrganizationInfoExample();// 查找全部IS NOT NULL
        Criteria findAll = findAllExample.createCriteria();// 生成查找条件
        findAll.andParentIdIsNotNull();
        try {
            selectFull = selectByExample(findAllExample);// 返回全部
            collect = selectByExample(example).stream().map(OrganizationInfo::getId).collect(Collectors.toSet()); // 返回符合查找条件的
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        if (selectFull == null)
            return null;
        if (collect != null && or.getFind() != null) {//显示高亮
            for (OrganizationInfo index : selectFull) {
                if (collect.contains(index.getId()))
                    index.setFind("1");
            }
        }
        Map<Integer, List<OrganizationInfo>> collectTree = selectFull.stream()
                .collect(Collectors.groupingBy(OrganizationInfo::getParentId));
        List<OrganizationInfo> list = collectTree.get(0);
        Set<Integer> keySet = collectTree.keySet();
        Tree(collectTree, list, keySet);
        return list;
    }

}
