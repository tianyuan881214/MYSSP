/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yada.mybatis.paging.Page;
import com.yada.ssp.model.FeeTable;
import com.yada.ssp.model.MerchantBusiness;
import com.yada.ssp.query.FeeTableQuery;
import com.yada.ssp.query.MerchantBusinessQuery;
import com.yada.ssp.service.FeeTableManager;
import com.yada.ssp.service.MerchantBusinessManager;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Controller
public class FeeTableController {
    @Autowired
    private FeeTableManager feeTableManager;
    @Autowired
    private MerchantBusinessManager merchantBusinessManager;

    /**
     * 执行搜索
     */
    @RequestMapping
    public String list(Model model, @ModelAttribute("query") FeeTableQuery query) {

        Page page = feeTableManager.queryPage(query);
        List<FeeTable> feeTableList = page.getResult();
        for (FeeTable feeTable : feeTableList) {
            Double fee = Double.parseDouble(feeTable.getFee());
            BigDecimal b = new BigDecimal(Double.toString(fee));
            BigDecimal a = new BigDecimal(100);
            Double fee1 = a.multiply(b).doubleValue();
            feeTable.setFee(fee1.toString() + "%");
        }
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        return "/ssp_pages/FeeTable/list";
    }

    /**
     * 查看对象
     */
    @RequestMapping
    public String show(Model model, @RequestParam("id") String id) {
        FeeTable feeTable = feeTableManager.getById(id);
        Double fee = Double.parseDouble(feeTable.getFee());
        BigDecimal b = new BigDecimal(Double.toString(fee));
        BigDecimal a = new BigDecimal(100);
        Double fee1 = a.multiply(b).doubleValue();
        feeTable.setFee(fee1.toString() + "%");
        model.addAttribute("model", feeTable);
        return "/ssp_pages/FeeTable/show";
    }

    /**
     * 进入新增页面
     */
    @RequestMapping
    public String create() {
        return "/ssp_pages/FeeTable/create";
    }

    /**
     * 保存新增对象
     */
    @RequestMapping
    public String save(@ModelAttribute("model") FeeTable feeTable) {
        String feeId = feeTableManager.getfeeId();
        feeTable.setFeeId(feeId);
        feeTableManager.insert(feeTable);
        return "redirect:list.do";
    }

    /**
     * 进入更新页面
     */
    @RequestMapping
    public String edit(Model model, @RequestParam("id") String id) {
        model.addAttribute("model", feeTableManager.getById(id));
        return "/ssp_pages/FeeTable/edit";
    }

    /**
     * 保存更新对象
     */
    @RequestMapping
    public String update(@ModelAttribute("model") FeeTable feeTable) {
        feeTableManager.update(feeTable);
        return "redirect:list.do";
    }

    /**
     * 删除对象
     */
    @RequestMapping
    public String delete(Model model, @RequestParam("id") String id) {
        feeTableManager.delete(id);
        return "redirect:list.do";
    }

    @RequestMapping
    public void isMerchandIdEdit(Model model, @RequestParam("feeId") String feeId, HttpServletResponse response) {

        //提示信息
        String mess = "*";
        System.out.println("被调用");
        //不可用
        MerchantBusinessQuery query = new MerchantBusinessQuery();
        query.setFeeTable(feeId);
        List<MerchantBusiness> lists = merchantBusinessManager.findAll(query);
        if (lists.size() != 0) {
            mess = "此扣率已被使用，不可修改!";
        }
        //响应
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(mess);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
