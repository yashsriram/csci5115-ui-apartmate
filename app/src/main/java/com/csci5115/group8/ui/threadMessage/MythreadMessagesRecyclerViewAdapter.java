package com.csci5115.group8.ui.threadMessage;

import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.csci5115.group8.R;
import com.csci5115.group8.data.ThreadMessage;
import com.csci5115.group8.ui.threadMessage.threadMessagesFragment.OnListFragmentInteractionListener;

import org.w3c.dom.Text;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MythreadMessagesRecyclerViewAdapter extends RecyclerView.Adapter<MythreadMessagesRecyclerViewAdapter.ViewHolder> {

    private final List<ThreadMessage> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MythreadMessagesRecyclerViewAdapter(List<ThreadMessage> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_threadmessages, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).message);
        if (!mValues.get(position).me) {
            holder.mLinearLayout.removeView(holder.mSpacerView);
        }

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
        public final TextView mSpacerView;
        public final LinearLayout mLinearLayout;
        public ThreadMessage mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mSpacerView = (TextView) view.findViewById(R.id.spacer);
            mContentView = (TextView) view.findViewById(R.id.content);
            mLinearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
