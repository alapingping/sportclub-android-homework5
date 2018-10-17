package com.sports.sportclub;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //设置下划线
        TextView forget_text = findViewById(R.id.forget_text);
        forget_text.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        //设置监听
        forget_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"该功能未开放",Toast.LENGTH_LONG).show();
            }
        });

        TextView signup_text = findViewById(R.id.register_text);
        signup_text.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        signup_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    //注册按钮的跳转
    public void onClickSignin(View view) {
        EditText username_input = findViewById(R.id.username_input);
        EditText password_input = findViewById(R.id.password_input);

        String username = username_input.getText().toString();
        String password = password_input.getText().toString();

        Intent intent = new Intent(this,navigationActivity.class);
        startActivity(intent);
        finish();
    }



}
