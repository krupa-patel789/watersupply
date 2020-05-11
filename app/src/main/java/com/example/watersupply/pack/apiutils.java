package com.example.watersupply.pack;

public class apiutils {

    public static final String url = "http://192.168.43.235:8080/watersupply/";

    public static API getUserService(){
        return retrofit.getClient(url).create(API.class);
    }
}
