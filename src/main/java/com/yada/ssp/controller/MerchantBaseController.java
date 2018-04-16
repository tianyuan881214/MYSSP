



/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.controller;

import alipay.sdk.AsyncAliPayMerchantHelper;
import alipay.sdk.config.Config$;
import alipay.sdk.protocol.merchantchanage.MerchantChangeResponse;
import alipay.sdk.protocol.merchantchanage.MerchantChangeResponseData;
import alipay.sdk.protocol.merchantcreate.*;
import alipay.sdk.traitcallback.IMerchantChangeCallBack;
import alipay.sdk.traitcallback.IMerchantCreateCallBack;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.yada.common.dict.util.DictUtil;
import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.security.model.Org;
import com.yada.security.model.User;
import com.yada.security.service.OrgManager;
import com.yada.ssp.model.*;
import com.yada.ssp.query.MerchantBaseQuery;
import com.yada.ssp.query.MerchantBusinessQuery;
import com.yada.ssp.query.MerchantGrpLsQuery;
import com.yada.ssp.service.*;
import net.sf.json.JSONArray;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import scala.Option;
import scala.Some;
import unionpay.sdk.HttpClient;
import unionpay.sdk.SDKConfig;
import wechat.sdk.AsyncWeChatCard;
import wechat.sdk.common.Configure$;
import wechat.sdk.protocol.MerchatAddResp;
import wechat.sdk.traitcallback.IMerchantAddCallback;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Controller
public class MerchantBaseController extends BaseController {

    @Autowired
    private MerchantBaseManager merchantBaseManager;
    @Autowired
    private BusinessBaseManager businessBaseManager;
    @Autowired
    private FeeTableManager feeTableManager;
    @Autowired
    private MerchantBusinessManager merchantBusinessManager;
    @Autowired
    private MerchantBaseSonManager merchantBaseSonManager;
    @Autowired
    private EnterAiliMerchantManager enterAiliMerchantManager;
    @Autowired
    private OrgManager orgManager;
    @Autowired
    private WebchantMerchantBaseManager webchantMerchantBaseManager;
    @Autowired
    private MerchantGrpLsManager merchantGrpLsManager;
    @Autowired
    private UnionMerchantBaseManager unionMerchantBaseManager;

    @Override
    public String save() {
        return super.save();
    }

