package com.example.henry.itreview.myclass;

/**
 * Created by asus on 2018/6/25.
 */



/**
 * Created by asus on 2018/6/25.
 */

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.PrintWriter;
        import java.net.HttpURLConnection;
        import java.net.URL;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.PrintWriter;
        import java.net.HttpURLConnection;
        import java.net.URL;

/**
 * Created by asus on 2018/6/25.
 */
        import android.widget.Toast;

        import org.json.JSONException;
        import org.json.JSONObject;

        import java.lang.reflect.Array;
        import java.net.*;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Iterator;
        import java.util.List;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;
public class Login{


    static StringBuilder result = new StringBuilder();
    static PrintWriter printWriter;
    static BufferedReader bufferedReader;
    public static String Post(String spec, String param) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            URL realUrl = new URL(spec);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();

            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            conn.setRequestMethod("POST"); // 设置请求方式
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();

            printWriter = new PrintWriter(conn.getOutputStream());
            printWriter.print(param);
            printWriter.flush();

            bufferedReader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null)
                result.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            if(printWriter!=null){
                printWriter.close();
            }
            if(bufferedReader!=null){
                bufferedReader.close();
            }
        }
        return result.toString();
    }
    public static String  connect(String username,String password)throws IOException{
//            String username = "qq78903232";
//            String password1 = "1234567";
//            String password2 = "1234567";
//            String sex = "男";
//            String country = "中国";
//            String age = "20";

        String data = String.format("username=%s&password=%s",username, password);
        String s =(Post("http://172.29.23.128/login", data));
        System.out.println(s);


        return s;

    }
//        public static void main(String args[])throws IOException{
//            System.out.println(Register.connect("qq789789","789456qwe","789456qwe","男","usa","48"));
//        }

}
