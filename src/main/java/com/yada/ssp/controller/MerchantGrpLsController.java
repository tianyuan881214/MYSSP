package com.yada.ssp.controller;

import com.yada.common.dict.util.DictUtil;
import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.ssp.model.MerchantBaseSon;
import com.yada.ssp.model.MerchantGrpLs;
import com.yada.ssp.query.MerchantGrpLsQuery;
import com.yada.ssp.service.MerchantBaseSonManager;
import com.yada.ssp.service.MerchantGrpLsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author xianyong
 */
@Controller
public class MerchantGrpLsController extends BaseController {
    @Autowired
    private MerchantGrpLsManager merchantGrpLsManager;
    @Autowired
    private MerchantBaseSonManager merchantBaseSonManager;

    @RequestMapping
    public String list(Model model, MerchantGrpLsQuery query, String message) {
        if (message != null && !"".equals(message)) {
            System.out.println("message:" + message);
            if (message.equals("0")) {
                model.addAttribute("message", "此分组已在使用，删除失败！");
            } else if (message.equals("1")) {
                model.addAttribute("message", "删除成功");
            }
        }
        Page page = merchantGrpLsManager.queryPage(query);
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        return "/ssp_pages/MerchantGrpLs/list";
    }

    @RequestMapping
    public String show(Model model, String id) {
        MerchantGrpLs merchantGrpLs = merchantGrpLsManager.getById(id);
        model.addAttribute("model", merchantGrpLs);
        return "/ssp_pages/MerchantGrpLs/show";
    }

    @RequestMapping
    public String create() {
        return "/ssp_pages/MerchantGrpLs/create";
    }

    @RequestMapping
    public String save(MerchantGrpLs merchantGrpLs) {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat formatTime = new SimpleDateFormat("HHmmss");
        String currDate = formatDate.format(date);
        String currTime = formatTime.format(date);
//        merchantGrpLs.setZbank(getCurUser().getUserExt().getOrgId());
        merchantGrpLs.setUpdateTime(currTime);
        merchantGrpLs.setUpdateDate(currDate);
        merchantGrpLsManager.insert(merchantGrpLs);
        DictUtil.remove("D_MER_GRP_ID");
        return "redirect:list.do";
    }

    @RequestMapping
    public String edit(String id, Model model) {
        MerchantGrpLs merchantGrpLs = merchantGrpLsManager.getById(id);
        model.addAttribute("model", merchantGrpLs);
        return "/ssp_pages/MerchantGrpLs/edit";
    }

    @RequestMapping
    public String update(MerchantGrpLs merchantGrpLs) {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat formatTime = new SimpleDateFormat("HHmmss");
        String currDate = formatDate.format(date);
        String currTime = formatTime.format(date);
        merchantGrpLs.setUpdateDate(currDate);
        merchantGrpLs.setUpdateTime(currTime);
        merchantGrpLsManager.update(merchantGrpLs);
        DictUtil.remove("D_MER_GRP_ID");
        return "redirect:list.do";
    }

    @RequestMapping
    public String delete(String id) {
        List<MerchantBaseSon> merchantBaseSons = merchantBaseSonManager.findByMerGrpId(id);
        String message;
        if (merchantBaseSons.size() > 0) {
            message = "0";
        } else {
            merchantGrpLsManager.delete(id);
            DictUtil.remove("D_MER_GRP_ID");
            message = "1";
        }
        return "redirect:list.do?message=" + message;
    }

    /**
     * 验证商户分组是否已存在
     *
     * @param
     * @author longwu.yan
     */
    @RequestMapping
    public void AJAX_isMerGrpIdExist(String merGrpId,
                                     HttpServletResponse response) {

        // 提示信息
        String mess = "*";
        MerchantGrpLs merchantGrpLs = merchantGrpLsManager.getById(merGrpId);
        // 不可用
        if (merchantGrpLs != null && !"".equals(merchantGrpLs)) {
            mess = "此商户分组已存在!";
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
}
