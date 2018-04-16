package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.TranSummer;
import com.yada.ssp.query.TranSummerQuery;
import com.yada.ssp.reportModel.TranSummerReportQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xianyong
 */
@Component
public class TranSummerDaoImpl extends BaseDaoImpl<TranSummer,String> {
    public List<TranSummer> findAll(TranSummerQuery query){
        return getSqlSessionTemplate().selectList("TranSummer_findAll",query);
    }

}
