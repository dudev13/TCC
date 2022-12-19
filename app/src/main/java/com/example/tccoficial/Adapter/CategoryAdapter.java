package com.example.tccoficial.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import com.example.tccoficial.Activity.ShowDetailActivity;
import com.example.tccoficial.Domain.CategoryDomain;
import com.example.tccoficial.Domain.FoodDomain;
import com.example.tccoficial.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<CategoryDomain> ItemDomains;
    ArrayList<FoodDomain> FoodDomain;
    ConstraintLayout mainLayout;


    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.ItemDomains = categoryDomains;
    }

    public void FoodDomain(ArrayList<FoodDomain> foodDomain){
        this.FoodDomain= foodDomain;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.ItemName.setText(ItemDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(ItemDomains.get(position).getFee()));

        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(ItemDomains.get(position).getPic(), "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(v -> {
            Intent intent=new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
//            intent.putExtra("object", String.valueOf(FoodDomain.get(position)));
           // intent.putExtra("object", String.valueOf(ItemDomains.get(position)));
            //intent.putExtra("object", ItemDomains.get(position));
            holder.itemView.getContext().startActivity(intent);



        });
    }

    @Override
    public int getItemCount() { return ItemDomains.size() ; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ItemName;
        ImageView pic;
        TextView ItemDescription;
        TextView fee;
        ConstraintLayout mainLayout;
        ImageView addBtn;


        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ItemName= itemView.findViewById(R.id.title);
            pic= itemView.findViewById(R.id.pic);
            //ItemDescription = itemView.findViewById(R.id.description);
            fee = itemView.findViewById(R.id.fee);
            mainLayout= itemView.findViewById(R.id.viewLayout);
            addBtn = itemView.findViewById(R.id.addBtn);
        }

        public class categorias{


        }
    }

}
