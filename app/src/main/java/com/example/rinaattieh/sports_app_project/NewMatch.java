package com.example.rinaattieh.sports_app_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewMatch extends AppCompatActivity {

    Button btn_map = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_match);


        btn_map = (Button) findViewById(R.id.btn_map);

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_map = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(int_map);
            }
        });
    }

}
