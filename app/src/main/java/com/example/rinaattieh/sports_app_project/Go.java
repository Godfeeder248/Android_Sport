package com.example.rinaattieh.sports_app_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Go extends AppCompatActivity {

    Spinner spinner;
    Button go =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        go = (Button) findViewById(R.id.go);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goo = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goo);
            }
        });


    //////////////////////////// SPINNER /////////////////////////////////////////////////////////////////////

    spinner = (Spinner) findViewById(R.id.equipe_menu);

    List equipe = new ArrayList();
    equipe.add("Equipe 1");
    equipe.add("Equipe 2");
    equipe.add("Equipe 3");

    ArrayAdapter adapter = new ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            equipe
    );

    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    //Enfin on passe l'adapter au Spinner et c'est tout
    spinner.setAdapter(adapter);

//////////////////////////// SPINNER /////////////////////////////////////////////////////////////////////
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_go, menu);
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
