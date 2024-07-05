package com.example.appdriver.bar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdriver.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TripAdapter tripAdapter;
    private List<Trip> tripList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        tripList = new ArrayList<>();
        tripList.add(new Trip("01/01/2024", "Quận 1 đến Quận 7"));
        tripList.add(new Trip("02/01/2024", "Quận 3 đến Quận 5"));
        tripList.add(new Trip("03/01/2024", "Quận 2 đến Quận 9"));

        tripAdapter = new TripAdapter(tripList);
        recyclerView.setAdapter(tripAdapter);
    }
}