    /**
     * 执行搜索
     */
    @RequestMapping
    public String list(Model model, @ModelAttribute("query") MerchantBaseQuery query, String subMerchantId, String message, String sub_mch_id, String sendStatus) {
        if (message != null && !"".equals(message)) {
            try {
                model.addAttribute("message", URLDecoder.decode(message, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String orgId = getCurUser().getUserExt().getOrgId();
        Org org = orgManager.getById(orgId);
        model.addAttribute("orgLev", org.getOrgLev());
        if ("1".equals(org.getOrgLev().toString())) {
            List<Org> orgs = orgManager.findZbankList(orgId);
            model.addAttribute("orgs", orgs);
            String lowerOrgId = query.getpOrgId();
            List<Org> lowerOrgs = null;
            if (lowerOrgId != null && !lowerOrgId.equals("")) {
                lowerOrgs = orgManager.findZbankList(query.getOrgId());
            }
            model.addAttribute("lowerOrgs", lowerOrgs);
        }
        if ("2".equals(org.getOrgLev().toString())) {
            List<Org> orgs = orgManager.findByPOrgId(orgId);
            model.addAttribute("orgs", orgs);
            query.setOrgId(orgId);
        }
        if ("3".equals(org.getOrgLev().toString())) {
            model.addAttribute("org", org);
        }
        Page page = merchantBaseManager.queryPage(query);
        List<MerchantBase> merchantBaseList = page.getResult();
        for (MerchantBase merchantBase : merchantBaseList) {
            for (MerchantBusiness merchantBusiness : merchantBase.getMerchantBusinesses()) {
                BusinessBase businessBase = businessBaseManager.getById(merchantBusiness.getBusinessBase());
                FeeTable feeTable = feeTableManager.getById(merchantBusiness.getFeeTable());
                merchantBusiness.setBusinessBases(businessBase);
                Double fee = Double.parseDouble(feeTable.getFee());
                BigDecimal a = new BigDecimal(100);
                BigDecimal b = new BigDecimal(Double.toString(fee));
                Double fee1 = a.multiply(b).doubleValue();
                feeTable.setFee(fee1.toString() + "%");
                merchantBusiness.setFeeTables(feeTable);
            }
        }
        List<BusinessBase> businessBases = businessBaseManager.findAll();
        //request.getSession().setAttribute("page", page);
        model.addAttribute("businessBases", businessBases);
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        model.addAttribute("sendStatus", sendStatus);
        return "/ssp_pages/MerchantBase/list";
    }


    /**
     * 搜索禁用状态的商户
     */
    @RequestMapping
    public String listDisabled(Model model, @ModelAttribute("query") MerchantBaseQuery query) {
        query.setMerchantStat("N");
        Page page = merchantBaseManager.queryPage(query);
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        return "/ssp_pages/MerchantBase/list";
    }

    /**
     * 查看对象
     */
    @RequestMapping
    public String show(Model model, @RequestParam("id") String id, HttpServletRequest request) {
        List<MerchantBaseSon> lists = merchantBaseSonManager.getmerbusinessList(id);
        MerchantBaseSon merchantson = merchantBaseSonManager.getById(id);
        MerchantBase merchant = merchantBaseManager.getById(id);
        MerchantGrpLs merchantGrp = merchantGrpLsManager.getById(id);
        /*String str = merchant.getBitFlag();
        this.Str_out(str, request);
		*/
        List<MerchantBusiness> merchantBusinesses = merchantBusinessManager.findByMerchantId(id);
        for (MerchantBusiness merchantBusiness : merchantBusinesses) {
            BusinessBase businessBase = businessBaseManager.getById(merchantBusiness.getBusinessBase());
            FeeTable feeTable = feeTableManager.getById(merchantBusiness.getFeeTable());
            merchantBusiness.setBusinessBases(businessBase);
            Double fee = Double.parseDouble(feeTable.getFee());
            BigDecimal b = new BigDecimal(Double.toString(fee));
            BigDecimal a = new BigDecimal(100);
            Double fee1 = a.multiply(b).doubleValue();
            feeTable.setFee(fee1.toString() + "%");
            merchantBusiness.setFeeTables(feeTable);
        }
        EnterAiliMerchant enterAiliMerchant = enterAiliMerchantManager.getById(id);
        request.getSession().setAttribute("lists", lists);
        model.addAttribute("enterAiliMerchant", enterAiliMerchant);
        model.addAttribute("FeeBusiness", merchantBusinesses);
        model.addAttribute("modelson", merchantson);
        model.addAttribute("model", merchant);
        model.addAttribute("merchantGrp", merchantGrp);

        return "/ssp_pages/MerchantBase/show";
    }

    /**
     * 进入新增页面
     */
    @RequestMapping
    public String create(Model model, MerchantGrpLsQuery query,String message) {
        if (message != null && !"".equals(message)) {
            try {
                model.addAttribute("message", URLDecoder.decode(message, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        //业务
        List<BusinessBase> BusinessList = businessBaseManager.getbusinessList();
        List<FeeTable> feeList = feeTableManager.getfeeList();
        List<MerchantGrpLs> merchantGrpLsList = merchantGrpLsManager.getmerchantList();
        for (FeeTable feeTable : feeList) {
            Double fee = Double.parseDouble(feeTable.getFee());
            BigDecimal a = new BigDecimal(100);
            BigDecimal b = new BigDecimal(Double.toString(fee));
            Double fee1 = a.multiply(b).doubleValue();
            feeTable.setFee(fee1.toString() + "%");
        }

        String orgId = getCurUser().getUserExt().getOrgId();
        List<Org> lowerOrgs = orgManager.findLowerPrvcOrg();
        List<Org> BelongcOrg = orgManager.findBelongcOrg();
        model.addAttribute("lowerOrgs", lowerOrgs);
        model.addAttribute("feeList", feeList);
        model.addAttribute("BusinessList", BusinessList);
        model.addAttribute("BelongcOrg", BelongcOrg);
        model.addAttribute("merchantGrpLsList", merchantGrpLsList);

        return "/ssp_pages/MerchantBase/create";
    }

    @Override
    public String showList() {
        return super.showList();
    }

    /**
     * 保存新增对象
     */
    @RequestMapping
    public String save(Model model, @ModelAttribute("model") MerchantBase merchantBase, @ModelAttribute("modelson") MerchantBaseSon merchantBaseson, HttpServletRequest request, String[] ids) {
        if (ids == null || ids.length < 1 || "".equals(request.getParameter(ids[0])) || request.getParameter(ids[0]) == null) {
            List<BusinessBase> BusinessList = businessBaseManager.getbusinessList();
            List<FeeTable> feeList = feeTableManager.getfeeList();
            List<MerchantGrpLs> merchantGrpLsList = merchantGrpLsManager.getmerchantList();
            for (FeeTable feeTable : feeList) {
                Double fee = Double.parseDouble(feeTable.getFee());
                BigDecimal a = new BigDecimal(100);
                BigDecimal b = new BigDecimal(Double.toString(fee));
                Double fee1 = a.multiply(b).doubleValue();
                feeTable.setFee(fee1.toString() + "%");
            }
            String message = null;
            model.addAttribute("feeList", feeList);
            model.addAttribute("BusinessList", BusinessList);
          // model.addAttribute("message", "必须为此商户选择业务及扣率");
            model.addAttribute("merchantGrpLsList", merchantGrpLsList);
            message = "必须为此商户选择业务及扣率请重新输入";
            try {
                message = URLEncoder.encode(message, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return "redirect:create.do？message="+message;
          //  return "/ssp_pages/MerchantBase/create";
        }

        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat formatTime = new SimpleDateFormat("HHmmss");
        String currDate = formatDate.format(date);
        String currTime = formatTime.format(date);
        //  System.out.println("merchantBase:"+merchantBase.toString());
        merchantBase.setUpdateOper(getCurUser().getLoginName());
        merchantBase.setUpdateDate(currDate);
        merchantBase.setUpdateTime(currTime);
        merchantBase.setSignHostId("00");
        merchantBase.setState("1");
        merchantBaseson.setMerGrpId("111111111111111");
        if (merchantBase.getOrgId() != null && !"".equals(merchantBase.getOrgId())) {
            merchantBase.setZbank(merchantBase.getOrgId().replaceAll(",", "").trim());
        } else {
            merchantBase.setZbank(getCurUser().getUserExt().getOrgId());
        }
        merchantBase.setSignBankId(merchantBase.getZbank());
        merchantBase.setUpdateOper(getCurUser().getUserName());
        merchantBase.setSendStatus("0");
        merchantBaseson.setMerchantId(merchantBase.getMerchantId());

        /**
         * 入驻支付宝请求
         */

        //支付宝商户入驻实体
        EnterAiliMerchant enterAiliMerchant = new EnterAiliMerchant();
        enterAiliMerchant.setExternal_id(merchantBase.getMerchantId());
        enterAiliMerchant.setCategory_id(merchantBaseson.getCategoryId());
        //enterAiliMerchant.setCategory_id("2015061690000025");
        enterAiliMerchant.setSource(Config$.MODULE$.pid());//是一个pid 在配置文件里面
        enterAiliMerchant.setName(merchantBase.getMerchantCname());
        enterAiliMerchant.setAlias_name(merchantBase.getAbbrCname());

        //微信商户入驻实体
        WebchantMerchantBase webchantMerchantBase = new WebchantMerchantBase();
        //将商品的信息存入银联实体
        UnionMerchantBase unionMerchantBase = new UnionMerchantBase();
        /**
         * 入驻支付宝返回结果
         */
        boolean alipay = false;
        boolean wechat = false;
        boolean union = false;
        for (int i = 0; i < ids.length; i++) {
            if ("000000000000002".equals(ids[i])) {
                alipay = true;
            }
            if ("000000000000003".equals(ids[i])) {
                wechat = true;
            }
            if ("000000000000004".equals(ids[i])) {
                union = true;
            }
        }
        String alisubMerchantId = "";
        String message = null;
        if (alipay) {
            alisubMerchantId = createMerchant(enterAiliMerchant, merchantBase, merchantBaseson);
            if (alisubMerchantId != null && !"".equals(alisubMerchantId)) {
                alisubMerchantId = alisubMerchantId;
                message = "支付宝：入驻成功";
            } else {
                message = "支付宝：入驻失败";
            }
            enterAiliMerchant.setSub_merchant_id(alisubMerchantId);
            System.out.println("alisubMerchantId:" + alisubMerchantId);
        }
        /**
         * 入驻微信返回结果
         */
        String wechatsub_mch_id = "";
        if (wechat) {
            wechatsub_mch_id = AddwechatSubmchId(merchantBase);
            if (wechatsub_mch_id != null && !"".equals(wechatsub_mch_id)) {
                wechatsub_mch_id = wechatsub_mch_id;
                message = String.format(" %s    微信:入驻成功", message);
            } else {
                message = String.format(" %s    微信:入驻失败", message);

            }
            System.out.println("SUB_MCH_ID:" + wechatsub_mch_id);
            webchantMerchantBase.setSub_mch_id(wechatsub_mch_id);
            webchantMerchantBase.setMerchant_id(merchantBase.getMerchantId());
            webchantMerchantBase.setMerchant_name(merchantBase.getMerchantCname());
            webchantMerchantBase.setMerchant_shortname(merchantBase.getAbbrCname());
            webchantMerchantBase.setService_phonr(merchantBase.getTelephone());
            webchantMerchantBase.setChannel_id(Configure$.MODULE$.MCH_ID());
            webchantMerchantBase.setBusiness("111");
            webchantMerchantBase.setMerchant_remark(merchantBase.getMerchantId());

        }
        /**
         * 入驻银联返回结果
         */
        String unionSubmchid = "";
        if (union == true) {
            unionSubmchid = merchantBase.getUnionSubmchid();
            unionMerchantBase.setMerchantId(merchantBase.getMerchantId());
            unionMerchantBase.setUnionName(merchantBase.getMerchantCname());
            unionMerchantBase.setMerchantShortname(merchantBase.getAbbrCname());
            unionMerchantBase.setServicePhonr(merchantBase.getTelephone());
            unionMerchantBase.setContact(merchantBase.getManager());
            unionMerchantBase.setContactPhone(merchantBase.getTelephone());
            unionMerchantBase.setContactEmail(merchantBaseson.getEmail());//邮箱
            unionMerchantBase.setUnionRemark(merchantBase.getMerchantId());
            unionMerchantBase.setUnionSubmchid(unionSubmchid);//子商户号
            System.out.println(unionMerchantBase);
        }
        List<MerchantBusiness> merchantBusinesses = new ArrayList<MerchantBusiness>();
        for (int i = 0; i < ids.length; i++) {
            String feeId = request.getParameter(ids[i]);
            String businessId = ids[i];
            String MerchantGrpLsId = ids[i];
            MerchantBusiness merchantBusiness = new MerchantBusiness();
            merchantBusiness.setBusinessBase(businessId);
            merchantBusiness.setFeeTable(feeId);
            merchantBusiness.setPaymerchantBases(merchantBase.getMerchantId());
            merchantBusiness.setMerchantGrpLs(merchantBase.getMerchantId());
            merchantBusinesses.add(merchantBusiness);
        }
        merchantBaseManager.save(unionMerchantBase, merchantBase, merchantBaseson, enterAiliMerchant, merchantBusinesses, webchantMerchantBase);
        DictUtil.remove("D_SUB_MERCHANT_ID");
        try {
            message = URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "redirect:list.do?merchantId=" + merchantBase.getMerchantId() + "&message=" + message;
    }

    /**
     * 入驻支付宝方法
     *
     * @param model
     * @param merchantBase
     * @return
     */
    public String createMerchant(EnterAiliMerchant model, MerchantBase merchantBase, MerchantBaseSon merchantBaseSon) {
        System.out.println("调用的支付宝的方法 ");
        final AlipayRes alipayRes = new AlipayRes();
        final CountDownLatch latch = new CountDownLatch(1);
        alipay.sdk.protocol.merchantcreate.ContactInfo contactInfo = new alipay.sdk.protocol.merchantcreate.ContactInfo(merchantBaseSon.getContactName(), merchantBase.getTelephone(), "", merchantBaseSon.getEmail(),
                merchantBaseSon.getContactType(), merchantBaseSon.getIdCard());
        BankCardInfo bankCardInfo = new BankCardInfo(merchantBaseSon.getCardNo(), merchantBaseSon.getCardName());
        AddressInfo addressInfo = new AddressInfo(merchantBaseSon.getProvinceCode(),
                merchantBaseSon.getCityCode(),
                merchantBaseSon.getDistrictCode(),
                merchantBase.getAddressChn(), "", "", "");

        AsyncAliPayMerchantHelper.merchantCreate(model.getExternal_id(),
                merchantBase.getMerchantCname(),
                merchantBase.getAbbrCname(),
                merchantBase.getTelephone(),
                null,
                null,
                null,
                null,
                model.getCategory_id(),
                Config$.MODULE$.pid(),
                Option.apply(merchantBaseSon.getBusinessLicense()),
                new Some<String>(merchantBaseSon.getIdCard()),
                new Some<String>(merchantBaseSon.getProvinceCode()),
                new Some<String>(merchantBaseSon.getCityCode()),
                new Some<String>(merchantBaseSon.getDistrictCode()),
                new Some<String>(merchantBase.getAddressChn()),
                null,
                Option.apply(contactInfo),
                Option.apply(addressInfo),
                Option.apply(bankCardInfo),
                new IMerchantCreateCallBack() {
                    @Override
                    public void callBack(MerchantCreateResponseData response) {
                        System.out.println("response：" + response.ant_merchant_expand_indirect_create_response());
                        MerchantCreateResponse resp = response.ant_merchant_expand_indirect_create_response();
                        System.out.println("MerchantCreateResponse：" + resp.toString());
                        if (resp.getCode().equals("10000")) {
                            alipayRes.setSub_mcrchant_id(resp.getSubMerchantId());
                            System.out.println("Alipay_sub_mch_Id_insert：" + alipayRes.getSub_mcrchant_id());
                            latch.countDown();
                        }
                    }
                });
        try {
            System.out.println("A开始输出：");
            latch.await(60, TimeUnit.SECONDS);
            System.out.println("A已输出：" + alipayRes.getSub_mcrchant_id());
        } catch (InterruptedException e) {
            latch.countDown();
            e.printStackTrace();
        }
        return alipayRes.getSub_mcrchant_id();

    }

    /**
     * @return
     * @微信入驻方法
     */

    public String AddwechatSubmchId(MerchantBase merchantBase) {
        System.out.println("调用的微信的入住 方法 ");
        final WechantpayRes wechantpayRes = new WechantpayRes();
        final CountDownLatch latch = new CountDownLatch(1);
        AsyncWeChatCard.merchantAdd(
                merchantBase.getMerchantCname(),//商户名称
                merchantBase.getAbbrCname(),//商户简称
                merchantBase.getTelephone(),//客服电话
                "",//联系人
                "", //联系电话
                "",//邮箱
                "111",//经营类目
                merchantBase.getMerchantId(),//备注
                Configure$.MODULE$.CHANNEL_ID(),//渠道号
                new IMerchantAddCallback() {
                    @Override
                    public void callback(MerchatAddResp resp) {
                        if (resp.return_code().equals("SUCCESS") && resp.result_code().equals("SUCCESS")) {
                            wechantpayRes.setSub_mcrchant_id(resp.sub_mch_id());
                        }
                        System.out.println("WECH_sub_mch_Id：" + wechantpayRes.getSub_mcrchant_id());
                        latch.countDown();
                    }
                });
        try {
            System.out.println("W开始输出：");
            latch.await(10, TimeUnit.SECONDS);
            System.out.println("W已经输出：" + wechantpayRes.getSub_mcrchant_id());
        } catch (InterruptedException e) {
            latch.countDown();
            e.printStackTrace();
        }
        return wechantpayRes.getSub_mcrchant_id();
    }

    /**
     * 修改入驻支付宝方法
     *
     * @param model
     * @param merchantBase
     * @return
     */
    public String updateMerchant(EnterAiliMerchant model, MerchantBase merchantBase, MerchantBaseSon merchantBaseSon) {
        System.out.println("调用的支付宝的更新  方法 ");
        final AlipayRes alipayRes = new AlipayRes();
        final CountDownLatch latch = new CountDownLatch(1);
        ContactInfo contactInfo = new ContactInfo(merchantBaseSon.getContactName(), merchantBase.getTelephone(), "", merchantBaseSon.getEmail(),
                merchantBaseSon.getContactType(), merchantBaseSon.getIdCard());
        BankCardInfo bankCardInfo = new BankCardInfo(merchantBaseSon.getCardNo(), merchantBaseSon.getCardName());
        AddressInfo addressInfo = new AddressInfo(merchantBaseSon.getProvinceCode(),
                merchantBaseSon.getCityCode(),
                merchantBaseSon.getDistrictCode(),
                merchantBase.getAddressChn(),
                "",
                "",
                "");
        AsyncAliPayMerchantHelper.merchantChange(new Some<String>(model.getSub_merchant_id()),
                new Some<String>(model.getExternal_id()),
                new Some<String>(merchantBase.getAbbrCname()),
                new Some<String>(merchantBase.getTelephone()),
                new Some<String>(merchantBase.getAddressChn()),
                null,
                null,
                null,
                null,
                null,//new Some<String>(merchantBase.getAddressChn()),
                new Some<String>(Config$.MODULE$.pid()),
                new Some<String>(model.getCategory_id()),
                new Some<ContactInfo>(contactInfo),
                new Some<AddressInfo>(addressInfo),
                new Some<BankCardInfo>(bankCardInfo), new IMerchantChangeCallBack() {
                    @Override
                    public void callBack(MerchantChangeResponseData response) {
                        MerchantChangeResponse resp = response.ant_merchant_expand_indirect_modify_response();
                        System.out.println("MerchantChangeResponse_UP：" + resp.toString());
                        if (resp.getCode().equals("10000")) {
                            System.out.println("MerchantChangeResponse：" + resp.toString());
                            alipayRes.setSub_mcrchant_id(resp.getSubMerchantId());
                            System.out.println("Alipay_sub_mch_Id_insert：" + alipayRes.getSub_mcrchant_id());
                            latch.countDown();
                        }
                    }
                });
        try {
            System.out.println("开始输出");
            latch.await(10, TimeUnit.SECONDS);
            System.out.println("已经输出");
        } catch (InterruptedException e) {
            latch.countDown();
            e.printStackTrace();
        }

        return alipayRes.getSub_mcrchant_id();

    }

    /**
     * 进入更新页面
     */
    @RequestMapping
    public String edit(Model model, @RequestParam("id") String id) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("curUser");
        MerchantBusinessQuery query = new MerchantBusinessQuery();
        query.setPaymerchantBases(id);
        List<MerchantBusiness> mbList = merchantBusinessManager.findAll(query);
        MerchantBaseSon merchantSon = merchantBaseSonManager.getById(id);

        List<BusinessBase> BusinessList = businessBaseManager.getbusinessList();
        List<FeeTable> feeLists = feeTableManager.getfeeList();
        // List<MerchantGrpLs> merchantGrpLsList = merchantGrpLsManager.getmerchantList();

        for (FeeTable feeTable : feeLists) {
            Double fee = Double.parseDouble(feeTable.getFee());
            BigDecimal b = new BigDecimal(Double.toString(fee));
            BigDecimal a = new BigDecimal(100);
            Double fee1 = a.multiply(b).doubleValue();
            feeTable.setFee(fee1.toString() + "%");
        }
        List<FeeTable> feeList = null;
        for (MerchantBusiness m : mbList) {
            //feeList= new ArrayList<FeeTable>();
            for (int i = 0; i < BusinessList.size(); i++) {
                BusinessBase b = BusinessList.get(i);
                if (m.getBusinessBase().equals(b.getBusinessId())) {
                    b.setChecked(true);
                    if (m.getFeeTable() == null || m.getFeeTable().equals("")) {
                        m.setFeeTable("");
                    }
                    FeeTable f = feeTableManager.getById(m.getFeeTable());
                    Double fee = Double.parseDouble(f.getFee());
                    BigDecimal c = new BigDecimal(Double.toString(fee));
                    BigDecimal a = new BigDecimal(100);
                    Double fee1 = a.multiply(c).doubleValue();
                    f.setFee(fee1.toString() + "%");
                    if (f == null || f.equals("")) {
                        b.setFeeid("");
                    } else {
                        b.setFeeid(f.getFee());
                    }
                }
            }
        }
        EnterAiliMerchant enterAiliMerchant = enterAiliMerchantManager.getById(id);
        WebchantMerchantBase webchantMerchantBase = webchantMerchantBaseManager.getById(id);
        List<Org> BelongcOrg = orgManager.findBelongcOrg();
        model.addAttribute("BelongcOrg", BelongcOrg);
        model.addAttribute("orgs", orgManager.findLowerPrvcOrg());
        model.addAttribute("feeList", feeLists);
        model.addAttribute("BusinessList", BusinessList);
        model.addAttribute("modelson", merchantSon);
        model.addAttribute("model", merchantBaseManager.getById(id));
        model.addAttribute("username", user.getLoginName());
        model.addAttribute("enterAiliMerchant", enterAiliMerchant);
        model.addAttribute("webchantMerchantBase", webchantMerchantBase);
        //model.addAttribute("merchantGrpLsList",merchantGrpLsList);
        return "/ssp_pages/MerchantBase/edit";
    }

    /**
     * 保存更新对象
     */
    @RequestMapping
    public String update(@ModelAttribute("model") MerchantBase merchantBase, Model model, @ModelAttribute("modelson") MerchantBaseSon merchantBaseSon, HttpServletRequest request, String[] ids) {
        if (ids == null || ids.length < 1 || "".equals(request.getParameter(ids[0])) || request.getParameter(ids[0]) == null) {
            List<BusinessBase> BusinessList = businessBaseManager.getbusinessList();
            List<FeeTable> feeList = feeTableManager.getfeeList();
            for (FeeTable feeTable : feeList) {
                Double fee = Double.parseDouble(feeTable.getFee());
                BigDecimal a = new BigDecimal(100);
                BigDecimal b = new BigDecimal(Double.toString(fee));
                Double fee1 = a.multiply(b).doubleValue();
                feeTable.setFee(fee1.toString() + "%");
            }
            model.addAttribute("BusinessList", BusinessList);
            model.addAttribute("feeList", feeList);
            model.addAttribute("message", "必须为此商户选择业务扣率");
            return "/ssp_pages/MerchantBase/edit";
        }
        merchantBase.setState("1");
        List<MerchantBusiness> mbList = merchantBusinessManager.getmerchantbusinessList(merchantBase.getMerchantId());
        List<MerchantBusiness> merchantBusinesses = new ArrayList<MerchantBusiness>();
        boolean alipayup = false;
        boolean wechatup = false;
        for (int i = 0; i < ids.length; i++) {
            String feeId = request.getParameter(ids[i]);
            String businessId = ids[i];
            MerchantBusiness merchantBusiness = new MerchantBusiness();
            merchantBusiness.setFeeTable(feeId);
            merchantBusiness.setBusinessBase(businessId);
            merchantBusiness.setPaymerchantBases(merchantBase.getMerchantId());
            merchantBusinesses.add(merchantBusiness);
            if ("000000000000002".equals(ids[i])) {
                alipayup = true;
            }
            if ("000000000000003".equals(ids[i])) {
                wechatup = true;
            }
        }
        String sub_mch_ids = request.getParameter("Wsub_mch_id");
        String alisub_merchant_id = request.getParameter("alisub_merchant_ids");
        System.out.println("getParameter:" + sub_mch_ids + "alisub_merchant_id:" + alisub_merchant_id);
        EnterAiliMerchant enterAiliMerchant = null;
        WebchantMerchantBase webchantMerchantBases = null;
        String message = null;
        if (alipayup) {
            Date date = new Date();
            User user = (User) SecurityUtils.getSubject().getSession().getAttribute("curUser");
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat formatTime = new SimpleDateFormat("HHmmss");
            String currDate = formatDate.format(date);
            String currTime = formatTime.format(date);
            merchantBase.setUpdateDate(currDate);
            merchantBase.setSignHostId("00");
            merchantBase.setZbank(merchantBase.getOrgId());
            merchantBase.setUpdateTime(currTime);
            merchantBase.setUpdateOper(user.getUserName());
            merchantBaseSon.setMerchantId(merchantBase.getMerchantId());
            enterAiliMerchant = enterAiliMerchantManager.getById(merchantBase.getMerchantId());
            if (enterAiliMerchant == null) {
                enterAiliMerchant = new EnterAiliMerchant();
            }
            if (alisub_merchant_id != null && alisub_merchant_id != "") {
                enterAiliMerchant.setExternal_id(merchantBase.getMerchantId());
                enterAiliMerchant.setCategory_id(merchantBaseSon.getCategoryId());
                enterAiliMerchant.setSource(Config$.MODULE$.pid());//是一个pid 在配置文件里面
                String subMerchantId = updateMerchant(enterAiliMerchant, merchantBase, merchantBaseSon);
                if (subMerchantId != null && !"".equals(subMerchantId)) {
                } else {
                    //支付宝商户入驻实体
                    EnterAiliMerchant enterAili = new EnterAiliMerchant();
                    enterAiliMerchant.setExternal_id(merchantBase.getMerchantId());
                    enterAiliMerchant.setCategory_id(merchantBaseSon.getCategoryId());
                    //enterAiliMerchant.setCategory_id("2015061690000025");
                    enterAiliMerchant.setSource(Config$.MODULE$.pid());//是一个pid 在配置文件里面
                    enterAiliMerchant.setName(merchantBase.getMerchantCname());
                    enterAiliMerchant.setAlias_name(merchantBase.getAbbrCname());
                    subMerchantId = createMerchant(enterAiliMerchant, merchantBase, merchantBaseSon);

                    if (subMerchantId != null && !"".equals(subMerchantId)) {
                        message = "支付宝：入驻成功";
                    } else {
                        message = "支付宝：入驻失败";
                    }
                }
                enterAiliMerchant.setSub_merchant_id(subMerchantId);
                enterAiliMerchant.setName(merchantBase.getMerchantCname());
                enterAiliMerchant.setAlias_name(merchantBase.getAbbrCname());
            } else {
                enterAiliMerchant.setExternal_id(merchantBase.getMerchantId());
                enterAiliMerchant.setCategory_id(merchantBaseSon.getCategoryId());
                enterAiliMerchant.setSource(Config$.MODULE$.pid());//是一个pid 在配置文件里面

                String subMerchantId = createMerchant(enterAiliMerchant, merchantBase, merchantBaseSon);
                if (subMerchantId != null && !"".equals(subMerchantId)) {
                    enterAiliMerchant.setSub_merchant_id(subMerchantId);
                    enterAiliMerchant.setName(merchantBase.getMerchantCname());
                    enterAiliMerchant.setAlias_name(merchantBase.getAbbrCname());
                    if (enterAiliMerchantManager.getById(merchantBase.getMerchantId()) == null) {
                        enterAiliMerchantManager.insert(enterAiliMerchant);
                    }
                    message = "支付宝：入驻成功";
                } else {
                    message = "支付宝：入驻失败";
                }
            }
        }
        if (wechatup) {
            if (sub_mch_ids == null || "".equals(sub_mch_ids)) {
                webchantMerchantBases = new WebchantMerchantBase();
                webchantMerchantBases.setMerchant_id(merchantBase.getMerchantId());
                webchantMerchantBases.setMerchant_name(merchantBase.getMerchantCname());
                webchantMerchantBases.setMerchant_shortname(merchantBase.getAbbrCname());
                webchantMerchantBases.setService_phonr(merchantBase.getTelephone());
                webchantMerchantBases.setChannel_id(Configure$.MODULE$.MCH_ID());
                webchantMerchantBases.setBusiness("111");
                webchantMerchantBases.setMerchant_remark(merchantBase.getMerchantId());
                String sub_mch_id = AddwechatSubmchId(merchantBase);
                System.out.println("微信 返回的子商户号：" + sub_mch_id);
                if (sub_mch_id != null && !"".equals(sub_mch_id)) {
                    webchantMerchantBases.setSub_mch_id(sub_mch_id);
                    webchantMerchantBaseManager.insert(webchantMerchantBases);
                    message = String.format(" %s    微信:入驻成功", message);
                } else {
                    message = String.format(" %s    微信:入驻失败", message);

                }


            } else {
                webchantMerchantBases = merchantBaseManager.getByid(merchantBase.getMerchantId());
                webchantMerchantBases.setSub_mch_id(sub_mch_ids);
            }
        }
        //将商品的信息存入银联的数据库中
        UnionMerchantBase unionMerchantBase = new UnionMerchantBase();
        unionMerchantBase.setMerchantId(merchantBase.getMerchantId());
        unionMerchantBase.setUnionName(merchantBase.getMerchantCname());
        unionMerchantBase.setMerchantShortname(merchantBase.getAbbrCname());
        unionMerchantBase.setServicePhonr(merchantBase.getTelephone());
        unionMerchantBase.setContact(merchantBase.getManager());
        unionMerchantBase.setContactPhone(merchantBase.getTelephone());
        unionMerchantBase.setContactEmail(merchantBaseSon.getEmail());//邮箱
        unionMerchantBase.setUnionRemark(merchantBase.getMerchantId());
        unionMerchantBase.setUnionSubmchid(null);//子商户号
        //unionMerchantBaseManager.update(unionMerchantBase);
        System.out.println("微信 商户对象：" + webchantMerchantBases.toString());
        merchantBaseManager.update(unionMerchantBase, merchantBase, merchantBaseSon, enterAiliMerchant, merchantBusinesses, webchantMerchantBases, sub_mch_ids, alisub_merchant_id);
        DictUtil.remove("D_SUB_MERCHANT_ID");
        try {
            if (message == null || message.equals(""))
                message = "更新成功";
            message = URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "redirect:list.do?message=" + message;
    }

    /**
     * 删除对象
     */
    @RequestMapping
    public String delete(Model model, @RequestParam("id") String id) {
        merchantBaseManager.delete(id);
        DictUtil.remove("D_SUB_MERCHANT_ID");
        return "redirect:list.do";
    }

    @RequestMapping
    public void AJAX_findlowerOrg(String orgId, HttpServletResponse response) {
        // 用户分组JSON
        String lowerOrgsJson = "";

        // 查找
        List<Org> lowerOrgs = orgManager.findZbankList(orgId);

        // 转换为JSON
        lowerOrgsJson = JSONArray.fromObject(lowerOrgs).toString();

        // 响应JSON格式数据
        try {
            response.setContentType("text/javascript; charset=utf-8");
            response.getWriter().print(lowerOrgsJson);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 验证商户号是否已存在
     *
     * @param
     * @author longwu.yan
     */
    @RequestMapping
    public void AJAX_isMerchantIdExist(String merchantId,
                                       HttpServletResponse response) {

        // 提示信息
        String mess = "*";
        MerchantBase merchantBase = merchantBaseManager.getById(merchantId);
        // 不可用
        if (merchantBase != null && !"".equals(merchantBase)) {
            mess = "此商户已存在!";
        }

        // 响应
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(mess);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @RequestMapping
    public void AJAX_findByLikeOrgName(String orgName, HttpServletResponse response) {
        // 用户分组JSON
        String lowerOrgsJson = "";

        // 查找
        List<Org> lowerOrgs = orgManager.findByLikeOrgName(orgName);

        // 转换为JSON
        lowerOrgsJson = JSONArray.fromObject(lowerOrgs).toString();

        // 响应JSON格式数据
        try {
            response.setContentType("text/javascript; charset=utf-8");
            response.getWriter().print(lowerOrgsJson);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 二维码下载
     *
     * @param
     * @author
     */
    @RequestMapping
    public void qrCode(Model model, HttpServletResponse res, HttpServletRequest request, @RequestParam("merchantId") String merchantId, @RequestParam("merchantCname") String merchantCname) {
        try {
            OutputStream os = res.getOutputStream();
            res.reset();
            res.setHeader("Content-Disposition", "attachment; filename=" + merchantId + ".jpg");
            res.setContentType("application/octet-stream; charset=utf-8");
            String content = "http://www.lanxinpay.com/pay/unionWeb?merID=" + merchantId + "&terminalId=88888888" + "&merchantName=" + merchantCname;

            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hints = new HashMap();
            //内容所使用编码
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix bitMatrix = multiFormatWriter.encode(
                    content, BarcodeFormat.QR_CODE, 300, 300, hints);
            MatrixToImageWriter.writeToStream(bitMatrix, "jpg", os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //发送需要字段给
    @RequestMapping
    public String sendData(Model model, String merchantNo, String aliMerchantNo, String merchantCname, String wechatMerchantNo, String unionMerchantNo,
                           String scanType, String accountType) {
        String sendStatus = "0";
        unionMerchantNo = merchantNo;
        System.out.println(merchantNo + "===" + aliMerchantNo + "====" + merchantCname + "===" + wechatMerchantNo + "===" + unionMerchantNo);
        int i = 2;

        try {
            merchantCname = URLEncoder.encode(merchantCname, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = "http://www.lanxinpay.com/pay/setMerchantBase?merchantNo=" + merchantNo + "&merchantName=" + merchantCname
                + "&aliMerchantNo=" + aliMerchantNo + "&wechatMerchantNo=" + wechatMerchantNo + "&unionMerchantNo=" + unionMerchantNo
                + "&scanType=" + scanType + "&accountType=" + accountType;
        HttpClient httpClient = new HttpClient(url, 3000000, 300000);
        try {
            //加载配置文件
            SDKConfig config = SDKConfig.getConfig();
            config.loadPropertiesFromSrc();
            i = httpClient.sendGet("utf-8");
            System.out.println("返回的响应码为：" + i);
        } catch (Exception e) {
            sendStatus = "0";
            e.printStackTrace();
            System.out.println("http连接异常");
            return "redirect:list.do?sendStatus=" + sendStatus;
        }
        if (i != 200) {
            sendStatus = "0";
            return "redirect:list.do?sendStatus=" + sendStatus;
        }
        merchantBaseManager.updateSendStatus(merchantNo, "1");
        sendStatus = "1";
        return "redirect:list.do?sendStatus=" + sendStatus;
    }


    @RequestMapping
    public void AJAX_isBelongOrgId(String belongOrgId, HttpServletResponse response) {
        List<Org> lowerOrgs = orgManager.findBelongOrgId(belongOrgId);
        //响应
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(JSONArray.fromObject(lowerOrgs));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
