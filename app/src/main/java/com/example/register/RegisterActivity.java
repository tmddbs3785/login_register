package com.example.register;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText idText = (EditText) findViewById(R.id.idText);
        EditText passwordText = (EditText) findViewById(R.id.passwordText);
        EditText nameText = (EditText) findViewById(R.id.nameText);
        EditText emailText1 = (EditText) findViewById(R.id.emailText1);
        EditText emailText2 = (EditText) findViewById(R.id.emailText2);
        EditText phText1 = (EditText) findViewById(R.id.phText1);
        EditText phText2 = (EditText) findViewById(R.id.phText2);
        EditText phText3 = (EditText) findViewById(R.id.phText3);
        EditText birthText1 = (EditText) findViewById(R.id.birthText1);
        EditText birthText2 = (EditText) findViewById(R.id.birthText2);
        EditText birthText3 = (EditText) findViewById(R.id.birthText3);
        EditText addressText = (EditText) findViewById(R.id.addressText);

        Button registerButton = (Button) findViewById((R.id.registerButton));

        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show();
        Intent registerIntent = new Intent(RegisterActivity.this, com.example.register.MainActivity.class);
        RegisterActivity.this.startActivity(registerIntent);
    }

}