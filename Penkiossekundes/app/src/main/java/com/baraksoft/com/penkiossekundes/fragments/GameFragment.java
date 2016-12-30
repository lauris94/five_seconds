package com.baraksoft.com.penkiossekundes.fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.baraksoft.com.penkiossekundes.R;
import com.baraksoft.com.penkiossekundes.activities.MainMenuActivity;
import com.baraksoft.com.penkiossekundes.services.QuestionsService;
import com.baraksoft.com.penkiossekundes.utils.ActivityUtils;
import com.baraksoft.com.penkiossekundes.views.BaseAlertDialog;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

/**
 * @author Laurynas
 * @since 2016-12-29
 */
public class GameFragment extends Fragment implements View.OnClickListener {

    OnAddPointsListener callback;

    public interface OnAddPointsListener {
        void onPointsScored(String name);
    }

    private Button btStartTime;
    private TextView timeLeft;
    private QuestionsService questionsService;
    private TextView questioner;
    private TextView question;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.questions_fragment, container, false);

        try {
            callback = (OnAddPointsListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnAddPointsListener");
        }

        //actionBar button
        getActivity().findViewById(R.id.btEndGame).setOnClickListener(this);

        btStartTime = (Button) view.findViewById(R.id.btStartTime);
        timeLeft = (TextView) view.findViewById(R.id.timeLeft);
        questioner = (TextView) view.findViewById(R.id.questioner);
        question = (TextView) view.findViewById(R.id.question);

        btStartTime.setOnClickListener(this);
        timeLeft.setVisibility(View.INVISIBLE);

        questionsService = new QuestionsService(getResources().getStringArray(R.array.temp_questions_array), getString(R.string.questionStart), getString(R.string.questionerStart));
        questionsService.prepareQuestionFields(question, questioner);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btEndGame:
                showEndGameDialog();
                break;
            case R.id.btStartTime:
                handleStartTimeClick();
        }
    }

    private void showEndGameDialog() {
        new BaseAlertDialog() {
            @Override
            public void onYesClick(DialogInterface dialoginterface, int i) {
                ActivityUtils.changeActivity(getActivity(), MainMenuActivity.class, getContext());
            }
        }.build(getContext(), getString(R.string.endGameDialogTitle), getString(R.string.endGameDialogText), getString(R.string.no), getString(R.string.yes)).show();
    }

    private void handleStartTimeClick() {
        setVisibilityTimeStarted();
        new CountDownTimer(5000, 100) {
            public void onTick(long millisUntilFinished) {
                BigDecimal time = new BigDecimal(millisUntilFinished).divide(new BigDecimal(1000), 1, RoundingMode.DOWN);
                timeLeft.setText(String.format(Locale.US, "Liko %s sekundžių", time.toPlainString()));
            }

            public void onFinish() {
                new BaseAlertDialog() {
                    @Override
                    public void onYesClick(DialogInterface dialoginterface, int i) {
                        callback.onPointsScored(questionsService.getQuestionerName());
                        dialoginterface.cancel();
                    }
                }.build(getContext(), "Atsakymas", "Atsakyta?", getString(R.string.no), getString(R.string.yes)).show();

                setVisibilityTimeFinished();
                questionsService.prepareQuestionFields(question, questioner);
            }
        }.start();
    }

    private void setVisibilityTimeStarted() {
        btStartTime.setVisibility(View.INVISIBLE);
        timeLeft.setVisibility(View.VISIBLE);
    }

    private void setVisibilityTimeFinished() {
        btStartTime.setVisibility(View.VISIBLE);
        timeLeft.setVisibility(View.INVISIBLE);
    }
}
