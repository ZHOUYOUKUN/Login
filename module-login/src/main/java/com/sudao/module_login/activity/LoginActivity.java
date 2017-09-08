package com.sudao.module_login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sudao.module_login.R;
import com.sudao.module_login.interfaces.AbstractLoginStartListener;
import com.sudao.module_login.presenters.LoginOperation;
import com.umeng.socialize.UMShareAPI;

/**
 * 登录界面
 */
public class LoginActivity extends BaseLoginActivity {
    public EditText usernameEdt;
    public EditText passwordEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initview();
        LoginOperation loginOpt=new LoginOperation(this,new LoginStart());
        Log.d("TAG","loginOpt.isLogin()"+loginOpt.isLogin());
        if(loginOpt.isLogin()){
            Toast.makeText(this,"已经登录过",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG","loginOpt.isLogin()");
    }

    /**
     * 控件初始化
     */
    public void initview(){
        usernameEdt=(EditText) findViewById(R.id.edtPhone);
        passwordEdt=(EditText) findViewById(R.id.edtPassword);
    }

    /**
     * 用户名密码登录点击事件处理
     * @param view
     */
    public void onClickLoginButton(View view) {

        String username=usernameEdt.getText().toString();
        String password=passwordEdt.getText().toString();

        if((null!=username && !"".equals(username))&&(null!=password && !"".equals(password))){
            LoginOperation loginOpt=new LoginOperation(this,new LoginStart());
            loginOpt.login(username, password);
        }
        else{
            Toast.makeText(this,"输入为空",Toast.LENGTH_LONG).show();
        }

    }
    /**
     * 点击qq登录
     * @param v
     */
    public void qqLogin(View v){
        LoginOperation loginOpt=new LoginOperation(this,new LoginStart());
        loginOpt.qqLogin();
    }

    /**
     * 点击微信登录
     * @param v
     */
    public void weixinLogin(View v){
        LoginOperation loginOpt=new LoginOperation(this,new LoginStart());
        loginOpt.wechatLogin(this);
    }

    /**
     * 注册
     * @param v
     */
    public void OnRegister(View v){
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * 登录状态返回，ui更新
     */
    class LoginStart extends AbstractLoginStartListener {

        @Override
        public void onSuccess(String str) {
            Toast.makeText(getApplicationContext(),"登录成功"+str,Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(int code, String str) {
            Toast.makeText(getApplicationContext(),"登录失败，code"+code+"message"+str,Toast.LENGTH_LONG).show();
        }
    }
    /**
     * 登录成功回调
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //友盟第三方登录回调
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }


}
