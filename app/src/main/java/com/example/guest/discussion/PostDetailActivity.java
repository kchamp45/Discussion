package com.example.guest.discussion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.discussion.adaptors.PostDetailAdapter;
import com.example.guest.discussion.models.Post;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static java.security.AccessController.getContext;

public class PostDetailActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private PostDetailAdapter mAdapter;

    @Bind(R.id.postImageView) ImageView mImageLabel;
    @Bind(R.id.categoryTextView) TextView mCategoryLabel;
    @Bind(R.id.subjectTextView) TextView mSubjectLabel;
    @Bind(R.id.titleTextView) TextView mTitleLabel;
    @Bind(R.id.messageTextView) TextView mMessageLabel;
    @Bind(R.id.dateTextView) TextView mDateLabel;

    @Bind(R.id.savePostButton) TextView mSavePostButton;

    private Post mPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mPost = Parcels.unwrap(getIntent().getParcelableExtra("post"));

//        mTitleLabel.setText(mPost.getTitle());
//        mCategoryLabel.setText(mPost.getCategory());
//        mSubjectLabel.setText(mPost.getSubject());
//        mMessageLabel.setText(mPost.getMessage());
//        mDateLabel.setText(mPost.getDate());

        mSavePostButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
    if (v == mSavePostButton) {
        DatabaseReference restaurantRef = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_POSTS);
        restaurantRef.push().setValue(mPost);
    }
}

}

