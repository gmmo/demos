////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls.custom_dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.droid_controls.R;

import static com.example.droid_controls.MainActivity.APP_TAG;

/**
 * Custom dialog
 */
public class CustomDialog extends DialogFragment {

    private Dialog mCustomDialog;
    private CustomDialogInterface mCustomDialogInterface;

    /**
     * @param customDialogInterface {@link CustomDialogInterface}
     */
    public void setDialogYesNoInterface(CustomDialogInterface customDialogInterface) {
        mCustomDialogInterface = customDialogInterface;
    }

    /**
     * @param savedInstanceState {@link Bundle}
     * @return {@link Dialog}
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mCustomDialog = new Dialog(getActivity());

        try {
            mCustomDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            mCustomDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
            mCustomDialog.setContentView(R.layout.custom_dialog);
            mCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mCustomDialog.setCancelable(false);
            mCustomDialog.setCanceledOnTouchOutside(false);
        } catch (NullPointerException e) {
            StackTraceElement trace = new Exception().getStackTrace()[0];
            Log.d(APP_TAG, "Could not initialize dialog [Exception:" + e.toString() + "]" +
                    trace.getClassName() + "->" + trace.getMethodName() + ":" + trace.getLineNumber());
        }

        final DialogFragment dialogFragment = this;

        mCustomDialog.findViewById(R.id.demo_dialog_yes_id).
                setOnClickListener((View view) -> {
                    if (mCustomDialogInterface != null) {

                        mCustomDialogInterface.onYes(view, dialogFragment);
                    }
                });

        mCustomDialog.findViewById(R.id.demo_dialog_no_id)
                .setOnClickListener((View view) -> {
                    if (mCustomDialogInterface != null) {
                        mCustomDialogInterface.onNo(view, dialogFragment);
                    } else {
                        dismiss();
                    }
                });

        return mCustomDialog;
    }
}
