package com.mrc.vidiohuoshandemo.View;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrc.vidiohuoshandemo.Adapter.PagerAdapter.MyViewPagerAdapter;
import com.mrc.vidiohuoshandemo.Fragment.LiveFragment;
import com.mrc.vidiohuoshandemo.Fragment.Video_Fragment;
import com.mrc.vidiohuoshandemo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    public void show(View view) {
        dialog = new Dialog(this, R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.bottom_dialog, null);
        //初始化控件
        edit_phone = (EditText) inflate.findViewById(R.id.edit_phone);
        next_jump = (Button) inflate.findViewById(R.id.next_jump);
        guanbi = inflate.findViewById(R.id.guanbi);
        guanbi.setOnClickListener(this);
        next_jump.setOnClickListener(this);
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
                Intent intent_sousuo = new Intent(this,SousuoActivity.class);
                startActivity(intent_sousuo);
                break;
            case R.id.login_button:
                show(inflate);
                break;
            case R.id.guanbi:
                hide();
                break;
            case R.id.next_jump:
                Intent intent_inlogin = new Intent(this,Main2Activity.class);
                startActivity(intent_inlogin);
                break;
        }

    }
}
