package com.hwua.storesystem.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Permission {

    private Integer permissionId;
    private Integer parentId;
    private String name;
    private String url;
    private List<Permission> children;


    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }
}
