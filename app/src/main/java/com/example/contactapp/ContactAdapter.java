package com.example.contactapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private ArrayList<String> localDataSet;
    public ContactAdapter(ArrayList<String> dataSet){
        localDataSet = dataSet;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.getTvIcon().setText(String.valueOf(localDataSet.get(position).charAt(0)));
    holder.getTvName().setText(localDataSet.get(position));

    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvIcon;
        private final TextView tvName;
        public ViewHolder(View view){
            super(view);

            tvIcon = (TextView) view.findViewById(R.id.text_icon);
            tvName = (TextView) view.findViewById(R.id.text_name);
        }

        public TextView getTvIcon() {
            return tvIcon;
        }

        public TextView getTvName() {
            return tvName;
        }
    }
}
