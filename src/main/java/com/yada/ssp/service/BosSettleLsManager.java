package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.BosSettleLsDaoImpl;
import com.yada.ssp.model.BosSettleLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xianyong
 */
@Service
public class BosSettleLsManager extends BaseService<BosSettleLs, String> {
    @Autowired
    private BosSettleLsDaoImpl bosSettleLsDao;

    @Override
    protected BaseDao<BosSettleLs, String> getBaseDao() {
        return bosSettleLsDao;
    }
}
