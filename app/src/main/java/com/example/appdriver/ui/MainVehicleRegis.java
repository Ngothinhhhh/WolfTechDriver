package com.example.appdriver.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appdriver.Object.Driver;
import com.example.appdriver.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.Date;


public class MainVehicleRegis extends AppCompatActivity {

    String[] item = {"Xe máy", "Xe ô tô"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;
    Button buttonRegisVe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_vehicle_regis);
        autoCompleteTextView = findViewById(R.id.auto_complete_textview);

        buttonRegisVe = findViewById(R.id.btnregisVeh);
        FirebaseFirestore db = FirebaseFirestore.getInstance();



        adapterItems = new ArrayAdapter<String>(this, R.layout.list_vehicle, item);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String item = adapterView.getItemAtPosition(position).toString();

            }
        });

//        buttonRegisVe.setOnClickListener(v -> {
//            Intent regisVeIntent = new Intent(MainVehicleRegis.this,HomeActivity.class);
//            startActivity(regisVeIntent);
//            finish();
//        });

        buttonRegisVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIt = getIntent();
                // lấy bundle khỏi INtent
                Bundle myBd = myIt.getBundleExtra("mypackage");
                // lấy data khỏi Bundle
                String name = myBd.getString("name");
                String email = myBd.getString("email");
                String pass = myBd.getString("pass");
//              String password_hash = generateHashedPass(pass) ;
                String password_hash = pass ;
                String phone_number = myBd.getString("phone");
                Timestamp created_at = new Timestamp(new Date());

                Boolean status = true;
                String vehicle_ref = "xe máy";

                // check data bằng if else
                Driver driver = new Driver(name, email, phone_number,  password_hash, created_at, status , vehicle_ref);
                db.collection("drivers")
                        .add(driver)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(MainVehicleRegis.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainVehicleRegis.this, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
                            }
                        });

                Intent regisVeIntent = new Intent(MainVehicleRegis.this,HomeActivity.class);
                startActivity(regisVeIntent);
                finish();
            }
        });


    }
//    private String generateHashedPass(String pass) {
//        // hash a plaintext password using the typical log rounds (10)
//        String bcryptHashString = Bcrypt.withDefaults().hashToString(12, pass.toCharArray());
//        return bcryptHashString;
//    }

}