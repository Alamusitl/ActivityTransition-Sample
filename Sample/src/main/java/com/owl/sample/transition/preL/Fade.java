package com.owl.sample.transition.preL;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.owl.sample.transition.BaseActivity;
import com.owl.sample.transition.R;

/**
 * Created by Alamusi on 2017/5/12.
 */

public class Fade extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        mTextView.setText("pre L Fade");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
