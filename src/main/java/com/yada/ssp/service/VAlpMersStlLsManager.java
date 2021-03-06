package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.VAlpMersStlLsDaoImpl;
import com.yada.ssp.model.VAlpMersStlLs;
import com.yada.ssp.reportModel.VAlpMersStlLsReportQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xianyong
 */
@Service
public class VAlpMersStlLsManager extends BaseService<VAlpMersStlLs,String> {
    @Autowired
    private VAlpMersStlLsDaoImpl vAlpMersStlLsDao;
    @Override
    protected BaseDao<VAlpMersStlLs, String> getBaseDao() {
        return vAlpMersStlLsDao;
    }

    public List<VAlpMersStlLs> findAll(VAlpMersStlLsReportQuery query){
        return vAlpMersStlLsDao.findAll(query);
    }
}
