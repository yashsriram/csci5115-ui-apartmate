package com.csci5115.group8.ui.chatThread;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.csci5115.group8.R;
import com.csci5115.group8.data.Thread;
import com.csci5115.group8.ui.chatThread.ChatThreadFragment.OnListFragmentInteractionListener;
import com.csci5115.group8.ui.chatThread.thread.ThreadContent.ThreadItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ThreadItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyChatThreadRecyclerViewAdapter extends RecyclerView.Adapter<MyChatThreadRecyclerViewAdapter.ViewHolder> {

    private final List<Thread> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyChatThreadRecyclerViewAdapter(List<Thread> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_chatthread, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).first_name);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public Thread mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
