package com.hwua.storesystem.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Brand {

    private Integer brandId;
    private String name;
    private Integer status;
    private Timestamp addTime;
    private String url;
    private String description;

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", addTime=" + addTime +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}