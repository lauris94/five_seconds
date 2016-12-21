package com.baraksoft.com.penkiossekundes.views;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * @author Laurynas
 * @since 2016-12-20
 */
public class BaseAlertDialog {

    public BaseAlertDialog() {
    }

    public AlertDialog.Builder build(Context context, String title, String message, String noButtonText, String yesButtonText) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title)
                .setMessage(message)
                .setNegativeButton(noButtonText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        onNoClick(dialoginterface, i);
                    }
                })
                .setPositiveButton(yesButtonText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        onYesClick(dialoginterface, i);
                    }
                });
        return dialog;
    }

    public void onNoClick(DialogInterface dialoginterface, int i) {
        dialoginterface.cancel();
    }

    public void onYesClick(DialogInterface dialoginterface, int i) {
        //stub
    }
}
