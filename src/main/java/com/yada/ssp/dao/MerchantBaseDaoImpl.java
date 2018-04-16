/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.MerchantBase;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class MerchantBaseDaoImpl extends BaseDaoImpl<MerchantBase,String>{

    public List<MerchantBase> findByZbank(String zbank){
        return getSqlSessionTemplate().selectList("MerchantBase_findByZbank",zbank);
    }

    public void updateSendStatus(String merchantId,String sendStatus){
        Map map = new HashMap();
        map.put("merchantId",merchantId);
        map.put("sendStatus",sendStatus);
        getSqlSessionTemplate().update("MerchantBase_updateSendStatus",map);
    }

    public List<MerchantBase> findListFh(){
        return getSqlSessionTemplate().selectList("findListFh");
    }

    public int updates(String state,String id){
        Map map = new HashMap();
        map.put("state",state);
        map.put("id",id);
        return this.getSqlSessionTemplate().update("MerchantBase_updates",map);
    }
}
