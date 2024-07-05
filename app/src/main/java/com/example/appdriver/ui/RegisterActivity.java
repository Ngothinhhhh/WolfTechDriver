package com.example.appdriver.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appdriver.R;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        btnRegis = findViewById(R.id.btnregis);

        btnRegis.setOnClickListener(v -> {
            Intent loginIntent = new Intent(RegisterActivity.this, MainVehicleRegis.class);
            startActivity(loginIntent);
            finish();
        });
    }
}