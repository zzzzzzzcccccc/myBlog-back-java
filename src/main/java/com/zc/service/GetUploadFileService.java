package com.zc.service;

import com.zc.utils.CommonConfig;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Service
public class GetUploadFileService {

    @Autowired
    private CommonConfig commonConfig;

    /*
    * 接收文件上传
    * @params file
    * @params request
    * */
    public CommonResult getFile(MultipartFile file, HttpServletRequest request) {

        if (file.isEmpty()) {
            return CommonResult.paramsError("");
        } else {
            // 文件名
            String fileName = file.getOriginalFilename();
            // 文件后缀
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 上传路径
            String uploadPath = commonConfig.getUploadPath();
            // 存放到的文件名称
            String uploadFileName = UUID.randomUUID() + "_" + new Date().getTime() + suffixName;
            // 新的文件
            File uploadFile = new File(uploadPath + uploadFileName);
            // 文件夹不存在新建一个
            if (!uploadFile.getParentFile().exists()) {
                uploadFile.getParentFile().mkdirs();
            }

            try {
                file.transferTo(uploadFile);
                commonConfig.setCommonUploadFilePath(commonConfig.getCommonUploadFilePath() + uploadFileName);
            } catch (IllegalStateException e) {
            } catch (IOException e) {}
        }

        return CommonResult.success(commonConfig.getCommonUploadFilePath());
    }
}
