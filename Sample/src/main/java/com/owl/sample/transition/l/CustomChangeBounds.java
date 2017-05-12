package com.owl.sample.transition.l;

import android.animation.Animator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.transition.ChangeBounds;
import android.transition.TransitionValues;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

/**
 * Created by Alamusi on 2017/5/12.
 */

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class CustomChangeBounds extends ChangeBounds {

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
        Animator changeBounds = super.createAnimator(sceneRoot, startValues, endValues);
        if (startValues == null || endValues == null || changeBounds == null) {
            return null;
        }
        changeBounds.setDuration(1000);
        changeBounds.setInterpolator(AnimationUtils.loadInterpolator(sceneRoot.getContext(), android.R.interpolator.fast_out_slow_in));
        return changeBounds;
    }
}
