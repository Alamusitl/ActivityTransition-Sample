package com.owl.sample.transition.l;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import com.owl.sample.transition.R;

/**
 * Created by Alamusi on 2017/5/12.
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ShareElement extends AppCompatActivity {

    private TextView mTextViewSingle;
    private TextView mTextViewBoth;
    private TextView mTextViewCustom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element);

        mTextViewSingle = (TextView) findViewById(R.id.id_share_single);
        mTextViewBoth = (TextView) findViewById(R.id.id_share_both);
        mTextViewCustom = (TextView) findViewById(R.id.id_share_custom);

        mTextViewSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShareElement.this, ShareElementSingle.class),
                        ActivityOptions.makeSceneTransitionAnimation(ShareElement.this, mTextViewSingle, "shareView").toBundle());

            }
        });
        mTextViewBoth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair<View, String> first = new Pair<View, String>(mTextViewSingle, ViewCompat.getTransitionName(mTextViewSingle));
                Pair<View, String> second = new Pair<View, String>(mTextViewBoth, ViewCompat.getTransitionName(mTextViewBoth));
                startActivity(new Intent(ShareElement.this, ShareElementBoth.class),
                        ActivityOptions.makeSceneTransitionAnimation(ShareElement.this, first, second).toBundle());

            }
        });
        mTextViewCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShareElement.this, ShareElementCustom.class),
                        ActivityOptions.makeSceneTransitionAnimation(ShareElement.this, mTextViewCustom, "shareView_custom").toBundle());

            }
        });
    }
}
