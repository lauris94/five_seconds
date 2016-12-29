package com.baraksoft.com.penkiossekundes.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.baraksoft.com.penkiossekundes.R;
import com.baraksoft.com.penkiossekundes.fragments.GameFragment;
import com.baraksoft.com.penkiossekundes.fragments.LeaderBoardFragment;
import com.baraksoft.com.penkiossekundes.utils.ActivityUtils;
import com.baraksoft.com.penkiossekundes.utils.FragmentUtils;
import com.baraksoft.com.penkiossekundes.views.BaseAlertDialog;

/**
 * @author Laurynas
 * @since 2016-12-29
 */
public class GamePlayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();

        LayoutInflater inflater = (LayoutInflater) actionBar.getThemedContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View customActionBarView = inflater.inflate(R.layout.in_game_actionbar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT);

        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(customActionBarView, params);

        setContentView(R.layout.game_play);

        FragmentUtils.change(new GameFragment(), getSupportFragmentManager(), R.id.game_frame_container);
        FragmentUtils.change(new LeaderBoardFragment(), getSupportFragmentManager(), R.id.leaderboard_frame_container);
    }

    @Override
    public void onBackPressed() {
        BaseAlertDialog baseAlertDialog = new BaseAlertDialog() {
            @Override
            public void onYesClick(DialogInterface dialoginterface, int i) {
                ActivityUtils.changeActivity(GamePlayActivity.this, MainMenuActivity.class, GamePlayActivity.this);
            }
        };
        baseAlertDialog.build(this, getString(R.string.endGameDialogTitle), getString(R.string.endGameDialogText), getString(R.string.no), getString(R.string.yes)).show();
    }
}
