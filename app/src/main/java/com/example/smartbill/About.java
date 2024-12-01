package com.example.smartbill;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        Button githubLink = findViewById(R.id.githubLink);
        githubLink.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Muzhahir/SmartBill-Electricity-Bill-Estimator"));
            startActivity(browserIntent);
        });
    }
}
