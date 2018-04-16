package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.CurTranLsDaoImpl;
import com.yada.ssp.model.CurTranLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xianyong
 */
@Service
public class CurTranLsManager extends BaseService<CurTranLs,String> {
    @Autowired
    private CurTranLsDaoImpl curTranLsDao;
    @Override
    protected BaseDao<CurTranLs, String> getBaseDao() {
        return curTranLsDao;
    }
}
