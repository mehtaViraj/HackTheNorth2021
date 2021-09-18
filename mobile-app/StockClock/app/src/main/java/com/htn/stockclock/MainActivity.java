package com.htn.stockclock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    private Button buttonAdd;

    private ArrayList<String> companyNameList = new ArrayList<>();
    private ArrayList<String> pointsList = new ArrayList<>();
    private ArrayList<Integer> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this, "You selected Apple company", Toast.LENGTH_SHORT).show();

        buttonAdd = findViewById(R.id.buttonAdd); //this is the button to add new companies

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        // Adding List items into the array lists :
        companyNameList.add("Apple");
        //countryNameList.add("Germany");
        //countryNameList.add("USA");

        pointsList.add("+ 0.8");
        //detailsList.add("This is the Germany Flag");
        //detailsList.add("This is the USA Flag");

        imageList.add(R.drawable.apple_logo_black);
        //imageList.add(R.drawable.germany);
        //imageList.add(R.drawable.usa);

        adapter = new RecyclerAdapter(companyNameList, pointsList, imageList, MainActivity.this);
        recyclerView.setAdapter(adapter);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GetCompany.class);
                startActivity(intent);
                finish();
            }
        });

    }
}