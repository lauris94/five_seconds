package com.baraksoft.com.penkiossekundes.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baraksoft.com.penkiossekundes.R;
import com.baraksoft.com.penkiossekundes.activities.MainMenuActivity;

/**
 * @author Laurynas
 * @since 2016-12-28
 */
public class SettingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ActionBar actionBar = ((MainMenuActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        View view = inflater.inflate(R.layout.settings_fragment, container, false);
        return view;
    }
}
