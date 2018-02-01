package com.zc.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "commonConfig")
public class CommonConfig {

    private String commonUploadFilePath;

    private String uploadPath;

    public String getCommonUploadFilePath() {
        return commonUploadFilePath;
    }

    public void setCommonUploadFilePath(String commonUploadFilePath) {
        this.commonUploadFilePath = commonUploadFilePath;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @Override
    public String toString() {
        return "CommonConfig{" +
                "commonUploadFilePath='" + commonUploadFilePath + '\'' +
                ", uploadPath='" + uploadPath + '\'' +
                '}';
    }
}
