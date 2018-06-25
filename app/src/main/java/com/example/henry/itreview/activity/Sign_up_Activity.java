package com.example.henry.itreview.activity;

/**
 * Created by asus on 2018/6/18.
 */
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.henry.itreview.R;
import com.example.henry.itreview.myclass.Register;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Sign_up_Activity extends AppCompatActivity {
    static StringBuilder result = new StringBuilder();
    static PrintWriter printWriter;
    static BufferedReader bufferedReader;
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        Button signup = (Button) findViewById(R.id.sign_up);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText)findViewById(R.id.signup_username);
                EditText password = (EditText)findViewById(R.id.signup_password);
                EditText password2 = (EditText)findViewById(R.id.signup_password2);
                EditText age = (EditText)findViewById(R.id.age);
                EditText country = (EditText)findViewById(R.id.country);
                RadioGroup s = (RadioGroup)findViewById(R.id.sex);
                String _name = name.getText().toString();
                String _pass1 = password.getText().toString();
                String _pass2 = password2.getText().toString();
                String _age = age.getText().toString();
                String _con = country.getText().toString();
                String sex = "男";
                for(int i =0;i<s.getChildCount();i++){
                    RadioButton r = (RadioButton)s.getChildAt(i);
                    if(r.isChecked()){
                        sex = r.getText().toString();
                        break;
                    }
                }
                if(check(_name,_pass1,_pass2,_age,_con,sex)){
                    try {
                        String ss = Register.connect(_name,_pass1,_pass2,sex,_con,_age);
                        System.out.println(ss);
                        JSONObject j = new JSONObject(ss);
                        String flag = j.getString("code");
                        System.out.println(flag);
                        if(flag.equals("1")){
                            Toast.makeText(Sign_up_Activity.this,"注册成功！",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Sign_up_Activity.this,Login_Activity.class);
                            Bundle bundle = new Bundle();
                            bundle.putCharSequence("name",_name);
                            bundle.putCharSequence("password",_pass1);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Sign_up_Activity.this,"注册失败！",Toast.LENGTH_LONG).show();
                        }
                    }catch (IOException e){
                        Toast.makeText(Sign_up_Activity.this,"连接服务器错误，请重试！",Toast.LENGTH_LONG).show();
                    }catch (JSONException e){
                        Toast.makeText(Sign_up_Activity.this,"解析json格式，请重试！",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Sign_up_Activity.this,"输入信息格式有误！！！",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean check(String n,String p1,String p2,String a,String c,String s){
        if(n.length()<=12&&p1.length()<=12&&!n.equals("")&&!p1.equals("")&&!p2.equals("")&&!a.equals("")&&p1.equals(p2)&&!isContainChinese(a)&&isright(n)&&isright(p1)){
            Toast.makeText(Sign_up_Activity.this,"格式正确！！",Toast.LENGTH_LONG).show();
            return true;
        }else{
            return false;
        }
    }

    public static boolean isContainChinese(String a){
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(a);
        if (m.find()) {
            return true;
        }
        return false;
    }
    public static boolean isright(String n) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < n.length(); i++) {
            if (Character.isDigit(n.charAt(i))) {
                a++;
            } else if (Character.isLetter(n.charAt(i))) {
                b++;
            }
        }
        if (a + b == n.length()&&a!=0&&b!=0)
            return true;
        else
            return false;
    }
}
