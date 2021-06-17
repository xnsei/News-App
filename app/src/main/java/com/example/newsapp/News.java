package com.example.newsapp;

public class News {

    String imageUrl;
    String title;
    String author;
    String url;

    public News(
            String imageUrl,
            String title,
            String author,
            String url
    ){
        this.imageUrl = imageUrl;
        this.title = title;
        this.author = author;
        this.url = url;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getUrl(){
        return url;
    }

}
