package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.WebCheckFile;
import com.yada.ssp.query.WebCheckFileQuery;
import com.yada.ssp.reportModel.WebCheckFileReportQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xianyong
 */
@Component
public class WebCheckFileDaoImpl extends BaseDaoImpl<WebCheckFile,String>{

    public List<WebCheckFile> findAll(WebCheckFileQuery query){
        return getSqlSessionTemplate().selectList("WebCheckFile_findAll",query);
    }
}
