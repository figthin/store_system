package com.hwua.storesystem.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Announcement {

    private Integer announcementId;
    private String name;
    private Timestamp addTime;
    private Integer times;
    private Integer status;
    private Integer classId;
    private Integer managerId;

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementId=" + announcementId +
                ", name='" + name + '\'' +
                ", addTime=" + addTime +
                ", times=" + times +
                ", status=" + status +
                ", classId=" + classId +
                ", managerId=" + managerId +
                '}';
    }

    public Integer getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
}
