package com.owl.sample.transition.preL;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.owl.sample.transition.BaseActivity;
import com.owl.sample.transition.R;

/**
 * Created by Alamusi on 2017/5/12.
 */

public class Slide extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        mTextView.setText("左滑进入， 右滑关闭");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
