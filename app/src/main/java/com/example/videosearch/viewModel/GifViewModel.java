package com.example.videosearch.viewModel;

import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.videosearch.R;

public class GifViewModel extends ViewModel {

    private String url;

    public GifViewModel(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(new RequestOptions().centerCrop().placeholder(R.color.colorAccent))
                .into(imageView);
    }
}
