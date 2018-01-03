package com.mrc.vidiohuoshandemo.View;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mrc.vidiohuoshandemo.Adapter.PagerAdapter.MyViewPagerAdapter;
import com.mrc.vidiohuoshandemo.App.APP;
import com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video.Video_Fragment;
import com.mrc.vidiohuoshandemo.R;
import com.mrc.vidiohuoshandemo.activity.PhoneLogin_Activity;
import com.mrc.vidiohuoshandemo.activity.SearchActivity;
import com.mrc.vidiohuoshandemo.common.BaseActivity;
import com.mrc.vidiohuoshandemo.model.LiveFragment;
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
    private LinearLayout mLayouHide;

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
        guanbi = (ImageView) inflate.findViewById(R.id.turnoff);
        qq = (ImageView) inflate.findViewById(R.id.QQ_Login);
        sina = (ImageView) inflate.findViewById(R.id.sina_Login);
        weixin = (ImageView) inflate.findViewById(R.id.wechat_Login);
        mLayouHide = (LinearLayout) inflate.findViewById(R.id.layou_hide);
        guanbi.setOnClickListener(this);
        edit_phone.setOnClickListener(this);
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
                Intent intent_sousuo = new Intent(this, SearchActivity.class);
                startActivity(intent_sousuo);
                break;
            case R.id.login_button:
                show(inflate);
                break;
            case R.id.edit_phone:
                Checkout_phoneleght();
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
                Checkout_phone();
                break;
        }
    }

    private void Checkout_phoneleght() {
        String phoneNums=edit_phone.getText().toString();
        if (phoneNums.length() <= 1 && phoneNums == "") {
            return;
        } else {
            mLayouHide.setVisibility(View.GONE);
            next_jump.setVisibility(View.VISIBLE);
        }
    }

    private void Checkout_phone() {
        String phoneNums = edit_phone.getText().toString();
        if (judgePhoneNums(phoneNums) == true) {
            Intent intent = new Intent(this, PhoneLogin_Activity.class);
            intent.putExtra("name",phoneNums);
            startActivity(intent);
        }
    }


    /**
     * 判断手机号码是否合理
     *
     * @param phoneNums
     */
    private boolean judgePhoneNums(String phoneNums) {
        if (isMatchLength(phoneNums, 11)
                && isMobileNO(phoneNums)) {
            return true;
        }
        Toast.makeText(this, "手机号码输入有误！", Toast.LENGTH_SHORT).show();
        return false;
    }

    /**
     * 判断一个字符串的位数
     *
     * @param str
     * @param length
     * @return
     */
    public static boolean isMatchLength(String str, int length) {
        if (str.isEmpty()) {
            return false;
        } else {
            return str.length() == length ? true : false;
        }
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobileNums) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
         * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
         * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
         */
        String telRegex = "[1][358]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobileNums))
            return false;
        else
            return mobileNums.matches(telRegex);
    }
}
