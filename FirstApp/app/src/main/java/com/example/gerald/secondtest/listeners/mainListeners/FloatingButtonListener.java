package com.example.gerald.secondtest.listeners.mainListeners;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by javieralejos on 10/1/17.
 */

public class FloatingButtonListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
