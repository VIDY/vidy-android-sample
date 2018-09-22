package com.vidy.sdk.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.vidy.sdk.api.VidySdk;
import com.vidy.sdk.api.component.callbacks.VidyCallback;
import com.vidy.sdk.api.component.enums.VidyError;
import com.vidy.sdk.api.component.enums.VidyState;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    private static final String TAG = FullscreenActivity.class.getSimpleName();

    private VidySdk vidySdk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        VidySdk.setApplicationId(this, "bd6e3c14-57ad-4d26-b7f2-b92a4c750c19");
        vidySdk = VidySdk.init(this, "samplepost", false, new VidyCallback() {
            @Override
            public void onSuccess(VidyState vidyState) {
                if(vidyState == VidyState.INITIALIZED) {
                    vidySdk.postUpdate();
                }

            }

            @Override
            public void onFailure(VidyError vidyError) {

            }
        });
    }
}
