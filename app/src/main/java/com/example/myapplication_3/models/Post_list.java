package com.example.myapplication_3.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Post_list {
    @SerializedName("content")
    public String content;

    @SerializedName("title")
    public String title;

    @SerializedName("created_at")
    public Date created_at;

    @SerializedName("published")
    public boolean published;

    @SerializedName("id")
    public int id;

    public Post_list(String content, String title, Date created_at, boolean published, int id) {
        this.content = content;
        this.title = title;
        this.created_at = created_at;
        this.published = published;
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public boolean isPublished() {
        return published;
    }

    public int getId() {
        return id;
    }

}
