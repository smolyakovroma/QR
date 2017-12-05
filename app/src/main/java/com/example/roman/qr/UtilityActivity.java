package com.example.roman.qr;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by Roman on 05.12.2017.
 */

public class UtilityActivity {
    public static void displayAlertDialogMessage(Activity activity, String message, DialogInterface.OnClickListener listener){
        new AlertDialog.Builder(activity)
                .setMessage(message)
                .setPositiveButton("OK", listener)
                .setNegativeButton("Cancel", null)
                .show();
    }
}
