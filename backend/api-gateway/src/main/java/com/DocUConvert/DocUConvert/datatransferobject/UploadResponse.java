package com.DocUConvert.DocUConvert.datatransferobject;

public class UploadResponse {

    private String fileName;
    private Long jobId;
    private String targetFormat;
    private String status;

    public UploadResponse() {
        // Default constructor
    }

    public UploadResponse(String fileName, Long jobId, String targetFormat, String status) {
        this.fileName = fileName;
        this.jobId = jobId;
        this.targetFormat = targetFormat;
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getjobId() {
        return jobId;
    }

    public void setJobID(Long jobId) {
        this.jobId = jobId;
    }

    public String getTargetFormat() {
        return targetFormat;
    }

    public void setTargetFormat(String targetFormat) {
        this.targetFormat = targetFormat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
