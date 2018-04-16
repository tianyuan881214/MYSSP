package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.PayTranAlipayLs;
import com.yada.ssp.query.PayTranAilpayLsQuery;
import com.yada.ssp.reportModel.PayTranAlipayLsReportQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xianyong
 */
@Component
public class PayTranAlipayLsDaoImpl extends BaseDaoImpl<PayTranAlipayLs,String >{
    public List<PayTranAlipayLs> findAll(PayTranAilpayLsQuery query){
        return getSqlSessionTemplate().selectList("PayTranAlipayLs_findAll",query);
    }
}
