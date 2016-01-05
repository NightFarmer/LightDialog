package com.nightfarmer.lightdialog.util;

import android.content.Context;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.nightfarmer.lightdialog.R;

/**
 * Created by zhangfan on 16-1-4.
 */
public class AnimateUtil {
    private static final int INVALID = -1;

    public static int getAnimationResource(int gravity, boolean isInAnimation) {
        switch (gravity) {
            case Gravity.TOP:
                return isInAnimation ? R.anim.slide_in_top : R.anim.slide_out_top;
            case Gravity.BOTTOM:
                return isInAnimation ? R.anim.slide_in_bottom : R.anim.slide_out_bottom;
            case Gravity.CENTER:
                return isInAnimation ? R.anim.fade_in_center : R.anim.fade_out_center;
            default:
                // This case is not implemented because we don't expect any other gravity at the moment
        }
        return INVALID;
    }

    public static Animation getRootAnimation(Context context, boolean visible) {
        return AnimationUtils.loadAnimation(context, visible ? R.anim.root_in : R.anim.root_out);
    }
}
