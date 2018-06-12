package com.example.henry.itreview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.henry.itreview.R;

/**
 * Created by Henry on 2018/6/12.
 */

public class MineFragment extends Fragment {
    public MineFragment() {}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment, container, false);
        return view;
    }
}
