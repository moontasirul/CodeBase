package com.moontasirul.codebasedesignpattern.ui.base_ui;

/**
 * This a handle class for tool bar and other related items.
 * Created by moontasirul on 10/10/2017.
 *
 * @author Atom AP Ltd.
 */

public interface IControlWindowBar {

    void showToolBar();
    void hideToolBar();
    void setTitleText(String title);

    void showBackArrow();
    void hideBackArrow();

//    void showDrawerBar();
//
//    void hideDrawerBar();
}
