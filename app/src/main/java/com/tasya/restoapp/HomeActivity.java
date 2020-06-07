package com.tasya.restoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.tasya.restoapp.adapter.CategoryAdapter;
import com.tasya.restoapp.adapter.MenuAdapter;
import com.tasya.restoapp.model.Categories;
import com.tasya.restoapp.model.GetData;
import com.tasya.restoapp.model.Menus;
import com.tasya.restoapp.rest.ApiClient;
import com.tasya.restoapp.rest.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    ArrayList<Menus> menus = new ArrayList<>();
    ArrayList<Categories> categories = new ArrayList<>();
    ApiClient apiClient;
    Service service = apiClient.getClient().create(Service.class);
    MenuAdapter menuAdapter;
    CategoryAdapter categoriesAdapter;
    RecyclerView recyclerViewMenu, recyclerViewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerViewMenu = findViewById(R.id.rvMenu);
        recyclerViewCategory = findViewById(R.id.rvBanner);
        callCategory();
        callMenu();
    }
    public void callMenu(){
        Call<GetData> call = service.menu();
        call.enqueue(new Callback<GetData>() {
            @Override
            public void onResponse(Call<GetData> call, Response<GetData> response) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                Gson gson = new Gson();
                if(response.isSuccessful()){
                    recyclerViewMenu.setLayoutManager(layoutManager);
                    menus = response.body().getData().getMenus();
                    menuAdapter = new MenuAdapter(menus, getApplicationContext());
                    recyclerViewMenu.setAdapter(menuAdapter);
                    //String oke = gson.toJson(response.body());
                    //Log.d("bissaaaaaa",oke);
                }else{
                    Log.d("biss",response.errorBody().toString() );
                }
            }

            @Override
            public void onFailure(Call<GetData> call, Throwable t) {
                Log.d("biss",t.getCause().toString() );
            }
        });
    }

    public void callCategory(){
        Call<GetData> call = service.category();
        call.enqueue(new Callback<GetData>() {
            @Override
            public void onResponse(Call<GetData> call, Response<GetData> response) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                Gson gson = new Gson();
                if(response.isSuccessful()){
                    recyclerViewCategory.setLayoutManager(layoutManager);
                    categories = response.body().getData().getCategories();
                    categoriesAdapter = new CategoryAdapter(categories, getApplicationContext());
                    recyclerViewCategory.setAdapter(categoriesAdapter);
                    String oke = gson.toJson(response.body().getData().getCategories());
                    Log.d("bissaaaaaa",oke);
                }else{
                    Log.d("biss",response.errorBody().toString() );
                }
            }

            @Override
            public void onFailure(Call<GetData> call, Throwable t) {
                Log.d("biss",t.getCause().toString() );
            }
        });
    }


}
