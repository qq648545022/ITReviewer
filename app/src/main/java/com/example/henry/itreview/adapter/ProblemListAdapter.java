package com.example.henry.itreview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.henry.itreview.R;
import com.example.henry.itreview.myclass.Problems;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henry on 2018/6/18.
 */

public class ProblemListAdapter extends ArrayAdapter<Problems> {
    private int id;
    public ProblemListAdapter(Context context, int id, List<Problems> ob) {
        super(context,id, ob);
        this.id = id;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        Problems problems = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(id, parent, false);
        TextView name = (TextView) view.findViewById(R.id.problem_name);
        name.setText(problems.getProblemName());
        return view;
    }
}
