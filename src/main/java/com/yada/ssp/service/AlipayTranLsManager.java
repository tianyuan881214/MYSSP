package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.AlipayTranLsDaoImpl;
import com.yada.ssp.model.AlipayTranLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/10.
 */
@Service
public class AlipayTranLsManager extends BaseService<AlipayTranLs,String>{
    @Autowired
    private AlipayTranLsDaoImpl alipayTranLsDao;

    @Override
    protected BaseDao<AlipayTranLs, String> getBaseDao() {
        return alipayTranLsDao;
    }
}
