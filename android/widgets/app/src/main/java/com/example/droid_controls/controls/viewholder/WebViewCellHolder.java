////////////////////////////////////////////////////////////////////////////////
//  Author: Gustavo Machado
////////////////////////////////////////////////////////////////////////////////

package com.example.droid_controls.controls.viewholder;

import android.view.View;
import android.webkit.WebView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.droid_controls.R;

/**
 * View holder for web-view
 */
public class WebViewCellHolder extends RecyclerView.ViewHolder {
    final private View mViewHolder;
    final private WebView mWebView;

    /**
     * @param itemView {@link View}
     */
    public WebViewCellHolder(View itemView) {
        super(itemView);
        mViewHolder = itemView;
        mWebView = itemView.findViewById(R.id.webview);
    }

    /**
     * getters
     */
    public View getViewHolder() {
        return mViewHolder;
    }

    public WebView getWebView() {
        return mWebView;
    }
}
