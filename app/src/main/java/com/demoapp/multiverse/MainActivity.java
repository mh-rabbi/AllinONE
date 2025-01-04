package com.demoapp.multiverse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    EditText edtUrl;
    ImageView edtSearch;
    GridLayout gridLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtUrl = findViewById(R.id.edt_url);
        edtSearch = findViewById(R.id.edt_search);
        gridLayout = findViewById(R.id.grid_layout);

        edtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = edtUrl.getText().toString();

                if (url.isEmpty()){
                    Toast.makeText(MainActivity.this, "You need to write something to search!", Toast.LENGTH_SHORT).show();

                }else{

                    String regex = "/^(?:(?:(?:https?|ftp):)?\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z0-9\\u00a1-\\uffff][a-z0-9\\u00a1-\\uffff_-]{0,62})?[a-z0-9\\u00a1-\\uffff]\\.)+(?:[a-z\\u00a1-\\uffff]{2,}\\.?))(?::\\d{2,5})?(?:[/?#]\\S*)?$/i";

                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(url);

                    if (matcher.matches()){
                       // myWeb.loadUrl(url);
                    }else{
                       // myWeb.loadUrl("https://www.google.com/search?q="+ url);
                    }
                }
            }
        });

        // Set up grid item click listeners
        for(int i = 0; i < gridLayout.getChildCount(); i++){
            FrameLayout frameLayout = (FrameLayout) gridLayout.getChildAt(i);
            int position = i;

            frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                    intent.putExtra("url", predefinedUrls[position]);
                    startActivity(intent);
                }
            });
        }

    }
}