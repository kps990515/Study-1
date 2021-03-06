package com.mdy.android.danielmemo.domain;

/**
 * Created by MDY on 2017-05-31.
 */

public class Memo {
    private String title;
    private String content;
    private String date;
    private boolean delete = false;

    public boolean getDelete() {
        return delete;
    }

    public void setDelete(boolean check) {
        this.delete = check;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}