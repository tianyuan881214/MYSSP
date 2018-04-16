package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.TranSummerDaoImpl;
import com.yada.ssp.model.TranSummer;
import com.yada.ssp.query.TranSummerQuery;
import com.yada.ssp.reportModel.TranSummerReportQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xianyong
 */
@Service
public class TranSummerManager extends BaseService<TranSummer, String> {
    @Autowired
    private TranSummerDaoImpl tranSummerDao;

    @Override
    protected BaseDao<TranSummer, String> getBaseDao() {
        return tranSummerDao;
    }

    public List<TranSummer> findAll(TranSummerQuery query){
        return tranSummerDao.findAll(query);
    }
}
