package com.baraksoft.com.penkiossekundes.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.baraksoft.com.penkiossekundes.R;
import com.baraksoft.com.penkiossekundes.activities.MainWindowActivity;

/**
 * Created by LaurynasC on 2016-12-20.
 */

public class MainMenuFragment extends Fragment implements View.OnClickListener{

    Button newGame;
    Button load;
    Button rules;
    Button about;
    FragmentManager manager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ActionBar actionBar = ((MainWindowActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);

        View view = inflater.inflate(R.layout.main_fragment, container, false);
        manager = getFragmentManager();

        //newGame = (Button) view.findViewById(R.id.btNewGame);
        //rules = (Button) view.findViewById(R.id.btRules);
        //about = (Button) view.findViewById(R.id.btSettings);

        //newGame.setOnClickListener(this);
        //load.setOnClickListener(this);
        //rules.setOnClickListener(this);
        //about.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btNewGame:
//                Intent intent = new Intent(getActivity(), TeamCreationActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivity(intent);
//                getActivity().finish();
                break;
            case R.id.btSettings:
//                SettingsFragment settingsFragment = new SettingsFragment();
//                changeFragment(settingsFragment);
                break;
            case R.id.btRules:
//                RulesFragment2 rulesFragment = new RulesFragment2();
//                changeFragment(rulesFragment);
        }
    }

    private void changeFragment(Fragment fragment){
        FragmentTransaction transaction = manager.beginTransaction();
        //transaction.replace(R.id.output, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
