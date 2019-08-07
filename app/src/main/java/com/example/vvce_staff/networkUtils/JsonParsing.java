package com.example.vvce_staff.networkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonParsing {
    String line, data;

    URL url = null;

        try {
        url = new URL("https://api.myjson.com/bins/sqhdt");
    } catch (
    MalformedURLException e) {
        e.printStackTrace();
    }

    HttpURLConnection connection = null;

        try {
        connection = (HttpURLConnection) url.openConnection();
    } catch (
    IOException e) {
        e.printStackTrace();
    }

    InputStream input = null;


        try {
        input = connection.getInputStream();
    } catch (IOException e) {
        e.printStackTrace();
    }

    BufferedReader buffer = new BufferedReader(new InputStreamReader(input));

        while (line != null) {
        try {
            line = buffer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        data = data + line;


        JSONArray ja = null;
        try {
            ja = new JSONArray(data);
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = (JSONObject) ja.get(i);

                //TODO : Code To Display On Screen


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
