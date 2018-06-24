package com.example.henry.itreview.myclass;

/**
 * Created by asus on 2018/6/19.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SQLCon {

    public static List<Problem> list =  new ArrayList<>();


    public static void main (String[] args) {



    }
    private static void parseJson(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0 ; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String question = jsonObject.getString("data");
                JSONArray array = new JSONArray(question);

                //String a = jsonObject.getString("A");
//                String b = jsonObject.getString("B");
//                String c = jsonObject.getString("C");
//                String d = jsonObject.getString("D");
                //String answer = jsonObject.getString("Answer");
                System.out.println(question);
                //Problem problem = new Problem(question, "A " + a, "B " + b, "C " + c, "D " + d, answer);
                //System.out.println(a+ b + c+ d);
                //list.add(problem);
            }
            //Log.d("json", "大小 " + jsonArray.length());
        }catch (Exception e) {

        }
    }
}
