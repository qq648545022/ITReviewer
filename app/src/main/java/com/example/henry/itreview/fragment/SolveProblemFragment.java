package com.example.henry.itreview.fragment;

import android.app.Activity;
import android.icu.text.LocaleDisplayNames;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.henry.itreview.R;
import com.example.henry.itreview.activity.MainActivity;
import com.example.henry.itreview.activity.SolveProblem;
import com.example.henry.itreview.myclass.Problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henry on 2018/6/25.
 */

public class SolveProblemFragment extends Fragment implements RadioGroup.OnCheckedChangeListener{
    private Activity activity;
    private TextView question;
    private RadioGroup rg;
    private RadioButton ra;
    private RadioButton rb;
    private RadioButton rc;
    private RadioButton rd;
    private int index;
    private List<String> answer = new ArrayList<>();
    private String temp;
    private TextView textView;
    public SolveProblemFragment(int i) {
        this.index = i;
    }
    private List<Problem>list = SolveProblem.getList();
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.problem_fragment, container, false);
        activity = getActivity();
        return view;
    }

    @Override
    public void onViewCreated (View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        textView = (TextView) view.findViewById(R.id.answer_view);
        question = (TextView)view.findViewById(R.id.problem);
        rg = (RadioGroup)view.findViewById(R.id.rg);
        ra = (RadioButton)view.findViewById(R.id.rba);
        rb = (RadioButton)view.findViewById(R.id.rbb);
        rc = (RadioButton)view.findViewById(R.id.rbc);
        rd = (RadioButton)view.findViewById(R.id.rbd);
        question.setText(list.get(index).getQuestion());
        ra.setText(list.get(index).getA());
        rb.setText(list.get(index).getB());
        rc.setText(list.get(index).getC());
        rd.setText(list.get(index).getD());
        textView.setVisibility(View.GONE);
        rg.setOnCheckedChangeListener(this);


    }

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
        if (temp.charAt(0) == list.get(index).getCorrect().charAt(0)) {
            textView.setVisibility(View.VISIBLE);
            textView.setText("答案正确");
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText("答案错误，正确答案为" + list.get(index).getCorrect().charAt(0));
        }
        Log.d("SolveProblem", temp);
        Log.d("SolveProblem", "answer的大小" + answer.size());
    }
    public List<String> getAnswer() {
        return answer;
    }
}
