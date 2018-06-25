package com.example.henry.itreview.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.henry.itreview.R;
import com.example.henry.itreview.activity.MainActivity;

import java.util.List;

/**
 * Created by Henry on 2018/6/12.
 */

public class MineFragment extends Fragment {
    private Activity activity;
    private ListView listView;
    private String[] data = {"修改资料", "错题收藏", "发表帖子", "设置"};
    public MineFragment() {}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, data);
        listView = (ListView)view.findViewById(R.id.my_list);
        listView.setAdapter(adapter);
        return view;
    }
    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {

    }


}
