package com.example.henry.itreview.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.henry.itreview.R;
import com.example.henry.itreview.activity.MainActivity;
import com.example.henry.itreview.adapter.ForumListAdapter;
import com.example.henry.itreview.myclass.ForumList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henry on 2018/6/12.
 */

public class ForumFragment extends Fragment {
    private List<ForumList> forumListList = new ArrayList<>();
    private Activity activity ;
    public ForumFragment(){}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forum_fragment, container, false);
        init();
        ForumListAdapter adapter = new ForumListAdapter(this.getContext(), R.layout.forum_list_item, forumListList);
        ListView listView = (ListView) view.findViewById(R.id.forum_list);
        listView.setAdapter(adapter);
        activity = getActivity();
        return view;
    }
    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {

    }

    private void init() {
        forumListList.add(new ForumList("讨论区",R.drawable.discuss));
        forumListList.add(new ForumList("我的帖子",R.drawable.tiezi));
        forumListList.add(new ForumList("排行榜",R.drawable.rank));
        forumListList.add(new ForumList("我的成就",R.drawable.grade));

    }
}
