/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.MerchantBaseFhDaoImpl;
import com.yada.ssp.model.MerchantBaseFh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Service
public class MerchantBaseFhManager extends BaseService<MerchantBaseFh, String> {
    @Autowired
    private MerchantBaseFhDaoImpl merchantBaseFhDao;
    @Override
    protected BaseDao<MerchantBaseFh, String> getBaseDao() {
        // TODO Auto-generated method stub
        return merchantBaseFhDao;
    }
    @Autowired
    private   MerchantGrpLsManager merchantGrpLsManager;

    public void updateSendStatus(String merchantId,String sendStatus){
        merchantBaseFhDao.updateSendStatus(merchantId,sendStatus);
    }

    public int updates(String state,String merchantId){
        return merchantBaseFhDao.updates(state,merchantId);
    }
}
