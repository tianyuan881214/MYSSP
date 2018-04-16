package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.PayTranWeChatLsDaoImpl;
import com.yada.ssp.model.PayTranWeChatLs;
import com.yada.ssp.reportModel.PayTranWechatLsReportQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xianyong
 */
@Service
public class PayTranWeChatLsManager extends BaseService<PayTranWeChatLs, String> {
    @Autowired
    private PayTranWeChatLsDaoImpl payTranWeChatLsDao;

    @Override
    protected BaseDao<PayTranWeChatLs, String> getBaseDao() {
        return payTranWeChatLsDao;
    }

    public List<PayTranWeChatLs> findAll(PayTranWechatLsReportQuery query) {
        List<PayTranWeChatLs> payTranWeChatLses = payTranWeChatLsDao.findAll(query);
        for (PayTranWeChatLs payTranWeChatLs : payTranWeChatLses) {
            if ("202001".equals(payTranWeChatLs.getTranType())) {
                payTranWeChatLs.setTranType("微信刷卡支付");
            } else if ("202002".equals(payTranWeChatLs.getTranType())) {
                payTranWeChatLs.setTranType("微信扫码支付");
            } else if ("202003".equals(payTranWeChatLs.getTranType())) {
                payTranWeChatLs.setTranType("微信撤销");
            } else if ("202004".equals(payTranWeChatLs.getTranType())) {
                payTranWeChatLs.setTranType("微信退货");
            }

            if("SUCCESS".equals(payTranWeChatLs.getResultCode())){
                payTranWeChatLs.setResultCode("成功");
            }else {
                payTranWeChatLs.setResultCode("失败");
            }
        }
        return payTranWeChatLses;
    }
}
