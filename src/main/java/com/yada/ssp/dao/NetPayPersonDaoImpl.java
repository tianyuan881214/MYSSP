package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.NetPayPerson;
import org.springframework.stereotype.Component;

/**
 * @author xianyong
 */
@Component
public class NetPayPersonDaoImpl extends BaseDaoImpl<NetPayPerson,String> {

    public NetPayPerson findByUserIdAndMerchant(NetPayPerson netPayPerson){
        return this.getSqlSessionTemplate().selectOne("NetPayPerson_getById",netPayPerson);
    }
    public NetPayPerson deleteByUserIdAndMerchant(NetPayPerson netPayPerson){
        return this.getSqlSessionTemplate().selectOne("NetPayPerson_delete",netPayPerson);
    }
}
