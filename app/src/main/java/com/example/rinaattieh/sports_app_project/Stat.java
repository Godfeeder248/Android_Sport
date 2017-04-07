package com.example.rinaattieh.sports_app_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Stat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        //Recupere le nom de l'equipe
        String team = (String) getIntent().getSerializableExtra("string");
        TextView nom_equipe_stat = (TextView )findViewById(R.id.nom_equipe_stat);
        nom_equipe_stat.setText("Equipe :  " + team);
    }
}
