package com.kamau.gabriel.kiswahili;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public  class SwahiliAdapter extends RecyclerView.Adapter<SwahiliAdapter.SwahiliViewHolder> {
    private String[] dataSet = new String[]{};

    void setDataSet(String[] dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public SwahiliAdapter.SwahiliViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView textView = (TextView)
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.words,viewGroup,false);
        return new SwahiliViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull SwahiliAdapter.SwahiliViewHolder swahiliViewHolder, int i) {
        if (!dataSet[i].isEmpty()){
            swahiliViewHolder.textView.setText((i+1)+". "+dataSet[i]);}
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }
    class SwahiliViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        SwahiliViewHolder(@NonNull TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }
}