package ca.ucalgary.soar.omnilog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



public class SplashScreenActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
        finish();
    }
}
