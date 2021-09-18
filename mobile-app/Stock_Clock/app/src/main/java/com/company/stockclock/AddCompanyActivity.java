package com.company.stockclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.company.stockclock.Activities.ImageNameHelper;
import com.company.stockclock.Activities.MainActivity;
import com.company.stockclock.Activities.NameFileHelper;

import java.util.ArrayList;

public class AddCompanyActivity extends AppCompatActivity {

    Button buttonAdd;
    EditText newCompany;

    public ArrayList<String> companyNameList = new ArrayList<>();

    public ArrayList<String> imageNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company2);

        buttonAdd = findViewById(R.id.buttonAddCompany);
        newCompany = findViewById(R.id.editTextName);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageNames = ImageNameHelper.readData(getApplicationContext());
                imageNames.add("https://logo.clearbit.com/"+newCompany.getText().toString().toLowerCase()+".com");
                ImageNameHelper.writeData(imageNames, getApplicationContext());

                companyNameList = NameFileHelper.readData(getApplicationContext()); //this will read data and send it to the arrayList if there is an data
                companyNameList.add(newCompany.getText().toString());
                NameFileHelper.writeData(companyNameList, getApplicationContext());

                Log.d("list", imageNames.toString());
                Log.d("list 2", companyNameList.toString());

                Intent i = new Intent(AddCompanyActivity.this, MainActivity.class);
                startActivity(i);

                finish();

            }
        });

    }
}