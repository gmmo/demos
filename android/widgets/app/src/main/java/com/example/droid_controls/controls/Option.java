////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls.controls;

import java.util.ArrayList;

/**
 * Wrapper class to hold content for widgets
 */
public class Option {

    private String mTitle;
    private String mSubTitle;
    private ArrayList<String> mSubOptions;
    private OptionRowType mOptionRowType;
    private OptionInterface mOptionInterface;

    public OptionInterface getOptionInterface() {
        return mOptionInterface;
    }

    /**
     * Constructor to pass the UI row type
     *
     * @param optionRowType
     */
    public Option(OptionRowType optionRowType) {
        mOptionRowType = optionRowType;
    }

    /**
     * Getters/Setters
     */
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public void setSubTitle(String subTitle) {
        this.mSubTitle = subTitle;
    }


    public ArrayList<String> getSubOptions() {
        return mSubOptions;
    }

    public void setSubOptions(ArrayList<String> mSubOptions) {
        this.mSubOptions = mSubOptions;
    }

    OptionRowType getOptionRowType() {
        return mOptionRowType;
    }
}
