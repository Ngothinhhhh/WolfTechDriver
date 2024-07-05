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

public class LoginActivity extends AppCompatActivity {

    private Button btnRegisInLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Khai báo các thành phần trong view
        initView();
        // Khai báo các xử lý chức năng
        initListener();
    }

    private void initView(){
        btnRegisInLogin = (Button) findViewById(R.id.btnRegisInLogin);
    }

    private void initListener(){
        btnRegisInLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRegister();
            }
        });
    }

    private void toRegister(){
        //qua activity đăng ký
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
    }
}