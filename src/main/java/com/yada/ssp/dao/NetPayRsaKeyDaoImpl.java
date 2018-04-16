package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.NetPayRsaKey;
import org.springframework.stereotype.Component;

/**
 * @author xianyong
 */
@Component
public class NetPayRsaKeyDaoImpl extends BaseDaoImpl<NetPayRsaKey,String> {

    public String findByMaxKeyVersion(){
        return this.getSqlSessionTemplate().selectOne("NetPayRsaKey_findByMaxKeyVersion");
    }
}
