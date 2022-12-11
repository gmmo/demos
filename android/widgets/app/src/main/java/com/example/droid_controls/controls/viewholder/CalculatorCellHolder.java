////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls.controls.viewholder;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * View holder for calculator widget
 */
public class CalculatorCellHolder extends RecyclerView.ViewHolder {
    final private View mViewHolder;

    /**
     * @param itemView {@link View}
     */
    public CalculatorCellHolder(View itemView) {
        super(itemView);
        mViewHolder = itemView;
    }

    /**
     * getters
     */
    public View getViewHolder() {
        return mViewHolder;
    }
}
