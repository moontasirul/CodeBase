package com.moontasirul.codebasedesignpattern.utils;

import android.content.Context;
import android.os.Build;

import androidx.appcompat.app.AlertDialog;


/**
 * Created by moontasirul on 28-Sep-17.
 */

public class DialogUtil {

    public static String numberOfRelay;

    public static AlertDialog.Builder getAlertDialogBuilder(Context context, String title, String message) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        return builder;
    }



}
