package com.example.guest.discussion;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guest.discussion.models.Post;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        @Bind(R.id.savedPostsButton) Button mSavedPostsButton;
        @Bind(R.id.addPostButton) Button mAddPostButton;
        @Bind(R.id.categoryEditText) EditText mCategoryEditText;
        @Bind(R.id.subjectEditText) EditText mSubjectEditText;
        @Bind(R.id.titleEditText) EditText mTitleEditText;
        @Bind(R.id.messageEditText) EditText mMessageEditText;
        @Bind(R.id.dateEditText) EditText mDateEditText;
        @Bind(R.id.appNameTextView) TextView mAppNameTextView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);

            Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
            mAppNameTextView.setTypeface(ostrichFont);

            mAddPostButton.setOnClickListener(this);
            mSavedPostsButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v == mAddPostButton) {
                String userCategory = mCategoryEditText.getText().toString();
                String userSubject = mSubjectEditText.getText().toString();
                String userTitle = mTitleEditText.getText().toString();
                String userMessage = mMessageEditText.getText().toString();
                String userDate = mDateEditText.getText().toString();

                Post post = new Post(userCategory, userSubject, userTitle, userMessage, userDate);

                Bundle args = new Bundle();
                args.putParcelable("post", Parcels.wrap(post));
                Intent intent = new Intent(MainActivity.this, PostDetailActivity.class);
                intent.putExtras(args);
                startActivity(intent);
            }
            if (v == mSavedPostsButton) {
                Intent intent = new Intent(MainActivity.this, SavedPostListActivity.class);
                startActivity(intent);
            }
        }

}
