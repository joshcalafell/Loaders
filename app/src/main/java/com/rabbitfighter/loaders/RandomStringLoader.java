package com.rabbitfighter.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by rabbitfighter on 5/27/15.
 */
public class RandomStringLoader extends AsyncTaskLoader<ArrayList<String>> {

    public RandomStringLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        super.onStartLoading();
    }

    @Override
    public ArrayList<String> loadInBackground() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<String> array = new ArrayList<String>();
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            String randomString = "";
            for (int j = 0; j < 20; j++) {
                randomString = randomString + chars[random.nextInt(chars.length)];
            }
            randomString += "\n";
            array.add(randomString);
        }
        return array;
    }

    @Override
    public void deliverResult(ArrayList<String> data) {
        //
        if (isStarted()) {
            super.deliverResult(data);
        }

    }
}
