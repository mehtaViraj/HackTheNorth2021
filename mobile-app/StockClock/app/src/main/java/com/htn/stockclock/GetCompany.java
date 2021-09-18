package com.htn.stockclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GetCompany extends AppCompatActivity {

    EditText companyName;
    Button doneDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_company);

        companyName = findViewById(R.id.editTextTextCompanyName);
        doneDone = findViewById(R.id.buttonAdd);

        doneDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String company = companyName.getText().toString();

                Intent i = new Intent(GetCompany.this, MainActivity.class);
                i.putExtra("name", company); // "name" is the keyword

                startActivity(i);

                finish();

            }
        });


    }
}