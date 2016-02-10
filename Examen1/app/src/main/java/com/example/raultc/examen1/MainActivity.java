package com.example.raultc.examen1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String From;
    String To;

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
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(MainActivity.this, layout2.examen.segundaPantalla.class));
                startActivity(new Intent("layout2.examen.segundaPantalla"));
            }


        });

        SharedPreferences sett = getSharedPreferences("preferences", 0);
        From = sett.getString("fromString", "USD");
        To = sett.getString("fromString", "MX");
        ((TextView)findViewById(R.id.textFrom)).setText(From);
        ((TextView)findViewById(R.id.textTo)).setText(To);

    }


    @Override
    protected  void onResume (){
        super.onResume();

        SharedPreferences sett = getSharedPreferences("preferences", 0);
        From = sett.getString("fromString", "USD");
        To = sett.getString("toString", "MX");
        ((TextView)findViewById(R.id.textFrom)).setText(From);
        ((TextView)findViewById(R.id.textTo)).setText(To);

    }


    public void convertFunction (View view ) {

        double mult = 0;
        double total;

        EditText currencyField = (EditText) findViewById(R.id.numField);

        if (currencyField.getText().toString().equals("")) {
            Toast.makeText(this, "Input a valid Number", Toast.LENGTH_SHORT).show();

        }
        else {

            String original = ((TextView) findViewById(R.id.textFrom)).getText().toString();
            String con = ((TextView) findViewById(R.id.textTo)).getText().toString();

            if (original.equals("USD")) {
                if (con.equals("USD")) {
                    mult = 1;
                }
                if (con.equals("MX")) {
                    mult = 18.8138;
                }
                if (con.equals("EU")) {
                    mult = .8895;
                }
            }
            if (original.equals( "MX")) {

                if (con.equals("MX")) {
                    mult = 1;
                }
                if (con.equals("USD")) {
                    mult = .0532;
                }
                if (con.equals("EU")) {
                    mult = .0473;
                }
            }
            if (original.equals("EU")) {

                if (con.equals("EU")) {
                    mult = 1;
                }

                if (con.equals("USD")) {
                    mult = 1.1237;
                }
                if (con.equals("MX")) {
                    mult = 21.1345;
                }

            }
            total = Double.parseDouble(((EditText) findViewById(R.id.numField)).getText().toString());
            Toast.makeText(this, String.valueOf((total * mult)), Toast.LENGTH_LONG).show();

        }

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
