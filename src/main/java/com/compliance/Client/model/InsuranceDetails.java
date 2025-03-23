package com.compliance.Client.model;

import lombok.Data;

@Data
public class InsuranceDetails {
    private String brokerName;
    private String policyNumber;
    private String expiryDate;
    private String remarks;
    private boolean phi;
}
