package com.moontasirul.codebasedesignpattern.ui.base_ui;


import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.moontasirul.codebasedesignpattern.R;
import com.moontasirul.codebasedesignpattern.utils.UtilityFunctions;


/**
 * This a Base fragment class, which is extends  in all fragment class for set toolbar and some basic
 * behaviors in UI
 * Created by moontasirul on 22-Sep-17.
 *
 * @author Atom AP Ltd.
 */

public class BaseFragment extends Fragment {
    private ProgressBar progressBar;
    private RelativeLayout progressLayout;
    private Toolbar mToolbar;


    public BaseFragment() {

    }


    protected void setProgressBar(View view) {
        progressLayout = (RelativeLayout) view.findViewById(R.id.progress_layout);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        progressBar.setIndeterminate(false);
    }


    /**
     * Invoke to back in previous fragment
     *
     * @return true|false
     */
    public boolean popFragment() {
        boolean isPop = false;
        if (getActivity() != null) {
            UtilityFunctions.hideVirtualKeyboard(getActivity());
            Log.e("getBackStackEntryCount ", "getBackStackEntryCount: "
                    + getActivity().getSupportFragmentManager().getBackStackEntryCount());
            if (getActivity().getSupportFragmentManager().getBackStackEntryCount() > 0) {
                isPop = true;
                getActivity().getSupportFragmentManager().popBackStack();
            }
        }
        return isPop;
    }

    /**
     * Invoke to back parent fragment
     */
    public void popBackToParentFragment() {
        if (getActivity() != null) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            int count = fm.getBackStackEntryCount();
            Log.e("getBackStackEntryCount ", "getBackStackEntryCount: " + count);
            for (int i = 0; i < count - 2; ++i) {
                fm.popBackStack();
            }
        }
    }

    /**
     * Invoke to back parent fragment
     */
    public void popBackToFragment() {
        if (getActivity() != null) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            int count = fm.getBackStackEntryCount();
            Log.e("getBackStackEntryCount ", "getBackStackEntryCount: " + count);
            for (int i = 0; i < count - 1; ++i) {
                fm.popBackStack();
            }
        }
    }

    public void returnToMainMenu(Fragment returnFragment) {
        UtilityFunctions.changedFragment(getActivity(), returnFragment, false);
    }



    public void showProgressBar() {
        progressLayout.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);

    }

    public void hideProgressBar() {
        progressLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }





    /**
     * Invoke to controlling visibility of ActionBar (Toolbar)
     * If @isShow is true ActionBar is visible
     * Else ActionBar is Gone
     *
     * @param isShow true| false
     */
    protected void controlledToolbar(boolean isShow, IControlWindowBar windowBar) {
        if (windowBar == null) {
            return;
        }

        if (isShow) {
            windowBar.showToolBar();
        } else {
            windowBar.hideToolBar();
        }
    }

    protected void setTitleText(String title, IControlWindowBar windowBar) {
        if (windowBar == null && title == null) {
            return;
        }
        windowBar.setTitleText(title);
    }

    protected void setBackArrow(boolean isShow,IControlWindowBar windowBar){
        if(windowBar == null){
            return;
        }
        if(isShow) {
            windowBar.showBackArrow();
        }else {
            windowBar.hideBackArrow();
        }
    }


    /**
     * @param view
     * @param activity
     */
    protected void hideSoftKeyboardByTouchingOutSideEditField(View view, final FragmentActivity activity) {

        if (view == null || activity == null) {
            return;
        }
        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    UtilityFunctions.hideVirtualKeyboard(activity);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                hideSoftKeyboardByTouchingOutSideEditField(innerView, activity);
            }
        }
    }

//    /**
//     * Invoke to controlling visibility of BottomNavigationBar
//     * If @isShow is true BottomNavBar is visible
//     * Else BottomNavBar is Gone
//     *
//     * @param isShow true| false
//     */
//    protected void controlledNavigationDrawer(boolean isShow) {
//        if (getActivity() == null) {
//            return;
//        }
//
//        if (isShow) {
//            ((IControlWindowBar) getActivity()).showDrawerBar();
//        } else {
//            ((IControlWindowBar) getActivity()).hideDrawerBar();
//        }
//    }

}
