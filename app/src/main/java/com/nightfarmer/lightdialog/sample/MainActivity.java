package com.nightfarmer.lightdialog.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by zhangfan on 16-1-4.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openProgressActivity(View view){
        startActivity(new Intent(this, ProgressActivity.class));
    }

    public void openAlertActivity(View view){
        startActivity(new Intent(this, AlertActivity.class));
    }


    public void openPickerActivity(View view){
        startActivity(new Intent(this, PickerActivity.class));
    }


}
