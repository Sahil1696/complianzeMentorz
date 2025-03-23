// Sample PHIFilterService.java to remove PHI data for non-admin users

package com.compliance.Client.service;

import com.compliance.Client.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PHIFilterService {

    public CompanyDetails filterPhiData(CompanyDetails company) {
        if (company == null) return null;

        // Filter contact details
        if (company.getBasicDetails().getContactDetails() != null) {
            company.getBasicDetails().setContactDetails(
                    company.getBasicDetails().getContactDetails().stream()
                            .filter(contact -> !contact.isPhi())
                            .collect(Collectors.toList())
            );
        }

        // Similar filtering for other nested lists
        company.setPermitLogins(filterPermitLogins(company.getPermitLogins()));
        company.setAuthorityLogins(filterAuthorityLogins(company.getAuthorityLogins()));
        company.setLoginGovs(filterLoginGov(company.getLoginGovs()));
        company.setEldLogins(filterEldLogins(company.getEldLogins()));
        company.setFuelLogins(filterFuelLogins(company.getFuelLogins()));
        company.setInsuranceProviders(filterInsurance(company.getInsuranceProviders()));
        company.setCreditCards(filterCreditCards(company.getCreditCards()));

        return company;
    }

    private List<PermitLogin> filterPermitLogins(List<PermitLogin> list) {
        return list == null ? null : list.stream().filter(item -> !item.isPhi()).collect(Collectors.toList());
    }

    private List<AuthorityLogin> filterAuthorityLogins(List<AuthorityLogin> list) {
        return list == null ? null : list.stream().filter(item -> !item.isPhi()).collect(Collectors.toList());
    }

    private List<LoginGov> filterLoginGov(List<LoginGov> list) {
        return list == null ? null : list.stream().filter(item -> !item.isPhi()).collect(Collectors.toList());
    }

    private List<EldLogin> filterEldLogins(List<EldLogin> list) {
        return list == null ? null : list.stream().filter(item -> !item.isPhi()).collect(Collectors.toList());
    }

    private List<FuelLogin> filterFuelLogins(List<FuelLogin> list) {
        return list == null ? null : list.stream().filter(item -> !item.isPhi()).collect(Collectors.toList());
    }

    private List<InsuranceDetails> filterInsurance(List<InsuranceDetails> list) {
        return list == null ? null : list.stream().filter(item -> !item.isPhi()).collect(Collectors.toList());
    }

    private List<CreditCard> filterCreditCards(List<CreditCard> list) {
        return list == null ? null : list.stream().filter(item -> !item.isPhi()).collect(Collectors.toList());
    }
}
