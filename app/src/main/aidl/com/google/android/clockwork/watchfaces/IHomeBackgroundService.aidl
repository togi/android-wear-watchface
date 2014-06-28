package com.google.android.clockwork.watchfaces;

import com.google.android.clockwork.watchfaces.WatchFaceStyle;

interface IHomeBackgroundService {
    oneway void setStyle(in WatchFaceStyle style);
}