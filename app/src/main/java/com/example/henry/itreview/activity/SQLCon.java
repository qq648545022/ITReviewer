package com.example.henry.itreview.activity;

/**
 * Created by asus on 2018/6/19.
 */
import java.sql.*;
public class SQLCon {
    private Connection con;
    public void getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            con = DriverManager.getConnection("jdbc:mysql:" + "//172.29.37.36:3306/app","root","123456");
            System.out.println("数据库连接成功！");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        SQLCon c = new SQLCon();
        c.getConnection();
    }
}
