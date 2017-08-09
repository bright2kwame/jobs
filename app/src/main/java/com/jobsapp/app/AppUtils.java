package com.jobsapp.app;

/**
 * Created by Monarchy on 01/12/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;


/**
 * Navigation utility class
 */

public class AppUtils {

    private AppUtils() {
    }

    /**
     * Navigate to the next activity
     *
     * @param activity the activity you are navigating from
     * @param extras   bundles to be passed to the other activity
     */
    public static void navigateUp(Activity activity, Bundle extras) {
        Intent upIntent = NavUtils.getParentActivityIntent(activity);
        if (upIntent != null) {
            if (extras != null) {
                upIntent.putExtras(extras);
            }
            if (NavUtils.shouldUpRecreateTask(activity, upIntent)) {
                TaskStackBuilder.create(activity)
                        .addNextIntentWithParentStack(upIntent)
                        .startActivities();
            } else {
                upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                activity.startActivity(upIntent);
            }
        }
        activity.finish();
    }

    public static void navigateUpKeep(Activity activity, Class destination, Bundle extras) {
        Intent upIntent = new Intent(activity, destination);
        if (extras != null) {
            upIntent.putExtras(extras);
        }
        if (NavUtils.shouldUpRecreateTask(activity, upIntent)) {
            TaskStackBuilder.create(activity)
                    .addNextIntentWithParentStack(upIntent)
                    .startActivities();
        } else {
            upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            activity.startActivity(upIntent);
        }
    }

    public static void navigateUp(Activity activity) {
        navigateUp(activity, null);
    }

    public static void startBrowser(Context context, String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        context.startActivity(i);
    }

}