////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls.controls.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.droid_controls.R;

/**
 * View holder for the map widget
 */
public class TitleButtonCellHolder extends RecyclerView.ViewHolder {
    final private View mViewHolder;
    final private TextView mTextTitle;
    final private Button mButton;

    /**
     * @param itemView {@link View}
     */
    public TitleButtonCellHolder(View itemView) {
        super(itemView);
        mViewHolder = itemView;
        mTextTitle = itemView.findViewById(R.id.option_title_id);
        mButton = itemView.findViewById(R.id.option_button_id);
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

    public Button getButton() {
        return mButton;
    }
}
