package com.demoapp.multiverse;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String[] predefinedUrls = {
            "https://www.nytimes.com",         // The New York Times
            "https://www.theguardian.com",    // The Guardian
            "https://www.wsj.com",            // The Wall Street Journal
            "https://www.washingtonpost.com", // The Washington Post
            "https://www.bbc.com/news",       // BBC News
            "https://www.cnn.com",            // CNN
            "https://www.aljazeera.com",      // Al Jazeera
            "https://www.reuters.com"         // Reuters
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }
}