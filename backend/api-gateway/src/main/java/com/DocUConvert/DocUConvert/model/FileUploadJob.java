package com.DocUConvert.DocUConvert.model;

import jakarta.persistence.*;


@Entity
@Table(name = "file_upload_jobs")
public class FileUploadJob {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
  
    private String fileName;
  
    private String filePath;

    private String targetFormat;

    private String status;

    public FileUploadJob() {
        // Default constructor
    }


   
    public FileUploadJob(String fileName, String filePath, String targetFormat, String status) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.targetFormat = targetFormat;
        this.status = status;
    }

    public String getTargetFormat() {
        return targetFormat;
    }

    public void setTargetFormat(String targetFormat) {
        this.targetFormat = targetFormat;
    }
  
    public Long getId() {
      return id;
    }
  
    public void setId(Long id) {
      this.id = id;
    }
  
    public String getName() {
      return fileName;
    }
  
    public void setName(String fileName) {
      this.fileName = fileName;
    }
  
    public String getfilePath() {
      return filePath;
    }
  
    public void setfilePath(String filePath) {
      this.filePath = filePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
  }