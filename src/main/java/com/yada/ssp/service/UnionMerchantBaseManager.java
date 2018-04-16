package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.UnionMerchantBaseDaoImpl;
import com.yada.ssp.model.UnionMerchantBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/5.
 */
@Service
public class UnionMerchantBaseManager extends BaseService<UnionMerchantBase,String>{
    @Autowired
    private UnionMerchantBaseDaoImpl unionMerchantBaseDao;

    @Override
    protected BaseDao<UnionMerchantBase, String> getBaseDao() {
        return unionMerchantBaseDao;
    }


}
