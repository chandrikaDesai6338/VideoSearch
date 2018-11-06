package com.example.videosearch.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.videosearch.R;
import com.example.videosearch.databinding.ItemBinding;
import com.example.videosearch.viewModel.GifViewModel;

import java.util.Collections;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<String> urls;
    public Context context;

    public ItemAdapter(Context context) {
        this.urls = Collections.emptyList();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.binding.setGifViewModel(new GifViewModel(urls.get(i)));
        holder.binding.executePendingBindings();
    }

    @Override
    public void onViewRecycled(final ViewHolder holder) {
        super.onViewRecycled(holder);
        ImageView imageViewGif = holder.binding.imageViewGif;
        Glide.with(context).clear(imageViewGif);
        imageViewGif.setImageDrawable(null);

    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    public void setUrls(List<String> urls) {
        if (this.urls.isEmpty()) {
            this.urls = urls;
        } else {
            this.urls.addAll(urls);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        this.urls.clear();
    }

     class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemBinding binding;

        public ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, PlayVideo.class);
            intent.putExtra("VIDEO_URL", urls.get()
            context.startActivity(intent);

        }
    }
}