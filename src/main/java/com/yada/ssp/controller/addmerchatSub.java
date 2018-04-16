package com.yada.ssp.controller;

import wechat.sdk.AsyncWeChatCard;
import wechat.sdk.protocol.MerchatAddResp;
import wechat.sdk.traitcallback.IMerchantAddCallback;

/**
 * Created by syk on 2017/4/20.
 */
public class addmerchatSub {
    public static void main(String args[]){
        try {
            //商户名称
            AsyncWeChatCard.merchantAdd("银行测试",
                    //商户简称
                    "银行测试",
                    //客服电话
                    "13800138000",
                    //联系人
                    "孙永康",
                    //联系电话
                    "13800138000",
                    "602796684@qq.com",
                    //经营类目
                    "204",
                    //商户备注
                    "13800138",
                    //银行商户号
                    "0945842",
                    new IMerchantAddCallback() {
                        @Override
                        public void callback(MerchatAddResp resp) {
                            System.out.println("QQQQQQ:"+resp.return_code());
                            System.out.println("WWSS@@@@:"+resp.sub_mch_id());
                        }
                    });

        }catch (StringIndexOutOfBoundsException e){
            System.out.println(e.toString());
        }
    }
}
