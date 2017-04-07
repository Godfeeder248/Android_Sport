package com.example.rinaattieh.sports_app_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewMatch extends AppCompatActivity {

    Button btn_map;
    Spinner switch_service;
    Spinner eq_tab_2;
    TextView eq1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_match);

        //Recupère nom de l'equipe selectionne au debut
        String txt = (String) getIntent().getSerializableExtra("string");

        btn_map = (Button) findViewById(R.id.btn_map);

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_map = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(int_map);
            }
        });

        //////////////////////////// SWITCH EQUIPE 2 TABLEAU ////////////////////////////////////////////////////////
        eq_tab_2 = (Spinner) findViewById(R.id.eq_tab_2);

        List equipe_tab = new ArrayList();
        equipe_tab.add("Autre1");
        equipe_tab.add("Autre2");

        ArrayAdapter adapter_tab = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                equipe_tab
        );

        adapter_tab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eq_tab_2.setAdapter(adapter_tab);

        //////////////////////////// SWITCH EQUIPE 2 TABLEAU ////////////////////////////////////////////////////////


        //////////////////////////// SWITCH EQUIPE SERVICE ////////////////////////////////////////////////////////
        switch_service = (Spinner) findViewById(R.id.switch_equipe);

        List equipe = new ArrayList();
        equipe.add(txt);
        equipe.add("Autre 1");
        equipe.add("Autre 2");

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                equipe
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        switch_service.setAdapter(adapter);


    //////////////////////////// SWITCH EQUIPE SERVICE ///////////////////////////////////////////////////////////////

        eq1 = (TextView)findViewById(R.id.eq1);
        eq1.setText("1 : " + txt);


    }

}
