package com.baraksoft.com.penkiossekundes.views;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by LaurynasC on 2016-12-20.
 */

public class BaseAlertDialog {

    public BaseAlertDialog() {

    }

    public AlertDialog.Builder create(Context context, String title, String message, String no, String yes) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title)
                .setMessage(message)
                .setNegativeButton(no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        dialoginterface.cancel();
                        onNoClick(dialoginterface, i);
                    }})
                .setPositiveButton(yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        onYesClick(dialoginterface, i);
                    }
                });
        return dialog;
    }

    public void onNoClick(DialogInterface dialoginterface, int i) {
        //stub
    }

    public void onYesClick(DialogInterface dialoginterface, int i) {
        //stub
    }


}
