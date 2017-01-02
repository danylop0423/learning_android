package com.example.gerald.secondtest;

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

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView saludotext;
    ImageButton callMeImg;
    EditText phonetxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //TODO mi creacion
        saludotext = (TextView) findViewById(R.id.SaludoText);
        /*callMeImg = (ImageButton) findViewById(R.id.callButtImg);
        callMeImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Integer numero = findViewById(R.id.callButtImg).toInteger();

            }

        });*/

        Button touchMeButton = (Button) findViewById(R.id.buttonTouchMe);
        touchMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String direccion = saludotext.getText().toString();
                //direccion = direccion.split("\n");
                /*Path newLink = "www.google.com";
                Path target = "estoEsUnamierda";
                try {
                    MediaStore.Files.createSymbolicLink(newLink, target);
                } catch (IOException x) {
                    System.err.println(x);
                } catch (UnsupportedOperationException x) {
                    // Some file systems do not support symbolic links.
                    System.err.println(x);
                }*/
                try {
                    //URL buscaBusca = new URL("https://www.google.es/search?q=" + direccion);
                    Uri uri = Uri.parse("https://www.google.es/search?q=" + direccion);
                    Intent intent= new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);


                }
                catch (Exception e) {
                    System.err.println("Esa dirección no existe cachondo");
                }

            }
        });


    Button mapa= (Button) this.findViewById(R.id.buttonMap);
    mapa.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goToMap = new Intent(getApplicationContext(),MapsActivity.class);//pq estamos en un objeto View sino seria el this
                    startActivity(goToMap);



                }
            }
    );




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
