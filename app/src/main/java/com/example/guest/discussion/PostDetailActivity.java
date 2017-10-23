package com.example.guest.discussion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    @Bind(R.id.postImageView) ImageView mImageLabel;
    @Bind(R.id.categoryTextView) TextView mCategoryLabel;
    @Bind(R.id.subjectTextView) TextView mSubjectLabel;
    @Bind(R.id.titleTextView) TextView mTitleLabel;
    @Bind(R.id.messageTextView) TextView mMessageLabel;
    @Bind(R.id.dateTextView) TextView mDateLabel;
    @Bind(R.id.savePostButton) TextView mSavePostButton;

    private Post mPost;

    //    public static PostDetailActivity newInstance(Post post) {
//        PostDetailActivity postDetailActivity = new PostDetailActivity();
//        Bundle args = new Bundle();
//        args.putParcelable("post", Parcels.wrap(post));
//        postDetailActivity.setArguments(args);
//        return postDetailActivity;
//    }
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        String subject = intent.getStringExtra("subject");
        String title = intent.getStringExtra("title");
        String message = intent.getStringExtra("message");
        String date = intent.getStringExtra("date");
//        mPost = Parcels.unwrap(getArguments().getParcelable("post"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_post_detail, container, false);
        ButterKnife.bind(this, view);

        mCategoryLabel.setText(mPost.getCategory());
        mSubjectLabel.setText(mPost.getSubject());
        mTitleLabel.setText(mPost.getTitle());
        mMessageLabel.setText(mPost.getMessage());
        mDateLabel.setText(mPost.getDate());

        mSavePostButton.setOnClickListener(this);

        return view;
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

