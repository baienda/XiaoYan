package com.baienda.xiaoyan.mvp.view.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.presenter.MainPresenter;
import com.baienda.xiaoyan.mvp.view.fragment.ActivityFragment;
import com.baienda.xiaoyan.mvp.view.fragment.CourseFragment;
import com.baienda.xiaoyan.mvp.view.fragment.MeFragment;
import com.baienda.xiaoyan.mvp.view.fragment.VideoFragment;
import com.baienda.xiaoyan.utils.system.SystemUtil;

import butterknife.BindView;

public class MainActivity extends MVPBaseActivity<MainPresenter> implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_city)
    TextView tv_city;

    @BindView(R.id.iv_config)
    ImageView iv_config;

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

    @BindView(R.id.rl_title_wrapper)
    RelativeLayout rl_title_wrapper;

    private TextView tv_notification_setting;
    private TextView tv_check_update;
    private TextView tv_change_password;
    private TextView tv_share_to_friend;
    private TextView tv_log_out;

    private FragmentManager mFragmentManager;
    private Fragment course_fragment, activity_fragment, video_fragment, me_fragment;
    private Fragment content_fragment;
    private PopupWindow config_window;
    private int config_offset;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initEvent() {
        rg_bottom_menu.setOnCheckedChangeListener(this);
        tv_city.setOnClickListener(this);
        iv_config.setOnClickListener(this);
    }

    @Override
    public void init() {
        mFragmentManager = getSupportFragmentManager();
        course_fragment = new CourseFragment();
        content_fragment = course_fragment;
        mFragmentManager.beginTransaction()
                .add(R.id.fl_fragment, course_fragment)
                .commit();
        initTabs();
    }

    private void initTabs() {
        int course_height = rb_course.getCompoundDrawables()[1].getMinimumHeight();
        int activity_height = rb_activity.getCompoundDrawables()[1].getMinimumHeight();
        int video_height = rb_video.getCompoundDrawables()[1].getMinimumHeight();
        int me_height = rb_me.getCompoundDrawables()[1].getMinimumHeight();
        int max_1 = Math.max(course_height, activity_height);
        int max_2 = Math.max(video_height, video_height);
        int max = Math.max(max_1, max_2);
        rb_course.setPadding(0, (max - course_height) / 2, 0, 0);
        rb_activity.setPadding(0, (max - activity_height) / 2, 0, 0);
        rb_video.setPadding(0, (max - video_height) / 2, 0, 0);
        rb_me.setPadding(0, (max - me_height) / 2, 0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_city:
                startActivityForResult(ChooseCityActivity.class, 100);
                break;
            case R.id.iv_config:
                if (config_window == null) {
                    View content = LayoutInflater.from(this).inflate(R.layout.content_config, null);
                    tv_notification_setting = (TextView) content.findViewById(R.id.tv_notification_setting);
                    tv_check_update = (TextView) content.findViewById(R.id.tv_check_update);
                    tv_change_password = (TextView) content.findViewById(R.id.tv_change_password);
                    tv_share_to_friend = (TextView) content.findViewById(R.id.tv_share_to_friend);
                    tv_log_out = (TextView) content.findViewById(R.id.tv_log_out);
                    tv_notification_setting.setOnClickListener(this);
                    tv_check_update.setOnClickListener(this);
                    tv_change_password.setOnClickListener(this);
                    tv_share_to_friend.setOnClickListener(this);
                    tv_log_out.setOnClickListener(this);
                    content.measure(0, 0);
                    config_window = new PopupWindow(this);
                    config_window.setContentView(content);
                    config_window.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
                    config_window.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                    //去除PopupWindow的黑边
                    config_window.setBackgroundDrawable(null);
                    //让PopupWindow出现在屏幕右侧
                    config_offset = (int) (SystemUtil.getScreenWidth(this) - content.getMeasuredWidth());
                }
                if (config_window.isShowing())
                    config_window.dismiss();
                else
                    config_window.showAsDropDown(rl_title_wrapper, config_offset, 0);
                break;
            case R.id.tv_notification_setting:
                startActivity(NotificationSettingActivity.class);
                break;
            case R.id.tv_check_update:
                Log.e("======", "1");
                break;
            case R.id.tv_change_password:
                startActivity(ChangePasswordActivity.class);
                break;
            case R.id.tv_share_to_friend:
                Log.e("======", "3");
                break;
            case R.id.tv_log_out:
                Log.e("======", "4");
                break;
        }
    }

    private void showCity(boolean show) {
        if (show) {
            tv_city.setVisibility(View.VISIBLE);
        } else {
            tv_city.setVisibility(View.INVISIBLE);
        }
    }

    private void showConfig(boolean show) {
        if (show) {
            iv_config.setVisibility(View.VISIBLE);
        } else {
            iv_config.setVisibility(View.INVISIBLE);
            if (config_window != null && config_window.isShowing())
                config_window.dismiss();
        }
    }

    public void switchContent(Fragment to) {
        if (content_fragment != to) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(content_fragment).add(R.id.fl_fragment, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(content_fragment).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
            content_fragment = to;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_course:
                tv_title.setText(getString(R.string.course));
                showCity(true);
                showConfig(false);
                switchContent(course_fragment);
                break;
            case R.id.rb_activity:
                tv_title.setText(getString(R.string.activity));
                showCity(true);
                showConfig(false);
                if (activity_fragment == null)
                    activity_fragment = new ActivityFragment();
                switchContent(activity_fragment);
                break;
            case R.id.rb_video:
                tv_title.setText(getString(R.string.video));
                showCity(false);
                showConfig(false);
                if (video_fragment == null)
                    video_fragment = new VideoFragment();
                switchContent(video_fragment);
                break;
            case R.id.rb_me:
                tv_title.setText(getString(R.string.me));
                showCity(false);
                showConfig(true);
                if (me_fragment == null)
                    me_fragment = new MeFragment();
                switchContent(me_fragment);
                break;
        }

    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            String city = data.getStringExtra("city");
            tv_city.setText(city);
        }
    }
}
