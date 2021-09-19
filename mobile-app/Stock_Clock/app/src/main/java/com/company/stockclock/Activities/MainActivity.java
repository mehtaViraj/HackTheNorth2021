package com.company.stockclock.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.company.stockclock.AddCompanyActivity;
import com.company.stockclock.adapters.AdapterClass;
import com.company.stockclock.ModelClass;
import com.company.stockclock.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ModelClass> arrayList;
    private AdapterClass adapter;
    Button addCompany;

    public ArrayList<String> companyNameList = new ArrayList<>(); //this list will store the names of all the companies the user has invested in
    //store the list of all companies locally as of now.
    //make a feature to add company names and add a card in the recycler view section.
    //run a loop or something over an array of modelclass so that code needn't be written for each company

    public ArrayList<String> imageNames = new ArrayList<>(); //this stores the names/links of all the image names.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recylerView);

        //defining addCompany button:
        addCompany = findViewById(R.id.buttonAdd);

      //  recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
       // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        arrayList = new ArrayList<>();


        // image names list stuff starts ---->

        imageNames = ImageNameHelper.readData(this);

        //adding image names into the array with image names:
        /* INITIAL LOADING OF DATA:
        imageNames.add("apple");
        imageNames.add("microsoft");
        imageNames.add("tesla");
        imageNames.add("amazon");
        */
        ImageNameHelper.writeData(imageNames, getApplicationContext());

        //adding names to the array with company names:


        // company names list stuff starts ---->

        companyNameList = NameFileHelper.readData(this); //this will read data and send it to the arrayList if there is an data
        //FileHelper is the class I wrote, readData method returns the arraylist of existing items

        /* INITIAL LOADING OF DATA:
        companyNameList.add("Apple");
        companyNameList.add("Microsoft");
        companyNameList.add("Tesla");
        companyNameList.add("Amazon");
        */

        NameFileHelper.writeData(companyNameList, getApplicationContext());

        //trying a for loop to reduce number of lines to be written for the modelclass array:
        for (int i = 0; i<imageNames.size(); i++){

            arrayList.add(new ModelClass(imageNames.get(i), companyNameList.get(i), "10 USD"));
            //TODO
            // the third argument in the above thing must be changed after integration with server
            Log.d("I", String.valueOf(i));

        }

        /*
        //creating objects of the model class:
        ModelClass modelClass1 = new ModelClass("apple", "Apple");
        ModelClass modelClass2 = new ModelClass("microsoft", "Microsoft");
        ModelClass modelClass3 = new ModelClass("tesla", "Tesla");
        ModelClass modelClass4 = new ModelClass("amazon", "Amazon");

        arrayList.add(modelClass1);
        arrayList.add(modelClass2);
        arrayList.add(modelClass3);
        arrayList.add(modelClass4);
        */

        adapter = new AdapterClass(arrayList, this);
        recyclerView.setAdapter(adapter);

        addCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, AddCompanyActivity.class);
                startActivity(i);
                finish();

            }
        });



    }
}