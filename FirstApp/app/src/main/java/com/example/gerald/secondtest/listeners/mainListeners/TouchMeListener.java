package com.example.gerald.secondtest.listeners.mainListeners;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

/**
 * Created by javieralejos on 10/1/17.
 */

public class TouchMeListener implements View.OnClickListener {

    private Activity main;
    private TextView saludotext;

    public TouchMeListener(TextView saludotext, Activity main) {
        this.saludotext = saludotext;
        this.main = main;
    }

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
            main.startActivity(intent);


        }
        catch (Exception e) {
            System.err.println("Esa dirección no existe cachondo");
        }

    }
}
