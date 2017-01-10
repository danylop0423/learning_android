package com.example.gerald.secondtest.listeners.mainListeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.gerald.secondtest.activities.MapsActivity;

/**
 * Created by javieralejos on 10/1/17.
 */

public class GoToAnActivityListener implements View.OnClickListener {

    private Activity myActivity;

    public GoToAnActivityListener(Activity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public void onClick(View v) {
        Intent goToMap = new Intent(myActivity.getApplicationContext(),MapsActivity.class);//pq estamos en un objeto View sino seria el this
        myActivity.startActivity(goToMap);



    }
}
