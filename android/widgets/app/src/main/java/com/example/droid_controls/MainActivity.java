////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.droid_controls.custom_dialog.CustomDialog;
import com.example.droid_controls.custom_dialog.CustomDialogInterface;

/**
 * Main Activity
 */
public class MainActivity extends AppCompatActivity {

    public static final String APP_TAG = "SELECTOR";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button dialogDemo = findViewById(R.id.custom_dialog_id);
        dialogDemo.setOnClickListener(v -> {
            try {
                CustomDialog customDialog = new CustomDialog();
                DialogInterfaceCallback dialogInterfaceCallback = new DialogInterfaceCallback();
                customDialog.setDialogYesNoInterface(dialogInterfaceCallback);
                customDialog.show(this.getFragmentManager(), APP_TAG);
            } catch (Exception e) {
                StackTraceElement trace = new Exception().getStackTrace()[0];
                Log.e(APP_TAG, "[Exception:" + e.toString() + "]" +
                        trace.getClassName() + "->" + trace.getMethodName() + ":" + trace.getLineNumber());
            }

        });

        final Button recyclerViewDemo = findViewById(R.id.custom_controls_id);
        recyclerViewDemo.setOnClickListener(v -> {
            startActivity(new Intent(this, ControlsActivity.class));

        });

        final Button testActivity = findViewById(R.id.test_activity_id);
        testActivity.setOnClickListener(v -> {
            //startActivity(new Intent(this, WebViewActivity.class));
            startActivity(new Intent(this, MapsActivity.class));
        });

        //startActivity(new Intent(this, MapsActivity.class));
    }

    @Override
    protected void onResume() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onResume();
    }

    private class DialogInterfaceCallback implements CustomDialogInterface {

        /**
         * @param view           {@link View}
         * @param dialogFragment {@link androidx.fragment.app.DialogFragment}
         */
        @Override
        public void onYes(View view, DialogFragment dialogFragment) {
            dialogFragment.dismiss();
        }

        /**
         * @param view           {@link View}
         * @param dialogFragment {@link androidx.fragment.app.DialogFragment}
         */
        @Override
        public void onNo(View view, DialogFragment dialogFragment) {
            dialogFragment.dismiss();
        }
    }

}
