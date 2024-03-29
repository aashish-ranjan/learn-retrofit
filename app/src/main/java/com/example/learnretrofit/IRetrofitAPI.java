package com.example.learnretrofit;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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

    @PUT("posts/{id}")
    Call<Post> editPostWithPut(@Path("id") String postId, @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> editPostWithPatch(@Path("id") String postId, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") String postId);

    @PATCH("posts/{id}")
    Call<Post> editPostWithPatchAndForcedNullFields(@Path("id") String postId, @Body Post post);

}
