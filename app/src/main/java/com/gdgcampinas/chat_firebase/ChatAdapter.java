package com.gdgcampinas.chat_firebase;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by thales on 2/23/15.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private List<Chat> mDataset;
    private SparseBooleanArray selectedItems;
    private Context mContext;
    private String mId;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public CardView mCardView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) itemView.findViewById(R.id.tvMessage);
            //mCardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }

    public ChatAdapter(Context context, List<Chat> myDataset, String id) {
        mContext = context;
        mDataset = myDataset;
        selectedItems = new SparseBooleanArray();
        mId = id;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        if(viewType == 1)
        {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_chat_right, parent, false);
        }
        else
        {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_chat_left, parent, false);
        }

        ViewHolder vh = new ViewHolder(v);
        Integer i = vh.getPosition();
        v.setTag(vh);

        return vh;
    }

    @Override
    public int getItemViewType(int position) {
        if(mDataset.get(position).getId().equals(mId))
            return 1;

        return 2;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Chat chat = mDataset.get(position);
        holder.mTextView.setText(chat.getMessage());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
