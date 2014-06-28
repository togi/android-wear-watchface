package com.google.android.clockwork.watchfaces;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;

public class WatchFaceStyle implements Parcelable {

    public static final int AMBIENT_PEEK_MODE_VISIBLE = 0;
    public static final int AMBIENT_PEEK_MODE_HIDDEN = 1;

    public static final int BACKGROUND_VISIBILITY_INTERRUPTIVE = 0;
    public static final int BACKGROUND_VISIBILITY_PERSISTENT = 1;

    public static final int PEEK_MODE_VARIABLE = 0;
    public static final int PEEK_MODE_SHORT = 1;

    public static final int PEEK_OPACITY_MODE_OPAQUE = 0;
    public static final int PEEK_OPACITY_MODE_TRANSLUCENT = 1;

    public static final int PROGRESS_MODE_NONE = 0;
    public static final int PROGRESS_MODE_DISPLAY = 1;

    public static final int PROTECT_STATUS_BAR = 1;
    public static final int PROTECT_OK_GOOGLE = 2;
    public static final int PROTECT_WHOLE_SCREEN = 4;

    public final ComponentName component;

    public final int cardPeekMode;
    public final int cardProgressMode;

    public final int backgroundVisibility;
    public final boolean showSystemUiTime;

    public final int ambientPeekMode;
    public final int peekOpacityMode;
    public final int viewProtectionMode;

    public final int statusBarGravity;
    public final int hotwordIndicatorGravity;

    private WatchFaceStyle(ComponentName component, int cardPeekMode, int cardProgressMode, int backgroundVisibility, boolean showSystemUiTime, int ambientPeekMode, int peekOpacityMode, int viewProtectionMode, int statusBarGravity, int hotwordIndicatorGravity) {
        this.component = component;
        this.cardPeekMode = cardPeekMode;
        this.cardProgressMode = cardProgressMode;
        this.backgroundVisibility = backgroundVisibility;
        this.showSystemUiTime = showSystemUiTime;
        this.ambientPeekMode = ambientPeekMode;
        this.peekOpacityMode = peekOpacityMode;
        this.viewProtectionMode = viewProtectionMode;
        this.statusBarGravity = statusBarGravity;
        this.hotwordIndicatorGravity = hotwordIndicatorGravity;
    }

    private WatchFaceStyle(Parcel in) {
        component = in.readParcelable(WatchFaceStyle.class.getClassLoader());
        cardPeekMode = in.readInt();
        cardProgressMode = in.readInt();
        backgroundVisibility = in.readInt();

        boolean[] val = new boolean[1];
        in.readBooleanArray(val);
        showSystemUiTime = val[0];

        ambientPeekMode = in.readInt();
        peekOpacityMode = in.readInt();
        viewProtectionMode = in.readInt();
        statusBarGravity = in.readInt();
        hotwordIndicatorGravity = in.readInt();
    }

    public static final Creator<WatchFaceStyle> CREATOR = new Creator<WatchFaceStyle>() {
        @Override
        public WatchFaceStyle createFromParcel(Parcel in) {
            return new WatchFaceStyle(in);
        }

        @Override
        public WatchFaceStyle[] newArray(int size) {
            return new WatchFaceStyle[size];
        }
    };

