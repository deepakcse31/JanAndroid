package com.example.janandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    List<MovieItem> list;

    public MovieAdapter(List<MovieItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.year.setText(String.valueOf(list.get(position).getYear()));
        Glide.with(holder.itemView.getContext())
                .load(list.get(position).getImgPoster());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView year;
        ImageView poster;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvName);
            year = itemView.findViewById(R.id.tvDescription);
            poster = itemView.findViewById(R.id.ivImage);

        }
    }
}
