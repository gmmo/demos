////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls.controls;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.droid_controls.R;
import com.example.droid_controls.controls.viewholder.CalculatorCellHolder;
import com.example.droid_controls.controls.viewholder.MapViewCellHolder;
import com.example.droid_controls.controls.viewholder.TitleButtonCellHolder;
import com.example.droid_controls.controls.viewholder.TitleSpinnerCellHolder;
import com.example.droid_controls.controls.viewholder.TitleSubTitleCellHolder;
import com.example.droid_controls.controls.viewholder.TitleToggleCellHolder;
import com.example.droid_controls.controls.viewholder.WebViewCellHolder;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import static com.example.droid_controls.MainActivity.APP_TAG;

/**
 * Recycler View Adapter for all widgets
 */
public class OptionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements OnMapReadyCallback {

    private ArrayList<Option> mOptionList;
    private Activity mParentActivity;

    /**
     * Helper class to encapsulate spinner listeners
     */
    private class SpinnerListener implements AdapterView.OnItemSelectedListener {

        private int mOptionListPosition;

        SpinnerListener(int position) {
            mOptionListPosition = position;
            Log.d(APP_TAG, "Create Spinner : " + position);
        }

        public int getPos() {
            return mOptionListPosition;
        }

        /**
         * @param parent
         * @param view
         * @param position
         * @param id
         */
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            Log.d(APP_TAG, "Selection (Option, Spinner): " +
                    mOptionListPosition + ", " + position);
        }

        /**
         * @param parent
         */
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    /**
     * @param optionList
     * @param parentActivity
     */
    public OptionAdapter(ArrayList<Option> optionList, Activity parentActivity) {
        mOptionList = optionList;
        mParentActivity = parentActivity;
    }

    /**
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            default:
            case OptionRowType.TITLE_SUBTITLE:
                itemView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.row_option_title_subtitle, parent, false);
                viewHolder = new TitleSubTitleCellHolder(itemView);
                break;

            case OptionRowType.TITLE_TOGGLE:
                itemView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.row_option_title_toggle, parent, false);
                viewHolder = new TitleToggleCellHolder(itemView);
                break;

            case OptionRowType.TITLE_BUTTON:
                itemView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.row_option_title_button, parent, false);
                viewHolder = new TitleButtonCellHolder(itemView);
                break;

            case OptionRowType.TITLE_SPINNER:
                itemView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.row_option_title_spinner, parent, false);
                viewHolder = new TitleSpinnerCellHolder(itemView);
                break;

            case OptionRowType.CALCULATOR:
                itemView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.row_option_calculator, parent, false);
                viewHolder = new CalculatorCellHolder(itemView);
                break;

            case OptionRowType.WEB_VIEW:
                itemView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.row_option_webview, parent, false);
                viewHolder = new WebViewCellHolder(itemView);
                break;

            case OptionRowType.MAP_VIEW:
                itemView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.row_option_mapview, parent, false);
                viewHolder = new MapViewCellHolder(itemView);
                break;

        }

        return viewHolder;
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {
            default:
            case OptionRowType.TITLE_SUBTITLE:
                bindTitleSubTitleCell((TitleSubTitleCellHolder) holder, position);
                break;
            case OptionRowType.TITLE_TOGGLE:
                bindTitleToggleCell((TitleToggleCellHolder) holder, position);
                break;
            case OptionRowType.TITLE_BUTTON:
                bindTitleButtonCell((TitleButtonCellHolder) holder, position);
                break;
            case OptionRowType.TITLE_SPINNER:
                bindTitleSpinnerCell((TitleSpinnerCellHolder) holder, position);
                break;
            case OptionRowType.CALCULATOR:
                bindCalculatorCell((CalculatorCellHolder) holder, position);
                break;

            case OptionRowType.WEB_VIEW:
                bindWebViewCell((WebViewCellHolder) holder, position);
                break;

            case OptionRowType.MAP_VIEW:
                bindMapViewCell((MapViewCellHolder) holder, position);
                break;
        }
    }

    /**
     * @param holder
     * @param position
     */
    private void bindCalculatorCell(CalculatorCellHolder holder, int position) {
    }

