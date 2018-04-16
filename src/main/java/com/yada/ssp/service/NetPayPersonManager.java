package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.NetPayPersonDaoImpl;
import com.yada.ssp.model.NetPayPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xianyong
 */
@Service
public class NetPayPersonManager extends BaseService<NetPayPerson, String> {
    @Autowired
    private NetPayPersonDaoImpl netPayPersonDao;

    protected BaseDao<NetPayPerson, String> getBaseDao() {
        return netPayPersonDao;
    }

    public NetPayPerson findByUserIdAndMerchant(String merchant, String userId) {
        NetPayPerson netPayPerson = new NetPayPerson();
        netPayPerson.setMerchant(merchant);
        netPayPerson.setUserId(userId);
        return netPayPersonDao.findByUserIdAndMerchant(netPayPerson);
    }
    public NetPayPerson deleteByUserIdAndMerchant(String merchant, String userId) {
        NetPayPerson netPayPerson = new NetPayPerson();
        netPayPerson.setMerchant(merchant);
        netPayPerson.setUserId(userId);
        return netPayPersonDao.deleteByUserIdAndMerchant(netPayPerson);
    }
}
