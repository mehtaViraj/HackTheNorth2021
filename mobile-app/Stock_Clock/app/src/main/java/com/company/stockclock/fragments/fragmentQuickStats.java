package com.company.stockclock.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.company.stockclock.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class fragmentQuickStats extends Fragment {

    public static fragmentQuickStats newInstance()
    {
        return new fragmentQuickStats();
    }

    private ImageView imageViewUnitedKingdom;
    private ProgressBar progressBarUnitedKingdom;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_uk, container, false);

       imageViewUnitedKingdom = view.findViewById(R.id.imageViewUnitedKingdom);
       progressBarUnitedKingdom = view.findViewById(R.id.progressBarUnitedKingdom);


       //graph comes here:
        Picasso.get().load("https://logo.clearbit.com/google.com")
                .into(imageViewUnitedKingdom, new Callback() {
                    @Override
                    public void onSuccess() {

                        progressBarUnitedKingdom.setVisibility(View.INVISIBLE);

                    }

                    @Override
                    public void onError(Exception e) {

                        Toast.makeText(getActivity(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        progressBarUnitedKingdom.setVisibility(View.INVISIBLE);

                    }
                });

       return view;
    }
}
