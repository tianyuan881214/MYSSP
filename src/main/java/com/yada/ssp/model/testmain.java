package com.yada.ssp.model;

import alipay.sdk.AsyncAliPayMerchantHelper;
import alipay.sdk.AsyncAliPayMerchantHelper$;
import alipay.sdk.config.Config;
import alipay.sdk.config.Config$;
import alipay.sdk.protocol.merchantcreate.MerchantCreateResponse;
import alipay.sdk.protocol.merchantcreate.MerchantCreateResponseData;
import alipay.sdk.traitcallback.IMerchantCreateCallBack;
import wechat.sdk.AsyncWeChatCard;
import wechat.sdk.common.Configure;
import wechat.sdk.common.Configure$;
import wechat.sdk.protocol.MerchatAddResp;
import wechat.sdk.traitcallback.IMerchantAddCallback;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by keenlyf on 2017/5/5.
 */
public class testmain {
    public static void main(String [] args){
//        System.out.println(Config$.MODULE$.app_id());
        System.out.println(Configure$.MODULE$.CHANNEL_ID());
        final CountDownLatch latch = new CountDownLatch(1);
//      AsyncAliPayMerchantHelper$.MODULE$.merchantCreate("122132132132",
//              "neinfasef",
//              "asdf",
//              "asdf",
//              null,
//              null,
//              null,
//              null,
//              "2015063000020189",
//              Config$.MODULE$.pid(),
//              null,
//              null,
//              null,
//              null,
//              null,
//              null,
//              null, new IMerchantCreateCallBack() {
//                  @Override
//                  public void callBack(MerchantCreateResponseData response) {
//                      MerchantCreateResponse resp = response.alipay_boss_prod_submerchant_create_response();
//                      if(resp.getCode().equals("10000")){
//                          System.out.println(resp.getSubMerchantId());
//                      }
//                      latch.countDown();
//                  }
//              });
        AsyncWeChatCard.merchantAdd(
                "中国银行",//商户名称
                "银行",//商户简称
                "13800138000",//客服电话
                "",//联系人
                "", //联系电话
                "",//邮箱
                "111",//经营类目
                "9875236987",//备注
                Configure$.MODULE$.MCH_ID(),//渠道号
                new IMerchantAddCallback() {
                    @Override
                    public void callback(MerchatAddResp resp) {

                        if(resp.return_code().equals("SUCCESS")&&resp.result_code().equals("SUCCESS")){
                            System.out.println( resp.sub_mch_id());
                        }
                        latch.countDown();
                    }
                });
        try {
            latch.await(10 ,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            latch.countDown();
            e.printStackTrace();
        }
    }
}
