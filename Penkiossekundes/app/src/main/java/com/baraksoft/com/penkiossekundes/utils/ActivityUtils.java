package com.baraksoft.com.penkiossekundes.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * @author Laurynas
 * @since 2016-12-29
 */
public class ActivityUtils {
    private ActivityUtils() {}

    public static void changeActivity(Activity oldActivity, Class newActivity, Context context) {
        Intent intent = new Intent(oldActivity, newActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(intent);
        oldActivity.finish();
    }
}
