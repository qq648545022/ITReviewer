package com.example.henry.itreview.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.sql.*;
import com.example.henry.itreview.R;
import com.example.henry.itreview.myclass.Login;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by asus on 2018/6/18.
 */

public class Login_Activity extends AppCompatActivity {

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password = (EditText)findViewById(R.id.password);
        Button signin = (Button)findViewById(R.id.sign_in);
        Button signup = (Button)findViewById(R.id.sign_up);
//        Intent intent = getIntent();
//        if(intent!=null) {
//            Bundle bundle = intent.getExtras();
//            username.setText(bundle.getString("name"));
//            password.setText(bundle.getString("password"));
//        }
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check(username.getText().toString(),password.getText().toString())){
                    try {
                        String ss = Login.connect(username.getText().toString(), password.getText().toString());
                        JSONObject j = new JSONObject(ss);
                        String flag = j.getString("code");
                        System.out.println(ss);
                        if(flag.equals("1")){
                            Toast.makeText(Login_Activity.this,"登录成功！！！",Toast.LENGTH_LONG).show();
                            //to be continue.......................


                        }else{
                            Toast.makeText(Login_Activity.this,"登录失败！！！",Toast.LENGTH_LONG).show();
                        }
                    }catch (IOException e){
                        Toast.makeText(Login_Activity.this,"连接服务器失败！",Toast.LENGTH_LONG).show();
                        Log.i("error", "onCreate:can not connect with server!");
                    }catch (JSONException q){
                        Log.i("error", "can not decode json!");
                    }
                }else{
                    Toast.makeText(Login_Activity.this,"请输入正确的用户名和密码！！！",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public boolean check(String n,String p){
        if(!n.equals("")&&!p.equals("")&&!Sign_up_Activity.isContainChinese(n)&&!Sign_up_Activity.isContainChinese(p)){
            return true;
        }else{
            return false;
        }

    }
}


