////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls.custom_dialog;

import android.app.DialogFragment;
import android.view.View;

/**
 * Custom listener interfaces
 */
public interface CustomDialogInterface {

    /**
     * @param view
     * @param dialogFragment
     */
    void onYes(View view, DialogFragment dialogFragment);

    /**
     * @param view
     * @param dialogFragment
     */
    void onNo(View view, DialogFragment dialogFragment);
}
