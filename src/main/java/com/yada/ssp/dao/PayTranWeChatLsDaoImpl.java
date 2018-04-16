package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.PayTranWeChatLs;
import com.yada.ssp.reportModel.PayTranWechatLsReportQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xianyong
 */
@Component
public class PayTranWeChatLsDaoImpl extends BaseDaoImpl<PayTranWeChatLs,String> {
    public List<PayTranWeChatLs> findAll(PayTranWechatLsReportQuery query){
        return getSqlSessionTemplate().selectList("PayTranWeChatLs_findAll",query);
    }
}


