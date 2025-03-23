package com.compliance.Client.model;

import lombok.Data;

import java.util.List;

@Data
public class BasicDetails {

    private String companyId;
    private String companyLegalName;
    private String companyDBA;
    private String workingStatus;
    private String operatingStatesProvinces;
    private String physicalAddress;
    private String mailingAddress;
    private String yardAddress;
    private String presidentName;
    private List<ContactDetails> contactDetails;
    private String contactPhoneExt;

    private String contactEmail;

    private String mcNumber;
    private String mcPin;
    private String usdot;
    private String fmcsaPin;
    private String kentucky;
    private String newMexicoWDT;
    private String nyFein;
    private String businessNumber;
    private String scac;
    private String carrierCode;
    private String cvorNumberNSC;
    private String cvorExpiryDate;
    private String oregonNumber;
    private String connecticutNumber;
    private String ezeePassAccount;
    private String aPass;
    private String irpAccountNumber;
    private String canadianBondNumber;
    private String usBonded;
    private String wsibAccount;
    private boolean phi;

}
