package com.compliance.Client.model;

import lombok.Data;

@Data
public class LoginGov {
    private String accountNumber;
    private String userId;
    private String password;
    private String accountStatus;
    private String link;
    private String backupCodes;
    private String remarks;
    private boolean phi;
}
