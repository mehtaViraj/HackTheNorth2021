package com.company.stockclock.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.company.stockclock.Activities.ImageNameHelper;
import com.company.stockclock.Activities.NameFileHelper;
import com.company.stockclock.ModelClass;
import com.company.stockclock.R;
import com.company.stockclock.Activities.GeneralScreen2Activity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.CardViewHolder>{

    private ArrayList<ModelClass> modelList;
    private Context context;

    public AdapterClass(ArrayList<ModelClass> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //we mention which card holder design we wanna use, here

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent, false);

        return new CardViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.CardViewHolder holder, int position) {

        //display data here
        ModelClass model = modelList.get(position);
        holder.textViewSplash.setText(model.getCategoryName());

        //here below the image is displayed:
        /*
        holder.imageViewSplash.setImageResource(context.getResources()
                .getIdentifier(model.getImageName(), "", context.getPackageName()));

         */

        holder.prevClose.setText(model.getPrevClose());

        Picasso.get().load(model.getImageName()).into(holder.imageViewSplash);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //MainActivity mainActivity = new MainActivity();

                ArrayList<String> companyNameList;
                ArrayList<String> imageNames;

                companyNameList = NameFileHelper.readData(context);
                imageNames = ImageNameHelper.readData(context);

                Intent intent = new Intent(context, GeneralScreen2Activity.class);
                intent.putExtra("company_name", companyNameList.get(position)); // "name" is the keyword
                intent.putExtra("image_name", imageNames.get(position));
                context.startActivity(intent);


                /*
                if (position == 0)
                {
                    Intent intent = new Intent(context, GeneralScreen2Activity.class);
                    context.startActivity(intent);
                }
                if (position == 1)
                {
                    Intent intent = new Intent(context, LeadersActivity.class);
                    context.startActivity(intent);
                }
                if (position == 2)
                {
                    Intent intent = new Intent(context, MuseumsActivity.class);
                    context.startActivity(intent);
                }
                if (position == 3)
                {
                    Intent intent = new Intent(context, WondersActivity.class);
                    context.startActivity(intent);
                }
                */
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewSplash;
        private TextView textViewSplash;
        private CardView cardView;
        private TextView prevClose;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewSplash = itemView.findViewById(R.id.imageViewSplash);
            textViewSplash = itemView.findViewById(R.id.textViewSplash);
            cardView = itemView.findViewById(R.id.cardView);
            prevClose = itemView.findViewById(R.id.textViewPrevClose);

        }


    }

}
