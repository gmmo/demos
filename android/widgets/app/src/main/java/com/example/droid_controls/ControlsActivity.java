////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.droid_controls.controls.Option;
import com.example.droid_controls.controls.OptionAdapter;
import com.example.droid_controls.controls.OptionRowType;

import java.util.ArrayList;
import java.util.Random;

/**
 * Controls Activity
 */
public class ControlsActivity extends AppCompatActivity {

    private static final String TITLE_STR = "Title";
    private static final String SUB_TITLE_STR = "Sub-Title";
    private static final String BUTTON_STR = "Button ";
    private static final String SUBOPTION_STR = "Sub-option";

    private ArrayList<Option> mOptionList = new ArrayList<>();
    private Random mRandomSeed = new Random();

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_control_ui);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_id);
        OptionAdapter optionAdapter = new OptionAdapter(mOptionList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(optionAdapter);
        initScreenControls();
        optionAdapter.notifyDataSetChanged();

        final Button backButton = findViewById(R.id.back_button_id);
        backButton.setOnClickListener(v -> {
            ControlsActivity.this.finish();
        });
    }

    /**
     * @param min
     * @param max
     * @return
     */
    int getRandomNumber(int min, int max) {

        int randomNum = mRandomSeed.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * Setup all screen controls
     */
    private void initScreenControls() {
        Option option;
        OptionRowType optionRowType;
        int labelCounter = 1;

        // Title, sub-title control
        for (int ii = 0; ii < getRandomNumber(2, 3); ii++) {
            optionRowType = new OptionRowType() {
                @Override
                public int getCellType() {
                    return OptionRowType.TITLE_SUBTITLE;
                }
            };
            option = new Option(optionRowType);
            option.setTitle(TITLE_STR + labelCounter);
            option.setSubTitle(SUB_TITLE_STR + labelCounter);
            mOptionList.add(option);
            labelCounter++;
        }

        // Title button control
        for (int ii = 0; ii < getRandomNumber(2, 3); ii++) {
            optionRowType = new OptionRowType() {
                @Override
                public int getCellType() {
                    return OptionRowType.TITLE_BUTTON;
                }
            };
            option = new Option(optionRowType);
            option.setTitle(TITLE_STR + labelCounter);
            option.setSubTitle(BUTTON_STR + labelCounter);
            mOptionList.add(option);
            labelCounter++;
        }

        // Toggle control
        for (int ii = 0; ii < getRandomNumber(2, 4); ii++) {
            optionRowType = new OptionRowType() {
                @Override
                public int getCellType() {
                    return OptionRowType.TITLE_TOGGLE;
                }
            };
            option = new Option(optionRowType);
            option.setTitle(TITLE_STR + labelCounter);
            mOptionList.add(option);
            labelCounter++;
        }

        // Title spinner control
        for (int ii = 0; ii < getRandomNumber(3, 4); ii++) {
            optionRowType = new OptionRowType() {
                @Override
                public int getCellType() {
                    return OptionRowType.TITLE_SPINNER;
                }
            };
            option = new Option(optionRowType);
            ArrayList<String> subOptions = new ArrayList<>();

            for (int jj = 0; jj < getRandomNumber(3, 4); jj++) {
                subOptions.add(SUBOPTION_STR + labelCounter + "." + jj);
            }
            option.setTitle(TITLE_STR);
            option.setSubOptions(subOptions);
            mOptionList.add(option);
            labelCounter++;
        }

        // Calculator controls
        optionRowType = new OptionRowType() {
            @Override
            public int getCellType() {
                return OptionRowType.CALCULATOR;
            }
        };
        option = new Option(optionRowType);
        mOptionList.add(option);

        // Web-view control
        optionRowType = new OptionRowType() {
            @Override
            public int getCellType() {
                return OptionRowType.WEB_VIEW;
            }
        };
        option = new Option(optionRowType);
        mOptionList.add(option);

        // Mapview
        optionRowType = new OptionRowType() {
            @Override
            public int getCellType() {
                return OptionRowType.MAP_VIEW;
            }
        };
        option = new Option(optionRowType);
        mOptionList.add(option);
    }
}
