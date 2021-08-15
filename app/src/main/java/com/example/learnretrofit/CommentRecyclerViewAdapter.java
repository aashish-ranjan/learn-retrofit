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

public class CommentRecyclerViewAdapter extends RecyclerView.Adapter<CommentRecyclerViewAdapter.CommentViewHolder> {

    private Context mContext;
    private List<Comment> mCommentList;

    public CommentRecyclerViewAdapter(Context context, List<Comment> commentList) {
        this.mContext = context;
        this.mCommentList = commentList;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemPostView = inflater.inflate(R.layout.item_comment, parent, false);
        return new CommentViewHolder(itemPostView);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = getComment(position);
        holder.postIdTextView.setText("PostId: " + comment.getPostId());
        holder.idTextView.setText("Id: " + comment.getId());
        holder.nameTextView.setText("Name: " + comment.getName());
        holder.emailTextView.setText("Email: " + comment.getEmail());
        holder.commentTextView.setText("Comment: " + comment.getComment());
    }

    @Override
    public int getItemCount() {
        return mCommentList != null ? mCommentList.size() : 0;
    }

    @Nullable
    private Comment getComment(int position) {
        return mCommentList != null ? mCommentList.get(position) : null;
    }

    public void loadData(List<Comment> commentList) {
        mCommentList = commentList;
        notifyDataSetChanged();
    }

    public static class CommentViewHolder extends RecyclerView.ViewHolder {
        private TextView postIdTextView, idTextView, nameTextView, emailTextView, commentTextView;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            postIdTextView = itemView.findViewById(R.id.tvPostId);
            idTextView = itemView.findViewById(R.id.tvId);
            nameTextView = itemView.findViewById(R.id.tvName);
            emailTextView = itemView.findViewById(R.id.tvEmail);
            commentTextView = itemView.findViewById(R.id.tvComment);
        }
    }

}
