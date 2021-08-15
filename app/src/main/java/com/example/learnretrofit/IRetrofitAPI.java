package com.example.learnretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IRetrofitAPI {

    @GET("posts")
    Call<List<Post>> getPostList();

    @GET("posts/{postId}")
    Call<Post> getPost(@Path("postId") int postId);

    @GET("posts/{postId}/comments")
    Call<List<Comment>> getCommentListWithPathParam(@Path("postId") int postId);

    @GET("comments")
    Call<List<Comment>> getCommentListWithQueryParam(@Query("postId") int postId);

    @POST("posts")
    Call<Post> createPost(@Body Post post);
}
