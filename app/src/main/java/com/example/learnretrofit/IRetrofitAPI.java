package com.example.learnretrofit;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IRetrofitAPI {

    @GET("posts")
    Call<List<Post>> getPostList();

    @GET("posts/{postId}")
    Call<Post> getPost(@Path("postId") String postId);

    @GET("posts/{postId}/comments")
    Call<List<Comment>> getCommentListWithPathParam(@Path("postId") String postId);

    @GET("comments")
    Call<List<Comment>> getCommentListWithQueryParam(@Query("postId") String postId);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@Field("userId") String userId, @Field("title") String postTitle);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String, String> fields);
}
