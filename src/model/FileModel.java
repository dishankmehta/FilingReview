package model;

import java.io.FileInputStream;


/**
 * Created by trainees on 2/17/2017.
 */
public class FileModel {

    private String fileName;
    private FileInputStream fileInputStream;

    public FileModel(){

    }

    public FileModel(String fileName, FileInputStream inputStream){
        this.fileName = fileName;
        this.fileInputStream = fileInputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }
}
