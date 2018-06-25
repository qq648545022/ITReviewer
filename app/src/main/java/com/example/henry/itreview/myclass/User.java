package com.example.henry.itreview.myclass;

/**
 * Created by Henry on 2018/6/25.
 */

public class User {
    private String name;
    private String sex;
    private String country;
    private String age;
    public User (String name, String sex, String country, String age) {
        this.name = name;
        this.sex = sex;
        this.country = country;
        this.age = age;
    }

    public String getName () {
        return name;
    }

    public String getAge () {
        return age;
    }

    public String getSex () {
        return sex;
    }

    public String getCountry () {
        return country;
    }
}
