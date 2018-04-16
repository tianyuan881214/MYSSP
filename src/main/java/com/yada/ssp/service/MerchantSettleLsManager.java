package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.MerchantSettleLsDaoImpl;
import com.yada.ssp.model.MerchantSettleLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/12.
 */
@Service
public class MerchantSettleLsManager extends BaseService<MerchantSettleLs,String>{

    @Autowired
    private MerchantSettleLsDaoImpl merchantSettleLsDao;

    @Override
    protected BaseDao<MerchantSettleLs, String> getBaseDao() {
        System.out.println("dao层："+merchantSettleLsDao);
        System.out.println("serivce");
        return merchantSettleLsDao;
    }
}
