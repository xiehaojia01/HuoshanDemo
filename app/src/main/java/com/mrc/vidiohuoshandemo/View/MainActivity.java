package com.mrc.vidiohuoshandemo.View;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mrc.vidiohuoshandemo.Adapter.PagerAdapter.MyViewPagerAdapter;
import com.mrc.vidiohuoshandemo.App.APP;
import com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video.Video_Fragment;
import com.mrc.vidiohuoshandemo.R;
import com.mrc.vidiohuoshandemo.activity.SearchActivity;
import com.mrc.vidiohuoshandemo.common.BaseActivity;
import com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.live.LiveFragment;
import com.mrc.vidiohuoshandemo.util.FirstEvent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mSousuo;
    private TabLayout mIndicator;
    /**
     * 登录/注册
     */
    private TextView mLoginButton;
    private ViewPager mViewPager;
    private List<Fragment> mFragmentList;
    private List<String> mTitleList;
    private View inflate;
    private Dialog dialog;
    private ImageView guanbi;
    private EditText edit_phone;
    private Button next_jump;
    private ImageView qq;
    private ImageView sina;
    private ImageView weixin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        //添加标题
        initTitile();
        //添加fragment
        initFragment();
        //设置适配器
        mViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(), mFragmentList, mTitleList));
        //将tablayout与fragment关联
        mIndicator.setupWithViewPager(mViewPager);
    }

    private void initTitile() {
        mTitleList = new ArrayList<>();
       mTitleList.add("直播");
        mTitleList.add("视频");
        //设置tablayout模式
        mIndicator.setTabMode(TabLayout.MODE_FIXED);
        //tablayout获取集合中的名称
        mIndicator.addTab(mIndicator.newTab().setText(mTitleList.get(0)));
        mIndicator.addTab(mIndicator.newTab().setText(mTitleList.get(1)));
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new LiveFragment());
        mFragmentList.add(new Video_Fragment());
    }

    private void initView() {
        mSousuo = (ImageView) findViewById(R.id.sousuo);
        mIndicator = (TabLayout) findViewById(R.id.indicator);
        mLoginButton = (TextView) findViewById(R.id.login_button);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mSousuo.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
    }
    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
            String iconurl = data.get("iconurl");
            String name = data.get("name");
            //使用EventBus把值传给我的
            EventBus.getDefault().post(new FirstEvent(iconurl, name));
            finish();
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, final Throwable t) {
            Toast.makeText(MainActivity.this, "登录失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };


    public void show(View view) {
        dialog = new Dialog(this, R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.bottom_dialog, null);
        //初始化控件
        edit_phone = (EditText) inflate.findViewById(R.id.edit_phone);
        next_jump = (Button) inflate.findViewById(R.id.next_jump);
        guanbi =(ImageView) inflate.findViewById(R.id.turnoff);
        qq = (ImageView) inflate.findViewById(R.id.QQ_Login);
        sina = (ImageView) inflate.findViewById(R.id.sina_Login);
        weixin = (ImageView) inflate.findViewById(R.id.wechat_Login);
        guanbi.setOnClickListener(this);
        next_jump.setOnClickListener(this);
        qq.setOnClickListener(this);
        sina.setOnClickListener(this);
        weixin.setOnClickListener(this);
        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //dialogWindow.getDecorView().setPadding(5,5,5,5);
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 5;//设置Dialog距离底部的距离
//       将属性设置给窗体
        dialogWindow.setAttributes(lp);
        WindowManager.LayoutParams attributes = dialogWindow.getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
        attributes.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        // 一定要重新设置, 才能生效
        dialogWindow.setAttributes(attributes);
        dialog.show();//显示对话框
    }

    public void hide() {
        dialog.dismiss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.sousuo:
                Intent intent_sousuo = new Intent(this,SearchActivity.class);
                startActivity(intent_sousuo);
                break;
            case R.id.login_button:
                show(inflate);
                break;
            case R.id.turnoff:
                hide();
                break;
            case R.id.QQ_Login:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, authListener);
            break;
            case R.id.wechat_Login:
                UMShareAPI.get(APP.getAppContext()).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, authListener);
                break;
            case R.id.sina_Login:
                UMShareAPI.get(APP.getAppContext()).getPlatformInfo(this, SHARE_MEDIA.SINA, authListener);
            break;
            case R.id.next_jump:
                Intent intent_inlogin = new Intent(this,Main2Activity.class);
                startActivity(intent_inlogin);
                break;
        }

    }
}
