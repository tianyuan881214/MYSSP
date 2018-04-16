package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.AlpConfigParamDaoImpl;
import com.yada.ssp.model.AlpConfigParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xianyong
 */
@Service
public class AlpConfigParamManager extends BaseService<AlpConfigParam,String>{
    @Autowired
    private AlpConfigParamDaoImpl alpConfigParamDao;
    @Override
    protected BaseDao<AlpConfigParam, String> getBaseDao() {
        return alpConfigParamDao;
    }

    public AlpConfigParam findAll(){
        return alpConfigParamDao.findAll();
    }

    public int updateList(AlpConfigParam alpConfigParam){
        return alpConfigParamDao.updateList(alpConfigParam);
    }
}
