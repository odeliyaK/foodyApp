package com.foodyapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;

public class OrganizationActivity extends Activity  {

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);
        this.context=this;
    }

    public void showSimpleAlertDialog(View view) {

        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Are you confident in choosing the organization to volunteer for?");
        builder. setTitle("Confirmation of organization selection");


        // Add the buttons
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                openVolunteerActivity();

            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Toast.makeText(context, "User cancelled his choice",Toast.LENGTH_SHORT).show();

            }
        });

        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();

        dialog.show();
    }

    public void openVolunteerActivity(){
        Intent intent=new Intent(this, VolunteerMainActivity.class);
        startActivity(intent);
    }
}