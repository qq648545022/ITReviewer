package com.example.henry.itreview.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.henry.itreview.R;
import com.example.henry.itreview.activity.ProblemList;

/**
 * Created by Henry on 2018/6/12.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{
    private SearchView searchView;
    private Button b1;
    private Button b2;
    private Activity mactivity;
    public HomeFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        mactivity = getActivity();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        searchView =(SearchView)view.findViewById(R.id.search);
        b1 = (Button)view.findViewById(R.id.b1);
        b2 = (Button)view.findViewById(R.id.b2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.b1:
                Intent intent = new Intent(mactivity, ProblemList.class);
                startActivity(intent);
                break;
            case R.id.b2:
                Toast.makeText(mactivity.getBaseContext(), "caonimai",Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
    }

}
