////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

/**
 * Calculator Activity
 */
public class CalculatorActivity extends AppCompatActivity {

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    /**
     *
     */
    @Override
    protected void onResume() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onResume();
    }

}
