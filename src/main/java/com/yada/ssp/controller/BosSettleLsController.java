package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.ssp.model.BosSettleLs;
import com.yada.ssp.query.BosSettleLsQuery;
import com.yada.ssp.service.BosSettleLsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xianyong
 */
@Controller
public class BosSettleLsController extends BaseController {
    @Autowired
    private BosSettleLsManager bosSettleLsManager;

    @RequestMapping
    public String list(Model model, BosSettleLsQuery query){
        if (query.isS_show()) {
            if ((query.getTranDateTimeBegin() == null || "".equals(query.getTranDateTimeBegin()) && (query.getTranDateTimeEnd() == null || "".equals(query.getTranDateTimeEnd())))) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Date date = new Date();
                String tranDate = sdf.format(new Date(date.getTime() - 24 * 60 * 60 * 1000));
                query.setTranDateTimeBegin(tranDate);
                query.setTranDateTimeEnd(tranDate);
            }
        }
        Page page = bosSettleLsManager.queryPage(query);
        model.addAttribute("page",page);
        model.addAttribute("query",query);
        return "/ssp_pages/BosSettleLs/list";
    }

    @RequestMapping
    public String show(Model model, String id){
        BosSettleLs bosSettleLs = bosSettleLsManager.getById(id);
        model.addAttribute("model",bosSettleLs);
        return "/ssp_pages/BosSettleLs/show";
    }
}
