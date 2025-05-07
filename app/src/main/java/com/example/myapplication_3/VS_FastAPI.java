package com.example.myapplication_3;

import com.example.myapplication_3.models.Post_list;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VS_FastAPI {

    @GET("/post")
    Call<List<Post_list>> get_all_postList();
}
