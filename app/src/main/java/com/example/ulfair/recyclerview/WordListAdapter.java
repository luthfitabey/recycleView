package com.example.ulfair.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by ulfair on 19/04/2018.
 */

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder>{

    //private final LinkedList<String> mWordList;
    private final LinkedList<NewsItem> mNewsList;
    private LayoutInflater mInflater;

    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordListAdapter.WordViewHolder holder, int position) {
        NewsItem currentNews = mNewsList.get(position);
        //add the data to the view holder
        holder.wordItemView.setText(currentNews.title);
        holder.descItemView.setText(currentNews.desc);
        holder.imageItemView.setImageResource(currentNews.idResGambar);
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public WordListAdapter(Context context, LinkedList<NewsItem> newsList) {
        mInflater = LayoutInflater.from(context);
        this.mNewsList = newsList;
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        public final ImageView imageItemView;
        public final TextView descItemView;
        final WordListAdapter mAdapter;
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.word_title);
            imageItemView=(ImageView) itemView.findViewById(R.id.thumbnail_view);
            descItemView=(TextView) itemView.findViewById(R.id.text);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            /*// Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element = mNewsList.get(mPosition);
            // Change the word in the mWordList.
            mNewsList.set(mPosition, "Clicked! " + element);
            // Notify the adapter, that the data has changed so it can */
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();

        }
    }
}