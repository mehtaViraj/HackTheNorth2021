package com.company.stockclock.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.company.stockclock.R;
import com.company.stockclock.adapters.ViewPagerAdapterGeneral;
import com.company.stockclock.fragments.FragmentStats;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class GeneralScreen2Activity extends AppCompatActivity {

    private TabLayout tabLayoutGeneral;
    private ViewPager2 viewPagerGeneral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        //Toast.makeText(getApplicationContext(), imageName, Toast. LENGTH_LONG);

        /*
        String companyName = i.getStringExtra("company_name");
        String imageName = i.getStringExtra("image_name");
        */

        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);

        // sending data to the fragment:
        Bundle newBundle = new Bundle();
        newBundle.putInt("position", position);
        FragmentStats objects = new FragmentStats();
        objects.setArguments(newBundle);


        //now send a bundle to the fragment and then put text in the textbox

        tabLayoutGeneral = findViewById(R.id.tabLayoutCountries);
        viewPagerGeneral = findViewById(R.id.viewPagerCountries);

        ViewPagerAdapterGeneral adapter = new ViewPagerAdapterGeneral(getSupportFragmentManager(), getLifecycle());

        viewPagerGeneral.setAdapter(adapter);

        // the below code is used to LINK the TAB LAYOUT with the VIEWPAGER

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayoutGeneral, viewPagerGeneral
                , true, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                // we will determine the text on the tab layout depending on the position variable

                switch (position)
                {
                    case 0:
                        tab.setText("Quick Stats");
                        break;
                    case 1:
                        tab.setText("Brimming News");
                        break;
                    case 2:
                        tab.setText("Reddit updates");
                        break;
                }

            }
        });

        tabLayoutMediator.attach(); // this will link the tab layout with the view pager
    }
}