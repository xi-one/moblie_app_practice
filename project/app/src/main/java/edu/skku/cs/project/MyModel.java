package edu.skku.cs.project;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;




public class MyModel implements MyContract.ContractForModel {

    public MyModel(){    // 생성자


    }

    boolean result;
    apiData data;


    @Override
    public boolean PostID(String type, String id, String pw)  {




        OkHttpClient client = new OkHttpClient();

        DataModel data = new DataModel();

        data.setName(id);
        data.setPasswd(pw);

        Gson gson = new Gson();
        String json = gson.toJson(data, DataModel.class);

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://jo5cq47jx3.execute-api.ap-northeast-2.amazonaws.com/dev/" + type).newBuilder();
        String url = urlBuilder.build().toString();

        Request req = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MediaType.parse("application/json"),json))
                .build();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                final String myResponse = response.body().string();

                Gson gson = new GsonBuilder().create();
                final DataModel data1 = gson.fromJson(myResponse,  DataModel.class);

                result = data1.isSuccess();
                countDownLatch.countDown();


            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return result;

    }

    @Override
    public Intent ChangeActivity(Context from, Class to, String user) {

        Intent intent = new Intent(from, to);
        intent.putExtra("user", user);

        return intent;
    }

    @Override
    public apiData getfromAPI(String name) {
        OkHttpClient client = new OkHttpClient();
        //HttpUrl.Builder urlBuilder = HttpUrl.parse("https://openapi.foodsafetykorea.go.kr/api/88691e1fbfb1469aaa86/COOKRCP01/json/1/100/RCP_NM=" + name).newBuilder();
        //urlBuilder.addQueryParameter("RCP_NM",name);

        //String url = urlBuilder.build().toString();
        String url = "http://openapi.foodsafetykorea.go.kr/api/88691e1fbfb1469aaa86/COOKRCP01/json/1/100/RCP_NM=" + name;
        //Log.i("api", url);

        Request req = new Request.Builder().url(url).build();

        CountDownLatch countDownLatch = new CountDownLatch(1);


        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                final String myResponse = response.body().string();
                Log.i("api",myResponse);

                Gson gson = new GsonBuilder().create();
                data = gson.fromJson(myResponse,  apiData.class);
                countDownLatch.countDown();
                Log.i("api",data.getCOOKRCP01().getTotal_count());


            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        return data;
    }

    @Override
    public Intent makerecipeIntent(Context from, Class to, Recipe item) {
        Intent intent = new Intent(from, to);
        intent.putExtra("item", item);
        return intent;
    }

    @Override
    public apiData getfromAWSbyuser(String user) {
        OkHttpClient client = new OkHttpClient();

        String url = "https://jo5cq47jx3.execute-api.ap-northeast-2.amazonaws.com/dev/searchmaker";



        Recipe data1 = new Recipe();

        data1.setMaker(user);

        Gson gson = new Gson();
        Log.i("debug1", user);
        String json = gson.toJson(data1, Recipe.class);

        Request req = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MediaType.parse("application/json"),json))
                .build();



        CountDownLatch countDownLatch = new CountDownLatch(1);


        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                final String myResponse = response.body().string();

                Gson gson = new GsonBuilder().create();
                data = gson.fromJson(myResponse,  apiData.class);
                countDownLatch.countDown();

            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        return data;

    }

    @Override
    public apiData getfromAWSbyname(String name) {
        OkHttpClient client = new OkHttpClient();

        String url = "https://jo5cq47jx3.execute-api.ap-northeast-2.amazonaws.com/dev/searchrecipe";



        Recipe data1 = new Recipe();

        data1.setRCP_NM(name);

        Gson gson = new Gson();
        String json = gson.toJson(data1, Recipe.class);

        Request req = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MediaType.parse("application/json"),json))
                .build();



        CountDownLatch countDownLatch = new CountDownLatch(1);


        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                final String myResponse = response.body().string();

                Gson gson = new GsonBuilder().create();
                Log.i("debug", "response is " + myResponse);
                data = gson.fromJson(myResponse,  apiData.class);
                countDownLatch.countDown();

            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        return data;
    }

    @Override
    public boolean deleteRecipe(String user, String name) {
        OkHttpClient client = new OkHttpClient();

        String url = "https://jo5cq47jx3.execute-api.ap-northeast-2.amazonaws.com/dev/deleterecipe";

        Recipe postData = new Recipe();
        postData.setRCP_NM(name);
        postData.setMaker(user);
        Gson gson = new Gson();
        String json = gson.toJson(postData, Recipe.class);

        Request req = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MediaType.parse("application/json"),json))
                .build();



        CountDownLatch countDownLatch = new CountDownLatch(1);


        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                final String myResponse = response.body().string();

                Gson gson = new GsonBuilder().create();
                DataModel res = new DataModel();
                res = gson.fromJson(myResponse,  DataModel.class);
                result = res.isSuccess();
                countDownLatch.countDown();

            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean addtoAWS(Recipe data) {
        OkHttpClient client = new OkHttpClient();

        String url = "https://jo5cq47jx3.execute-api.ap-northeast-2.amazonaws.com/dev/addrecipe";

        Gson gson = new Gson();
        String json = gson.toJson(data, Recipe.class);

        Request req = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MediaType.parse("application/json"),json))
                .build();



        CountDownLatch countDownLatch = new CountDownLatch(1);


        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                final String myResponse = response.body().string();

                Gson gson = new GsonBuilder().create();
                DataModel res = new DataModel();
                res = gson.fromJson(myResponse,  DataModel.class);
                result = res.isSuccess();
                countDownLatch.countDown();

            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;

    }


}
