package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.AlipaySettleSumLsDaoImpl;
import com.yada.ssp.model.AlipaySettleSumLs;
import com.yada.ssp.query.AlipaySettleSumLsQuery;
import com.yada.ssp.reportModel.AlipaySettleSumLsReportQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xianyong
 */
@Service
public class AlipaySettleSumLsManager extends BaseService<AlipaySettleSumLs,String>{
    @Autowired
    private AlipaySettleSumLsDaoImpl alipaySettleSumLsDao;
    @Override
    protected BaseDao<AlipaySettleSumLs, String> getBaseDao() {
        return alipaySettleSumLsDao;
    }

    public List<AlipaySettleSumLs> findAll(AlipaySettleSumLsQuery query){
        return alipaySettleSumLsDao.findAll(query);
    }
}
