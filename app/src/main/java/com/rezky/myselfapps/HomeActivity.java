package com.rezky.myselfapps;

/*
 * NIM   : 10118016
 * NAMA  : Rezky Nur Fauzi
 * KELAS : IF1
 * TGL   : 29/05/2021
 * */

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //ass variable
        drawerLayout = findViewById(R.id.DrawerLayout);

    }
    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        // open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //close drawer

        // check
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }
    }

    public void ClickHome(View view){
        recreate();
    }

    public void ClickDaily(View view){
        //redirect to Daily
        redirectActivity(this,Daily.class);
    }

    public void ClickGallery(View view){
        //redirect to Gallery
        redirectActivity(this,Gallery.class);
    }

    public void ClickMusic(View view){
        //redirect to Gallery
        redirectActivity(this,Music.class);
    }
    public void ClickProfile(View view){
        //redirect to Gallery
        redirectActivity(this,Profile.class);
    }
    public void ClickLogout(View view){
        //redirect to Gallery
        logout(this);
    }

    public static void logout(final Activity activity) {
        //alert
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //set title
        builder.setTitle("Logout");
        //set message
        builder.setMessage("Yakin Keluar ?");

        //positive
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //FINISH
                activity.finishAffinity();
                //exit
                System.exit(0);
            }

        });
        //negative
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //dismiss dialog
                dialog.dismiss();

            }

        });
        //show dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        //intent
        Intent intent = new Intent(activity,aClass);

        //set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //close
        closeDrawer(drawerLayout);
    }
}