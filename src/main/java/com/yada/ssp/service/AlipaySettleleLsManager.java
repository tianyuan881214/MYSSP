package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.AlipaySettleLsDaoImpl;
import com.yada.ssp.model.AlipaySettleLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/9.
 */
@Service
public class AlipaySettleleLsManager extends BaseService<AlipaySettleLs,String>{
    @Autowired
    private AlipaySettleLsDaoImpl alipaySettleLsDao;

    @Override
    protected BaseDao<AlipaySettleLs, String> getBaseDao() {
        return alipaySettleLsDao;
    }
}
