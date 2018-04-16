package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.WebChatSettleLsDaoImpl;
import com.yada.ssp.dao.WebChatTranLsDaoImpl;
import com.yada.ssp.model.WebChatSettleLs;
import com.yada.ssp.model.WebChatTranLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/10.
 */
@Service
public class WebChatTranLsManager extends BaseService<WebChatTranLs,String> {
    @Autowired
    private WebChatTranLsDaoImpl webChatTranLsDao;

    @Override
    protected BaseDao<WebChatTranLs, String> getBaseDao() {
        return webChatTranLsDao;
    }
}
