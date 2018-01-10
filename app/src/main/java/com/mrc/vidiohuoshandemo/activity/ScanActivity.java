package com.mrc.vidiohuoshandemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.activity.CaptureActivity;
import com.mrc.vidiohuoshandemo.R;

public class ScanActivity extends AppCompatActivity implements View.OnClickListener{
//这是扫一扫界面
    private Button mCreates,mScans;
    private ImageView mImage;
    private final static int REQ_CODE = 1028;
    private TextView mHint;
    private TextView mResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        initView();
    }
    private void initView() {
//        mCreates = (Button)findViewById(R.id.btn_create);
        mScans = (Button)findViewById(R.id.btn_scan);

        mImage = (ImageView)findViewById(R.id.iv_image);
        mHint = (TextView)findViewById(R.id.tv_hint);
        mResult = (TextView)findViewById(R.id.tv_result);

//        mCreates.setOnClickListener(this);
        mScans.setOnClickListener(this);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {
            mImage.setVisibility(View.VISIBLE);

//            String result = data.getStringExtra(CaptureActivity.SCAN_QRCODE_RESULT);
//            Bitmap bitmap = data.getParcelableExtra(CaptureActivity.SCAN_QRCODE_BITMAP);
//
//            mResult.setText("扫描结果为：" + result);
//            showToast("扫码结果："+result);
//            if (bitmap != null) {
//                mImage.setImageBitmap(bitmap);
//            }

        }
    }

    private void showToast(String msg) {
        Toast.makeText(ScanActivity.this, "" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.btn_create :
//                //生成二维码
//                String content = "杨群";
//                Bitmap bitmap = null;
//                try {
//                    bitmap = BitmapUtils.create2DCode(content);
//                    mImage.setVisibility(View.VISIBLE);
//                    mHint.setVisibility(View.GONE);
//                    mImage.setImageBitmap(bitmap);
//                }catch (Exception e) {
//                    e.printStackTrace();
//                }
//                break;
            case R.id.btn_scan :
                //扫码
                Intent intent = new Intent(ScanActivity.this, CaptureActivity.class);
                startActivityForResult(intent,REQ_CODE);
                break;

            default:
                break;
        }
    }
}
