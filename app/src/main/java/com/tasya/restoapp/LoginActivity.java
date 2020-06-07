package com.tasya.restoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.tasya.restoapp.adapter.CategoryAdapter;
import com.tasya.restoapp.adapter.MenuAdapter;
import com.tasya.restoapp.model.Categories;
import com.tasya.restoapp.model.GetData;
import com.tasya.restoapp.model.Menus;
import com.tasya.restoapp.model.RequestBody;
import com.tasya.restoapp.model.Users;
import com.tasya.restoapp.rest.ApiClient;
import com.tasya.restoapp.rest.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ArrayList<Menus> menus = new ArrayList<>();
    ArrayList<Categories> categories = new ArrayList<>();
    ApiClient apiClient;
    Service service = apiClient.getClient().create(Service.class);
    MenuAdapter menuAdapter;
    CategoryAdapter categoriesAdapter;
    RecyclerView recyclerViewMenu, recyclerViewCategory;

    TextView xemail, xpassword;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        xemail = findViewById(R.id.xemail);
        xpassword = findViewById(R.id.xpassword);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_login.setEnabled(false);
                btn_login.setText("Loading...");

                final String email = xemail.getText().toString();
                final String password = xpassword.getText().toString();
                if (email.isEmpty()) {
                    if(password.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Email dan Password Kosong!", Toast.LENGTH_SHORT).show();
                        //ubah state menjadi loading
                        btn_login.setEnabled(true);
                        btn_login.setText("LOGIN");
                    }else {
                        Toast.makeText(getApplicationContext(), "Email Kosong!", Toast.LENGTH_SHORT).show();
                        //ubah state menjadi loading
                        btn_login.setEnabled(true);
                        btn_login.setText("LOGIN");
                    }
                }else {
                    if (password.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Password Kosong!", Toast.LENGTH_SHORT).show();
                        //ubah state menjadi loading
                        btn_login.setEnabled(true);
                        btn_login.setText("LOGIN");
                    } else {
                        RequestBody requestBody = new RequestBody(email, password);
                        Call<GetData> call = service.createReq(requestBody);
                        call.enqueue(new Callback<GetData>() {
                            @Override
                            public void onResponse(Call<GetData> call, Response<GetData> response) {
                                Gson gson = new Gson();
                                if (response.isSuccessful()) {
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    String oke = gson.toJson(response.body().getData().getUsers());
                                    Log.d("bissaaaaaa", oke);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Akun tidak ada!", Toast.LENGTH_SHORT).show();
                                    btn_login.setEnabled(true);
                                    btn_login.setText("LOGIN");
                                }
                            }

                            @Override
                            public void onFailure(Call<GetData> call, Throwable t) {
                                Log.d("biss", t.getCause().toString());
                            }
                        });


                    }
                }
            }
        });
    }


}
