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
public class SlideBottom extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setEnterTransition(mSlideBottom);
        getWindow().setExitTransition(mSlideBottom);
        getWindow().setReenterTransition(mSlideBottom);

        setContentView(R.layout.activity_explode);
        mTextView.setText("Slide Bottom");
    }
}
