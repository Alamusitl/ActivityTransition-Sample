package com.owl.sample.transition.l;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

import com.owl.sample.transition.BaseActivity;
import com.owl.sample.transition.R;

/**
 * Created by Alamusi on 2017/5/12.
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class SlideLeft extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setEnterTransition(mSlideLeft);
        getWindow().setExitTransition(mSlideLeft);
        getWindow().setReenterTransition(mSlideLeft);

        setContentView(R.layout.activity_explode);
        mTextView.setText("Slide Left");
    }
}
