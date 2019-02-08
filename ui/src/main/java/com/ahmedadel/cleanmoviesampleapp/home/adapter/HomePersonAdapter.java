package com.ahmedadel.cleanmoviesampleapp.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmedadel.cleanmoviesampleapp.R;
import com.ahmedadel.presentation.model.PersonUIModel;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePersonAdapter extends RecyclerView.Adapter<HomePersonAdapter.ViewHolder> {

    private List<PersonUIModel> persons;

    public HomePersonAdapter(List<PersonUIModel> persons) {
        this.persons = persons;
    }

    @NonNull
    @Override
    public HomePersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new HomePersonAdapter.ViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.person_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(persons.get(position));
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.person_image)
        ImageView personImage;
        @BindView(R.id.person_title)
        TextView personTitle;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(PersonUIModel person) {
            personTitle.setText(person.getName());
            String IMAGE_URL = "https://image.tmdb.org/t/p/w200/";
            Glide.with(itemView.getContext()).load(IMAGE_URL + person.getProfilePath())
                    .into(personImage);
        }
    }

}
