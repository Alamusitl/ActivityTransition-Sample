package com.owl.sample.transition;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Dimension;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.owl.sample.transition.l.Explode;
import com.owl.sample.transition.l.Move;
import com.owl.sample.transition.l.ShareElement;
import com.owl.sample.transition.l.SlideBottom;
import com.owl.sample.transition.l.SlideLeft;
import com.owl.sample.transition.l.SlideRight;
import com.owl.sample.transition.l.SlideTop;
import com.owl.sample.transition.preL.Fade;
import com.owl.sample.transition.preL.Slide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private List<String> mTransitionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setMainContentView();

        initData();

        ListView listView = (ListView) findViewById(R.id.id_listView);
        listView.setAdapter(new TransitionAdapter(this));
        listView.setOnItemClickListener(this);
    }

    private void initData() {
        mTransitionList.add("CircularReveal");
        mTransitionList.add("Pre L Slide");
        mTransitionList.add("Pre L Fade");

        mTransitionList.add("L+ Explode");
        mTransitionList.add("L+ Fade");
        mTransitionList.add("L+ Move");
        mTransitionList.add("L+ Slide Left");
        mTransitionList.add("L+ Slide Right");
        mTransitionList.add("L+ Slide Top");
        mTransitionList.add("L+ Slide Bottom");

        mTransitionList.add("L+ Share Element");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, CircularRevealActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, Slide.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case 2:
                startActivity(new Intent(this, Fade.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case 3:
                startActivityTransition(Explode.class);
                break;
            case 4:
                startActivityTransition(com.owl.sample.transition.l.Fade.class);
                break;
            case 5:
                startActivityTransition(Move.class);
                break;
            case 6:
                startActivityTransition(SlideLeft.class);
                break;
            case 7:
                startActivityTransition(SlideRight.class);
                break;
            case 8:
                startActivityTransition(SlideTop.class);
                break;
            case 9:
                startActivityTransition(SlideBottom.class);
                break;
            case 10:
                startActivity(new Intent(this, ShareElement.class));
                break;
        }
    }

    private class TransitionAdapter extends BaseAdapter {

        private Context mContext;

        TransitionAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return mTransitionList.size();
        }

        @Override
        public Object getItem(int position) {
            return mTransitionList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder(mContext);
                convertView = holder.mTextView;
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.mTextView.setText(mTransitionList.get(position));
            if (position > 1 && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                holder.mTextView.setEnabled(false);
            }
            return convertView;
        }
    }

    private class ViewHolder {

        TextView mTextView;

        ViewHolder(Context context) {
            mTextView = new TextView(context);
            mTextView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
            mTextView.setGravity(Gravity.CENTER_VERTICAL);
            mTextView.setPadding(50, 20, 0, 20);
            mTextView.setTextSize(Dimension.SP, 26);
        }

    }
}
