package com.baraksoft.com.penkiossekundes.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baraksoft.com.penkiossekundes.R;
import com.baraksoft.com.penkiossekundes.activities.MainMenuActivity;
import com.baraksoft.com.penkiossekundes.utils.FragmentUtils;

/**
 * @author Laurynas
 * @since 2016-12-20
 */
public class MainMenuFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer mp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mp = MediaPlayer.create(getContext(), R.raw.click_sound2);
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        ((MainMenuActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        view.findViewById(R.id.btNewGame).setOnClickListener(this);
        view.findViewById(R.id.btAbout).setOnClickListener(this);
        view.findViewById(R.id.btRules).setOnClickListener(this);
        view.findViewById(R.id.btSettings).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        mp.start();
        switch (view.getId()) {
            case R.id.btNewGame:
                FragmentUtils.change(new TeamCreationFragment(), getFragmentManager(), R.id.main_frame_container);
//                Intent intent = new Intent(getActivity(), TeamCreationActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivity(intent);
//                getActivity().finish();
                break;
            case R.id.btAbout:
                FragmentUtils.change(new AboutFragment(), getFragmentManager(), R.id.main_frame_container);
                break;
            case R.id.btRules:
                FragmentUtils.change(new RulesFragment(), getFragmentManager(), R.id.main_frame_container);
                break;
            case R.id.btSettings:
                FragmentUtils.change(new SettingsFragment(), getFragmentManager(), R.id.main_frame_container);
        }
    }
}
