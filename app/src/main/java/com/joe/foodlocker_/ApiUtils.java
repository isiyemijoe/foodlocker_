package com.joe.foodlocker_;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ApiUtils {
    public static final String BASE_API_URL = "http://v2.foodlocker.com.ng/apiv1?action=all_products";


    public static URL buildUrl (String title){
        URL url = null;
        Uri uri = Uri.parse(BASE_API_URL).buildUpon().build();
        try{
            url = new URL(uri.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  url;
    }

    public static String getJson(URL url) throws IOException{
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            InputStream stream = connection.getInputStream();
            Scanner scanner = new Scanner(stream);
            scanner.useDelimiter("\\A");
            boolean hasData = scanner.hasNext();
            if (hasData) {
                return scanner.next();
            } else {
                return null;
            }
        } catch (Exception e) {
            Log.d("Error", e.toString());

        } finally {
            connection.disconnect();
            Log.d("Error", "This list finish Here");
        }
        Log.d("Error", "We got Here too");
        return null;
    }

    public static ArrayList<Food> getFoodFromJson(String Json) {
        final String name = "name";
        String thumbnail;
        String Description;
        String category;
        String Price;
        String products = "products";
        ArrayList<Food> foods = new ArrayList<>();

        try {
            JSONObject jsonfood = new JSONObject(Json);
            JSONArray arrayFoods = jsonfood.getJSONArray(products);
            int numberOfFoods = arrayFoods.length();
            for (int i = 0; i < numberOfFoods; i++) {

            }


        } catch (Exception e) {
            Log.d("Network", "Error getting Connection");
        }
        return foods;
    }
}
