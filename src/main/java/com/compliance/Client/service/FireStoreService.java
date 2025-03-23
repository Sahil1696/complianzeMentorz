package com.compliance.Client.service;

import com.compliance.Client.config.FirestoreConfig;
import com.compliance.Client.model.CompanyDetails;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FireStoreService {

    private final Firestore db;

    @Autowired
    public FireStoreService()
            throws IOException {
        this.db = FirestoreConfig.getFirestore();
    }





    public void addCompany(CompanyDetails companyDetails) throws Exception {
        db.collection("CompanyDetails").document(companyDetails.getBasicDetails().getCompanyId()).set(companyDetails);
    }


    public CompanyDetails getCompanyDetails(String companyId) throws Exception {
        DocumentSnapshot snapshot = db.collection("CompanyDetails").document(companyId).get().get();
        return snapshot.toObject(CompanyDetails.class);
    }
}
