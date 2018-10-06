package com.vidy.sdk.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.vidy.sdk.api.VidySdk;
import com.vidy.sdk.api.component.callbacks.VidyCallback;
import com.vidy.sdk.api.component.controllers.VidyPost;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLifecycle();

        setContentView(R.layout.activity_fullscreen);

        VidySdk.activate(this, "samplepost", false, new VidyCallback() {
            @Override
            public void onSuccess(VidyPost post, VidyState vidyState) {
                post.updateViews();
                Log.d(TAG, "onSuccess() vidyState: "+vidyState);
            }

            @Override
            public void onFailure(VidyPost post, VidyError vidyError) {
                Log.d(TAG, "onFailure() vidyError: "+vidyError);
            }
        });
    }
}
