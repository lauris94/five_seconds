package com.baraksoft.com.penkiossekundes.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.baraksoft.com.penkiossekundes.R;
import com.baraksoft.com.penkiossekundes.fragments.MainMenuFragment;
import com.baraksoft.com.penkiossekundes.views.BaseAlertDialog;

public class MainWindowActivity extends AppCompatActivity {

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getSupportActionBar();

        LayoutInflater inflater = (LayoutInflater) actionBar.getThemedContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View customActionBarView = inflater.inflate(R.layout.actionbar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT);

        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(customActionBarView, params);

        setContentView(R.layout.mainwindow);

        MainMenuFragment fragment = new MainMenuFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_containerone, fragment, "Mainas");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        BaseAlertDialog baseAlertDialog = new BaseAlertDialog() {
            @Override
            public void onNoClick(DialogInterface dialoginterface, int i) {
                dialoginterface.cancel();
            }

            @Override
            public void onYesClick(DialogInterface dialoginterface, int i) {
                finish();
            }
        };
        baseAlertDialog.create(this, "Išjungimas", "Ar tikrai norite išjungti programą", "Ne", "Taip").show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
