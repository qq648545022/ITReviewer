package com.example.henry.itreview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.henry.itreview.R;
import com.example.henry.itreview.adapter.ProblemListAdapter;
import com.example.henry.itreview.myclass.Problems;

import java.util.ArrayList;
import java.util.List;

public class ProblemList extends AppCompatActivity{
    private String[] data = {"Android", "Java",  "C/C++", "Python"};
    private List<Problems> problems = new ArrayList<>();
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_list);
        initList();
        ProblemListAdapter adapter = new ProblemListAdapter(ProblemList.this, R.layout.problems_item, problems);
        final ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                Problems problem = problems.get(position);
                String type = data[position];
                Intent intent = new Intent(getBaseContext(), SolveProblem.class);
                intent.putExtra("type", type);
                startActivity(intent);
            }
        });

    }

    public void initList() {
        Problems android = new Problems("Andorid");
        problems.add(android);
        Problems java = new Problems("Java");
        problems.add(java);
        Problems c = new Problems("C/C++");
        problems.add(c);
        Problems python = new Problems("Python");
        problems.add(python);
    }

}
