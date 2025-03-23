package com.compliance.Client.model;

import lombok.Data;

@Data
public class AuthorityLogin {
    private String authorityType;
    private String accountNumber;
    private String userId;
    private String password;
    private String link;
    private String renewalDate;
    private String daysLeftInRenewal;
    private String remarks;
    private boolean phi;
}
