package com.example.baseproject;

import static android.content.ContentValues.TAG;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {
    public static final String TAG ="NewAppWidget";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);

        }
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        int width = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH);
        int height = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT);


        Log.d(TAG, "Width "+width+ " Height "+height);

        if(width<160) {
            views.setViewVisibility(R.id.layoutPlace, View.GONE);
            views.setViewVisibility(R.id.layoutTimeTem, View.GONE);
            views.setViewVisibility(R.id.layoutTemDate, View.GONE);
        }else if(width<250){
            views.setViewVisibility(R.id.layoutPlace, View.VISIBLE);
            views.setViewVisibility(R.id.layoutTimeTem, View.GONE);
            views.setViewVisibility(R.id.layoutTemDate, View.VISIBLE);
        }else if(width<350&&height<210){
            views.setViewVisibility(R.id.layoutTimeTem, View.VISIBLE);
        }else if(width<160&& height<325){
            views.setViewVisibility(R.id.layoutPlace, View.GONE);
            views.setViewVisibility(R.id.layoutTimeTem, View.GONE);
            views.setViewVisibility(R.id.layoutTemDate, View.GONE);
        }else if(width<250&&height<325) {
            views.setViewVisibility(R.id.layoutPlace, View.VISIBLE);
            views.setViewVisibility(R.id.layoutTemDate, View.VISIBLE);
            views.setViewVisibility(R.id.layoutTimeTem, View.GONE);
        }else if (width<250&&height<440){
            views.setViewVisibility(R.id.layoutTemDate, View.VISIBLE);
            views.setViewVisibility(R.id.layoutTimeTem, View.GONE);
        }else if(width<350&&height<450){
            views.setViewVisibility(R.id.layoutTemDate, View.VISIBLE);
            views.setViewVisibility(R.id.layoutTimeTem, View.VISIBLE);
        }else if(width<250 &&height>450){
            views.setViewVisibility(R.id.layoutPlace, View.VISIBLE);
            views.setViewVisibility(R.id.layoutTimeTem, View.GONE);
        }else if(width<350 && height>450){
            views.setViewVisibility(R.id.layoutTimeTem, View.VISIBLE);
        }
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}