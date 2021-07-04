package com.zcr.c002;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class MyOKHttp {

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) {

        MyOKHttp myOKHttp = new MyOKHttp();
        try {
            String result = myOKHttp.run(" http://localhost:8801");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
