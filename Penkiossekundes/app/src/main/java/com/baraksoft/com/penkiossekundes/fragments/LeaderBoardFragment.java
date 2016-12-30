package com.baraksoft.com.penkiossekundes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.baraksoft.com.penkiossekundes.R;

import java.util.Map;

/**
 * @author Laurynas
 * @since 2016-12-29
 */
public class LeaderBoardFragment extends Fragment {

    private Map<String, Integer> gameResults;

    public LeaderBoardFragment() {
        setArguments(new Bundle());
    }

    public void setGameResults(Map<String, Integer> gameResults) {
        this.gameResults = gameResults;
    }

    @Override
    public void onAttach(Context context) {
        String scorer = getArguments().getString("scorer");
        if (scorer != null) {
            Integer score = gameResults.get(scorer);
            gameResults.put(scorer, score + 1);
        }
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.leaderboard, container, false);

        TableLayout tl = (TableLayout) view.findViewById(R.id.resultsTable);

        for (Map.Entry<String,Integer> entry : gameResults.entrySet()) {
            buildTableRows(tl, entry);
        }

        return view;
    }

    private void buildTableRows(TableLayout tl, Map.Entry<String, Integer> entry) {
        TableRow rowName = new TableRow(getContext());
        rowName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        TextView playerResult = new TextView(getContext());
        playerResult.setText(entry.getKey());
        playerResult.setTextColor(ContextCompat.getColor(getContext(), R.color.green));

        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        // TODO: 2016-12-30 eilutes layoutas
        playerResult.setLayoutParams(params);

        rowName.addView(playerResult);
        tl.addView(rowName, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

        TableRow rowResult = new TableRow(getContext());
        rowResult.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        TextView playerResult2 = new TextView(getContext());
        playerResult2.setText(String.valueOf(entry.getValue()));
        playerResult2.setTextColor(ContextCompat.getColor(getContext(), R.color.red));

        TableRow.LayoutParams params2 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        // TODO: 2016-12-30 eilutes layoutas
        playerResult.setLayoutParams(params2);

        rowResult.addView(playerResult2);
        tl.addView(rowResult, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
    }
}
