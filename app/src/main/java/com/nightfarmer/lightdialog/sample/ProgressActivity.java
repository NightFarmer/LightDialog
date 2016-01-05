package com.nightfarmer.lightdialog.sample;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.nightfarmer.lightdialog.progress.ProgressHUD;

/**
 * Created by zhangfan on 16-1-4.
 */
public class ProgressActivity extends AppCompatActivity {

    private ProgressHUD mSVProgressHUD;
    int progress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mSVProgressHUD = new ProgressHUD(this);
    }

    public void show(View view){
        mSVProgressHUD.show();
    }
    public void showWithMaskType(View view){
        mSVProgressHUD.showWithMaskType(ProgressHUD.SVProgressHUDMaskType.Clear);
//        mSVProgressHUD.showWithMaskType(ProgressHUD.SVProgressHUDMaskType.Black);
//        mSVProgressHUD.showWithMaskType(ProgressHUD.SVProgressHUDMaskType.BlackCancel);
//        mSVProgressHUD.showWithMaskType(ProgressHUD.SVProgressHUDMaskType.Clear);
//        mSVProgressHUD.showWithMaskType(ProgressHUD.SVProgressHUDMaskType.ClearCancel);
//        mSVProgressHUD.showWithMaskType(ProgressHUD.SVProgressHUDMaskType.Gradient);
//        mSVProgressHUD.showWithMaskType(ProgressHUD.SVProgressHUDMaskType.GradientCancel);
    }
    public void showWithStatus(View view){
        mSVProgressHUD.showWithStatus("加载中...");
    }
    public void showInfoWithStatus(View view){
        mSVProgressHUD.showInfoWithStatus("这是提示", ProgressHUD.SVProgressHUDMaskType.Clear);
    }
    public void showSuccessWithStatus(View view){
        mSVProgressHUD.showSuccessWithStatus("恭喜，提交成功！");
    }
    public void showErrorWithStatus(View view){
        mSVProgressHUD.showErrorWithStatus("不约，叔叔我们不约～", ProgressHUD.SVProgressHUDMaskType.GradientCancel);
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progress = progress + 1;
            if (mSVProgressHUD.getProgressBar().getMax() != mSVProgressHUD.getProgressBar().getProgress()) {
                mSVProgressHUD.getProgressBar().setProgress(progress);
                mSVProgressHUD.setText("进度 "+progress+"%");

                mHandler.sendEmptyMessageDelayed(0,100);
            }
            else{
                mSVProgressHUD.dismiss();
            }

        }
    };
    public void showWithProgress(View view){
        progress = 0;
        mSVProgressHUD.getProgressBar().setProgress(progress);//先重设了进度再显示，避免下次再show会先显示上一次的进度位置所以要先将进度归0
        mSVProgressHUD.showWithProgress("进度 " + progress + "%", ProgressHUD.SVProgressHUDMaskType.Black);
        mHandler.sendEmptyMessageDelayed(0,100);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
        {
            if(mSVProgressHUD.isShowing()){
                mSVProgressHUD.dismiss();
                mHandler.removeCallbacksAndMessages(null);
                return false;
            }
        }

        return super.onKeyDown(keyCode, event);

    }
}
