package com.example.gerald.secondtest.activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Path;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gerald.secondtest.listeners.mainListeners.FloatingButtonListener;
import com.example.gerald.secondtest.listeners.mainListeners.GoToAnActivityListener;
import com.example.gerald.secondtest.listeners.mainListeners.TouchMeListener;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView saludotext;
    private ImageButton callMeImg;
    private EditText phonetxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Gerky code and Gerky listeners
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new FloatingButtonListener());

        saludotext = (TextView) findViewById(R.id.SaludoText);//habría que crear otra clase listener para el botón de las llamadas
        /*callMeImg = (ImageButton) findViewById(R.id.callButtImg);
        callMeImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Integer numero = findViewById(R.id.callButtImg).toInteger();

            }

        });*/

        Button touchMeButton = (Button) findViewById(R.id.buttonTouchMe);
        touchMeButton.setOnClickListener(new TouchMeListener(saludotext,this));


        Button mapa= (Button) this.findViewById(R.id.buttonMap);
        mapa.setOnClickListener(new GoToAnActivityListener(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
