package com.compliance.Client.model;

import lombok.Data;

@Data
public class CreditCard {
    private String cardType;
    private String cardCurrency;
    private String cardNumber;
    private String expiryDate; // MM/YY
    private String cvv;
    private String cardHolderName;
    private String cardAddress;
    private String remarks;
    private boolean phi;
}
