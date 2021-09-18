package com.htn.stockclock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// This adapter class connects the design and the recycler view component
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CompanyViewHolder>{

    private ArrayList<String> companyNameList;
    private ArrayList<String>pointsList;
    private ArrayList<Integer>imageList;
    private Context context;

    public RecyclerAdapter(ArrayList<String> companyNameList, ArrayList<String> pointsList, ArrayList<Integer> imageList, Context context) {
        this.companyNameList = companyNameList;
        this.pointsList = pointsList;
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull

    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false    );

        return new CompanyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, int position) {

        holder.textViewCompany.setText(companyNameList.get(position));
        holder.textViewPoints.setText(pointsList.get(position));
        holder.imageView.setImageResource(imageList.get(position));
        holder.cardView.setOnClickListener(v -> {


        //Toast.makeText(context, "You selected Apple company", Toast.LENGTH_SHORT).show();

        if (position == 0)
        {
            Toast.makeText(context.getApplicationContext(), "You selected Apple company", Toast.LENGTH_SHORT).show();

        }

        });


    }

    @Override
    public int getItemCount() {
        return companyNameList.size();
    }

    public class CompanyViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewCompany, textViewPoints;
        private ImageView imageView;
        private CardView cardView;

        public CompanyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCompany = itemView.findViewById(R.id.textViewCompany);
            textViewPoints = itemView.findViewById(R.id.textViewPoints);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
