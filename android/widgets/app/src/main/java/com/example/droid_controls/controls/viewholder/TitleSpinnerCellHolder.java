////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls.controls.viewholder;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.droid_controls.R;

/**
 * View holder for the map widget
 */
public class TitleSpinnerCellHolder extends RecyclerView.ViewHolder {
    final private View mViewHolder;
    final private TextView mTextTitle;
    final private Spinner mSpinner;

    /**
     * @param itemView {@link View}
     */
    public TitleSpinnerCellHolder(View itemView) {
        super(itemView);
        mViewHolder = itemView;
        mTextTitle = itemView.findViewById(R.id.option_title_id);
        mSpinner = itemView.findViewById(R.id.option_spinner_id);
    }

    /**
     * getters
     */
    public View getViewHolder() {
        return mViewHolder;
    }

    public TextView getTextTitle() {
        return mTextTitle;
    }

    public Spinner getSpinner() {
        return mSpinner;
    }
}