    /**
     * @param holder
     * @param position
     */
    private void bindWebViewCell(WebViewCellHolder holder, int position) {

        WebView browser = holder.getWebView();
        browser.loadUrl("http://www.guitarv.com");
    }

    /**
     * @param holder
     * @param position
     */
    private void bindMapViewCell(MapViewCellHolder holder, int position) {

        MapView mapView = holder.getMapView();
        mapView.onCreate(null);
        mapView.onResume();
        mapView.getMapAsync(this);
    }

    /**
     * @param context
     * @return Current GPS or network location
     */
    private LatLng getCurrentLocation(Context context) {
        double longitude = 0.0;
        double latitude = 0.0;

        Location gpsLocation = null;
        Location networkLocation = null;

        LocationManager locationManager = (LocationManager)
                context.getSystemService(Context.LOCATION_SERVICE);

        if (!(ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED)) {

            try {

                gpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                networkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            } catch (Exception e) {
                Log.e(APP_TAG, e.toString());
            }

            if (gpsLocation != null) {
                latitude = gpsLocation.getLatitude();
                longitude = gpsLocation.getLongitude();
            } else if (networkLocation != null) {
                latitude = networkLocation.getLatitude();
                longitude = networkLocation.getLongitude();
            } else {
                latitude = 0.0;
                longitude = 0.0;
            }
        }

        LatLng latLng = new LatLng(latitude, longitude);
        return latLng;
    }

    /**
     * @param googleMap
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMinZoomPreference(12);
        googleMap.setIndoorEnabled(true);
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setIndoorLevelPickerEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);

        Context context = mParentActivity.getApplicationContext();

        LatLng latLng = getCurrentLocation(context);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    /**
     * @param holder
     * @param position
     */
    private void bindTitleSpinnerCell(TitleSpinnerCellHolder holder, int position) {
        final TextView title = holder.getTextTitle();
        final Spinner spinner = holder.getSpinner();

        String text = mOptionList.get(position).getTitle();
        title.setText(text);

        ArrayList<String> subOptions = mOptionList.get(position).getSubOptions();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(mParentActivity,
                android.R.layout.simple_spinner_item, subOptions);

        SpinnerListener spinnerListener = new SpinnerListener(position);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(spinnerListener);
    }

    /**
     * @param holder
     * @param position
     */
    private void bindTitleButtonCell(TitleButtonCellHolder holder, final int position) {
        final TextView title = holder.getTextTitle();
        final Button button = holder.getButton();

        String text = mOptionList.get(position).getTitle();
        title.setText(text);

        String buttonText = mOptionList.get(position).getSubTitle();
        button.setText(buttonText);

        final OptionInterface optionInterface = mOptionList.get(position).getOptionInterface();
        if (optionInterface != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    optionInterface.onClick(view, position);
                }
            });
        } else {
            Log.e(APP_TAG, "Could not attach listener to button");
        }
    }

    /**
     * @param holder
     * @param position
     */
    private void bindTitleToggleCell(TitleToggleCellHolder holder, int position) {
        final TextView title = holder.getTextTitle();
        final Switch toggleSwitch = holder.getSwitch();


        String text = mOptionList.get(position).getTitle();
        title.setText(text);

        final OptionInterface optionInterface = mOptionList.get(position).getOptionInterface();
        if (optionInterface != null) {
            toggleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    optionInterface.onCheckedChanged(compoundButton, isChecked, position);
                }
            });


        } else {
            Log.d(APP_TAG, "Could not attach listener to switch");
        }
    }

    /**
     * @param holder
     * @param position
     */
    private void bindTitleSubTitleCell(TitleSubTitleCellHolder holder, int position) {
        final TextView title = holder.getTextTitle();
        final TextView subtitle = holder.getTextSubTitle();

        String text = mOptionList.get(position).getTitle();
        title.setText(text);

        text = mOptionList.get(position).getSubTitle();
        subtitle.setText(text);
    }

    /**
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        int cellType = mOptionList.get(position).getOptionRowType().getCellType();
        return cellType;
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {
        int itemCount = 0;
        if (mOptionList != null) {
            itemCount = mOptionList.size();
        }

        return itemCount;
    }
}
