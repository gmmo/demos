////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls.controls.viewholder;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.droid_controls.R;
import com.google.android.gms.maps.MapView;

/**
 * View holder for the map widget
 */
public class MapViewCellHolder extends RecyclerView.ViewHolder {
    final private View mViewHolder;
    private MapView mMapView;

    /**
     * @param itemView {@link View}
     */
    public MapViewCellHolder(View itemView) {
        super(itemView);
        mViewHolder = itemView;
        mMapView = (MapView) itemView.findViewById(R.id.map_view_id);
    }

    /**
     * getters
     */
    public View getViewHolder() {
        return mViewHolder;
    }

    public MapView getMapView() {
        return mMapView;
    }

}
