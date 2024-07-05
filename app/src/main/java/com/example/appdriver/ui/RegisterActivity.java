package com.example.appdriver.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appdriver.R;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegis, btnLoginInRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        // khai báo view và listener
        initView();
        initListener();
    }

    private void initView(){
        // ánh xạ các nút trong view
        btnRegis = (Button) findViewById(R.id.btnregis);
        btnLoginInRegis = (Button) findViewById(R.id.btnLoginInRegis);
    }

    private void initListener(){
        // Nút đăng ký
        btnRegis.setOnClickListener(v -> {
            Intent loginIntent = new Intent(RegisterActivity.this, MainVehicleRegis.class);
            startActivity(loginIntent);
            finish();
        });
        //Nút chuyển sang đăng nhập
        btnLoginInRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toLogin();
            }
        });
    }

    private void toLogin(){
        //qua activity đăng nhập
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }
}