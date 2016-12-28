package com.baraksoft.com.penkiossekundes.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.baraksoft.com.penkiossekundes.R;
import com.baraksoft.com.penkiossekundes.fragments.MainMenuFragment;
import com.baraksoft.com.penkiossekundes.utils.FragmentUtils;
import com.baraksoft.com.penkiossekundes.views.BaseAlertDialog;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();

        LayoutInflater inflater = (LayoutInflater) actionBar.getThemedContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View customActionBarView = inflater.inflate(R.layout.actionbar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT);

        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(customActionBarView, params);

        setContentView(R.layout.mainwindow);

        FragmentUtils.changeWithBack(new MainMenuFragment(), getSupportFragmentManager(), R.id.main_frame_container);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();

        if (fm.getBackStackEntryCount() >= 1) {
            super.onBackPressed();
        } else {
            BaseAlertDialog baseAlertDialog = new BaseAlertDialog() {
                @Override
                public void onYesClick(DialogInterface dialoginterface, int i) {
                    finish();
                }
            };
            baseAlertDialog.build(this, "Išjungimas", "Ar tikrai norite išjungti programą?", "Ne", "Taip").show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
