package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.ssp.model.NetPayPerson;
import com.yada.ssp.query.NetPayPersonQuery;
import com.yada.ssp.service.NetPayPersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xianyong
 */
@Controller
public class NetPayPersonController {
    @Autowired
    private NetPayPersonManager netPayPersonManager;

    @RequestMapping
    public String list(Model model, NetPayPersonQuery query) {
        Page page = netPayPersonManager.queryPage(query);
        model.addAttribute("page", page);
        return "ssp_pages/NetPayPerson/list";
    }

    @RequestMapping
    public String show(Model model, String merchant, String userId) {
        NetPayPerson netPayPerson = netPayPersonManager.findByUserIdAndMerchant(merchant, userId);
        model.addAttribute("model", netPayPerson);
        return "ssp_pages/NetPayPerson/show";
    }

    @RequestMapping
    public String delete(Model model, String merchant, String userId) {
        netPayPersonManager.deleteByUserIdAndMerchant(merchant, userId);
        return "redirect:list.do";
    }

    @RequestMapping
    public String create() {
        return "ssp_pages/NetPayPerson/create";
    }

    @RequestMapping
    public String save(NetPayPerson netPayPerson,Model model) {
        NetPayPerson netPayPerson1 = netPayPersonManager.findByUserIdAndMerchant(netPayPerson.getMerchant(),netPayPerson.getUserId());
        if (netPayPerson1!=null && !"".equals(netPayPerson1)){
            model.addAttribute("message","此柜员已存在！！！");
            return "ssp_pages/NetPayPerson/create";
        }
        netPayPersonManager.insert(netPayPerson);
        return "redirect:list.do";
    }

    @RequestMapping
    public String edit(Model model, String merchant, String userId) {
        NetPayPerson netPayPerson = netPayPersonManager.findByUserIdAndMerchant(merchant,userId);
        model.addAttribute("model",netPayPerson);
        return "ssp_pages/NetPayPerson/edit";
    }

    @RequestMapping
    public String update(Model model,NetPayPerson netPayPerson) {
        netPayPersonManager.update(netPayPerson);
        return "redirect:list.do";
    }
}
