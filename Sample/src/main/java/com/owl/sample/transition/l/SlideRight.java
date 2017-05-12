package com.owl.sample.transition.l;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.owl.sample.transition.BaseActivity;
import com.owl.sample.transition.R;

/**
 * Created by Alamusi on 2017/5/12.
 */

public class SlideRight extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setEnterTransition(mSlideRight);
        getWindow().setExitTransition(mSlideRight);
        getWindow().setReenterTransition(mSlideRight);

        setContentView(R.layout.activity_explode);
        mTextView.setText("Slide Right");
    }
}
