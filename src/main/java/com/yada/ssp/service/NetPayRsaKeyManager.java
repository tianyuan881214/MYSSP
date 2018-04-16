package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.NetPayRsaKeyDaoImpl;
import com.yada.ssp.model.NetPayRsaKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xianyong
 */
@Service
public class NetPayRsaKeyManager extends BaseService<NetPayRsaKey, String> {
    @Autowired
    private NetPayRsaKeyDaoImpl netPayRsaKeyDao;

    protected BaseDao<NetPayRsaKey, String> getBaseDao() {
        return netPayRsaKeyDao;
    }

    public String findByMaxKeyVersion() {
        String keyVersion = netPayRsaKeyDao.findByMaxKeyVersion();
        Long count = 0l;
        if (keyVersion != null && !"".equals(keyVersion)) {
            count = Long.parseLong(keyVersion);
        }
        String keyVer = String.format("%02d", count + 1);
        return keyVer;
    }
}
