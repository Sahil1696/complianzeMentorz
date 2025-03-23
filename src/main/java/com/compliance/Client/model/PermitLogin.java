package com.compliance.Client.model;

import lombok.Data;

@Data
public class PermitLogin {
    private String loginType;
    private String accountNumber;
    private String userId;
    private String password;
    private String remarks;
    private boolean phi;
}
