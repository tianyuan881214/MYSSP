/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.MerchantBaseFh;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MerchantBaseFhDaoImpl extends BaseDaoImpl<MerchantBaseFh,String>{

    public List<MerchantBaseFh> findByZbank(String zbank){
        return getSqlSessionTemplate().selectList("MerchantBaseFh_findByZbank",zbank);
    }

    public void updateSendStatus(String merchantId,String sendStatus){
        Map map = new HashMap();
        map.put("merchantId",merchantId);
        map.put("sendStatus",sendStatus);
        getSqlSessionTemplate().update("MerchantBaseFh_updateSendStatus",map);
    }

    public int updates(String state,String merchantId){
        Map map = new HashMap();
        map.put("state",state);
        map.put("merchantId",merchantId);
        return this.getSqlSessionTemplate().update("MerchantBaseFh_updateSendStatus",map);
    }
}
