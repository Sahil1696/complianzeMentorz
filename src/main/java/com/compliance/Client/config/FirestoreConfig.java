package com.compliance.Client.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirestoreConfig {

    private static Firestore db;

    @Bean
    public static Firestore getFirestore() throws IOException {
        if (db == null) {
            initializeFirebase();
        }
        return db;
    }

    private static void initializeFirebase() throws IOException {
        InputStream serviceAccount = FirestoreConfig.class.getClassLoader()
                .getResourceAsStream("FireStoreServiceKey.json");

        if (serviceAccount == null) {
            throw new FileNotFoundException("ServiceAccountKey.json not found in classpath. Check the file location.");
        }

        // Initialize Firebase only if no apps are already initialized
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            FirebaseApp.initializeApp(options);
        }

        db = FirestoreClient.getFirestore();
    }
}
