package com.ahmedadel.cleanmoviesampleapp.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmedadel.cleanmoviesampleapp.R;
import com.ahmedadel.presentation.model.TVUIModel;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeTvAdapter extends RecyclerView.Adapter<HomeTvAdapter.ViewHolder> {

    private List<TVUIModel> tvs;

    public HomeTvAdapter(List<TVUIModel> tvs) {
        this.tvs = tvs;
    }

    @NonNull
    @Override
    public HomeTvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new HomeTvAdapter.ViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.tv_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(tvs.get(position));
    }

    @Override
    public int getItemCount() {
        return tvs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_image)
        ImageView tvImage;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(TVUIModel tv) {
            tvTitle.setText(tv.getName());
            String IMAGE_URL = "https://image.tmdb.org/t/p/w200/";
            Glide.with(itemView.getContext()).load(IMAGE_URL + tv.getPosterPath())
                    .into(tvImage);
        }
    }

}
