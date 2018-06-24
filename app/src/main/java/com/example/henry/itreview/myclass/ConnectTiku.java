package com.example.henry.itreview.myclass;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Henry on 2018/6/21.
 */

public class ConnectTiku {

    private List<Problem> list = new ArrayList<>();
    public ConnectTiku (Connection c, String type)  {

    }
    private void initProblem() {
        Runnable runnable = new Runnable() {
            @Override
            public void run () {
                OkHttpClient client = new OkHttpClient();
               // Request request = new Request.Builder().build().url("")
            }
        };
    }

}
