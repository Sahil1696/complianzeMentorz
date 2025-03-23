package com.compliance.Client.controller;

import com.compliance.Client.model.CompanyDetails;
import com.compliance.Client.service.FireStoreService;
import com.compliance.Client.service.FirebaseService;
import com.compliance.Client.service.PHIFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private FireStoreService firestoreService;

    @Autowired
    private FirebaseService firebaseService;

    @Autowired
    private PHIFilterService phiFilterService;

    @PostMapping("/add")
    public ResponseEntity<String> addCompany(@RequestBody CompanyDetails companyDetails,
                                             @RequestHeader("Authorization") String authHeader) throws Exception {
        // Extract token from Authorization header
        String idToken = authHeader.replace("Bearer ", "");

        // Get user role from Firebase
        String role = firebaseService.getUserRoleFromToken(idToken);

        // Allow only admins to add company
        if (!"admin".equalsIgnoreCase(role)) {
            return ResponseEntity.status(403).body("Unauthorized: Only admins can add companies.");
        }

        // Save company data to Firestore
        firestoreService.addCompany(companyDetails);
        return ResponseEntity.ok("Company Added Successfully");
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDetails> getCompanyDetails(@PathVariable String companyId,
                                                            @RequestHeader("Authorization") String authHeader) throws Exception {
        // Extract Bearer token
        String idToken = authHeader.replace("Bearer ", "");

        // Fetch user role by verifying the token with Firebase
        String role = firebaseService.getUserRoleFromToken(idToken);

        // Fetch the company details from Firestore
        CompanyDetails companyDetails = firestoreService.getCompanyDetails(companyId);

        // If the user is not admin, filter PHI data
        if (!"admin".equalsIgnoreCase(role)) {
            companyDetails = phiFilterService.filterPhiData(companyDetails);
        }

        // Return the final response
        return ResponseEntity.ok(companyDetails);
    }
}

