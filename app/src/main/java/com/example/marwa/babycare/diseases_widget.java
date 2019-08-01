package com.example.marwa.babycare;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import io.paperdb.Paper;

/**
 * Implementation of App Widget functionality.
 */
public class diseases_widget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        Paper.init(context);
        String title = Paper.book().read("desc");
        String url = Paper.book().read("url");

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.diseases_widget);

        try {
            Bitmap bitmap = Glide.with(context)
                    .asBitmap()
                    .load(url)
                    .submit(512, 512)
                    .get();
            views.setImageViewBitmap(R.id.widget_iv, bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        views.setTextViewText(R.id.desc_widget_tv,title);


        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

