package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.EnterAiliMerchantDaoImpl;
import com.yada.ssp.model.EnterAiliMerchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xianyong
 */
@Service
public class EnterAiliMerchantManager extends BaseService<EnterAiliMerchant,String> {
    @Autowired
    private EnterAiliMerchantDaoImpl enterAiliMerchantDao;
    @Override
    protected BaseDao<EnterAiliMerchant, String> getBaseDao() {
        return enterAiliMerchantDao;
    }

    public void update(EnterAiliMerchant enterAiliMerchant){
        enterAiliMerchantDao.update(enterAiliMerchant);
    }
}

