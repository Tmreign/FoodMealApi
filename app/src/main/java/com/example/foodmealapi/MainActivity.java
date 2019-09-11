package com.example.foodmealapi;

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

    ArrayList<Category> categories = new ArrayList<>();
    private CategoryAdapter categoryAdapter;

    private RecyclerView Category_RecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Category_RecycleView =(RecyclerView)findViewById(R.id.Category_RecycleView);
        Category_RecycleView.setLayoutManager(new LinearLayoutManager(this));


        getCategoryResponse();
    }

    private void getCategoryResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<List<Category>> Call=requestInterface.getCategoryJson();


        Call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                categories = new ArrayList<>(response.body());
                categoryAdapter = new CategoryAdapter(MainActivity.this,categories);
                Category_RecycleView.setAdapter(categoryAdapter);

                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
