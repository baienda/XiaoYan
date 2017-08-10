package com.baienda.xiaoyan.view.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.presenter.MainPresenter;
import com.baienda.xiaoyan.view.fragment.ActivityFragment;
import com.baienda.xiaoyan.view.fragment.CourseFragment;
import com.baienda.xiaoyan.view.fragment.MeFragment;
import com.baienda.xiaoyan.view.fragment.VideoFragment;

import butterknife.BindView;

public class MainActivity extends MVPBaseActivity<MainPresenter> implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.rg_bottom_menu)
    RadioGroup rg_bottom_menu;
    @BindView(R.id.rb_course)
    RadioButton rb_course;
    @BindView(R.id.rb_activity)
    RadioButton rb_activity;
    @BindView(R.id.rb_video)
    RadioButton rb_video;
    @BindView(R.id.rb_me)
    RadioButton rb_me;
    @BindView(R.id.iv_course)
    ImageView iv_course;
    @BindView(R.id.iv_activity)
    ImageView iv_activity;
    @BindView(R.id.iv_video)
    ImageView iv_video;
    @BindView(R.id.iv_me)
    ImageView iv_me;
    @BindView(R.id.tv_city)
    TextView tv_city;
    @BindView(R.id.iv_choose)
    ImageView iv_choose;

    private FragmentManager mFragmentManager;
    private Fragment course_fragment, activity_fragment, video_fragment, me_fragment;
    private Fragment last_fragment, current_fragment;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initEvent() {
        rg_bottom_menu.setOnCheckedChangeListener(this);
        iv_course.setOnClickListener(this);
        iv_activity.setOnClickListener(this);
        iv_video.setOnClickListener(this);
        iv_me.setOnClickListener(this);
    }

    @Override
    public void init() {
        mFragmentManager = getSupportFragmentManager();
        rb_course.setChecked(true);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.iv_course:
                rb_course.setChecked(true);
                break;
            case R.id.iv_activity:
                rb_activity.setChecked(true);
                break;
            case R.id.iv_video:
                rb_video.setChecked(true);
                break;
            case R.id.iv_me:
                rb_me.setChecked(true);
                break;
        }

    }

    private void showCity(boolean show) {
        if (show) {
            tv_city.setVisibility(View.VISIBLE);
            iv_choose.setVisibility(View.VISIBLE);
        } else {
            tv_city.setVisibility(View.INVISIBLE);
            iv_choose.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        String title = "";
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        last_fragment = current_fragment;
        if (last_fragment != null)
            transaction.hide(last_fragment);
        switch (checkedId) {
            case R.id.rb_course:
                title = getString(R.string.course);
                iv_course.setImageResource(R.mipmap.tab_course_active);
                iv_activity.setImageResource(R.mipmap.tab_activity);
                iv_video.setImageResource(R.mipmap.tab_video);
                iv_me.setImageResource(R.mipmap.tab_me);
                showCity(true);
                if (course_fragment == null) {
                    course_fragment = new CourseFragment();
                    transaction.add(R.id.fl_fragment, course_fragment);
                } else {
                    transaction.show(course_fragment);
                }
                current_fragment = course_fragment;
                break;
            case R.id.rb_activity:
                title = getString(R.string.activity);
                iv_course.setImageResource(R.mipmap.tab_course);
                iv_activity.setImageResource(R.mipmap.tab_activity_active);
                iv_video.setImageResource(R.mipmap.tab_video);
                iv_me.setImageResource(R.mipmap.tab_me);
                showCity(true);
                if (activity_fragment == null) {
                    activity_fragment = new ActivityFragment();
                    transaction.add(R.id.fl_fragment, activity_fragment);
                } else {
                    transaction.show(activity_fragment);
                }
                current_fragment = activity_fragment;
                break;
            case R.id.rb_video:
                title = getString(R.string.video);
                iv_course.setImageResource(R.mipmap.tab_course);
                iv_activity.setImageResource(R.mipmap.tab_activity);
                iv_video.setImageResource(R.mipmap.tab_video_active);
                iv_me.setImageResource(R.mipmap.tab_me);
                showCity(false);
                if (video_fragment == null) {
                    video_fragment = new VideoFragment();
                    transaction.add(R.id.fl_fragment, video_fragment);
                } else {
                    transaction.show(video_fragment);
                }
                current_fragment = video_fragment;
                break;
            case R.id.rb_me:
                title = getString(R.string.me);
                iv_course.setImageResource(R.mipmap.tab_course);
                iv_activity.setImageResource(R.mipmap.tab_activity);
                iv_video.setImageResource(R.mipmap.tab_video);
                iv_me.setImageResource(R.mipmap.tab_me_active);
                showCity(false);
                if (me_fragment == null) {
                    me_fragment = new MeFragment();
                    transaction.add(R.id.fl_fragment, me_fragment);
                } else {
                    transaction.show(me_fragment);
                }
                current_fragment = me_fragment;
                break;
        }
        transaction.commit();
        tv_title.setText(title);
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }
}
