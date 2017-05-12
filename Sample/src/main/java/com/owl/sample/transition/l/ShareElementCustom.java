package com.owl.sample.transition.l;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.ArcMotion;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import com.owl.sample.transition.R;

/**
 * Created by Alamusi on 2017/5/12.
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ShareElementCustom extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_custom);

        ArcMotion arcMotion = new ArcMotion();
        arcMotion.setMinimumHorizontalAngle(50f);
        arcMotion.setMinimumVerticalAngle(50f);

        Interpolator interpolator = AnimationUtils.loadInterpolator(this, android.R.interpolator.fast_out_slow_in);

        CustomChangeBounds customChangeBounds = new CustomChangeBounds();
        customChangeBounds.setPathMotion(arcMotion);
        customChangeBounds.setInterpolator(interpolator);

        getWindow().setSharedElementEnterTransition(customChangeBounds);
        getWindow().setSharedElementReenterTransition(customChangeBounds);
        getWindow().setSharedElementExitTransition(customChangeBounds);
        getWindow().setSharedElementReturnTransition(customChangeBounds);
    }
}
