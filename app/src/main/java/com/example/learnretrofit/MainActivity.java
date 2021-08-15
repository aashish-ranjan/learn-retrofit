package com.example.learnretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    PostRecyclerViewAdapter mPostRecyclerViewAdapter;
    IRetrofitAPI retrofitAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView postRecyclerView = findViewById(R.id.rv_post);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        postRecyclerView.setHasFixedSize(true);
        mPostRecyclerViewAdapter = new PostRecyclerViewAdapter(this, new ArrayList<>());
        postRecyclerView.setAdapter(mPostRecyclerViewAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitAPI = retrofit.create(IRetrofitAPI.class);
//        getPostList();
        getPost(3);
    }

    private void getPostList() {
        Call<List<Post>> call = retrofitAPI.getPostList();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Post> postList = response.body();
                mPostRecyclerViewAdapter.loadData(postList);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getPost(int postId) {
        Call<Post> call = retrofitAPI.getPost(postId);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Post post = response.body();
                List<Post> postList = new ArrayList<>();
                postList.add(post);
                mPostRecyclerViewAdapter.loadData(postList);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}