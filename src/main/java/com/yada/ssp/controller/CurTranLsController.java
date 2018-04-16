package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.ssp.model.CurTranLs;
import com.yada.ssp.query.CurTranLsQuery;
import com.yada.ssp.service.CurTranLsManager;
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
public class CurTranLsController extends BaseController {
    @Autowired
    private CurTranLsManager curTranLsManager;

    @RequestMapping
    public String list(CurTranLsQuery query, Model model) {
        /*if (query.isS_show()){
            if ((query.getLocalSysDateTimeBegin() == null || "".equals(query.getLocalSysDateTimeBegin()) && (query.getLocalSysDateTimeEnd() == null || "".equals(query.getLocalSysDateTimeEnd())))) {
                SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
                Date date = new Date();
                String tranDate = sdf.format(date);
                query.setLocalSysDateTimeBegin(tranDate);
                query.setLocalSysDateTimeEnd(tranDate);
            }
        }*/
        Page page = curTranLsManager.queryPage(query);
        model.addAttribute("page", page);
        model.addAttribute("query",query);
        return "/ssp_pages/CurTranLs/list";
    }

    @RequestMapping
    public String show( Model model,String id) {
        CurTranLs curTranLs  = curTranLsManager.getById(id);
        model.addAttribute("model", curTranLs);
        return "/ssp_pages/CurTranLs/show";
    }
}
