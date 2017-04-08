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

    Button btn_map, valider;
    Spinner switch_service;
    Spinner eq_tab_2;
    TextView eq1;

    // Bouton points services
    Button service, ace, filet, time_out, limit, out;

    // Bouton points echange
    Button smash_t1, smash_t2, class_t1, class_t2, faute_t1, faute_t2;

    // TextView Afficher resultat
    // 4 set a 25 points
    // 2 team
    TextView s1_t1, s1_t2, s2_t1, s2_t2, s3_t1, s3_t2, s4_t1, s4_t2;


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
        equipe_tab.add("France");
        equipe_tab.add("Espagne");
        equipe_tab.add("Italie");
        equipe_tab.add("Allemagne");

        ArrayAdapter adapter_tab = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                equipe_tab
        );

        adapter_tab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eq_tab_2.setAdapter(adapter_tab);

        //////////////////////////// SWITCH EQUIPE SERVICE ////////////////////////////////////////////////////////
        switch_service = (Spinner) findViewById(R.id.switch_equipe);

        List equipe = new ArrayList();
        equipe.add(txt);
        equipe.add("Equipe 2");

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                equipe
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        switch_service.setAdapter(adapter);

        // on récupère le nom de la premiere equipe (selectionné au debut)
        eq1 = (TextView)findViewById(R.id.eq1);
        eq1.setText(txt);

    //////////////////////// COMPTE POINTS //////////////////////////////////////////////////////

        service = (Button) findViewById(R.id.serv);
        ace = (Button) findViewById(R.id.ace);
        filet = (Button) findViewById(R.id.filet);
        time_out = (Button) findViewById(R.id.time_out);
        limit = (Button) findViewById(R.id.limit);
        out = (Button) findViewById(R.id.out);

        smash_t1 = (Button) findViewById(R.id.smash_t1);
        smash_t2 = (Button) findViewById(R.id.smash_t2);
        class_t1 = (Button) findViewById(R.id.class_t1);
        class_t2 = (Button) findViewById(R.id.class_t2);
        faute_t1 = (Button) findViewById(R.id.faute_t1);
        faute_t2 = (Button) findViewById(R.id.faute_t2);

        valider = (Button) findViewById(R.id.valider_match);

        s1_t1 = (TextView)findViewById(R.id.s1_t1);
        s1_t2 = (TextView)findViewById(R.id.s1_t2);
        s2_t1 = (TextView)findViewById(R.id.s2_t1);
        s2_t2 = (TextView)findViewById(R.id.s2_t2);
        s3_t1 = (TextView)findViewById(R.id.s3_t1);
        s3_t2 = (TextView)findViewById(R.id.s3_t2);
        s4_t1 = (TextView)findViewById(R.id.s4_t1);
        s4_t2 = (TextView)findViewById(R.id.s4_t2);

        final int[] point_s1_t1 = {Integer.parseInt(s1_t1.getText().toString())};
        final int[] point_s1_t2 = {Integer.parseInt(s1_t2.getText().toString())};
        final int[] point_s2_t1 = {Integer.parseInt(s2_t1.getText().toString())};
        final int[] point_s2_t2 = {Integer.parseInt(s2_t2.getText().toString())};
        final int[] point_s3_t1 = {Integer.parseInt(s3_t1.getText().toString())};
        final int[] point_s3_t2 = {Integer.parseInt(s3_t2.getText().toString())};
        final int[] point_s4_t1 = {Integer.parseInt(s4_t1.getText().toString())};
        final int[] point_s4_t2 = {Integer.parseInt(s4_t2.getText().toString())};

        //service, gagnant pour equipe selectionee
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = (String) getIntent().getSerializableExtra("string");
                String service_equipe = switch_service.getSelectedItem().toString();

                if (service_equipe == txt)
                {
                    if (point_s1_t1[0] <= 24 && ( point_s1_t2[0] != 25 ) ){
                        point_s1_t1[0]++;
                        s1_t1.setText(""+ point_s1_t1[0]);
                    }
                    else if(point_s2_t1[0] <= 24 && ( point_s1_t1[0] ==25 || point_s1_t2[0] == 25) && point_s2_t2[0] !=25 ){
                        point_s2_t1[0]++;
                        s2_t1.setText(""+ point_s2_t1[0]);
                    }
                    else if(point_s3_t1[0] <= 24 && ( point_s2_t1[0] ==25 || point_s2_t2[0] == 25) && point_s3_t2[0] !=25 ){
                        point_s3_t1[0]++;
                        s3_t1.setText(""+ point_s3_t1[0]);
                    }
                    else if(point_s4_t1[0] <= 24 && ( point_s3_t1[0] ==25 || point_s3_t2[0] == 25) && point_s4_t2[0] !=25 ){
                        point_s4_t1[0]++;
                        s4_t1.setText(""+ point_s4_t1[0]);
                    }
                }
                else
                {
                    if (point_s1_t2[0] <= 24 && ( point_s1_t1[0] != 25 ) ) {
                        point_s1_t2[0]++;
                        s1_t2.setText(""+ point_s1_t2[0]);
                    }
                    else if(point_s2_t2[0] <= 24 && ( point_s1_t1[0] == 25 || point_s1_t2[0] == 25) && point_s2_t1[0] !=25){
                        point_s2_t2[0]++;
                        s2_t2.setText(""+ point_s2_t2[0]);
                    }
                    else if(point_s3_t2[0] <= 24 && ( point_s2_t1[0] == 25 || point_s2_t2[0] == 25) && point_s3_t1[0] !=25 ){
                        point_s3_t2[0]++;
                        s3_t2.setText(""+ point_s3_t2[0]);
                    }
                    else if(point_s4_t2[0] <= 24 && ( point_s3_t1[0] == 25 || point_s3_t2[0] == 25) && point_s4_t1[0] !=25 ){
                        point_s4_t2[0]++;
                        s4_t2.setText(""+ point_s4_t2[0]);
                    }
                }
            }
        });

        //ace, gagnant pour equipe selectionee
        ace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = (String) getIntent().getSerializableExtra("string");
                String service_equipe = switch_service.getSelectedItem().toString();

                if (service_equipe == txt)
                {
                    if (point_s1_t1[0] <= 24 && ( point_s1_t2[0] != 25 ) ){
                        point_s1_t1[0]++;
                        s1_t1.setText(""+ point_s1_t1[0]);
                    }
                    else if(point_s2_t1[0] <= 24 && ( point_s1_t1[0] ==25 || point_s1_t2[0] == 25) && point_s2_t2[0] !=25 ){
                        point_s2_t1[0]++;
                        s2_t1.setText(""+ point_s2_t1[0]);
                    }
                    else if(point_s3_t1[0] <= 24 && ( point_s2_t1[0] ==25 || point_s2_t2[0] == 25) && point_s3_t2[0] !=25 ){
                        point_s3_t1[0]++;
                        s3_t1.setText(""+ point_s3_t1[0]);
                    }
                    else if(point_s4_t1[0] <= 24 && ( point_s3_t1[0] ==25 || point_s3_t2[0] == 25) && point_s4_t2[0] !=25 ){
                        point_s4_t1[0]++;
                        s4_t1.setText(""+ point_s4_t1[0]);
                    }
                }
                else
                {
                    if (point_s1_t2[0] <= 24 && ( point_s1_t1[0] != 25 ) ) {
                        point_s1_t2[0]++;
                        s1_t2.setText(""+ point_s1_t2[0]);
                    }
                    else if(point_s2_t2[0] <= 24 && ( point_s1_t1[0] == 25 || point_s1_t2[0] == 25) && point_s2_t1[0] !=25){
                        point_s2_t2[0]++;
                        s2_t2.setText(""+ point_s2_t2[0]);
                    }
                    else if(point_s3_t2[0] <= 24 && ( point_s2_t1[0] == 25 || point_s2_t2[0] == 25) && point_s3_t1[0] !=25 ){
                        point_s3_t2[0]++;
                        s3_t2.setText(""+ point_s3_t2[0]);
                    }
                    else if(point_s4_t2[0] <= 24 && ( point_s3_t1[0] == 25 || point_s3_t2[0] == 25) && point_s4_t1[0] !=25 ){
                        point_s4_t2[0]++;
                        s4_t2.setText(""+ point_s4_t2[0]);
                    }
                }
            }
        });

        //filet, perdant pour equipe selectionee
        filet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = (String) getIntent().getSerializableExtra("string");
                String service_equipe = switch_service.getSelectedItem().toString();

                if (service_equipe == txt)
                {
                    if (point_s1_t2[0] <= 24 && ( point_s1_t1[0] != 25 ) ){
                        point_s1_t2[0]++;
                        s1_t2.setText(""+ point_s1_t2[0]);
                    }
                    else if(point_s2_t2[0] <= 24 && ( point_s1_t1[0] ==25 || point_s1_t2[0] == 25) && point_s2_t1[0] !=25 ){
                        point_s2_t2[0]++;
                        s2_t2.setText(""+ point_s2_t2[0]);
                    }
                    else if(point_s3_t2[0] <= 24 && ( point_s2_t1[0] ==25 || point_s2_t2[0] == 25) && point_s3_t1[0] !=25 ){
                        point_s3_t2[0]++;
                        s3_t2.setText(""+ point_s3_t2[0]);
                    }
                    else if(point_s4_t2[0] <= 24 && ( point_s3_t1[0] ==25 || point_s3_t2[0] == 25) && point_s4_t1[0] !=25 ){
                        point_s4_t2[0]++;
                        s4_t2.setText(""+ point_s4_t2[0]);
                    }
                }
                else
                {
                    if (point_s1_t1[0] <= 24 && ( point_s1_t1[0] != 25 ) ) {
                        point_s1_t1[0]++;
                        s1_t1.setText(""+ point_s1_t1[0]);
                    }
                    else if(point_s2_t1[0] <= 24 && ( point_s1_t1[0] == 25 || point_s1_t2[0] == 25) && point_s2_t2[0] !=25){
                        point_s2_t1[0]++;
                        s2_t1.setText(""+ point_s2_t1[0]);
                    }
                    else if(point_s3_t1[0] <= 24 && ( point_s2_t1[0] == 25 || point_s2_t2[0] == 25) && point_s3_t2[0] !=25 ){
                        point_s3_t1[0]++;
                        s3_t1.setText(""+ point_s3_t1[0]);
                    }
                    else if(point_s4_t1[0] <= 24 && ( point_s3_t1[0] == 25 || point_s3_t2[0] == 25) && point_s4_t2[0] !=25 ){
                        point_s4_t1[0]++;
                        s4_t1.setText(""+ point_s4_t1[0]);
                    }
                }
            }
        });

        //time out, perdant pour equipe selectionee
        time_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = (String) getIntent().getSerializableExtra("string");
                String service_equipe = switch_service.getSelectedItem().toString();

                if (service_equipe == txt)
                {
                    if (point_s1_t2[0] <= 24 && ( point_s1_t1[0] != 25 ) ){
                        point_s1_t2[0]++;
                        s1_t2.setText(""+ point_s1_t2[0]);
                    }
                    else if(point_s2_t2[0] <= 24 && ( point_s1_t1[0] ==25 || point_s1_t2[0] == 25) && point_s2_t1[0] !=25 ){
                        point_s2_t2[0]++;
                        s2_t2.setText(""+ point_s2_t2[0]);
                    }
                    else if(point_s3_t2[0] <= 24 && ( point_s2_t1[0] ==25 || point_s2_t2[0] == 25) && point_s3_t1[0] !=25 ){
                        point_s3_t2[0]++;
                        s3_t2.setText(""+ point_s3_t2[0]);
                    }
                    else if(point_s4_t2[0] <= 24 && ( point_s3_t1[0] ==25 || point_s3_t2[0] == 25) && point_s4_t1[0] !=25 ){
                        point_s4_t2[0]++;
                        s4_t2.setText(""+ point_s4_t2[0]);
                    }
                }
                else
                {
                    if (point_s1_t1[0] <= 24 && ( point_s1_t1[0] != 25 ) ) {
                        point_s1_t1[0]++;
                        s1_t1.setText(""+ point_s1_t1[0]);
                    }
                    else if(point_s2_t1[0] <= 24 && ( point_s1_t1[0] == 25 || point_s1_t2[0] == 25) && point_s2_t2[0] !=25){
                        point_s2_t1[0]++;
                        s2_t1.setText(""+ point_s2_t1[0]);
                    }
                    else if(point_s3_t1[0] <= 24 && ( point_s2_t1[0] == 25 || point_s2_t2[0] == 25) && point_s3_t2[0] !=25 ){
                        point_s3_t1[0]++;
                        s3_t1.setText(""+ point_s3_t1[0]);
                    }
                    else if(point_s4_t1[0] <= 24 && ( point_s3_t1[0] == 25 || point_s3_t2[0] == 25) && point_s4_t2[0] !=25 ){
                        point_s4_t1[0]++;
                        s4_t1.setText(""+ point_s4_t1[0]);
                    }
                }
            }
        });

        //limit, perdant pour equipe selectionee
        limit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = (String) getIntent().getSerializableExtra("string");
                String service_equipe = switch_service.getSelectedItem().toString();

                if (service_equipe == txt)
                {
                    if (point_s1_t2[0] <= 24 && ( point_s1_t1[0] != 25 ) ){
                        point_s1_t2[0]++;
                        s1_t2.setText(""+ point_s1_t2[0]);
                    }
                    else if(point_s2_t2[0] <= 24 && ( point_s1_t1[0] ==25 || point_s1_t2[0] == 25) && point_s2_t1[0] !=25 ){
                        point_s2_t2[0]++;
                        s2_t2.setText(""+ point_s2_t2[0]);
                    }
                    else if(point_s3_t2[0] <= 24 && ( point_s2_t1[0] ==25 || point_s2_t2[0] == 25) && point_s3_t1[0] !=25 ){
                        point_s3_t2[0]++;
                        s3_t2.setText(""+ point_s3_t2[0]);
                    }
                    else if(point_s4_t2[0] <= 24 && ( point_s3_t1[0] ==25 || point_s3_t2[0] == 25) && point_s4_t1[0] !=25 ){
                        point_s4_t2[0]++;
                        s4_t2.setText(""+ point_s4_t2[0]);
                    }
                }
                else
                {
                    if (point_s1_t1[0] <= 24 && ( point_s1_t1[0] != 25 ) ) {
                        point_s1_t1[0]++;
                        s1_t1.setText(""+ point_s1_t1[0]);
                    }
                    else if(point_s2_t1[0] <= 24 && ( point_s1_t1[0] == 25 || point_s1_t2[0] == 25) && point_s2_t2[0] !=25){
                        point_s2_t1[0]++;
                        s2_t1.setText(""+ point_s2_t1[0]);
                    }
                    else if(point_s3_t1[0] <= 24 && ( point_s2_t1[0] == 25 || point_s2_t2[0] == 25) && point_s3_t2[0] !=25 ){
                        point_s3_t1[0]++;
                        s3_t1.setText(""+ point_s3_t1[0]);
                    }
                    else if(point_s4_t1[0] <= 24 && ( point_s3_t1[0] == 25 || point_s3_t2[0] == 25) && point_s4_t2[0] !=25 ){
                        point_s4_t1[0]++;
                        s4_t1.setText(""+ point_s4_t1[0]);
                    }
                }
            }
        });

        //out, perdant pour equipe selectionee
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = (String) getIntent().getSerializableExtra("string");
                String service_equipe = switch_service.getSelectedItem().toString();

                if (service_equipe == txt)
                {
                    if (point_s1_t2[0] <= 24 && ( point_s1_t1[0] != 25 ) ){
                        point_s1_t2[0]++;
                        s1_t2.setText(""+ point_s1_t2[0]);
                    }
                    else if(point_s2_t2[0] <= 24 && ( point_s1_t1[0] ==25 || point_s1_t2[0] == 25) && point_s2_t1[0] !=25 ){
                        point_s2_t2[0]++;
                        s2_t2.setText(""+ point_s2_t2[0]);
                    }
                    else if(point_s3_t2[0] <= 24 && ( point_s2_t1[0] ==25 || point_s2_t2[0] == 25) && point_s3_t1[0] !=25 ){
                        point_s3_t2[0]++;
                        s3_t2.setText(""+ point_s3_t2[0]);
                    }
                    else if(point_s4_t2[0] <= 24 && ( point_s3_t1[0] ==25 || point_s3_t2[0] == 25) && point_s4_t1[0] !=25 ){
                        point_s4_t2[0]++;
                        s4_t2.setText(""+ point_s4_t2[0]);
                    }
                }
                else
                {
                    if (point_s1_t1[0] <= 24 && ( point_s1_t1[0] != 25 ) ) {
                        point_s1_t1[0]++;
                        s1_t1.setText(""+ point_s1_t1[0]);
                    }
                    else if(point_s2_t1[0] <= 24 && ( point_s1_t1[0] == 25 || point_s1_t2[0] == 25) && point_s2_t2[0] !=25){
                        point_s2_t1[0]++;
                        s2_t1.setText(""+ point_s2_t1[0]);
                    }
                    else if(point_s3_t1[0] <= 24 && ( point_s2_t1[0] == 25 || point_s2_t2[0] == 25) && point_s3_t2[0] !=25 ){
                        point_s3_t1[0]++;
                        s3_t1.setText(""+ point_s3_t1[0]);
                    }
                    else if(point_s4_t1[0] <= 24 && ( point_s3_t1[0] == 25 || point_s3_t2[0] == 25) && point_s4_t2[0] !=25 ){
                        point_s4_t1[0]++;
                        s4_t1.setText(""+ point_s4_t1[0]);
                    }
                }
            }
        });

        // Gagnant pour equipe 1
        smash_t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (point_s1_t1[0] <= 24 && (point_s1_t2[0] != 25)) {
                    point_s1_t1[0]++;
                    s1_t1.setText("" + point_s1_t1[0]);
                }
                else if (point_s2_t1[0] <= 24 && (point_s1_t1[0] == 25 || point_s1_t2[0] == 25) && point_s2_t2[0] != 25) {
                    point_s2_t1[0]++;
                    s2_t1.setText("" + point_s2_t1[0]);
                }
                else if (point_s3_t1[0] <= 24 && (point_s2_t1[0] == 25 || point_s2_t2[0] == 25) && point_s3_t2[0] != 25) {
                    point_s3_t1[0]++;
                    s3_t1.setText("" + point_s3_t1[0]);
                }
                else if (point_s4_t1[0] <= 24 && (point_s3_t1[0] == 25 || point_s3_t2[0] == 25) && point_s4_t2[0] != 25) {
                    point_s4_t1[0]++;
                    s4_t1.setText("" + point_s4_t1[0]);
                }
            }
        });

        // Gagnant pour equipe 2
        smash_t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (point_s1_t2[0] <= 24 && ( point_s1_t1[0] != 25 ) ) {
                    point_s1_t2[0]++;
                    s1_t2.setText(""+ point_s1_t2[0]);
                }
                else if(point_s2_t2[0] <= 24 && ( point_s1_t1[0] == 25 || point_s1_t2[0] == 25) && point_s2_t1[0] !=25){
                    point_s2_t2[0]++;
                    s2_t2.setText(""+ point_s2_t2[0]);
                }
                else if(point_s3_t2[0] <= 24 && ( point_s2_t1[0] == 25 || point_s2_t2[0] == 25) && point_s3_t1[0] !=25 ){
                    point_s3_t2[0]++;
                    s3_t2.setText(""+ point_s3_t2[0]);
                }
                else if(point_s4_t2[0] <= 24 && ( point_s3_t1[0] == 25 || point_s3_t2[0] == 25) && point_s4_t1[0] !=25 ){
                    point_s4_t2[0]++;
                    s4_t2.setText(""+ point_s4_t2[0]);
                }
            }

        });

        // Gagnant pour equipe 1 (pt classique)
        class_t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (point_s1_t1[0] <= 24 && (point_s1_t2[0] != 25)) {
                    point_s1_t1[0]++;
                    s1_t1.setText("" + point_s1_t1[0]);
                }
                else if (point_s2_t1[0] <= 24 && (point_s1_t1[0] == 25 || point_s1_t2[0] == 25) && point_s2_t2[0] != 25) {
                    point_s2_t1[0]++;
                    s2_t1.setText("" + point_s2_t1[0]);
                }
                else if (point_s3_t1[0] <= 24 && (point_s2_t1[0] == 25 || point_s2_t2[0] == 25) && point_s3_t2[0] != 25) {
                    point_s3_t1[0]++;
                    s3_t1.setText("" + point_s3_t1[0]);
                }
                else if (point_s4_t1[0] <= 24 && (point_s3_t1[0] == 25 || point_s3_t2[0] == 25) && point_s4_t2[0] != 25) {
                    point_s4_t1[0]++;
                    s4_t1.setText("" + point_s4_t1[0]);
                }
            }
        });

        // Gagnant pour equipe 2 (pt classique)
        class_t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (point_s1_t2[0] <= 24 && ( point_s1_t1[0] != 25 ) ) {
                    point_s1_t2[0]++;
                    s1_t2.setText(""+ point_s1_t2[0]);
                }
                else if(point_s2_t2[0] <= 24 && ( point_s1_t1[0] == 25 || point_s1_t2[0] == 25) && point_s2_t1[0] !=25){
                    point_s2_t2[0]++;
                    s2_t2.setText(""+ point_s2_t2[0]);
                }
                else if(point_s3_t2[0] <= 24 && ( point_s2_t1[0] == 25 || point_s2_t2[0] == 25) && point_s3_t1[0] !=25 ){
                    point_s3_t2[0]++;
                    s3_t2.setText(""+ point_s3_t2[0]);
                }
                else if(point_s4_t2[0] <= 24 && ( point_s3_t1[0] == 25 || point_s3_t2[0] == 25) && point_s4_t1[0] !=25 ){
                    point_s4_t2[0]++;
                    s4_t2.setText(""+ point_s4_t2[0]);
                }
            }

        });

        // Gagnant pour equipe 2, equipe 1 fait la faute
        faute_t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (point_s1_t2[0] <= 24 && ( point_s1_t1[0] != 25 ) ) {
                    point_s1_t2[0]++;
                    s1_t2.setText(""+ point_s1_t2[0]);
                }
                else if(point_s2_t2[0] <= 24 && ( point_s1_t1[0] == 25 || point_s1_t2[0] == 25) && point_s2_t1[0] !=25){
                    point_s2_t2[0]++;
                    s2_t2.setText(""+ point_s2_t2[0]);
                }
                else if(point_s3_t2[0] <= 24 && ( point_s2_t1[0] == 25 || point_s2_t2[0] == 25) && point_s3_t1[0] !=25 ){
                    point_s3_t2[0]++;
                    s3_t2.setText(""+ point_s3_t2[0]);
                }
                else if(point_s4_t2[0] <= 24 && ( point_s3_t1[0] == 25 || point_s3_t2[0] == 25) && point_s4_t1[0] !=25 ){
                    point_s4_t2[0]++;
                    s4_t2.setText(""+ point_s4_t2[0]);
                }
            }
        });

        // Gagnant pour equipe 1, equipe 2 fait la faute
        faute_t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (point_s1_t1[0] <= 24 && (point_s1_t2[0] != 25)) {
                    point_s1_t1[0]++;
                    s1_t1.setText("" + point_s1_t1[0]);
                }
                else if (point_s2_t1[0] <= 24 && (point_s1_t1[0] == 25 || point_s1_t2[0] == 25) && point_s2_t2[0] != 25) {
                    point_s2_t1[0]++;
                    s2_t1.setText("" + point_s2_t1[0]);
                }
                else if (point_s3_t1[0] <= 24 && (point_s2_t1[0] == 25 || point_s2_t2[0] == 25) && point_s3_t2[0] != 25) {
                    point_s3_t1[0]++;
                    s3_t1.setText("" + point_s3_t1[0]);
                }
                else if (point_s4_t1[0] <= 24 && (point_s3_t1[0] == 25 || point_s3_t2[0] == 25) && point_s4_t2[0] != 25) {
                    point_s4_t1[0]++;
                    s4_t1.setText("" + point_s4_t1[0]);
                }
            }
        });

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // verifier que 3 set gagné par la mme equipe, sinon erreur
                //(ici pas prise en compte du 5eme set, trop complique)
                // Il faut rajouter des compteur dans le compatge de points pour pouvoir stocké les donnees
                //Entrer toutes les stat dans la base de donnees
                // Remttre à O le score
            }
        });



    } // fin OnCreate

}
