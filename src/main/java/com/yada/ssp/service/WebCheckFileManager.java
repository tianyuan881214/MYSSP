package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.WebCheckFileDaoImpl;
import com.yada.ssp.model.WebCheckFile;
import com.yada.ssp.query.WebCheckFileQuery;
import com.yada.ssp.reportModel.WebCheckFileReportQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sun
 */
@Service
public class WebCheckFileManager extends BaseService<WebCheckFile, String> {
    @Autowired
    private WebCheckFileDaoImpl webCheckFileDao;

    @Override
    protected BaseDao<WebCheckFile, String> getBaseDao() {
        return webCheckFileDao;
    }

    public List<WebCheckFile> findAll(WebCheckFileQuery query) {
        return webCheckFileDao.findAll(query);
    }
}
