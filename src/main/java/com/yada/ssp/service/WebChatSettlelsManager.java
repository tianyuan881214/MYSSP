package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.WebChatSettleLsDaoImpl;
import com.yada.ssp.model.WebChatSettleLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/9.
 */
@Service
public class WebChatSettlelsManager extends BaseService<WebChatSettleLs,String>{
    @Autowired
    private WebChatSettleLsDaoImpl webChatSettlsDaoImpl;

    @Override
    protected BaseDao<WebChatSettleLs, String> getBaseDao() {
        return webChatSettlsDaoImpl;

    }
}
