/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.*;
import com.yada.ssp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Service
public class MerchantBaseManager extends BaseService<MerchantBase, java.lang.String> {
    @Autowired
    private MerchantBaseDaoImpl merchantBaseDao;
    @Autowired
    private MerchantBaseSonDaoImpl merchantBaseSonDao;
    @Autowired
    private EnterAiliMerchantDaoImpl enterAiliMerchantDao;
    @Autowired
    private MerchantBusinessDaoImpl merchantBusinessDao;
    @Autowired
    private NetPayPersonManager netPayPersonManager;
    @Autowired
    private WebchantMerchantBaseDaoImpl webchantMerchantBasedao;
    @Autowired
    private UnionMerchantBaseDaoImpl unionMerchantBaseDao;

    @Override
    protected BaseDao<MerchantBase, String> getBaseDao() {
        // TODO Auto-generated method stub
        return merchantBaseDao;
    }

    @Autowired
    private MerchantGrpLsManager merchantGrpLsManager;

    public void save(UnionMerchantBase unionMerchantBase, MerchantBase merchantBase, MerchantBaseSon merchantBaseSon, EnterAiliMerchant enterAiliMerchant, List<MerchantBusiness> merchantBusinesses, WebchantMerchantBase webchantMerchantBase) {
        merchantBaseSonDao.insert(merchantBaseSon);
        merchantBaseDao.insert(merchantBase);
        if (enterAiliMerchant.getExternal_id() == null || "".equals(enterAiliMerchant.getExternal_id())) {

        } else {
            if (enterAiliMerchant.getSub_merchant_id() != null && !"".equals(enterAiliMerchant.getSub_merchant_id()))
                enterAiliMerchantDao.insert(enterAiliMerchant);
        }
        if (webchantMerchantBase.getMerchant_id() == null || "".equals(webchantMerchantBase.getMerchant_id())) {

        } else {
            if (webchantMerchantBase.getSub_mch_id() != null && !"".equals(webchantMerchantBase.getSub_mch_id()))
                webchantMerchantBasedao.insert(webchantMerchantBase);
        }
        if (unionMerchantBase.getMerchantId() == null || "".equals(unionMerchantBase.getMerchantId())) {
        } else {
            unionMerchantBaseDao.insert(unionMerchantBase);
        }

        for (MerchantBusiness merchantBusiness : merchantBusinesses) {
            merchantBusinessDao.insert(merchantBusiness);
        }
        NetPayPerson netPayPerson = new NetPayPerson();
        netPayPerson.setMerchant(merchantBase.getMerchantId());
        netPayPerson.setUserId("111111");
        netPayPerson.setPwd("00000000");
        netPayPerson.setName("");
        netPayPerson.setLevel("A");
        netPayPerson.setTerminal("");
        netPayPerson.setPhone("");
        NetPayPerson netPayPerson1 = netPayPersonManager.findByUserIdAndMerchant(netPayPerson.getMerchant(), netPayPerson.getUserId());
        if (netPayPerson1 == null || "".equals(netPayPerson1)) {
            netPayPersonManager.insert(netPayPerson);
        }
    }

    public void saves(WebchantMerchantBase webchantMerchantBases) {
        webchantMerchantBasedao.insert(webchantMerchantBases);
    }

    public void update(WebchantMerchantBase webchantMerchantBases, EnterAiliMerchant enterAiliMerchant) {
        enterAiliMerchantDao.update(enterAiliMerchant);
        webchantMerchantBasedao.update(webchantMerchantBases);
    }

    public WebchantMerchantBase getByid(String ID) {
        return webchantMerchantBasedao.getById(ID);
    }

    /**
     * 入驻支付宝或者修改商户基本信息
     *
     * @param merchantBase       商户基本信息
     * @param merchantBaseSon    商户附属账户信息
     * @param enterAiliMerchant  入驻支付宝信息
     * @param merchantBusinesses 业务费率商户表关联信息
     */
    public void update(UnionMerchantBase unionMerchantBase, MerchantBase merchantBase, MerchantBaseSon merchantBaseSon, EnterAiliMerchant enterAiliMerchant, List<MerchantBusiness> merchantBusinesses, WebchantMerchantBase webchantMerchantBase,String wechat_merchant_id,String alisub_merchant_id) {
        merchantBusinessDao.deleteMerchant(merchantBase.getMerchantId());
        for (MerchantBusiness merchantBusiness : merchantBusinesses) {
            merchantBusinessDao.insert(merchantBusiness);
        }
        merchantBaseSonDao.update(merchantBaseSon);
        merchantBase.setSendStatus("0");
        merchantBaseDao.update(merchantBase);
        if(alisub_merchant_id!=null&&!"".equals(alisub_merchant_id)) {
            enterAiliMerchant.setSub_merchant_id(alisub_merchant_id);
            enterAiliMerchantDao.update(enterAiliMerchant);
        }else{
            if (enterAiliMerchant.getSub_merchant_id() != null && !"".equals(enterAiliMerchant.getSub_merchant_id()))
                enterAiliMerchantDao.insert(enterAiliMerchant);
        }

        if(wechat_merchant_id!=null&&!"".equals(wechat_merchant_id)){
            webchantMerchantBase.setSub_mch_id(wechat_merchant_id);
            webchantMerchantBasedao.update(webchantMerchantBase);
        }else{
            if (webchantMerchantBase.getSub_mch_id() != null && !"".equals(webchantMerchantBase.getSub_mch_id()))
                webchantMerchantBasedao.insert(webchantMerchantBase);
        }

        unionMerchantBaseDao.update(unionMerchantBase);

    }

    /*public void deleteBusiness(MerchantBusiness merchantBusiness){
        int count=merchantBusinessDao.deleteMerchant(merchantBusiness);
        System.out.println("count:"+count);
    }*/
    public List<String> findByZbank(String zbank) {
        List<MerchantBase> merchantBases = merchantBaseDao.findByZbank(zbank);
        List<String> merchantIds = new ArrayList<>();
        for (MerchantBase merchantBase : merchantBases) {
            merchantIds.add(merchantBase.getMerchantId());
        }
        return merchantIds;
    }

    public void updateSendStatus(String merchantId, String sendStatus) {
        merchantBaseDao.updateSendStatus(merchantId, sendStatus);
    }

    public List<MerchantBase> findListFh() {
        return merchantBaseDao.findListFh();
    }

    public int updates(String state, String id) {
        return merchantBaseDao.updates(state, id);
    }
}
