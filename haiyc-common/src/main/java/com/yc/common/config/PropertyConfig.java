package com.yc.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *@project PropertyConfig.java
 *@function 参数配置类
 *@author 村子里最好的剑
 *@date 2020年09月14日 10:20
 */
@Component
public class PropertyConfig {

    @Value("${file.size}")
    private String fileSize;

    @Value("${file.path}")
    private String filePath;

    @Value("${file.visitPath}")
    private String visitPath;

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getVisitPath() {
        return visitPath;
    }

    public void setVisitPath(String visitPath) {
        this.visitPath = visitPath;
    }
}
