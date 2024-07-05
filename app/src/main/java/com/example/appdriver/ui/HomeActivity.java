package com.example.appdriver.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.appdriver.R;
import com.example.appdriver.bar.HistoryActivity;
import com.example.appdriver.bar.SettingActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements OnMapReadyCallback {

    private DrawerLayout drawerLayout;
    private GoogleMap mMap;
    private View bookingCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    startActivity(new Intent(HomeActivity.this, HistoryActivity.class));
                } else if (id == R.id.nav_settings) {
                    startActivity(new Intent(HomeActivity.this, SettingActivity.class));
                } else if (id == R.id.nav_logout) {

                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        bookingCard = findViewById(R.id.bookingCard);
        Button btnAccept = bookingCard.findViewById(R.id.btnAccept);
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bookingCard.setVisibility(View.GONE);
            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                simulateBookingRequest();
            }
        }, 6000);
    }

    private void simulateBookingRequest() {
        bookingCard.setVisibility(View.VISIBLE);
        TextView tvCustomerName = bookingCard.findViewById(R.id.tvCustomerName);
        TextView tvPickupLocation = bookingCard.findViewById(R.id.tvPickupLocation);
        tvCustomerName.setText("Hoàng Long");
        tvPickupLocation.setText("Quận 7, TP Hồ Chí Minh");
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        LatLng hoChiMinhCity = new LatLng(10.8231, 106.6297);
        mMap.addMarker(new MarkerOptions().position(hoChiMinhCity).title("Marker in Ho Chi Minh City"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hoChiMinhCity, 13));
    }
}
