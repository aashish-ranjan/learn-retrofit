package com.example.learnretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRetrofitAPI {

    @GET("posts")
    Call<List<Post>> getPostList();
}
