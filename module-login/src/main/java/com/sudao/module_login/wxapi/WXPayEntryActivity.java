//package com.sudao.module_login.wxapi;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//
//import com.kuaicto.lebao.consts.Consts;
//import com.kuaicto.lebao.rxbus.RxBus;
//import com.kuaicto.lebao.util.ToastUtil;
//import com.tencent.mm.opensdk.constants.ConstantsAPI;
//import com.tencent.mm.opensdk.modelbase.BaseReq;
//import com.tencent.mm.opensdk.modelbase.BaseResp;
//import com.tencent.mm.opensdk.openapi.IWXAPI;
//import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
//import com.tencent.mm.opensdk.openapi.WXAPIFactory;
//
///**
// * Created by pan jh on 2017/6/22.
// */
//
//public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
//
//    private static final String TAG = "WXPayEntryActivity";
//
//    private IWXAPI api;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.pay_result);
//
//        api = WXAPIFactory.createWXAPI(this, "");
//        api.handleIntent(getIntent(), this);
//    }
//
//    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        setIntent(intent);
//        api.handleIntent(intent, this);
//    }
//
//    @Override
//    public void onReq(BaseReq req) {
//    }
//
//    @Override
//    public void onResp(BaseResp resp) {
//        Log.d(TAG, "onPayFinish, errCode = " + resp.errCode);
//        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
//            if (resp.errCode == 0) {
//                ToastUtil.getInstance(this).showToast("支付成功");
//                RxBus.get().post(Consts.WX_PAY_SUCCESS, "");
//            } else {
//                ToastUtil.getInstance(this).showToast("支付失败，请重试");
//                RxBus.get().post(Consts.WX_PAY_FAIL, "");
//            }
//        }
//        /*if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle(R.string.app_tip);
//            builder.setMessage(getString(R.string.pay_result_callback_msg, String.valueOf(resp.errCode)));
//            builder.show();
//        }*/
//        finish();
//    }
//}
