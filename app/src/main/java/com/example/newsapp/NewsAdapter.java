package com.example.newsapp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {

    private ArrayList<News> mData = new ArrayList<News>();
    private Context mContext;


    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_news, parent, false);

        NewsHolder newsHolder = new NewsHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicked(mData.get(newsHolder.getAdapterPosition()));
            }
        });

        mContext = parent.getContext();

        return  newsHolder;
    }

    private void onItemClicked(News news) {
        String url = news.getUrl();
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(mContext, Uri.parse(url));
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        News  newsItem = mData.get(position);

        holder.titleView.setText(newsItem.getTitle());
        holder.authorView.setText(newsItem.getAuthor());

        Glide.with(mContext).load(newsItem.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateUI(ArrayList<News> newsArrayList){
        mData.clear();
        mData.addAll(newsArrayList);

        notifyDataSetChanged();
    }

}

class NewsHolder extends RecyclerView.ViewHolder {

    TextView titleView;
    TextView authorView;
    ImageView imageView;

    public NewsHolder(@NonNull @NotNull View itemView) {
        super(itemView);

        titleView = itemView.findViewById(R.id.title);
        authorView = itemView.findViewById(R.id.author);
        imageView = itemView.findViewById(R.id.image);
    }
}