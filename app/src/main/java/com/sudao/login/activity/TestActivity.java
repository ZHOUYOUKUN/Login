package com.sudao.login.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;


import com.sudao.module_login.R;
import com.sudao.module_login.activity.LoginActivity;

/**
 * Created by pcdalao on 2017/8/30.
 */

public class TestActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startIntent();
    }
    public void startIntent(){
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();

    }
}
