package com.zc.controller;

import com.zc.service.GetUploadFileService;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/upload")
public class GetUploadFileController {

    @Autowired
    private GetUploadFileService getUploadFileService;

    /*
    * 接收上传事件
    * @params request
    * @params multiReq
    * */
    @PostMapping(value = "/file")
    public CommonResult getFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        return getUploadFileService.getFile(file, request);
    }
}
