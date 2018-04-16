package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.VAlpBocStlDaoImpl;
import com.yada.ssp.model.VAlpBocStl;
import com.yada.ssp.query.VAlpBocStlQuery;
import com.yada.ssp.reportModel.VAlpBocStlModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xianyong
 */
@Service
public class VAlpBocStlManager extends BaseService<VAlpBocStl,String> {
    @Autowired
    private VAlpBocStlDaoImpl vAlpBocStlDao;
    @Override
    protected BaseDao<VAlpBocStl, String> getBaseDao() {
        return vAlpBocStlDao;
    }

    public List<VAlpBocStl> findAll(VAlpBocStlQuery query){
        return vAlpBocStlDao.findAll(query);
    }
}
