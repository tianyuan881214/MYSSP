/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */


package com.yada.ssp.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;


/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


@Controller
public class BatchFileDownloadController {
    @Value("#{configProperties['downloadfilepathforbank']}")
    private String downloadfilepathforbank;
    @Value("#{configProperties['downloadfilepathformerchant']}")
    private String downloadfilepathformerchant;


/**
     * 执行搜索
     */
    @RequestMapping
    public String list(Model model,String fileDate) {

        //E://日期.zip    //商户号加日期
        File downLoadFile = new File(downloadfilepathforbank);
        String fileName = "";
        for(String file : downLoadFile.list()){
         if(fileDate!=null&&!fileDate.equals("")&&file.contains(fileDate))
            fileName = file;
        }
        model.addAttribute("files", fileName);
        model.addAttribute("fileDate",fileDate);
        return "/ssp_pages/BatchFileDownload/list";
    }

    @RequestMapping
    public  ResponseEntity<byte[]> download(String fileName) throws IOException {
        File file=new File(downloadfilepathforbank+fileName);
        HttpHeaders headers=new HttpHeaders();
        System.out.print(fileName);
        headers.setContentDispositionFormData("attachment",  new String(fileName.getBytes("GBK"),"ISO-8859-1"));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers,HttpStatus.OK);
    }

    @RequestMapping
    public String listMer(Model model,String fileDate,String merchantId) {
        File downLoadFile = new File(downloadfilepathformerchant);
        String fileName = "";
        for(String file : downLoadFile.list()){
            if(fileDate!=null&&!fileDate.equals("")&&file.contains(merchantId+fileDate))
                fileName = file;
        }
        model.addAttribute("files", fileName);
        model.addAttribute("fileDate",fileDate);
        return "/ssp_pages/BatchFileDownload/listMer";
    }
    @RequestMapping
    public  ResponseEntity<byte[]> downloadMer(String fileName) throws IOException {
        File file=new File(downloadfilepathformerchant+fileName);
        HttpHeaders headers=new HttpHeaders();
        System.out.print(fileName);
        headers.setContentDispositionFormData("attachment",  new String(fileName.getBytes("GBK"),"ISO-8859-1"));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers,HttpStatus.OK);
    }

}

