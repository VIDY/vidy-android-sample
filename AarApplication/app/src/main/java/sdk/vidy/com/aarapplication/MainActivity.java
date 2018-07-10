package sdk.vidy.com.aarapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vidy.sdk.api.VidySdk;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> embedStrings = new ArrayList<>();
        embedStrings.add("Nibh mauris cursus mattis molestie a.");
        embedStrings.add("vitae tempus quam pellentesque");
        embedStrings.add("Senectus et netus et malesuada fames ac turpis egestas maecenas.");
        embedStrings.add("Tortor vitae purus faucibus ornare suspendisse sed nisi lacus sed.");

        VidySdk.setApplicationId(this, "bd6e3c14-57ad-4d26-b7f2-b92a4c750c19");
        VidySdk.init(this, embedStrings);

    }
}
