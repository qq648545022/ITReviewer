package com.example.henry.itreview.activity;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.henry.itreview.R;
import com.example.henry.itreview.myclass.Problem;

import java.util.ArrayList;
import java.util.List;

public class SolveProblem extends AppCompatActivity {
    private TextView question;
    private RadioGroup rg;
    private RadioButton ra;
    private RadioButton rb;
    private RadioButton rc;
    private RadioButton rd;
    private Button b1;
    private Button b2;
    String temp = "dasd";
    int i = 0;
    private List<Problem> list = new ArrayList<>();
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_problem);
        init();
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

        Problem p1 = new Problem("下列哪些语句关于内存回收的说明是正确的?", "A 程序员必须创建一个线程来释放内存", "B 内存回收程序负责释放无用内存", "C 内存回收程序允许程序员直接释放内存", "D 内存回收程序可以在指定的时间释放内存对象", "B");
        Problem p2 = new Problem("对一些资源以及状态的操作保存，最好是保存在生命周期的哪个函数中进行", "A onPause()", "B onCreate()", "C onResume()", "D onStart()", "D");
        Problem p3 = new Problem("下列哪些语句关于内存回收的说明是正确的?", "A 程序员必须创建一个线程来释放内存", "B 内存回收程序负责释放无用内存", "C 内存回收程序允许程序员直接释放内存", "D 内存回收程序可以在指定的时间释放内存对象", "B");

        list.add(p1);
        list.add(p2);
        list.add(p3);

        do {
            if (i == 0) {
                b1.setText("无");
            } else {
                b1.setText("上一题");
            }
            question.setText(list.get(i).getQuestion());
            ra.setText(list.get(i).getA());
            rb.setText(list.get(i).getB());
            rc.setText(list.get(i).getC());
            rd.setText(list.get(i).getD());
            String t = null;

            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged (RadioGroup group, @IdRes int checkedId) {
                    if (checkedId == R.id.rba) {
                        temp = ra.getText().toString();

                    } else if (checkedId == R.id.rbb) {
                        temp = rb.getText().toString();
                    } else if (checkedId == R.id.rbc) {
                        temp = rc.getText().toString();
                    } else {
                        temp = rd.getText().toString();
                    }
                    if (temp.charAt(0) == list.get(i).getCorrect().charAt(0)) {
                        Toast.makeText(SolveProblem.this, "答案正确", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SolveProblem.this, "答案错误", Toast.LENGTH_SHORT).show();
                    }


                }
            });


            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v) {
                    i--;
                    ra.setText(list.get(i).getA());
                    rb.setText(list.get(i).getB());
                    rc.setText(list.get(i).getC());
                    rd.setText(list.get(i).getD());
                    ra.setSelected(false);
                    rb.setSelected(false);
                    rc.setSelected(false);
                    rd.setSelected(false);
                    if (i == 0) {
                        b1.setText("无");
                    } else {
                        b1.setText("上一题");
                    }
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v) {
                    i++;
                    ra.setText(list.get(i).getA());
                    rb.setText(list.get(i).getB());
                    rc.setText(list.get(i).getC());
                    rd.setText(list.get(i).getD());
                    ra.setSelected(false);
                    rb.setSelected(false);
                    rc.setSelected(false);
                    rd.setSelected(false);
                    if (i == 0) {
                        b1.setText("无");
                    } else if (i < list.size() && i != 0){
                        b1.setText("上一题");
                    } else if (i >= list.size()) {
                        Toast.makeText(SolveProblem.this, "题目没了", Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }while (i != 0 && i < list.size());




    }
}
