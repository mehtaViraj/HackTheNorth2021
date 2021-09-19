package com.company.stockclock.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.company.stockclock.R;
import com.company.stockclock.adapters.ViewPagerAdapterGeneral;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class GeneralScreen2Activity extends AppCompatActivity {

    private TabLayout tabLayoutGeneral;
    private ViewPager2 viewPagerGeneral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

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