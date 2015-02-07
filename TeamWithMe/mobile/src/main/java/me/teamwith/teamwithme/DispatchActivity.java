package me.teamwith.teamwithme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseUser;

public class DispatchActivity extends ActionBarActivity {
    public static final String TAG = "TWM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "Reached Dispatch Activity.");

        // Start Parse
        // TODO: Extract Parse keys to api_keys.xml
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, getString(R.string.PARSE_APPLICATION_ID), getString(R.string.PARSE_CLIENT_KEY));
        // End Parse

        // Start Parse Push Notifications
//        ParsePush.subscribeInBackground("", new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//
//                if (e == null) {
//                    Log.d("com.parse.push", "Successfully subscribed to Push.");
//                } else {
//                    Log.e("com.parse.push", "Failed to subscribe to Push.", e);
//                }
//            }
//        });
        // End Parse Push Notifications

        super.onCreate(savedInstanceState);

        // Check if there is current user info
        if (ParseUser.getCurrentUser() != null) {
            // Start an intent for the logged in activity
            startActivity(new Intent(this, MainActivity.class));
        } else {
            // Start and intent for the logged out activity
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}