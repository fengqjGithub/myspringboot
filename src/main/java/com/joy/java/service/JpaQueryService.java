package com.joy.java.service;

import com.alibaba.fastjson.JSON;
import com.joy.java.bean.BkksBean;
import com.joy.java.dao.*;
import com.joy.java.entity.BasisMemberEn;
import com.joy.java.bean.TestBean;
import com.joy.java.entity.TjsjTjdierjbEn;
import com.joy.java.entity.TjsjTjdisanjbEn;
import com.joy.java.util.lang.JSONUtils;
import com.joy.java.util.lang.MyStringUtil;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project: myspringbootlearning
 * @Package: com.joy.java.service
 * @Author: 冯前进
 * @Date: 2018-05-11 9:18
 * @Description: TODO
 **/
@Service
public class JpaQueryService {
    @Autowired
    BasisMemberDao basisMemberDao;
    @Autowired
    TestBeanDao testBeanDao;
    @Resource
    TjsjTjdisanjbDao tjsjTjdisanjbDao;
    @Resource
    TjsjTjdierjbDao tjsjTjdierjbDao;
    @Resource
    TjsjTjdiyijbDao tjsjTjdiyijbDao;

    @PersistenceContext
    public EntityManager em;

    public String test0() {
        List<BasisMemberEn> list = basisMemberDao.findAll();
        for (BasisMemberEn en : list) {
            System.out.println(en.toString());
        }
        return JSON.toJSONString(list);
    }

    public String test1() {
        List<TestBean> s = testBeanDao.tests11();
        return JSON.toJSONString(s);
    }

    public String test2() {
        final Map<String, String> para = new HashMap<>();
        List<TjsjTjdierjbEn> resList = tjsjTjdierjbDao.findAll(new Specification<TjsjTjdierjbEn>() {
            @Override
            public Predicate toPredicate(Root<TjsjTjdierjbEn> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                String csno = para.get("csno");
                String xqno = para.get("xqno");
                String ksccno = para.get("ksccno");
                String tjlxno = para.get("tjlxno1");
                List<Predicate> list = new ArrayList<Predicate>();
                list.add(cb.equal(root.get("tjdierjb_tjlblxno").as(String.class), "4"));
                if (null != csno && !"".equals(csno)) {
                    list.add(cb.equal(root.get("tjdierjbCol1").as(String.class), csno));
                }
                if (null != ksccno && !"".equals(ksccno)) {
                    list.add(cb.equal(root.get("tjdierjb_col7").as(String.class), ksccno));
                }
                if (null != tjlxno && !"".equals(tjlxno)) {
                    list.add(cb.equal(root.get("tjdierjbTjlxno").as(String.class), tjlxno));
                }
                cb.asc(root.get("tjdierjb_col9"));
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        });
        return JSON.toJSONString(resList);
    }

    public String test3() {
        final Map<String, String> para = new HashMap<>();
        String pageTemp = para.get("page");
        String sizeTemp = para.get("size");
        Integer page = 1;
        Integer size = 10;
        if (!MyStringUtil.isBlankMy(pageTemp)) {
            page = Integer.parseInt(pageTemp);
        }
        if (!MyStringUtil.isBlankMy(sizeTemp)) {
            size = Integer.parseInt(sizeTemp);
        }
        Pageable pageable = new PageRequest(page - 1, size, Sort.Direction.ASC, "tjdisanjbCol1");
        Page<TjsjTjdisanjbEn> beans = tjsjTjdisanjbDao.findAll(new Specification<TjsjTjdisanjbEn>() {
            @Override
            public Predicate toPredicate(Root<TjsjTjdisanjbEn> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (MyStringUtil.isNotBlankMy(para.get("tjlx"))) {
                    list.add(cb.equal(root.get("tjdisanjbTjlxno").as(String.class), para.get("tjlx")));
                }
                //in查询
                List li = new ArrayList();
                li.add(3);
                li.add(4);
                list.add(root.get("tjdisanjbTjlblxno").as(String.class).in(li));
                if (MyStringUtil.isNotBlankMy(para.get("csNo"))) {
                    list.add(cb.equal(root.get("tjdisanjbCol1").as(String.class), para.get("csNo")));
                }
                if (MyStringUtil.isNotBlankMy(para.get("xqNo")) && !"0".equals(para.get("xqNo"))) {
                    list.add(cb.equal(root.get("tjdisanjb_col3").as(String.class), para.get("xqNo")));
                }
                if (MyStringUtil.isNotBlankMy(para.get("kcNo")) && !"AllKsccno".equals(para.get("kcNo"))) {
                    list.add(cb.equal(root.get("tjdisanjb_col5").as(String.class), para.get("kcNo")));
                }
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        }, pageable);
        return JSON.toJSONString(beans.getContent());
    }
    public String test4() {
        String bkksSql = "SELECT newid() as id, ks_ksno,ks_xm,ks_bmxh,ks_zkzh,ks_zjno,ks_xb,ks_lxrdh,ks_xjno,ks_sfks,kskscc_zw AS ks_zw,km_no,km_mc, "
                + " kscc_no,kscc_mc,kscc_kssj,kscc_jssj,kcss_no,kcss_mc,kcss_sx,kc_no,kc_mc,bmd_no,bmd_mc,ks_cjbj "
                + " FROM bk_ks LEFT JOIN bk_kskscc ON bk_kskscc.kskscc_ksid = bk_ks.ksid "
                + " LEFT JOIN zd_km ON bk_kskscc.kskscc_kmid = zd_km.kmid "
                + " LEFT JOIN zd_kscc ON zd_km.km_ksccid = zd_kscc.ksccid "
                + " LEFT JOIN qy_kcss ON bk_kskscc.kskscc_kcssid = qy_kcss.kcssid "
                + " LEFT JOIN qy_kc ON bk_kskscc.kskscc_kcid = qy_kc.kcid AND qy_kc.kcid = qy_kcss.kcss_kcid "
                + " LEFT JOIN qy_bmd ON qy_bmd.bmdid = bk_ks.ks_bmdid  where 1=1 ";
        Query query = em.createNativeQuery(bkksSql);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<BkksBean> dataList = query.getResultList();
        List<BkksBean> list;
        try {
            list =JSONUtils.fromJsonArray(JSONUtils.beanToJson(dataList), BkksBean.class);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return JSON.toJSONString(list);
    }
}
