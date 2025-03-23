package com.compliance.Client.model;

import lombok.Data;

@Data
public class EldLogin {
    private String eldServiceProvider;
    private String userId;
    private String password;
    private String remarks;
    private boolean phi;
}
