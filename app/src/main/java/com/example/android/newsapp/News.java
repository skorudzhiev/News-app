package com.example.android.newsapp;

public class News {

    String title;
    String section;
    String date;
    String url;

    public News(String Title, String Section, String Date, String Url){
        title = Title;
        section = Section;
        date = Date;
        url = Url;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }
}
