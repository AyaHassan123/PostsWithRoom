package com.example.postswithroom.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postswithroom.R;
import com.example.postswithroom.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostsViewHolder> {

    private List<PostModel> postsList = new ArrayList<>();

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        holder.titleTV.setText(postsList.get(position).getTitle());
        holder.bodyTV.setText(postsList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public void setList(List<PostModel> postsList) {
        this.postsList = postsList;
        notifyDataSetChanged();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTV, bodyTV;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.item_title_textView);
            bodyTV = itemView.findViewById(R.id.item_body_textView);
        }
    }
}
