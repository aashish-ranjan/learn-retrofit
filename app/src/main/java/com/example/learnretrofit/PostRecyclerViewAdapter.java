package com.example.learnretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostRecyclerViewAdapter extends RecyclerView.Adapter<PostRecyclerViewAdapter.PostViewHolder> {

    private Context mContext;
    private List<Post> mPostList;

    public PostRecyclerViewAdapter(Context context, List<Post> postList) {
        this.mContext = context;
        this.mPostList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemPostView = inflater.inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(itemPostView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostRecyclerViewAdapter.PostViewHolder holder, int position) {
        Post post = getPost(position);
        holder.userIdTextView.setText("UserId: " + post.getUserId());
        holder.idTextView.setText("Id: " + post.getId());
        holder.titleTextView.setText("Title: " + post.getTitle());
        holder.bodyTextView.setText("Body: " + post.getBody());
    }

    @Override
    public int getItemCount() {
        return mPostList != null ? mPostList.size() : 0;
    }

    @Nullable
    private Post getPost(int position) {
        return mPostList != null ? mPostList.get(position) : null;
    }

    public void loadData(List<Post> postList) {
        mPostList = postList;
        notifyDataSetChanged();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView userIdTextView, idTextView, titleTextView, bodyTextView;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            userIdTextView = itemView.findViewById(R.id.tvUserId);
            idTextView = itemView.findViewById(R.id.tvId);
            titleTextView = itemView.findViewById(R.id.tvTitle);
            bodyTextView = itemView.findViewById(R.id.tvBody);
        }
    }

}
