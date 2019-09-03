package com.moontasirul.codebasedesignpattern.data.remote;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import com.moontasirul.codebasedesignpattern.R;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.ApiError;

import java.io.IOException;
import java.net.SocketTimeoutException;

/**
 * Created by moontasirul on 2-April-18.
 * <p>
 * Updated by Moontasirul on 22-May-18
 */

public class ErrorHandler {


    /**
     * Invoke to get error message besd on the error code
     *
     * @param context
     * @param errorCode
     * @return
     */
    public static String getErrorMessage(Context context, int errorCode, String errorDescription) {
        String errorMsg = "";
        switch (errorCode) {
            case ErrorCode.ERROR_CODE_40003:
//                errorMsg = context.getString(R.string.error_code_10001);
                break;
            default:
                errorMsg = errorDescription;
        }
        return errorMsg;
    }

    /**
     * Invoke to get error message besd on the error code
     *
     * @param context
     * @param error   ApiError
     * @return
     */
    public static String getErrorMessage(Context context, ApiError error) {
        if (context == null) return "";
        String errorMsg = context.getString(R.string.label_text_unknown_error);
        if (error == null) {
            return errorMsg;
        }

        switch (error.getErrorCode()) {
            case ErrorCode.ERROR_CODE_40003:
                errorMsg = context.getString(R.string.error_code_40003);
                break;
            case ErrorCode.ERROR_CODE_40009:
                errorMsg = context.getString(R.string.error_code_40009);
                break;
            case ErrorCode.ERROR_CODE_40011:
                errorMsg = context.getString(R.string.error_code_40011);
                break;
            case ErrorCode.ERROR_CODE_40012:
                errorMsg = context.getString(R.string.error_code_40012);
                break;
            case ErrorCode.ERROR_CODE_40013:
                errorMsg = context.getString(R.string.error_code_40013);
                break;
            case ErrorCode.ERROR_CODE_40015:
                errorMsg = context.getString(R.string.error_code_40015);
                break;
            case ErrorCode.ERROR_CODE_40016:
                errorMsg = context.getString(R.string.error_code_40016);
                break;
            case ErrorCode.ERROR_CODE_40017:
                errorMsg = context.getString(R.string.error_code_40017);
                break;
            case ErrorCode.ERROR_CODE_40018:
                errorMsg = context.getString(R.string.error_code_40018);
                break;
            case ErrorCode.ERROR_CODE_40019:
                errorMsg = context.getString(R.string.error_code_40019);
                break;
            case ErrorCode.ERROR_CODE_40020:
                errorMsg = context.getString(R.string.error_code_40020);
                break;
            case ErrorCode.ERROR_CODE_40021:
                errorMsg = context.getString(R.string.error_code_40021);
                break;
            case ErrorCode.ERROR_CODE_40022:
                errorMsg = context.getString(R.string.error_code_40022);
                break;
            case ErrorCode.ERROR_CODE_40023:
                errorMsg = context.getString(R.string.error_code_40023);
                break;
            case ErrorCode.ERROR_CODE_40024:
                errorMsg = context.getString(R.string.error_code_40024);
                break;
            case ErrorCode.ERROR_CODE_40025:
                errorMsg = context.getString(R.string.error_code_40025);
                break;
            case ErrorCode.ERROR_CODE_40026:
                errorMsg = context.getString(R.string.error_code_40026);
                break;
            case ErrorCode.ERROR_CODE_60001:
                errorMsg = context.getString(R.string.error_code_60001);
                break;
            case ErrorCode.ERROR_CODE_60002:
                errorMsg = context.getString(R.string.error_code_60002);
                break;
            default:
                errorMsg = context.getString(R.string.label_text_unknown_error);
        }
        return errorMsg;
    }



    /**
     * Invoke to showing dialog for showing error message
     *
     * @param context
     * @param error
     */
    public static void showDialog(final FragmentActivity context, ApiError error) {

        if (context == null || error == null) {
            return;
        }
        final String errorMsg = getErrorMessage(context, error);
        Log.i("Error-MSG:", " " + errorMsg);

        View dialogView = LayoutInflater.from(context).inflate(R.layout.success_pop_up, null);
        TextView tvTitle = dialogView.findViewById(R.id.tv_title);
        TextView tvShowError = dialogView.findViewById(R.id.tv_show_error);
        TextView btnOk = dialogView.findViewById(R.id.btn_error_ok);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final Dialog errorDialog = builder.setView(dialogView).create();

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(errorDialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        tvTitle.setText(R.string.label_text_error);
        tvShowError.setText(errorMsg);
        errorDialog.setCancelable(false);
        errorDialog.getWindow().setAttributes(params);
        btnOk.setOnClickListener(v -> {
//            if (error.getErrorCode() == ErrorCode.ERROR_CODE_40003) {
//                DataManager.getInstance().removeUserInfo();
//                UtilityFunctions.changedFragment(context, new LoginFragment(), false);
//            }
            errorDialog.dismiss();
        });
        errorDialog.show();

    }

    /**
     * Invoke to showing dialog for showing error message
     *
     * @param context
     * @param throwable
     */
    public static void showDialog(final FragmentActivity context, Throwable throwable) {

        if (context == null || throwable == null) {
            return;
        }
        String error = connectionError(context, throwable);
        Log.i("Error-MSG:", " " + error);

        View dialogView = LayoutInflater.from(context).inflate(R.layout.success_pop_up, null);
        TextView tvTitle = dialogView.findViewById(R.id.tv_title);
        TextView tvShowError = dialogView.findViewById(R.id.tv_show_error);
        TextView btnOk = dialogView.findViewById(R.id.btn_error_ok);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final Dialog errorDialog = builder.setView(dialogView).create();

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(errorDialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        tvTitle.setText(R.string.label_text_error);
        tvShowError.setText(error);
        errorDialog.setCancelable(false);
        errorDialog.getWindow().setAttributes(params);
        btnOk.setOnClickListener(v -> {
            errorDialog.dismiss();
        });
        errorDialog.show();

    }

    /**
     * Invoke to get connection error
     *
     * @param context
     * @param throwable
     * @return
     */
    public static String connectionError(final Context context, Throwable throwable) {
        String error = "";
        if (throwable instanceof IOException) {
            error = context.getString(R.string.label_text_no_internet_connection);
        } else if (throwable instanceof SocketTimeoutException) {
            error = context.getString(R.string.label_text_connection_time_out);
        } else {
            error = context.getString(R.string.label_text_unknown_error);
        }
        return error;
    }
}
