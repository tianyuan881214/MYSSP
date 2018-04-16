package com.yada.ssp.service;


import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.WebchantMerchantBaseDaoImpl;
import com.yada.ssp.model.WebchantMerchantBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sun
 */
@Service
public class WebchantMerchantBaseManager extends BaseService<WebchantMerchantBase,String> {
    @Autowired
    private WebchantMerchantBaseDaoImpl webchantMerchantBaseDao;
    @Override
    protected BaseDao<WebchantMerchantBase, String> getBaseDao() {

        return webchantMerchantBaseDao;
    }
}
