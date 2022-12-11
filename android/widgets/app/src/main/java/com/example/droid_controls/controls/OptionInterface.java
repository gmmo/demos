////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls.controls;

import android.view.View;
import android.widget.CompoundButton;

/**
 * Interface to handle tap events
 */
public interface OptionInterface {
    /**
     * @param view
     * @param position
     */
    void onClick(View view,
                 int position);

    /**
     * @param compoundButton
     * @param isChecked
     * @param position
     */
    void onCheckedChanged(CompoundButton compoundButton,
                          boolean isChecked,
                          int position);
}
