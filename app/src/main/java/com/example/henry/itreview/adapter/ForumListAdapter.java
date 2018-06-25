package com.example.henry.itreview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.henry.itreview.R;
import com.example.henry.itreview.myclass.ConnectTiku;
import com.example.henry.itreview.myclass.ForumList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henry on 2018/6/25.
 */

public class ForumListAdapter extends ArrayAdapter<ForumList>{
    private int resourceId;

    public ForumListAdapter (Context context, int textView, List<ForumList> objects) {
        super(context, textView, objects);
        resourceId = textView;
    }

    @Override
    public View getView (int position, View v, ViewGroup parent) {
        ForumList forumList = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView imageView = (ImageView)view.findViewById(R.id.forum_list_icon);
        TextView textView = (TextView) view.findViewById(R.id.forum_list_name);
        imageView.setImageResource(forumList.getImageId());
        textView.setText(forumList.getName());
        return view;
    }

}
