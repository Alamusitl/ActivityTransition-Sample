package com.owl.sample.transition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by Alamusi on 2017/5/12.
 */

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView mTextView;

    protected Transition mExplode;
    protected Transition mFade;
    protected Transition mMove;
    protected Transition mSlideLeft;
    protected Transition mSlideRight;
    protected Transition mSlideTop;
    protected Transition mSlideBottom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 启用Android Transition动画
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }

        initTransition();
    }

    @Override
    public void setContentView(@LayoutRes int layoutId) {
        super.setContentView(layoutId);
        mTextView = (TextView) findViewById(R.id.id_textView);
        mTextView.setOnClickListener(this);
    }

    protected void setContentView() {
        super.setContentView(R.layout.activity_common);
        mTextView = (TextView) findViewById(R.id.id_common_textView);
        mTextView.setOnClickListener(this);
    }

    protected void setMainContentView() {
        super.setContentView(R.layout.activity_list);
    }

    private void initTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mExplode = TransitionInflater.from(this).inflateTransition(R.transition.explode);
            mFade = TransitionInflater.from(this).inflateTransition(R.transition.fade);
            mMove = TransitionInflater.from(this).inflateTransition(R.transition.move);
            mSlideLeft = TransitionInflater.from(this).inflateTransition(R.transition.slide_left);
            mSlideRight = TransitionInflater.from(this).inflateTransition(R.transition.slide_right);
            mSlideTop = TransitionInflater.from(this).inflateTransition(R.transition.slide_top);
            mSlideBottom = TransitionInflater.from(this).inflateTransition(R.transition.slide_bottom);
        }
    }

    protected void startActivityTransition(Class clz) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(new Intent(this, clz), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v == mTextView) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(new Intent(this, MainActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
            }
        }
    }
}
