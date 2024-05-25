package com.example.myproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    private ArrayList<recipe_feed> arrayList;

    public RecipesAdapter(ArrayList<recipe_feed> arrayList,
                          RecyclerViewInterface recyclerViewInterface){
        this.arrayList=arrayList;
        this.recyclerViewInterface=recyclerViewInterface;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.recipe_item,parent,false);
        return new ViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        recipe_feed recipeFeed=arrayList.get(position);
        holder.name.setText(recipeFeed.getName());
        holder.recipeImage.setImageResource(recipeFeed.getRecipeImage());
        holder.profileImage.setImageResource(recipeFeed.getProfileImage());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImage, recipeImage;
        TextView name;
        ImageButton like,comment,add;
        int num=1;

        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            profileImage=itemView.findViewById(R.id.profileImage);
            recipeImage=itemView.findViewById(R.id.recipeImage);
            name=itemView.findViewById(R.id.Name);
            like=itemView.findViewById(R.id.like);
            comment=itemView.findViewById(R.id.comment);
            add=itemView.findViewById(R.id.mealAdd);


            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (num == 1) {
                        like.setBackgroundResource(R.drawable.baseline_favorite_24);
                        num++;
                    } else if (num == 2) {
                        like.setBackgroundResource(R.drawable.baseline_favorite_border_24);
                        num--;
                    }
                }
            });

            recipeImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface!=null){
                        int pos=getAdapterPosition();

                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.OnItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
