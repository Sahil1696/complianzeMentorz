package com.compliance.Client.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

public class FirebaseService {

    public String getUserRoleFromToken(String idToken) throws Exception {
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        String role = (String) decodedToken.getClaims().get("role"); // role must be set in custom claims
        return role;
    }
}