    @Override
    public void writeToParcel(Parcel p, int flags) {
        p.writeParcelable(component, flags);
        p.writeInt(cardPeekMode);
        p.writeInt(cardProgressMode);
        p.writeInt(backgroundVisibility);

        boolean[] val = new boolean[1];
        val[0] = showSystemUiTime;
        p.writeBooleanArray(val);

        p.writeInt(ambientPeekMode);
        p.writeInt(peekOpacityMode);
        p.writeInt(viewProtectionMode);
        p.writeInt(statusBarGravity);
        p.writeInt(hotwordIndicatorGravity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // TODO: implements equals and hashCode

    @Override
    public String toString() {
        String componentName = "default";
        if (component != null) {
            componentName = component.getShortClassName();
        }
        return String.format("watch face %s (card %d/%d bg %d time %s " +
                        "ambientPeekMode %d peekOpacityMode %d viewProtectionMode %d " +
                        "statusBarGravity %d hotwordIndicatorGravity %d)",
                componentName,
                cardPeekMode, cardProgressMode, backgroundVisibility, showSystemUiTime,
                ambientPeekMode, peekOpacityMode, viewProtectionMode,
                statusBarGravity, hotwordIndicatorGravity);
    }

    public static class Builder {
        private ComponentName mComponent;

        private int mCardPeekMode;
        private int mCardProgressMode;

        private int mBackgroundVisibility;
        private boolean mShowSystemUiTime;

        private int mAmbientPeekMode;
        private int mPeekOpacityMode;
        private int mViewProtectionMode;

        private int mStatusBarGravity;
        private int mHotwordIndicatorGravity;

        private Builder() {
            mBackgroundVisibility = BACKGROUND_VISIBILITY_PERSISTENT;
        }

        public static Builder forActivity(Activity activity) {
            if (activity == null) {
                throw new IllegalArgumentException("activity must not be null.");
            }
            return forComponentName(new ComponentName(activity, activity.getClass()));
        }

        public static Builder forComponentName(ComponentName component) {
            if (component == null) {
                throw new IllegalArgumentException("component must not be null.");
            }
            Builder builder = new Builder();
            builder.mComponent = component;
            return builder;
        }

        public static Builder forDefault() {
            return new Builder();
        }

        public WatchFaceStyle build() {
            return new WatchFaceStyle(
                    mComponent,
                    mCardPeekMode, mCardProgressMode,
                    mBackgroundVisibility,
                    mShowSystemUiTime,
                    mAmbientPeekMode,
                    mPeekOpacityMode,
                    mViewProtectionMode,
                    mStatusBarGravity, mHotwordIndicatorGravity);
        }



        public Builder setAmbientPeekMode(int ambientPeekMode) {
            switch (ambientPeekMode) {
                case AMBIENT_PEEK_MODE_VISIBLE:
                case AMBIENT_PEEK_MODE_HIDDEN:
                    break;

                default:
                    throw new IllegalArgumentException("Ambient peek mode must be AMBIENT_PEEK_MODE_VISIBLE or AMBIENT_PEEK_MODE_HIDDEN");
            }

            mAmbientPeekMode = ambientPeekMode;
            return this;
        }

        public Builder setBackgroundVisibility(int backgroundVisibility) {
            switch (backgroundVisibility) {
                case BACKGROUND_VISIBILITY_INTERRUPTIVE:
                case BACKGROUND_VISIBILITY_PERSISTENT:
                    break;

                default:
                    throw new IllegalArgumentException("backgroundVisibility must be BACKGROUND_VISIBILITY_INTERRUPTIVE or BACKGROUND_VISIBILITY_PERSISTENT");
            }

            mBackgroundVisibility = backgroundVisibility;
            return this;
        }

        public Builder setCardPeekMode(int peekMode) {
            switch (peekMode) {
                case PEEK_MODE_VARIABLE:
                case PEEK_MODE_SHORT:
                    break;

                default:
                    throw new IllegalArgumentException("peekMode must be PEEK_MODE_VARIABLE or PEEK_MODE_SHORT");
            }

            mCardPeekMode = peekMode;
            return this;
        }

        public Builder setCardProgressMode(int progressMode) {
            switch (progressMode) {
                case PROGRESS_MODE_NONE:
                case PROGRESS_MODE_DISPLAY:
                    break;

                default:
                    throw new IllegalArgumentException("progressMode must be PROGRESS_MODE_NONE or PROGRESS_MODE_DISPLAY");
            }

            mCardProgressMode = progressMode;
            return this;
        }

        public Builder setHotwordIndicatorGravity(int hotwordIndicatorGravity) {
            mHotwordIndicatorGravity = hotwordIndicatorGravity;
            return this;
        }

        public Builder setPeekOpacityMode(int peekOpacityMode) {
            switch (peekOpacityMode) {
                case PEEK_OPACITY_MODE_OPAQUE:
                case PEEK_OPACITY_MODE_TRANSLUCENT:
                    break;

                default:
                    throw new IllegalArgumentException("Peek card opacity must be PEEK_OPACITY_MODE_OPAQUE or PEEK_OPACITY_MODE_TRANSLUCENT");
            }

            mPeekOpacityMode = peekOpacityMode;
            return this;
        }

        public Builder setShowSystemUiTime(boolean showSystemUiTime) {
            mShowSystemUiTime = showSystemUiTime;
            return this;
        }

        public Builder setStatusBarGravity(int statusBarGravity) {
            mStatusBarGravity = statusBarGravity;
            return this;
        }

        public Builder setViewProtection(int viewProtection) {
            if (viewProtection > (PROTECT_STATUS_BAR | PROTECT_OK_GOOGLE | PROTECT_WHOLE_SCREEN)) {
                throw new IllegalArgumentException("View protection must be combination PROTECT_STATUS_BAR, PROTECT_OK_GOOGLE or PROTECT_WHOLE_SCREEN");
            }

            mViewProtectionMode = viewProtection;
            return this;
        }
    }
}
