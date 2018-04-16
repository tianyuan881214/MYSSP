package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.ErrorTranLsDaoImpl;
import com.yada.ssp.model.ErrorTranLs;
import com.yada.ssp.query.ErrorTranLsQuery;
import com.yada.ssp.query.ErrorTranLsReportQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author xianyong
 */
@Service
public class ErrorTranLsManager extends BaseService<ErrorTranLs, String> {
    @Autowired
    private ErrorTranLsDaoImpl errorTranLsDao;

    @Override
    protected BaseDao<ErrorTranLs, String> getBaseDao() {
        return errorTranLsDao;
    }

    public List<ErrorTranLs> findAll(ErrorTranLsReportQuery query) {
        List<ErrorTranLs> errorTranLses = errorTranLsDao.findAll(query);
        for (ErrorTranLs errorTranLs : errorTranLses) {
            errorTranLs.setAccountRelation(getAccountRelation(errorTranLs.getAccountRelation()));
            errorTranLs.setErrorCause("".equals(errorTranLs.getErrorCause()) ? "本地长款" : "本地短款");
            errorTranLs.setTranType(getTranType(errorTranLs.getTranType()));
            errorTranLs.setTranSources(getTranSources(errorTranLs.getTranSources()));
            DecimalFormat df= new DecimalFormat("#.00");
            errorTranLs.setTranAmt(Double.parseDouble(df.format(errorTranLs.getTranAmt())));
        }
        return errorTranLses;
    }

    public String getAccountRelation(String accountRelation) {
        Map<String, String> accountRelationMap = new HashMap<>();
        accountRelationMap.put("1", "本地与支付宝");
        accountRelationMap.put("2", "本地与微信");
        accountRelationMap.put("3", "本地与银联");
        accountRelationMap.put("4", "本地与miss");
        return accountRelationMap.get(accountRelation);
    }

    public String getTranType(String tranType) {
        Map<String, String> tranTypeMap = new HashMap<>();
        tranTypeMap.put("201001", "支付宝条码支付");
        tranTypeMap.put("201002", "支付宝扫码支付");
        tranTypeMap.put("201003", "支付宝撤销");
        tranTypeMap.put("201004", "支付宝退货");
        tranTypeMap.put("202001", "微信刷卡支付");
        tranTypeMap.put("202002", "微信扫码支付");
        tranTypeMap.put("202003", "微信撤销");
        tranTypeMap.put("202004", "微信退货");
        return tranTypeMap.get(tranType);
    }

    public String getTranSources(String tranSources) {
        Map<String, String> tranSourcesMap = new HashMap<>();
        tranSourcesMap.put("1", "本地");
        tranSourcesMap.put("2", "支付宝");
        tranSourcesMap.put("3", "微信");
        tranSourcesMap.put("4", "银联");
        tranSourcesMap.put("4", "miss");
        return tranSourcesMap.get(tranSources);
    }
}
