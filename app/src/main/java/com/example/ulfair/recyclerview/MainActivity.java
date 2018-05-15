package com.example.ulfair.recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    //private final LinkedList<String> mWordList = new LinkedList<>();
    private final LinkedList<NewsItem> mNewsList = new LinkedList<>();
    private int mCount = 0;
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 10; i++) {
            //mNewsList.addLast("Word " + mCount++);
        }
            NewsItem news1 = new NewsItem();
            news1.title = "Bayar Wifi";
            news1.desc = "Rabu, 09 Maret 2018";
            news1.idResGambar = R.drawable.android;
            mNewsList.add(news1);

            NewsItem news2 = new NewsItem();
            news2.title = "Beli paketan bulanan";
            news2.desc = "Senin, 18 April 2018";
            news2.idResGambar = R.drawable.user;
            mNewsList.add(news2);

            NewsItem news3 = new NewsItem();
            news3.title = "Membayar Kos bulanan";
            news3.desc = "Sabtu, 23 April 2018";
            news3.idResGambar = R.drawable.clerk;
            mNewsList.add(news3);

            // Get a handle to the RecyclerView.
            mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
            // Create an adapter and supply the data to be displayed.
            mAdapter = new WordListAdapter(this, mNewsList);
            // Connect the adapter with the RecyclerView.
            mRecyclerView.setAdapter(mAdapter);
            // Give the RecyclerView a default layout manager.
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
           // Log.d("WordList", mWordList.getLast());

        // Add a floating action click handler for creating new entries.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mNewsList.size();
                // Add a new word to the end of the wordList.
                //mNewsList.addLast("+ Word " + wordListSize);
                // Notify the adapter, that the data has changed so it can
                // update the RecyclerView to display the data.
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                // Scroll to the bottom.
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });
    }

}
