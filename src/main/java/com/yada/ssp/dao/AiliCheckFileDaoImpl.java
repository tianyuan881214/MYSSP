package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.AiliCheckFile;
import com.yada.ssp.query.AiliCheckFileQuery;
import com.yada.ssp.reportModel.AlpCheckFile;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @author xianyong
 */
@Component
public class AiliCheckFileDaoImpl extends BaseDaoImpl<AiliCheckFile,String> implements Serializable{
    private static final long serialVersionUID = 7246014414369081664L;

    public AiliCheckFile findByTradeNoAndTranTypeAndCreateDate(AiliCheckFileQuery Query){
        return getSqlSessionTemplate().selectOne("AiliCheckFile_findByTradeNoAndTranTypeAndCreateDate",Query);
    }

    public List<AiliCheckFile> findAll(AiliCheckFileQuery Query){
        return this.getSqlSessionTemplate().selectList("AiliCheckFile_findAll",Query);
    }
}
