package com.google.android.clockwork.watchfaces;

import android.content.ComponentName;
import android.content.Intent;

public class WatchFaceIntents {

    public static final String ACTION_BACKGROUND_ACTION = "com.google.android.clockwork.home.action.BACKGROUND_ACTION";
    public static final String ACTION_BIND_HOME = "com.google.android.clockwork.home.action.BIND_HOME";

    public static final Intent BIND_HOME_INTENT;

    public static final String EXTRA_AMBIENT_MODE = "ambient_mode";
    public static final String EXTRA_CARD_LOCATION = "card_location";
    public static final String EXTRA_CARD_PROGRESS = "card_progress";
    public static final String EXTRA_CARD_PROGRESS_ENABLED = "card_progress_enabled";

    public static final String PERMISSION_PROVIDE_BACKGROUND = "com.google.android.permission.PROVIDE_BACKGROUND";

    static {
        BIND_HOME_INTENT = new Intent(ACTION_BIND_HOME);
        BIND_HOME_INTENT.setComponent(new ComponentName("com.google.android.wearable.app", "com.google.android.clockwork.home.watchfaces.HomeBackgroundService"));
    }
}
