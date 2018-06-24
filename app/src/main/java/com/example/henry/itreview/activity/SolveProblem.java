package com.example.henry.itreview.activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.henry.itreview.R;
import com.example.henry.itreview.myclass.ConnectTiku;
import com.example.henry.itreview.myclass.Problem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ResponseCache;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SolveProblem extends AppCompatActivity {
    private TextView question;
    private RadioGroup rg;
    private RadioButton ra;
    private RadioButton rb;
    private RadioButton rc;
    private RadioButton rd;
    private Button b1;
    private Button b2;
    private String temp = "dasd";
    int i = 0;
    private List<String> answer = new ArrayList<>();
    private List<Problem> list = new ArrayList<>();
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_problem);
        Intent intent = getIntent();
        final String type = intent.getStringExtra("type");
        getProblems(type);

    }

    private void getProblems(final String type) {
        new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    URL url = new URL("http://172.29.23.128/question?type=" + type);
                    HttpURLConnection connection =(HttpURLConnection)url.openConnection();
                    StringBuilder s = new StringBuilder("");
                    InputStream inputStream = connection.getInputStream();
                    int c;
                    while ((c = inputStream.read()) != -1) {
                        s.append((char)c);
                    }
                    JSONObject jsonObject = new JSONObject(s.toString());
                    //JSONArray jsonArray = jsonObject.getJSONArray("data");
                    parseJson(s.toString());
                    Log.d("wocaonima", s.toString());

                    Log.d("extra", "大小为：" + list.size());
                    init();

                } catch (Exception e) {
                    Log.d("debug", "错误");
                }
            }
        }).start();
        Log.d("aaa", "大小" +list.size());

    }
    private void parseJson(String json1) {
        try {
            JSONObject jsonObject = new JSONObject(json1);
            JSONArray array = jsonObject.getJSONArray("data");
            for (int i = 0 ; i < array.length(); i++) {
                JSONObject json = array.getJSONObject(i);
                String question = json.getString("Question");
                String a = json.getString("A");
                String b = json.getString("B");
                String c = json.getString("C");
                String d = json.getString("D");
                String answer = json.getString("Answer");
                Problem problem = new Problem(question, "A " + a, "B " + b, "C " + c, "D " + d, answer);
                list.add(problem);
            }
            Log.d("json", "大小 " + array.length());
        }catch (Exception e) {

        }
    }

    private void init() {
        question = (TextView)findViewById(R.id.problem);
        rg = (RadioGroup)findViewById(R.id.rg);
        ra = (RadioButton)findViewById(R.id.rba);
        rb = (RadioButton)findViewById(R.id.rbb);
        rc = (RadioButton)findViewById(R.id.rbc);
        rd = (RadioButton)findViewById(R.id.rbd);
        b1 = (Button)findViewById(R.id.last_problem);
        b2 = (Button)findViewById(R.id.next_problem);
        do {
            if (i == 0) {
                b1.setVisibility(View.GONE);
            }
            question.setText(list.get(i).getQuestion());
            ra.setText(list.get(i).getA());
            rb.setText(list.get(i).getB());
            rc.setText(list.get(i).getC());
            rd.setText(list.get(i).getD());
            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged (RadioGroup group, @IdRes int checkedId) {
                    if (checkedId == R.id.rba) {
                        temp = ra.getText().toString();
                    } else if (checkedId == R.id.rbb) {
                        temp = rb.getText().toString();
                    } else if (checkedId == R.id.rbc) {
                        temp = rc.getText().toString();
                    } else if (checkedId == R.id.rbd){
                        temp = rd.getText().toString();
                    } else {
                        return;
                    }
//                    if (temp.charAt(0) == list.get(i).getCorrect().charAt(0)) {
//                        //Toast.makeText(SolveProblem.this, "答案正确", Toast.LENGTH_SHORT).show();
//
//                    } else {
//                        Toast.makeText(SolveProblem.this, "答案错误", Toast.LENGTH_SHORT).show();
//                    }
                    answer.add(temp);

                }
            });

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v) {
                    i--;
                    question.setText(list.get(i).getQuestion());
                    ra.setText(list.get(i).getA());
                    rb.setText(list.get(i).getB());
                    rc.setText(list.get(i).getC());
                    rd.setText(list.get(i).getD());
                    //rg.clearCheck();
                    if (i == 0) {
                        b1.setVisibility(View.GONE);
                    } else if (i < list.size() -1){
                        b1.setVisibility(View.VISIBLE);
                        b2.setVisibility(View.VISIBLE);
                    }
                    ra.setChecked(false);
                    rb.setChecked(false);
                    rc.setChecked(false);
                    rd.setChecked(false);
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v) {
                    i++;
                    Log.d("debug", "index " + i);
                    question.setText(list.get(i).getQuestion());
                    ra.setText(list.get(i).getA());
                    rb.setText(list.get(i).getB());
                    rc.setText(list.get(i).getC());
                    rd.setText(list.get(i).getD());
                    //rg.clearCheck();
                    if (i == 0) {
                        b1.setText("无");
                    } else if (i < list.size() - 1 && i != 0){
                        b1.setText("上一题");
                        b1.setVisibility(View.VISIBLE);
                    } else if (i == list.size() - 1) {
                        Log.d("debug", "indexd " + i);
                        b2.setVisibility(View.GONE);
                    }
                    ra.setChecked(false);
                    rb.setChecked(false);
                    rc.setChecked(false);
                    rd.setChecked(false);
                }
            });


        }while (i != 0 && i <= list.size());




    }
}
