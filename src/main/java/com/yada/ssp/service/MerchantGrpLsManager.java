package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.MerchantGrpLsDaoImpl;
import com.yada.ssp.model.MerchantGrpLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xianyong
 */
@Service
public class MerchantGrpLsManager extends BaseService<MerchantGrpLs, String> {
    @Autowired
    private MerchantGrpLsDaoImpl merchantGrpLsDao;

    @Override
    protected BaseDao<MerchantGrpLs, String> getBaseDao() {
        return merchantGrpLsDao;
    }

    public List<MerchantGrpLs> getmerchantList(){
        return merchantGrpLsDao.getmerchantList();
    }
}
