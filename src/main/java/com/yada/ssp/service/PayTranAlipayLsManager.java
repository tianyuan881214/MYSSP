package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.PayTranAlipayLsDaoImpl;
import com.yada.ssp.model.PayTranAlipayLs;
import com.yada.ssp.query.PayTranAilpayLsQuery;
import com.yada.ssp.reportModel.PayTranAlipayLsReportQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xianyong
 */
@Service
public class PayTranAlipayLsManager extends BaseService<PayTranAlipayLs, String> {
    @Autowired
    private PayTranAlipayLsDaoImpl payTranAlipayLsDao;

    @Override
    protected BaseDao<PayTranAlipayLs, String> getBaseDao() {
        return payTranAlipayLsDao;
    }

    public List<PayTranAlipayLs> findAll(PayTranAilpayLsQuery query) {
        List<PayTranAlipayLs> payTranAlipayLses = payTranAlipayLsDao.findAll(query);
        for (PayTranAlipayLs payTranAlipayLs : payTranAlipayLses) {
            if ("201001".equals(payTranAlipayLs.getTranType())) {
                payTranAlipayLs.setTranType("支付宝条码支付");
            } else if ("201002".equals(payTranAlipayLs.getTranType())) {
                payTranAlipayLs.setTranType("支付宝扫码支付");
            } else if ("201003".equals(payTranAlipayLs.getTranType())) {
                payTranAlipayLs.setTranType("支付宝撤销");
            } else if ("201004".equals(payTranAlipayLs.getTranType())) {
                payTranAlipayLs.setTranType("支付宝退货");
            }
        }
        return payTranAlipayLses;
    }
}
