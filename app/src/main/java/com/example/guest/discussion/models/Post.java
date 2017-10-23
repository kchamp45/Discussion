package com.example.guest.discussion.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Post {
    private String message;
    private String category;
    private String subject;
    private String title;
    private String date;

public Post(){
}

public Post(String category, String subject, String title, String message, String date) {

    this.category = category;
    this.subject = subject;
    this.title = title;
    this.message = message;
    this.date = date;

}

    public String getMessage() {
        return message;
    }

    public String getCategory() {
        return category;
    }

    public String getSubject() {
        return subject;
    }

    public String getTitle(){ return title; }

    public String getDate() {
        return date;
    }
}
