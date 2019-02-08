package com.ahmedadel.cleanmoviesampleapp.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmedadel.cleanmoviesampleapp.R;
import com.ahmedadel.presentation.model.MovieUIModel;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeMovieAdapter extends RecyclerView.Adapter<HomeMovieAdapter.ViewHolder> {

    private List<MovieUIModel> movies;

    public HomeMovieAdapter(List<MovieUIModel> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.movie_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_image)
        ImageView movieImage;
        @BindView(R.id.movie_title)
        TextView movieTitle;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(MovieUIModel movie) {
            movieTitle.setText(movie.getTitle());
            String IMAGE_URL = "https://image.tmdb.org/t/p/w200/";
            Glide.with(itemView.getContext()).load(IMAGE_URL + movie.getPosterPath())
                    .into(movieImage);
        }

    }

}
