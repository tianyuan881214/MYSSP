package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.ErrorTranLs;
import com.yada.ssp.query.ErrorTranLsQuery;
import com.yada.ssp.query.ErrorTranLsReportQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xianyong
 */
@Component
public class ErrorTranLsDaoImpl extends BaseDaoImpl<ErrorTranLs, String> {

    public List<ErrorTranLs> findAll(ErrorTranLsReportQuery query){
        return getSqlSessionTemplate().selectList("ErrorTranLs_findAll",query);
    }
}
