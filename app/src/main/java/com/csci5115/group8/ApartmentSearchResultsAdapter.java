package com.csci5115.group8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.csci5115.group8.data.apartment.Apartment;
import com.csci5115.group8.data.apartment.ApartmentUnit;

import java.util.List;

public class ApartmentSearchResultsAdapter extends RecyclerView.Adapter<ApartmentSearchResultsAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameHolder);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null)
                itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    private List<Apartment> data;
    private LayoutInflater inflater;
    private ItemClickListener itemClickListener;

    public ApartmentSearchResultsAdapter(Context context, List<Apartment> data, ItemClickListener itemClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
        this.itemClickListener = itemClickListener;
    }

    Apartment getItem(int id) {
        return data.get(id);
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view_apartment_search_result, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Apartment apartment = data.get(position);
        holder.name.setText("" + apartment.name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}