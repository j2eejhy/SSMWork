package com.jhy.pojo;

import lombok.Data;

@Data
public class Privilege {
    private Long id;

    private String privilegeName;

    private String privilegeUri;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName == null ? null : privilegeName.trim();
    }

    public String getPrivilegeUri() {
        return privilegeUri;
    }

    public void setPrivilegeUri(String privilegeUri) {
        this.privilegeUri = privilegeUri == null ? null : privilegeUri.trim();
    }
}