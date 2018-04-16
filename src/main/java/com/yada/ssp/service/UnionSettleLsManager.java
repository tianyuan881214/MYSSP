package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.AiliCheckFileDaoImpl;
import com.yada.ssp.dao.UnionSettleLsDaoImpl;
import com.yada.ssp.model.AiliCheckFile;
import com.yada.ssp.model.AlipaySettleSumLs;
import com.yada.ssp.model.UnionSettleLs;
import com.yada.ssp.query.AiliCheckFileQuery;
import com.yada.ssp.query.AlipaySettleSumLsQuery;
import com.yada.ssp.query.UnionSettleLsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author xianyong
 */
@Service
public class UnionSettleLsManager extends BaseService<UnionSettleLs,String> {
    @Autowired
    private UnionSettleLsDaoImpl unionSettleLsDao;

    @Override
    protected BaseDao<UnionSettleLs, String> getBaseDao() {
        return unionSettleLsDao;
    }

    public List<UnionSettleLs> findAll(){
        return unionSettleLsDao.findAll();
    }
}
