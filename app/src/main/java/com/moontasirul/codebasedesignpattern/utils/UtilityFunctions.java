package com.moontasirul.codebasedesignpattern.utils;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.moontasirul.codebasedesignpattern.R;
import com.moontasirul.codebasedesignpattern.ui.base_ui.LauncherActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by moontasirul on 9/18/2017.
 */

public class UtilityFunctions {

    private static ProgressDialog progressDialog;
    /**
     * status bar transparent
     * @param activity
     */


    public static void setStatusBarTransparent(FragmentActivity activity, boolean isTransparent){
        if(activity == null){
            return;
        }
//        Window window = activity.getWindow();
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
//


        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (isTransparent) {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.setStatusBarColor(activity.getResources().getColor(R.color.colorPrimaryDark));
            }
        }

    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static void noInternetDialogBox(final Context context) {

        AlertDialog.Builder builder = getAlertDialogBuilder(context,
                context.getString(R.string.internet_connection_title),
                context.getString(R.string.no_inernet_dailog));
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                loggOut((FragmentActivity) context);
                Intent gpsIntent = new Intent(Settings.ACTION_SETTINGS);
                context.startActivity(gpsIntent);
            }
        });
        builder.create();
        builder.show();

    }
    public static AlertDialog.Builder getAlertDialogBuilder(Context context, String title, String message) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(false);
        return builder;
    }

    public static AlertDialog.Builder getAlertBuilder(Context context, String title, String msg) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setMessage(msg);
        builder.setCancelable(false);
        return builder;
    }


    public static void showProgressBar(final FragmentActivity aActivity) {

        try {
            if (progressDialog != null || aActivity == null) {
                return;
            }

            progressDialog = new ProgressDialog(aActivity);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("Connecting");
            progressDialog.setCancelable(false);
            progressDialog.show();


        } catch (Exception ex) {

        }

    }


    public static void stopProgressBar(final FragmentActivity aActivity) {
        try {

            if (progressDialog != null) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        } catch (Exception ex) {

        }
    }



    @SuppressLint("MissingPermission")
    public static String getDeviceId(Context context) {
        if (context == null) {
            return "";
        }

        boolean isTelephonyService = false;
        PackageManager packageManager = context.getPackageManager();
        // Check the Package Manager isn't exists
        if (packageManager != null) {
            isTelephonyService = packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY);
        }
        // Check it has Telephony Service
        if (isTelephonyService) {
            // Get the IMEI number
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                return  telephonyManager.getImei();
            } else {
                return  telephonyManager.getDeviceId();
            }
        } else {
            // Get the MAC Address
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            return "MAC Address: " + wifiManager.getConnectionInfo().getMacAddress();
        }

    }



    public static void changedFragment(FragmentActivity activity, Fragment fragment, boolean isAddToBackStack) {
        if (activity == null || fragment == null) {
            return;
        }
        FragmentTransaction transaction = activity.getSupportFragmentManager()
                .beginTransaction();
        if (isAddToBackStack) {
            transaction.addToBackStack(null);
            Log.i("changeFragment", "Granted");
        }
        transaction.replace(R.id.container, fragment, Constant.CURRENT_FRAGMENT);
        transaction.commitAllowingStateLoss();
        activity.getSupportFragmentManager().executePendingTransactions();
    }



    public static void changedFragment(FragmentActivity activity, Fragment fragment, boolean isAddToBackStack, Bundle bundle) {
        if (activity == null || fragment == null) {
            return;
        }
        FragmentTransaction transaction = activity.getSupportFragmentManager()
                .beginTransaction();
        if (isAddToBackStack) {
            transaction.addToBackStack(null);
            Log.i("changeFragment", "Granted");
        }
        transaction.replace(R.id.container, fragment, Constant.CURRENT_FRAGMENT);
        transaction.commitAllowingStateLoss();
        activity.getSupportFragmentManager().executePendingTransactions();
    }


    /**
     * Invoke to back in previous fragment
     *
     * @return true|false
     */
    public static void popFragment(FragmentActivity activity) {
        if (activity != null) {
            Log.e("getBackStackEntryCount ", "getBackStackEntryCount: "
                    + activity.getSupportFragmentManager().getBackStackEntryCount());
            if (activity.getSupportFragmentManager().getBackStackEntryCount() > 0) {
                activity.getSupportFragmentManager().popBackStack();
            }
        }
    }


    /**
     * invoke to hide keyboard
     *
     * @param activity
     */
    public static void hideVirtualKeyboard(FragmentActivity activity) {
        if (activity == null) {
            return;
        }

        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(null == activity
                .getCurrentFocus() ? null : activity.getCurrentFocus()
                .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }


    public static void showSoftKeyboard(FragmentActivity activity, View view) {
        if (activity == null || view == null) {
            return;
        }

        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager)
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }


    /**
     * check the user name is alpha uumaric or not
     * @param aString
     * @return
     */
    public static boolean isAlphaNumeric(String aString) {
        String reges = "[A-Za-z0-9]+";
        return aString.matches(reges);
    }



    /**
     * Invoke to validate user name
     *
     * @param userName
     * @return
     */
    public static boolean isUserNameValid(String userName) {
        return isAlphaNumeric(userName) && userName.length() <= 20;
    }



    /**
     * This method will check the phone number is valid or invalid.
     *
     * @param phoneNo (It will get string)
     * @return true or false
     */
    public static boolean isPhoneNumberValid(String phoneNo) {
        if (TextUtils.isEmpty(phoneNo)) {
            return false;
        }
        return Patterns.PHONE.matcher(phoneNo).matches();
    }



    /**
     * This method will check the is valid or invalid.
     *
     * @param email (It will get string)
     * @return true or false
     */
    public static boolean isEmailValid(String email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }






    /**
     * Invoke to validate customer password
     *
     * @param password(customer password)
     * @return true|false
     */
    public static boolean isPasswordValid(String password) {
        return isAlphaNumeric(password)
                && (password.length() > 5 && password.length() < 13);
    }



    /**
     * Invoke to convert date format
     *
     * @param date
     * @return
     */
    public static String getDuration(String date) {
        if (date == null) {
            return "";
        }
        String[] duration = date.split(" ");
        if (duration.length < 2) return "";
        return duration[0] + " " + get12HoursFormat(duration[1]);
    }

    /**
     * Invoke to convert time 24 hours to 12 hour format
     *
     * @param time string
     * @return
     */
    private static String get12HoursFormat(String time) {
        if (time == null) {
            return "";
        }
        String[] t = time.split(":");
        if (t.length < 3) return "";
        int h = Integer.parseInt(t[0]);
        String amPm = "";
        if (h == 0) {
            h = 12;
            amPm = " am";
        } else if (h == 12) {
            amPm = " pm";
        } else if (h > 12) {
            h = h - 12;
            amPm = " pm";
        } else {
            amPm = " am";
        }
        return h + ":" + t[1]  + amPm;
    }

    /**
     * Invoke to convert date format
     */
    public static String parseDateToddMMyyyy(String time) {
        String inputPattern = "yyyy-MM-dd HH:mm:ss";
        String outputPattern = "dd-MMM-yyyy h:mm a";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }




    /**
     * Invoke for go to login screen
     *
     * @param activity
     */
    public static void loggOut(FragmentActivity activity) {
        if (activity == null) return;
        Intent intent = new Intent(activity, LauncherActivity.class);
        intent.putExtra(Constant.BUNDLE_KEY_LOGOUT, true);
        activity.startActivity(intent);
        activity.finish();
    }

    /**
     * Invoke to make phone call
     *
     * @param number telephone or cell phone number
     */
    public static void makeCall(FragmentActivity activity, String number) {
        if (activity == null || number == null || TextUtils.isEmpty(number)) {
            return;
        }
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(Constant.TEL + number.trim()));
        activity.startActivity(Intent.createChooser(callIntent, ""));
    }





}
