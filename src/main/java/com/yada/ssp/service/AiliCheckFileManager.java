package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.AiliCheckFileDaoImpl;
import com.yada.ssp.model.AiliCheckFile;
import com.yada.ssp.query.AiliCheckFileQuery;
import com.yada.ssp.reportModel.AlpCheckFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author xianyong
 */
@Service
public class AiliCheckFileManager extends BaseService<AiliCheckFile,java.lang.String> {
    @Autowired
    private AiliCheckFileDaoImpl ailiCheckFileDao;

    @Override
    protected BaseDao<AiliCheckFile, String> getBaseDao() {
        return ailiCheckFileDao;
    }

    public AiliCheckFile findByTradeNoAndTranTypeAndCreateDate(AiliCheckFileQuery Query){
        return ailiCheckFileDao.findByTradeNoAndTranTypeAndCreateDate(Query);
    }

    public List<AiliCheckFile> findAll(AiliCheckFileQuery Query){
        return ailiCheckFileDao.findAll(Query);
    }
}
