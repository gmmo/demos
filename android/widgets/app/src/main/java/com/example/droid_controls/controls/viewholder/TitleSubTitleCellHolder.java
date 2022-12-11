////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls.controls.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.droid_controls.R;

/**
 * View holder for title sub-title cell
 */
public class TitleSubTitleCellHolder extends RecyclerView.ViewHolder {
    final private View mViewHolder;
    final private TextView mTextTitle;
    final private TextView mTextSubTitle;

    /**
     * @param itemView {@link View}
     */
    public TitleSubTitleCellHolder(View itemView) {
        super(itemView);
        mViewHolder = itemView;
        mTextTitle = itemView.findViewById(R.id.option_title_id);
        mTextSubTitle = itemView.findViewById(R.id.option_sub_title_id);
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

    public TextView getTextSubTitle() {
        return mTextSubTitle;
    }
}
