package com.csci5115.group8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.csci5115.group8.data.user.User;
import com.csci5115.group8.data.user.UserSRL;

import java.util.List;
import java.util.Map;

public class UserSearchResultsAdapter extends RecyclerView.Adapter<UserSearchResultsAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView gender;
        TextView commonAmenities;
        TextView commonAmenitiesHint;


        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameHolder);
            commonAmenities = itemView.findViewById(R.id.commonAmenitiesHolder);
            commonAmenitiesHint = itemView.findViewById(R.id.commonAmenitiesHintHolder);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null)
                itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    private Map<String,User> data;
    private LayoutInflater inflater;
    private ItemClickListener itemClickListener;

    public UserSearchResultsAdapter(Context context, Map<String,User> data, ItemClickListener itemClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
        this.itemClickListener = itemClickListener;
    }

    User getItem(int id) {
        return data.get(id);
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycle_view_user_search_result, parent, false);
        return new ViewHolder(view);
    }

    private String truncate(String str, int maxLen) {
        if (str.length() > maxLen) {
            return str.substring(0, maxLen) + "...";
        } else {
            return str;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = new User("john@apartmate.com",
                "pass",
                "john",
                "male",
                20,
                600,
                false,
                false,
                true,
                true,
                true,
                true,
                "English",
                false);
        holder.name.setText(truncate(user.name, 15));
        holder.name.setVisibility(UserSRL.nameVisible ? View.VISIBLE : View.GONE);
        holder.commonAmenities.setText(truncate(user.gender.toString(), 50));
        holder.commonAmenities.setVisibility(UserSRL.genderVisible ? View.VISIBLE : View.GONE);
        holder.commonAmenitiesHint.setVisibility(UserSRL.genderVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}