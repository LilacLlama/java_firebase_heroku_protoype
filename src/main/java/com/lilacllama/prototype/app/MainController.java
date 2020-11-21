package com.lilacllama.prototype.app;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Lilac Llama
 */
@Controller
@CrossOrigin
public class MainController {

    Firestore db;

    public MainController() throws Exception {
        String jsonData = System.getenv("SERVICE_JSON");
        String dbURL = System.getenv("DB_URL");
        System.out.println("JSONDATA::" + jsonData);
        System.out.println("DB_URL::" + jsonData);
        InputStream serviceAccount = new ByteArrayInputStream(jsonData.getBytes());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl(dbURL).build();

        FirebaseApp.initializeApp(options);
        this.db = FirestoreClient.getFirestore();
        // asynchronously retrieve all users
    }

    @GetMapping({ "/", "/home" })
    public String adminConsole(Model model) throws Exception {
        System.out.println("Root.");
        ApiFuture<QuerySnapshot> query = db.collection("todos").get();
        // ...
        // query.get() blocks on response
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        List<Map> dataList = new ArrayList<>();
        for (QueryDocumentSnapshot document : documents) {
            Map docData = document.getData();
            docData.put("id", document.getId());
            System.out.println(docData.toString());
            dataList.add(docData);
        }

        model.addAttribute("dataList", dataList);
        return "main";
    }

}
