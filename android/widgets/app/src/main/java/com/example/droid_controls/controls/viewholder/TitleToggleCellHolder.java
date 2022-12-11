////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls.controls.viewholder;

import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.droid_controls.R;

/**
 * View holder for toggle
 */
public class TitleToggleCellHolder extends RecyclerView.ViewHolder {
    final private View mViewHolder;
    final private TextView mTextTitle;
    final private Switch mSwitch;

    /**
     * @param itemView {@link View}
     */
    public TitleToggleCellHolder(View itemView) {
        super(itemView);
        mViewHolder = itemView;
        mTextTitle = itemView.findViewById(R.id.option_title_id);
        mSwitch = itemView.findViewById(R.id.option_toggle_id);
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

    public Switch getSwitch() {
        return mSwitch;
    }
}
