package layout2.examen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.raultc.examen1.R;

public class segundaPantalla extends AppCompatActivity {

    Spinner currency;
    Spinner currency2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
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


         currency = (Spinner)findViewById(R.id.spinner);

        String[] cur = getResources().getStringArray(R.array.Currencies);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cur);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currency.setAdapter(myAdapter);

         currency2 = (Spinner)findViewById(R.id.spinner2);

        String[] cur2 = getResources().getStringArray(R.array.Currencies);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cur2);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currency2.setAdapter(myAdapter2);
    }

    public void onClickkk(View view) {
        String spinnerSelecF = currency.getSelectedItem().toString();
        String spinnerSelecT = currency2.getSelectedItem().toString();
        SharedPreferences sett = getSharedPreferences("preferences", 0);
        SharedPreferences.Editor editor = sett.edit();
        editor.putString("fromString", spinnerSelecF);
        editor.putString("toString", spinnerSelecT);

        editor.commit();
        finish();





    }

}
