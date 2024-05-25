package com.example.myproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.ViewHolder>{

    private ArrayList<goal_feed> arrayList;

    public GoalAdapter(ArrayList<goal_feed> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.goal_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        goal_feed goalFeed=arrayList.get(position);
        holder.description.setText(goalFeed.getDescription());
        holder.goalProgress.setMax(goalFeed.getMax());
        holder.goalProgress.setProgress(goalFeed.getCurrent());
        holder.currentProg.setText(String.valueOf(goalFeed.getCurrent()));
        holder.target.setText(String.valueOf(goalFeed.getMax()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView description, currentProg, target;
        ProgressBar goalProgress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            description=itemView.findViewById(R.id.goal_description);
            goalProgress=itemView.findViewById(R.id.goalProgress);
            currentProg=itemView.findViewById(R.id.currentProg);
            target=itemView.findViewById(R.id.target);
        }
    }
}
