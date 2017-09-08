package com.sudao.module_login.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sudao.module_login.R;
import com.sudao.module_login.interfaces.AbstractLoginStartListener;
import com.sudao.module_login.presenters.RegisterOperation;

/**
 * Created by pcdalao on 2017/9/1.
 */

public class RegisterActivity  extends  BaseLoginActivity{
    private EditText edtPhone;
    private EditText edtPossword;
    private EditText authcode;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        init();
    }

    /**
     * 初始化控件
     */
    public void init(){
        edtPhone=(EditText)findViewById(R.id.edtPhone);
        edtPossword=(EditText)findViewById(R.id.edtPassword);
        authcode=(EditText)findViewById(R.id.edtCode);
    }

    /**
     * 获取验证
     * @param v
     */
    public void Onregist_get_code(View v){
        RegisterOperation registerOperation=new RegisterOperation(RegisterActivity.this,new RegistergetPhonenumberListener(this));
        registerOperation.getAuthCode(edtPhone.getText().toString());
    }

    /**
     * 注册信息提交
     * @param v
     */
    public void OnRegister_submit (View v){
        RegisterOperation registerOperation=new RegisterOperation(RegisterActivity.this,new RegisterStatusListener(this));
        registerOperation.OnRegister(edtPhone.getText().toString(),
                edtPossword.getText().toString(),
                authcode.getText().toString());
    }

}

/**
 * 注册状态监听
 */
class RegisterStatusListener extends AbstractLoginStartListener{
    private  Context context;
    public RegisterStatusListener(Context context){
        this.context=context;
    }
    @Override
    public void onSuccess(String str) {
        super.onSuccess(str);
        Toast.makeText(context,str,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(int code, String str) {
        super.onError(code, str);
        Toast.makeText(context,code+str,Toast.LENGTH_LONG).show();
    }
}
/**
 * 获取验证码状态监听
 */
class RegistergetPhonenumberListener extends AbstractLoginStartListener{
    private  Context context;
    public RegistergetPhonenumberListener(Context context){
        this.context=context;
    }
    @Override
    public void onSuccess(String str) {
        super.onSuccess(str);
        Toast.makeText(context,str,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(int code, String str) {
        super.onError(code, str);
        Toast.makeText(context,code+str,Toast.LENGTH_LONG).show();
    }
}
