package com.compliance.Client.model;

import lombok.Data;
import java.util.List;

@Data
public class CompanyDetails {
    private BasicDetails basicDetails;
    private List<PermitLogin> permitLogins;
    private List<AuthorityLogin> authorityLogins;
    private List<LoginGov> loginGovs;
    private List<EldLogin> eldLogins;
    private List<FuelLogin> fuelLogins;
    private List<InsuranceDetails> insuranceProviders;
    private List<CreditCard> creditCards;
}
