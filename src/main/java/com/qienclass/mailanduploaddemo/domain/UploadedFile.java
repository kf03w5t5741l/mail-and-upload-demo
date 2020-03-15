package com.qienclass.mailanduploaddemo.domain;

import javax.persistence.*;
import java.nio.file.Path;

@Entity
public class UploadedFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fileId;

    @Column(unique = true)
    private String path;

    public UploadedFile() {}

    public UploadedFile(String path) {
        this.path = path;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
