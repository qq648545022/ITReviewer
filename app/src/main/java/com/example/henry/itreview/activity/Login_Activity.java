package com.example.henry.itreview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.henry.itreview.R;

/**
 * Created by asus on 2018/6/18.
 */

public class Login_Activity extends AppCompatActivity {
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);
        Button signin = (Button)findViewById(R.id.sign_in);
        Button signup = (Button)findViewById(R.id.sign_up);
    }
}
