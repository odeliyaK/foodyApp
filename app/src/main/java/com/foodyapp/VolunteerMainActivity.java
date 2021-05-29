package com.foodyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VolunteerMainActivity extends AppCompatActivity implements organizationsAlertDialogFragmentListener {

    String items[] = new String[]{"Choose organization", "Manage Packages", "order food from supplier", "inventory management",
            "Packages history"};
    ListView volList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_main);

        ImageView toolBarArrow=findViewById(R.id.arrow);
        TextView toolBarTitle=findViewById(R.id.toolbar_title);
        ImageView rightIcon=findViewById(R.id.menu);

        toolBarArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });

//        volList =(ListView)findViewById(R.id.volunteerlistview);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
//        volList.setAdapter(adapter);
//        volList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //if "choose organization" was clicked
//                if (position==0){
//                    showCustomAlertDialog();
//                }
//                //if "Manage Orders" was clicked
//                else if(position==1){
//                    openOrdersActivity();
//                }
//                //if "order food from suppliers" was clicked
//                else if(position==2){
//                    openOrderFoodActivity();
//                }
//                //if "inventory management" was clicked
//                else if(position==3){
//                    openInventoryActivity();
//                }
//                ////if "Parcels history" was clicked
//                else if (position==4){
//                    openHistoryActivity();
//                }
//            }
//        });

    }
private void openMain(){
    Intent intent=new Intent(this, MainActivity.class);
    startActivity(intent);
}

    private void openHistoryActivity() {
        Intent intent=new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    private void showCustomAlertDialog() {
        OganizationDialogFragment frag = new OganizationDialogFragment();
        Bundle args = new Bundle();
        args.putInt("title", 1);
        frag.setArguments(args);
        frag.show(getFragmentManager(), "dialog");
    }

    @Override
    public void onDialogPositiveClick(OganizationDialogFragment dialog) {
//        String res= dialog.getFirstNameField() + " " + dialog.getLastNameField() + " " + dialog.getIdField() ;
//        Toast.makeText(this, "onDialogPositiveClick " + res,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDialogNegativeClick(OganizationDialogFragment dialog) {
        Toast.makeText(this, "onDialogNegativeClick " ,Toast.LENGTH_SHORT).show();
    }


    public void openOrdersActivity(){
        Intent intent=new Intent(this, UsersActivity.class);
        startActivity(intent);
    }

    public void openInventoryActivity(){
        Intent intent=new Intent(this, InventoryActivity.class);
        startActivity(intent);
    }

    public void openOrderFoodActivity(){
        Intent intent=new Intent(this, OrderActivity.class);
        startActivity(intent);
    }

    private void showMenu(View v){
        PopupMenu popupMenu=new PopupMenu(VolunteerMainActivity.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu_volunteer, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()== R.id.manage){
                    openOrdersActivity();
                }
                else if (item.getItemId()== R.id.orderFood){
                    openOrderFoodActivity();
                }
                else if (item.getItemId()== R.id.inventoryManagement){

                    openInventoryActivity();
                }
                else if (item.getItemId()== R.id.packageHistory){
                    openHistoryActivity();
                }
                return true;
            }
        });
        popupMenu.show();
    }
}