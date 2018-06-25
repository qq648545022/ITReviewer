package com.example.henry.itreview.activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.henry.itreview.R;
import com.example.henry.itreview.adapter.ViewPagerAdapter;
import com.example.henry.itreview.fragment.SolveProblemFragment;
import com.example.henry.itreview.myclass.Problem;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SolveProblem extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    private ViewPager viewPager;
    private static List<Fragment> fragments = new ArrayList<>();
    private List<String> answer = new ArrayList<>();
    private static List<Problem> list = new ArrayList<>();
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_solve_problem);
        Intent intent = getIntent();
        final String type = intent.getStringExtra("type");
        getProblems(type);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SolveProblem", "onrestart");
        list.clear();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (list.size() >= 0) {
            list.clear();
        }
        //Log.d("SolveProblem", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (list.size() >= 0) {
            list.clear();
            fragments.clear();
        }
        Log.d("SolveProblem", "onPause");
    }

    private void getProblems(final String type) {
        new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    URL url = new URL("http://172.29.23.128/question?type=" + type.toLowerCase());
                    HttpURLConnection connection =(HttpURLConnection)url.openConnection();
                    StringBuilder s = new StringBuilder("");
                    InputStream inputStream = connection.getInputStream();
                    int c;
                    while ((c = inputStream.read()) != -1) {
                        s.append((char)c);
                    }
                    parseJson(s.toString());
                    initPager();
                } catch (Exception e) {
                    Log.d("debug", "错误");
                }
            }
        }).start();

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
                Problem problem = new Problem(question, "A " + a, "B " + b, "C " + c, "D " + d, answer.toUpperCase());
                list.add(problem);
            }
        }catch (Exception e) {

        }
    }


    private void initPager () {
        viewPager = (ViewPager)findViewById(R.id.solve_pager);
        Log.d("SolveProblem", "大小" +list.size());
        for (int i = 0; i < list.size(); i++) {
            fragments.add(new SolveProblemFragment(i));
        }

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
        //int index = viewPager.getCurrentItem();

    }

    @Override
    public void onPageScrolled (int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected (int position) {

    }

    @Override
    public void onPageScrollStateChanged (int state) {

    }

    public static List<Problem> getList() {
        return list;
    }
}
