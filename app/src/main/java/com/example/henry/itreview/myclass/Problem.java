package com.example.henry.itreview.myclass;

/**
 * Created by Henry on 2018/6/19.
 */

public class Problem {
    private String question;
    private String a;
    private String b;
    private String c;
    private String d;
    private String correct;
    public Problem(String q, String a, String b, String c, String d, String correct) {
        this.question = q;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.correct = correct;
    }

    public String getQuestion () {
        return question;
    }

    public String getA () {
        return a;
    }

    public String getB () {
        return b;
    }

    public String getC () {
        return c;
    }

    public String getD () {
        return d;
    }

    public String getCorrect () {
        return correct;
    }
}
