package com.isoftstone.humanresources.domain.workTime;

import java.io.InputStream;

public class FileModel {

    private String fileName ;

    private InputStream fileInputstream ;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getFileInputstream() {
        return fileInputstream;
    }

    public void setFileInputstream(InputStream fileInputstream) {
        this.fileInputstream = fileInputstream;
    }
}
