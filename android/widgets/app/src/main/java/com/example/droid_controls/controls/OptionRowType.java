////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls.controls;

/**
 * Types of widget cells
 */
public abstract class OptionRowType {

    public final static int TITLE_SUBTITLE = 0;
    public final static int TITLE_TOGGLE = 2;
    public final static int TITLE_BUTTON = 3;
    public final static int TITLE_SPINNER = 4;
    public final static int CALCULATOR = 5;
    public final static int WEB_VIEW = 6;
    public final static int MAP_VIEW = 7;

    /**
     * @return Option type
     */
    public abstract int getCellType();
}
