package com.yada.ssp.controller;

import com.yada.ssp.model.AlpConfigParam;
import com.yada.ssp.service.AlpConfigParamManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xianyong
 */
@Controller
public class AlpConfigParamController {
    @Autowired
    private AlpConfigParamManager alpConfigParamManager;

    @RequestMapping
    public String edit(Model model,String result) {
        if ("0".equals(result)){
            model.addAttribute("message",result);
        }
        AlpConfigParam alpConfigParam = alpConfigParamManager.findAll();
        model.addAttribute("alpConfigParam", alpConfigParam);
        return "/ssp_pages/AlpConfigParam/edit";
    }

    @RequestMapping
    public String update(AlpConfigParam alpConfigParam) {
        AlpConfigParam alpConfigParam1 = alpConfigParamManager.findAll();
        alpConfigParam1.setPid(alpConfigParam.getPid());
        alpConfigParam1.setAppId(alpConfigParam.getAppId());
        alpConfigParam1.setPublicKey(alpConfigParam.getPublicKey());
        alpConfigParam1.setAlpPublicKey(alpConfigParam.getAlpPublicKey());
        alpConfigParam1.setPrivateKey(alpConfigParam.getPrivateKey());
        alpConfigParamManager.update(alpConfigParam1);
        String result="0";
        return "redirect:edit.do?result="+result;
    }
}