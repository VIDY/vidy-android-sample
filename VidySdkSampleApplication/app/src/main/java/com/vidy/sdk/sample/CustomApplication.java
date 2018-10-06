package com.vidy.sdk.sample;

import android.app.Application;

import com.vidy.sdk.api.VidySdk;

/**
 * Created by Jake on 9/21/2018.
 */

public class CustomApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();

        VidySdk.setApplicationId(this, "bd6e3c14-57ad-4d26-b7f2-b92a4c750c19");
    }
}
