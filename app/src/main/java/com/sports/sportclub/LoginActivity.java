package com.sports.sportclub;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sports.sportclub.DataModel.ResultBean;
import com.sports.sportclub.DataModel.User;
import com.sports.sportclub.api.BmobService;
import com.sports.sportclub.api.Client;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private BmobUser current_user;

    private ResultBean users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化bmob服务
        Bmob.initialize(this, "5fad9f2543ffa83e56155a46398d6ede");
        /*
        * 验证本地缓存用户
        * 若用户存在，则免登陆
        * 否则需用户输入登陆信息
        * */
        current_user = BmobUser.getCurrentUser();
        if(current_user != null){
            jump2main();
        }
        else{
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
    }

    //登陆按钮的跳转
    public void onClickSignin(View view) {
        EditText username_input = findViewById(R.id.username_input);
        EditText password_input = findViewById(R.id.password_input);

        final String username = username_input.getText().toString();
        String password = password_input.getText().toString();

        //使用retrofit实现登录请求
        BmobService service = Client.retrofit.create(BmobService.class);
        Call<ResponseBody> call = service.getUser(username,password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if(response.code() == 200){
                    showmsg("登陆成功");
                    jump2main();
                }
                else if(response.code() == 400) {
                    showmsg("用户名或密码错误");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                showmsg(t.getMessage());
            }
        });




        //bmob内部封装的登陆方法
//        current_user = new BmobUser();
//        current_user.setPassword(password);
//        current_user.setUsername(userEmail);
//        current_user.login(new SaveListener<BmobUser>() {
//
//            @Override
//            public void done(BmobUser user, BmobException e) {
//                if(e == null){
//                    showmsg("登陆成功");
//                    jump2main();
//                }
//                else{
//                    showmsg(e.getMessage().toString());
//                }
//            }
//        });

    }

    public boolean Validation(User user){

        return false;
    }

    //显示信息
    public void showmsg(String msg){
        Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_LONG).show();
    }
    //跳转至主界面
    public void jump2main(){
        Intent intent = new Intent(this,navigationActivity.class);
        startActivity(intent);
        finish();
    }

}
