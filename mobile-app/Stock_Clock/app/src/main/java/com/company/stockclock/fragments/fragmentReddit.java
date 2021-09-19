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

public class fragmentReddit extends Fragment {

    public static fragmentReddit newInstance()
    {
        return new fragmentReddit();
    }

    private ImageView imageViewItaly;
    private ProgressBar progressBarItaly;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_italy, container, false);

        imageViewItaly = view.findViewById(R.id.imageViewItaly);
        progressBarItaly = view.findViewById(R.id.progressBarItaly);

        Picasso.get().load("https://p.kindpng.com/picc/s/208-2084626_flag-hd-png-download.png")
                .into(imageViewItaly, new Callback() {
                    @Override
                    public void onSuccess() {

                        progressBarItaly.setVisibility(View.INVISIBLE);

                    }

                    @Override
                    public void onError(Exception e) {

                        Toast.makeText(getActivity(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        progressBarItaly.setVisibility(View.INVISIBLE);

                    }
                });

       return view;
    }
}
