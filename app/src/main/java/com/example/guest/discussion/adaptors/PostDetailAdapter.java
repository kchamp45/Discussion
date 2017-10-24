package com.example.guest.discussion.adaptors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.discussion.R;
import com.example.guest.discussion.models.Post;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class PostDetailAdapter extends RecyclerView.Adapter<PostDetailAdapter.PostViewHolder> {
    private ArrayList<Post> mPosts = new ArrayList<>();
    private Context mContext;

    public PostDetailAdapter(Context context, ArrayList<Post> posts) {
        mContext = context;
        mPosts = posts;
    }

    @Override
    public PostDetailAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_post_detail, parent, false);
        PostViewHolder viewHolder = new PostViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PostDetailAdapter.PostViewHolder holder, int position) {
        holder.bindPost(mPosts.get(position));
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.titleTextView)
        TextView mTitleTextView;
        @Bind(R.id.categoryTextView)
        TextView mCategoryTextView;
        @Bind(R.id.subjectTextView)
        TextView mSubjectTextView;
        @Bind(R.id.messageTextView)
        TextView mMessageTextView;
        @Bind(R.id.dateTextView)
        TextView mDateTextView;

        private Context mContext;

        public PostViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindPost(Post post) {
            mTitleTextView.setText(post.getTitle());
            mCategoryTextView.setText(post.getCategory());
            mSubjectTextView.setText(post.getSubject());
            mMessageTextView.setText(post.getMessage());
            mDateTextView.setText(post.getDate());

        }
    }
}