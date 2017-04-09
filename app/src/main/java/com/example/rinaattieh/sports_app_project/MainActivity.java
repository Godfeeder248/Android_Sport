package com.example.rinaattieh.sports_app_project;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* Pas utile
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Recup du nom de l'equipe pour l'afficher
        String txt = (String) getIntent().getSerializableExtra("string");
        TextView equipe = (TextView )findViewById(R.id.nom_equipe);
        equipe.setText("Equipe :  " + txt);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void changeLanguage_fr(MenuItem item){

        Configuration config = new Configuration();
        Locale locale;
        locale = new Locale("fr");
        config.locale =locale;
        getResources().updateConfiguration(config, null);
        startActivity(new Intent(getBaseContext(), Go.class));
    }

    public void changeLanguage_en(MenuItem item){

        Configuration config = new Configuration();
        config.locale = Locale.ENGLISH;
        getResources().updateConfiguration(config, null);
        startActivity(new Intent(getBaseContext(), Go.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /////////////////////////////////////////////////////// PHOTOS ////////////////////////////////////////////

    static final int REQUEST_IMAGE_CAPTURE = 1;
    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    //Ajouter la photo à la gallery pour la rendre accessible (a afficher)
    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
        //Probleme de chemin en commentaire dans le manifest
        // Autre methode : Apres avec creer la base de donnes avce SQLite, enregistrer les photos
        // directement, meme si pas recommandé
    }

    ////////////////////////////////////////////////////////// PHOTOS ////////////////////////////////////////////

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.new_match) {
            //recupère l'équipe selectionne au debut
            String txt = (String) getIntent().getSerializableExtra("string");
            Intent newAct = new Intent(getApplicationContext(), NewMatch.class);
            newAct.putExtra("string", txt);
            startActivity(newAct);

        } else if (id == R.id.stat) {
            //recupère l'équipe selectionne au debut
            String txt = (String) getIntent().getSerializableExtra("string");
            Intent newAct = new Intent(getApplicationContext(), Stat.class);
            newAct.putExtra("string", txt);
            startActivity(newAct);

            // Faire les requete pour affciher les stat dans les textview
            //COmment ??


        } else if (id == R.id.players) {
            Intent newAct = new Intent(getApplicationContext(), Players.class);
            startActivity(newAct);
            // A supprimer ou Mettre une phrase de renseignement dans le xml

        } else if (id == R.id.nav_camera) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            // Test pour voir si la camera marche, une foid le probleme de stckage de photo réglé
            // Enlever la ligne suivante et décommenter le reste
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

            /* A DECOMMENTER ENSUITE

            // Ensure that there's a camera activity to handle the intent
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                // Create the File where the photo should go
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException ex) {
                    // Error occurred while creating the File
                }
                // Continue only if the File was successfully created
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(this,
                            "com.example.android.fileprovider",
                            photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }*/

        } else if (id == R.id.nav_gallery) {
            //Requete pour afficher toutes les photos stockés, si possible les classer par date

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
