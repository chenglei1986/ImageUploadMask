package com.example.imageuploadmask;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import imageuploadmask.ImageUploadMask;
import imageuploadmask.ShapeMask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageView1;
    private ImageView mImageView2;
    private ImageView mImageView3;
    private ImageView mImageView4;

    private ImageView mImageView5;
    private ImageView mImageView6;
    private ImageView mImageView7;
    private ImageView mImageView8;

    private ImageUploadMask mMask1;
    private ImageUploadMask mMask2;
    private ImageUploadMask mMask3;
    private ImageUploadMask mMask4;

    private ImageUploadMask mMask5;
    private ImageUploadMask mMask6;
    private ImageUploadMask mMask7;
    private ImageUploadMask mMask8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView1 = (ImageView) findViewById(R.id.imageView1);
        mImageView2 = (ImageView) findViewById(R.id.imageView2);
        mImageView3 = (ImageView) findViewById(R.id.imageView3);
        mImageView4 = (ImageView) findViewById(R.id.imageView4);
        mImageView5 = (ImageView) findViewById(R.id.imageView5);
        mImageView6 = (ImageView) findViewById(R.id.imageView6);
        mImageView7 = (ImageView) findViewById(R.id.imageView7);
        mImageView8 = (ImageView) findViewById(R.id.imageView8);

        findViewById(R.id.button).setOnClickListener(this);

        mMask1 = new ImageUploadMask.Builder(this)
                .oval(true)
                .direction(ShapeMask.Direction.LTR)
                .maskColorInt(0x88000000)
                .cornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .textColorInt(Color.WHITE)
                .textSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .margin(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics()))
                .bind(mImageView1)
                .build();

        mMask2 = new ImageUploadMask.Builder(this)
                .oval(true)
                .direction(ShapeMask.Direction.RTL)
                .maskColorInt(0x88000000)
                .cornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .textColorInt(Color.WHITE)
                .textSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .margin(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics()))
                .bind(mImageView2)
                .build();

        mMask3 = new ImageUploadMask.Builder(this)
                .oval(true)
                .direction(ShapeMask.Direction.UTD)
                .maskColorInt(0x88000000)
                .cornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .textColorInt(Color.WHITE)
                .textSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .margin(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics()))
                .bind(mImageView3)
                .build();

        mMask4 = new ImageUploadMask.Builder(this)
                .oval(true)
                .direction(ShapeMask.Direction.DTU)
                .maskColorInt(0x88000000)
                .cornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .textColorInt(Color.WHITE)
                .textSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .margin(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics()))
                .bind(mImageView4)
                .build();

        mMask5 = new ImageUploadMask.Builder(this)
                .oval(false)
                .direction(ShapeMask.Direction.LTR)
                .maskColorInt(0x88000000)
                .cornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .textColorInt(Color.WHITE)
                .textSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .margin(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics()))
                .bind(mImageView5)
                .build();

        mMask6 = new ImageUploadMask.Builder(this)
                .oval(false)
                .direction(ShapeMask.Direction.RTL)
                .maskColorInt(0x88000000)
                .cornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .textColorInt(Color.WHITE)
                .textSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .margin(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics()))
                .bind(mImageView6)
                .build();

        mMask7 = new ImageUploadMask.Builder(this)
                .oval(false)
                .direction(ShapeMask.Direction.UTD)
                .maskColorInt(0x88000000)
                .cornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .textColorInt(Color.WHITE)
                .textSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .margin(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics()))
                .bind(mImageView7)
                .build();

        mMask8 = new ImageUploadMask.Builder(this)
                .oval(false)
                .direction(ShapeMask.Direction.DTU)
                .maskColorInt(0x88000000)
                .cornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .textColorInt(Color.WHITE)
                .textSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .margin(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics()))
                .bind(mImageView8)
                .build();

    }

    private CountDownTimer mTimer = new CountDownTimer(10000, 50) {
        @Override
        public void onTick(long millisUntilFinished) {
            float progress = (10000 - millisUntilFinished) * 100f / 10000;
            mMask1.setProgress(progress);
            mMask2.setProgress(progress);
            mMask3.setProgress(progress);
            mMask4.setProgress(progress);
            mMask5.setProgress(progress);
            mMask6.setProgress(progress);
            mMask7.setProgress(progress);
            mMask8.setProgress(progress);
        }

        @Override
        public void onFinish() {
            mMask1.setProgress(100);
            mMask2.setProgress(100);
            mMask3.setProgress(100);
            mMask4.setProgress(100);
            mMask5.setProgress(100);
            mMask6.setProgress(100);
            mMask7.setProgress(100);
            mMask8.setProgress(100);
        }
    };

    @Override
    public void onClick(View v) {
        mTimer.cancel();
        mTimer.start();
    }
}
