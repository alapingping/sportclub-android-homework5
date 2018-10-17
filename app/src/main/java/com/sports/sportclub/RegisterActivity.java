package com.sports.sportclub;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView back = findViewById(R.id.backToLoginText);
        back.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


    }

    public void onClickSignup(View view) {
        EditText username_input = findViewById(R.id.username_input);
        EditText password_input = findViewById(R.id.password_input);
        EditText ensure_password_input = findViewById(R.id.ensure_password_input);
        String username = username_input.getText().toString();
        String password = password_input.getText().toString();
        String ensure_password = ensure_password_input.getText().toString();

        Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,navigationActivity.class);
        startActivity(intent);
        finish();
    }
}
