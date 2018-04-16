package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.AlipaySettleSumLs;
import com.yada.ssp.query.AlipaySettleSumLsQuery;
import com.yada.ssp.reportModel.AlipaySettleSumLsReportQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xianyong
 */
@Component
public class AlipaySettleSumLsDaoImpl extends BaseDaoImpl<AlipaySettleSumLs,String> {
    public List<AlipaySettleSumLs> findAll(AlipaySettleSumLsQuery query){
        return getSqlSessionTemplate().selectList("AlipaySettleSumLs_findAll",query);
    }
}
