package com.compliance.Client.model;

import lombok.Data;

@Data
public class FuelLogin {
    private String fuelVendor;
    private String userId;
    private String password;
    private String securityPin;
    private String remarks;
    private boolean phi;
}
