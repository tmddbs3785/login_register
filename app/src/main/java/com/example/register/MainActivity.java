package com.example.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText idText = null;
    private EditText passwordText = null;
    private Button loginButton = null;
    private TextView registerButton = null;

    Retrofit retrofit;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).build();
        apiService = retrofit.create(ApiService.class);

        Call<ResponseBody> comment = apiService.getComment(1);
        comment.enqueue(new Callback<ResponseBody>(){
            @Override
            public void onResponse(Call<ResponseBody>call, Response<ResponseBody>response){
                try {
                    Log.v("Test",response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody>call, Throwable t){

            }
        });
        idText = (EditText) findViewById(R.id.idText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        loginButton = (Button) findViewById((R.id.loginButton));
        registerButton = (TextView) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent registerIntent = new Intent(MainActivity.this, com.example.register.RegisterActivity.class);
        MainActivity.this.startActivity(registerIntent);
    }
}