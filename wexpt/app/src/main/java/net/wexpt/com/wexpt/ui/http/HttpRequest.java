//package net.wexpt.com.wexpt.ui.http;
//
//import android.app.ActivityManager;
//import android.content.ComponentName;
//import android.content.Context;
//import android.os.Handler;
//import android.os.Message;
//import android.text.TextUtils;
//import android.util.Log;
//
//import com.google.gson.Gson;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import okhttp3.Request;
//
///**
// * Created by vvguoliang on 2017/9/19.
// * <p>
// * 请求数据封装
// */
//
//@SuppressWarnings("JavaDoc")
//public class HttpRequest implements HttpRequestIn {
//
//    @Override
//    public void setPublic(Context context, Map<String, Object> map, Handler mHnadler, String url, String name) {
//        if (!PhoneDevice.getInstance().isNetworkConnected( context )) {
//            ToatUtils.showShort( context, "    您的网络不给力!\n 请在网络好的地方使用" );
//        } else {
////            isShowAct = isForeground( context, context.getClass().getName() );
////            if (context instanceof Activity && isShowAct) {
////                waitDialog = new ViewLoading( context );
////                waitDialog.show();
////            } else {
////                if (waitDialog != null) {
////                    waitDialog.dismiss();
////                }
////            }
//            OkHttpManager.postAsync( url, name, HttpOnekey.getInstance().setMap( context, map ),
//                    new DataCallBack() {
//                        @Override
//                        public void requestFailure(Request request, String name, IOException e) {
////                            if (waitDialog != null) {
////                                waitDialog.dismiss();
////                            }
//                            if (name.equals( "APK_UPGRADE" )) {
//                                DialogUtils.getInstance().getVersionUpdateDialog( context, "1", "", "", mHnadler );
//                            }
//                            ToatUtils.showShort1( context, "超时" );
//                        }
//
//                        @Override
//                        public void requestSuccess(String result, String name) throws Exception {
////                            if (waitDialog != null && context instanceof Activity && isShowAct) {
////                                waitDialog.dismiss();
////                            }
//                            DataEntity dataEntity = gson.fromJson( result, DataEntity.class );
////                        String s = HttpOnekey.getInstance().setAesDecry( AS"PxFkOnUTWfD5qe8mBDlfkIWDUy4zUgnaR4+dSnc8dtaJ5+2+1Pb9ssvyNSJyzZnqMLpke8wzIGBrloL4juA1V+Wa8EC4tjamj1AkdmhHNqQBLA0cn6a8tZccP/xDZetHF4QrC4nkuqpipL/SMfQxEuzRnWySrNhtDEo8XKM41qW147tz5eBWR7tSkFJv5QAaUagBTVaJlscF+FYn+kQk0iPXVXFf7Prl12geeTnqFuWRCHyTkfwZ5DKU5OlrtU9hWH89rPSvJopV0JKqN5+9PVr+ahCAYOHue+RMBLQMSlrPqSMyaQmMIFR4/cBaL+Um0VpmlXm0e9Y2a8GuMGlCccAx49HA7Wm55wfDrcoNWDvvs87M+oxhtvHGcMriqkVf9FgVRCLvLrJDcwqUj9fLv21zX/FQLpEkW3LcIjUaa24u0tSD8x03/puj5QR0+7yK84Pi30r1B8Ql4JP0ZxLn17E69ZqRqbAVT3hIkL2jGsCRaQcB9aKRu4QB+OqpUX3W", SharedPreferencesUtils.get( context, "jiami", "" ).toString() );
//                            if (HttpOnekey.getInstance().setBoolen( context, dataEntity.getCode(), dataEntity.getMsg(), mHnadler )) {
//                                switch (name) {
//                                    case "USER_REGISTER":
//                                        getUSER_REGISTER( context, dataEntity.getData(), mHnadler );//注册
//                                        break;
//                                    case "USER_CODE":
//                                        getUSER_CODE( context, dataEntity.getData(), mHnadler );//验证码
//                                        break;
//                                    case "USER_LOGIN":
//                                        getUSER_LOGIN( context, dataEntity.getData(), mHnadler );//登入
//                                        break;
//                                    case "MODIFY_PASSWORD":
//                                        getMODIFY_PASSWORD( context, dataEntity.getData(), mHnadler );//修改密码和忘记密码
//                                        break;
//                                    case "FORGET_PASSWORD":
//                                        getFORGET_PASSWORD( context, dataEntity.getData(), mHnadler );//修改密码和忘记密码
//                                        break;
//                                    case "WIFI_ADDRESS":
//                                        getWIFI_ADDRESS( context, dataEntity.getData(), mHnadler );//WI-FI地址接口
//                                        break;
//                                    case "HOME_PAGE":
//                                        getHOME_PAGE( context, dataEntity.getData(), mHnadler );//首页接口
//                                        break;
//                                    case "INDIVIDUAL_INFORMATION":
//                                        getINDIVIDUAL_INFORMATION( context, dataEntity.getData(), mHnadler );//个人信息接口
//                                        break;
//                                    case "WORK_INFORMATION":
//                                        getWORK_INFORMATION( context, dataEntity.getData(), mHnadler );//工作信息
//                                        break;
//                                    case "CONTACT_PERSON":
//                                        getCONTACT_PERSON( context, dataEntity.getData(), mHnadler );//紧急联系人
//                                        break;
//                                    case "FILLIN_INFORMATION_STATE":
//                                        getFILLIN_INFORMATION_STATE( context, dataEntity.getData(), mHnadler );//个人信息填写
//                                        break;
//                                    case "OCCUPATION_INCOME_LIST":
//                                        getOCCUPATION_INCOME_LIST( context, dataEntity.getData(), mHnadler );//职业和收入下来列表接口
//                                        break;
//                                    case "FILLIN_DATA_STATE":
//                                        getFILLIN_DATA_STATE( context, dataEntity.getData(), mHnadler );// 个人资料填写状态接口
//                                        break;
//                                    case "SESAME_CERTIFICATION":
//                                        getSESAME_CERTIFICATION( context, dataEntity.getData(), mHnadler );//芝麻认证
//                                        break;
//                                    case "MOBILE_PHONE_CARRIER":
//                                        getMOBILE_PHONE_CARRIER( context, dataEntity.getData(), mHnadler );//运营商
//                                        break;
//                                    case "COLLECTION_CARD":
//                                        getCOLLECTION_CARD( context, dataEntity.getData(), mHnadler );//收款银行卡
//                                        break;
//                                    case "ACCOUNT_BANK_CARD":
//                                        getACCOUNT_BANK_CARD( context, dataEntity.getData(), mHnadler );//开户行下拉列表
//                                        break;
//                                    case "BORROWING_RECORD":
//                                        getBORROWING_RECORD( context, dataEntity.getData(), mHnadler );//借款记录
//                                        break;
//                                    case "MINE_BORROWING":
//                                        getMINE_BORROWING( context, dataEntity.getData(), mHnadler );//我的借款
//                                        break;
//                                    case "MINE_BORROWING_CONFIRM_DETAILS"://我的借款确认详情
//                                        getMINE_BORROWING_CONFIRM_DETAILS( context, dataEntity.getData(), mHnadler );
//                                        break;
//                                    case "MINE_BORROWING_DETAILS":
//                                        getMINE_BORROWING_DETAILS( context, dataEntity.getData(), mHnadler );//借款审核状态
//                                        break;
//                                    case "LAUNCH_PAGE":
//                                        getLAUNCH_PAGE( context, dataEntity.getData(), mHnadler );//启动页面
//                                        break;
//                                    case "BORROWING_AUDIT_STATUS":
//                                        getBORROWING_AUDIT_STATUS( context, dataEntity.getData(), mHnadler );//借款审核状态
//                                        break;
//                                    case "NEXT_BORROW":
//                                        getNEXT_BORROW( context, dataEntity.getData(), mHnadler );//借款开始
//                                        break;
//                                    case "BIND_CARD":
//                                        getBIND_CARD( context, dataEntity.getData(), mHnadler );//银行卡类标
//                                        break;
//                                    case "SIGN_CARD":
//                                        getSIGN_CARD( context, dataEntity.getData(), mHnadler );//sign
//                                        break;
//                                    case "EXIT_LOGIN":
//                                        getEXIT_LOGIN( context, dataEntity.getData(), mHnadler );//sign
//                                        break;
//                                    case "CREATE_TASK":
//                                        getCREATE_TASK( context, dataEntity.getData(), mHnadler );//算话
//                                        break;
//                                    case "LOGIN_FORM":
//                                        getLOGIN_FORM( context, dataEntity.getData(), mHnadler );//算话 登入
//                                        break;
//                                    case "GER_CODE":
//                                        getGER_CODE( context, dataEntity.getData(), mHnadler );//算话 短信
//                                        break;
//                                    case "COMMIT_FORM":
//                                        getCOMMIT_FORM( context, dataEntity.getData(), mHnadler );//算话 验证表单
//                                        break;
//                                    case "REFRESH_CODE":
//                                        getREFRESH_CODE( context, dataEntity.getData(), mHnadler );//算话 图片验证
//                                        break;
//                                    case "FACE_PLUS":
//                                        getFACE_PLUS( context, dataEntity.getData(), mHnadler );//Face++
//                                        break;
//                                    case "CREATE_LOGIN":
//                                        getCREATE_LOGIN( context, dataEntity.getData(), mHnadler );//魔盒创建
//                                        break;
//                                    case "BORROW_SWITCH":
//                                        getBORROW_SWITCH( context, dataEntity.getData(), mHnadler );//总开关
//                                        break;
//                                    case "CONFIRM_BORROWING":
//                                        getCONFIRM_BORROWING( context, dataEntity.getData(), mHnadler );//魔盒创建
//                                        break;
//                                    case "RECHARGE_HANDLE":
//                                        getRECHARGE_HANDLE( context, dataEntity.getData(), mHnadler );//充值
//                                        break;
//                                    case "APK_UPGRADE":
//                                        getAPK_UPGRADE( context, dataEntity.getData(), mHnadler );//充值
//                                        break;
//                                    case "PHONE_INFO":
//                                        getPHONE_INFO( context, dataEntity.getData(), mHnadler );//手机信息
//                                        break;
//                                    case "OVER_DUE":
//                                        getOVER_DUE( context, dataEntity.getData(), mHnadler );//逾期接口
//                                        break;
//                                    case "TONGDUN_INFO":
//                                        getTONGDUN_INFO( context, dataEntity.getData(), mHnadler );
//                                        break;
//                                    case "CHECK_CODE":
//                                        getCHECK_CODE( context, dataEntity.getData(), mHnadler );//魔盒的验证码和图形验证码
//                                        break;
//                                    case "CHECK_AGAIN":
//                                        getCHECK_AGAIN( context, dataEntity.getData(), mHnadler );//魔盒重试的验证码和图形验证码
//                                        break;
//                                    case "OPERATOR_SWITCH":
//                                        getOPERATOR_SWITCH( context, dataEntity.getData(), mHnadler );//魔盒与算话开关
//                                        break;
//                                    case "PRE_ORDER":
//                                        getPRE_ORDER( context, dataEntity.getData(), mHnadler );//预订单
//                                        break;
//                                    case "MAGIC_BOX":
//                                        getMAGIC_BOX( context, dataEntity.getData(), mHnadler );//魔盒 H5
//                                        break;
//                                    case "REBACK_H5":
//                                        getREBACK_H5( context, dataEntity.getData(), mHnadler );//魔盒 H5
//                                        break;
//                                    case "MAGICBOX_STATE":
//                                        break;
//                                }
//                            } else {
//                                mHnadler.sendEmptyMessage( 205 );
//                            }
//                        }
//                    } );
//        }
//    }
//
//    @Override
//    public void setWIFI_ADDRESS(Context context, Handler mHandler) {
//        try {
//            String wifiname = PhoneDevice.getInstance().setwifiName( context );
//            String ExternalIP = SharedPreferencesUtils.get( context, "ExternalIP", "" ).toString();
//            String LocalMacAddressFromWifiInfo = SharedPreferencesUtils.get( context, "LocalMacAddressFromWifiInfo", "02:00:00:00:00:00" ).toString();
//            String GPS = SharedPreferencesUtils.get( context, "GPS", "" ).toString();
//            List<Map<String, Object>> list = SharedPreferencesUtils.getInfo( context, GPS );
//            if (list != null && list.size() > 0) {
//                if (!TextUtils.isEmpty( list.get( 0 ).get( "country" ).toString() ) && !TextUtils.isEmpty( list.get( 0 ).get( "province" ).toString() )
//                        && !TextUtils.isEmpty( list.get( 0 ).get( "city" ).toString() ) && !TextUtils.isEmpty( list.get( 0 ).get( "district" ).toString() )
//                        && !TextUtils.isEmpty( list.get( 0 ).get( "address" ).toString() ) && !TextUtils.isEmpty( ExternalIP )
//                        && !LocalMacAddressFromWifiInfo.equals( "02:00:00:00:00:00" )) {
//                    HttpRequest.getInstance().setPublic( context, AfferentDataHttpMap.getInstance().setWIFI_ADDRESS( ExternalIP, LocalMacAddressFromWifiInfo,
//                            list.get( 0 ).get( "country" ).toString() +
//                                    list.get( 0 ).get( "province" ).toString() +
//                                    list.get( 0 ).get( "city" ).toString() +
//                                    list.get( 0 ).get( "district" ).toString() +
//                                    list.get( 0 ).get( "address" ).toString(),
//                            PhoneDevice.getInstance().setLocalIpAddress(),
//                            PhoneDevice.getInstance().setNetWork( context ),
//                            list.get( 0 ).get( "longitude" ).toString(),
//                            list.get( 0 ).get( "latitude" ).toString(),
//                            wifiname,
//                            PhoneDevice.getInstance().setWifi( context ),
//                            Phone.getInstance().setQueryAppInfo( context ) ),
//                            mHandler,
//                            HttpImplements.getInstance().getHttp( context, "WIFI_ADDRESS" ), "WIFI_ADDRESS" );
//                }
//            }
//        } catch (Exception e) {
//            Log.e( HttpRequest.class.getName(), "WIFI_ADDRESS: 获取GPS和WIFI信息失败" );
//        }
//    }
//
//    /**
//     * 单例对象实例
//     */
//    private static class HttpRequestHolder {
//        static final HttpRequest INSTANCE = new HttpRequest();
//    }
//
//    public static HttpRequest getInstance() {
//        return HttpRequestHolder.INSTANCE;
//    }
//
//    /**
//     * private的构造函数用于避免外界直接使用new来实例化对象
//     */
//    private HttpRequest() {
//    }
//
//    private Gson gson = new Gson();
//
//    private Message message;
//
//    private JSONObject object;
//
//    /**
//     * 注册
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getUSER_REGISTER(Context context, String result, Handler mHnadler) {
////        DataEntity dataEntity = gson.fromJson( result, DataEntity.class );
////        if (HttpOnekey.getInstance().setBoolen( context, dataEntity.getCode(), dataEntity.getMsg() )) {
////            try {
////                object = new JSONObject( HttpOnekey.getInstance().setAesDecry( dataEntity.getData(),
////                        HttpOnekey.getInstance().setMD5( context ).substring( HttpOnekey.getInstance().setMD5( context ).
////                                length() - 16, HttpOnekey.getInstance().setMD5( context ).length() ) ) );
////                SharedPreferencesUtils.put( context, "userNumber", object.optString( "userNumber" ) );
//
//        message = new Message();
//        message.what = 1000;
//        mHnadler.sendMessage( message );
////            } catch (JSONException e) {
////                e.printStackTrace();
////            }
////        }
//    }
//
//    /**
//     * 验证码
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getUSER_LOGIN(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//    }
//
//    /**
//     * 验证码
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getUSER_CODE(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            message = new Message();
//            message.what = 1032;
//            message.obj = jsonObject.optString( "state" );
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 修改密码和忘记密码
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getMODIFY_PASSWORD(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            message = new Message();
//            message.what = 1000;
//            message.obj = jsonObject.optString( "state" );
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 修改密码和忘记密码
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getFORGET_PASSWORD(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            message = new Message();
//            message.what = 1018;
//            message.obj = jsonObject.optString( "state" );
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * WIFI 地址接口
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getWIFI_ADDRESS(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//    }
//
//    /**
//     * 首页接口
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getHOME_PAGE(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        HomePageDateEntity homePageDateEntity = gson.fromJson( result, HomePageDateEntity.class );
//        message = new Message();
//        message.what = 1002;
//        message.obj = homePageDateEntity;
//        mHnadler.sendMessage( message );
//    }
//
//    /**
//     * 个人接口
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//
//    private void getINDIVIDUAL_INFORMATION(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            if (jsonObject.has( "state" )) {
//                message = new Message();
//                message.what = 1003;
//                message.obj = jsonObject.optString( "state" );
//            } else {
//                INDIVIDUAL_INFORMATIONdataEntity individual_informatioNdataEntity = gson.fromJson( result, INDIVIDUAL_INFORMATIONdataEntity.class );
//                message = new Message();
//                message.what = 1003;
//                message.obj = individual_informatioNdataEntity;
//            }
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 工作信息接口
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getWORK_INFORMATION(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            if (jsonObject.has( "state" )) {
//                message = new Message();
//                message.what = 1004;
//                message.obj = jsonObject.optString( "state" );
//            } else {
//                WORK_INFORMATIONdataEntitly work_informatioNdataEntitly = gson.fromJson( result, WORK_INFORMATIONdataEntitly.class );
//                message = new Message();
//                message.what = 1004;
//                message.obj = work_informatioNdataEntitly;
//            }
//            mHnadler.sendMessage( message );
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 紧急联系人接口
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getCONTACT_PERSON(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            if (jsonObject.has( "state" )) {
//                message = new Message();
//                message.what = 1005;
//                message.obj = jsonObject.optString( "state" );
//            } else {
//                CONTACT_PERSONdataEntity contact_persoNdataEntity = gson.fromJson( result, CONTACT_PERSONdataEntity.class );
//                message = new Message();
//                message.what = 1005;
//                message.obj = contact_persoNdataEntity;
//            }
//            mHnadler.sendMessage( message );
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 个人信息填写状态接口
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getFILLIN_INFORMATION_STATE(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            String buffer = jsonObject.optString( "personalInfoState" ) +
//                    jsonObject.optString( "workInfoState" ) +
//                    jsonObject.optString( "contactPerInfo" );
//            message = new Message();
//            message.what = 1006;
//            message.obj = buffer;
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 职业后劲儿收入下来列表接口
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getOCCUPATION_INCOME_LIST(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        OCCUPATION_INCOME_LISTdataEntity occupationIncomeLisTdataEntity = gson.fromJson( result, OCCUPATION_INCOME_LISTdataEntity.class );
//        message = new Message();
//        message.what = 1007;
//        message.obj = occupationIncomeLisTdataEntity;
//        mHnadler.sendMessage( message );
//    }
//
//    /**
//     * 个人资料填写状态接口
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getFILLIN_DATA_STATE(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        FILLIN_DATA_STATEdataEntity fillin_data_statEdataEntity = gson.fromJson( result, FILLIN_DATA_STATEdataEntity.class );
//        message = new Message();
//        message.what = 1008;
//        message.obj = fillin_data_statEdataEntity;
//        mHnadler.sendMessage( message );
//
//    }
//
//    /**
//     * 芝麻认证
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getSESAME_CERTIFICATION(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            message = new Message();
//            message.what = 1009;
//            message.obj = jsonObject.optString( "url" );
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    /**
//     * 运营商接口
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getMOBILE_PHONE_CARRIER(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            message = new Message();
//            message.what = 1010;
//            message.obj = jsonObject.optString( "state" );
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 收款银行卡
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getCOLLECTION_CARD(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        message = new Message();
//        message.what = 1011;
//        message.obj = result;
//        mHnadler.sendMessage( message );
//    }
//
//    /**
//     * 开户行下来列表
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getACCOUNT_BANK_CARD(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        ACCOUNT_BANK_CARDdataEntity account_bank_carDdataEntity = gson.fromJson( result, ACCOUNT_BANK_CARDdataEntity.class );
//        message = new Message();
//        message.what = 1012;
//        message.obj = account_bank_carDdataEntity;
//        mHnadler.sendMessage( message );
//    }
//
//    /**
//     * 借款记录
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getBORROWING_RECORD(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            if (jsonObject.has( "state" )) {
//                message = new Message();
//                message.what = 1033;
//                message.obj = jsonObject.optString( "state" );
//                mHnadler.sendMessage( message );
//            } else {
//                JSONObject object = new JSONObject( jsonObject.optString( "data" ) );
//                if (object.optString( "success" ).equals( "1" )) {
//                    JSONObject jsonObject1 = new JSONObject( jsonObject.optString( "data" ) );
//                    message = new Message();
//                    message.what = 1033;
//                    message.obj = jsonObject1.optString( "errorMsg" );
//                    mHnadler.sendMessage( message );
//                } else {
//                    JSONArray array = new JSONArray( object.optString( "data" ) );
//                    List<BORROWING_RECORDdataEntity> borrowing_recorDdataEntityList = new ArrayList<>();
//                    for (int i = 0; array.length() > i; i++) {
//                        JSONObject jsonObject1 = array.optJSONObject( i );
//                        borrowing_recorDdataEntityList.add( gson.fromJson( jsonObject1.toString(), BORROWING_RECORDdataEntity.class ) );
//                    }
//                    message = new Message();
//                    message.what = 1013;
//                    message.obj = borrowing_recorDdataEntityList;
//                    mHnadler.sendMessage( message );
//                }
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 我的借款
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getMINE_BORROWING(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            JSONObject jsonObject1 = new JSONObject( jsonObject.optString( "data" ) );
//            if (jsonObject1.optString( "success" ).equals( "1" )) {
//                message = new Message();
//                message.what = 1035;
//                message.obj = jsonObject1.optString( "errorMsg" );
//                mHnadler.sendMessage( message );
//            } else {
//                JSONObject object = new JSONObject( result );
//                JSONObject object1 = new JSONObject( object.optString( "data" ) );
//                JSONObject object2 = new JSONObject( object1.optString( "data" ) );
//                MINE_BORROWINGdataEntity mine_borrowinGdataEntity = gson.fromJson( object2.toString(), MINE_BORROWINGdataEntity.class );
//                message = new Message();
//                message.what = 1014;
//                message.obj = mine_borrowinGdataEntity;
//                mHnadler.sendMessage( message );
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 我的借款确认详情
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getMINE_BORROWING_CONFIRM_DETAILS(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        MINE_BORROWING_CONFIRM_DETAILSdataEntity mine_borrowing_confirm_detailSdataEntity = gson.fromJson( result,
//                MINE_BORROWING_CONFIRM_DETAILSdataEntity.class );
//        message = new Message();
//        message.what = 1015;
//        message.obj = mine_borrowing_confirm_detailSdataEntity;
//        mHnadler.sendMessage( message );
//    }
//
//    /**
//     * 借款审核状态
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getMINE_BORROWING_DETAILS(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        message = new Message();
//        message.what = 1016;
//        message.obj = "";
//        mHnadler.sendMessage( message );
//    }
//
//    /**
//     * 启动页面
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getLAUNCH_PAGE(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        message = new Message();
//        message.what = 1017;
//        message.obj = "";
//        mHnadler.sendMessage( message );
//    }
//
//    /**
//     * 借款审核状态
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getBORROWING_AUDIT_STATUS(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            BORROWING_AUDIT_STATUSdataEntity borrowing_audit_statuSdataEntity = gson.fromJson( jsonObject.toString(), BORROWING_AUDIT_STATUSdataEntity.class );
//            message = new Message();
//            message.what = 1017;
//            message.obj = borrowing_audit_statuSdataEntity;
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 借款开始
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getNEXT_BORROW(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        NEXT_BORROWdataEntity next_borroWdataEntity = gson.fromJson( result, NEXT_BORROWdataEntity.class );
//        message = new Message();
//        message.what = 1019;
//        message.obj = next_borroWdataEntity;
//        mHnadler.sendMessage( message );
//    }
//
//    /**
//     * 借款开始
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getBIND_CARD(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            JSONArray array = new JSONArray( jsonObject.optString( "card" ) );
//            List<BIND_CARDdataEntity> bind_carDdataEntityList = new ArrayList<>();
//            for (int i = 0; array.length() > i; i++) {
//                JSONObject jsonObject1 = array.optJSONObject( i );
//                bind_carDdataEntityList.add( gson.fromJson( jsonObject1.toString(), BIND_CARDdataEntity.class ) );
//            }
//            message = new Message();
//            message.what = 1020;
//            message.obj = bind_carDdataEntityList;
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * sing
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getSIGN_CARD(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        message = new Message();
//        message.what = 1021;
//        message.obj = result;
//        mHnadler.sendMessage( message );
//    }
//
//    /**
//     * sing
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getEXIT_LOGIN(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            message = new Message();
//            message.what = 1022;
//            message.obj = jsonObject.optString( "state" );
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 算话 创建
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getCREATE_TASK(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            jsonObject = new JSONObject( jsonObject.optString( "data" ) );
//            message = new Message();
//            message.what = 1023;
//            message.obj = jsonObject.toString();
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 算话 登入
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getLOGIN_FORM(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            jsonObject = new JSONObject( jsonObject.optString( "data" ) );
//            message = new Message();
//            message.what = 1024;
//            message.obj = jsonObject.toString();
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 算话 短信
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getGER_CODE(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            jsonObject = new JSONObject( jsonObject.optString( "data" ) );
//            message = new Message();
//            message.what = 1025;
//            message.obj = jsonObject.toString();
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 算话 验证表单
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getCOMMIT_FORM(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            jsonObject = new JSONObject( jsonObject.optString( "data" ) );
//            message = new Message();
//            message.what = 1026;
//            message.obj = jsonObject.toString();
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 算话 图片验证
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getREFRESH_CODE(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            JSONObject jsonObject1 = new JSONObject( jsonObject.optString( "data" ) );
//            message = new Message();
//            message.what = 1027;
//            message.obj = jsonObject1.toString();
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Face++
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getFACE_PLUS(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            JSONObject jsonObject1 = new JSONObject( jsonObject.optString( "data" ) );
//            if (jsonObject1.optString( "msgcode" ).equals( "1" )) {
//                message = new Message();
//                message.what = 1028;
//                message.obj = "state";
//                mHnadler.sendMessage( message );
//            } else {
//                message = new Message();
//                message.what = 1028;
//                message.obj = jsonObject1.optString( "errormsg" );
//                mHnadler.sendMessage( message );
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 魔盒
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getCREATE_LOGIN(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            jsonObject = new JSONObject( jsonObject.optString( "data" ) );
//            message = new Message();
//            if (jsonObject.has( "code" ) && jsonObject.optString( "code" ).equals( "100" )) {
//                message.what = 1050;
//                mHnadler.sendMessage( message );
//            } else if (jsonObject.has( "code" ) && jsonObject.optString( "code" ).equals( "101" )) {//图形验证码
//                message.what = 1051;
//                message.obj = jsonObject.toString();
//                mHnadler.sendMessage( message );
//            } else if (jsonObject.has( "code" ) && jsonObject.optString( "code" ).equals( "105" )) {//短信验证码
//                message.what = 1052;
//                message.obj = jsonObject.toString();
//                mHnadler.sendMessage( message );
//            } else if (jsonObject.has( "code" ) && jsonObject.optString( "code" ).equals( "123" )) {//图片+手机验证码
//                message.what = 1054;
//                message.obj = jsonObject.toString();
//                mHnadler.sendMessage( message );
//            } else if (jsonObject.has( "code" ) && (jsonObject.optString( "code" ).equals( "104" ) ||
//                    jsonObject.optString( "code" ).equals( "108" ) || jsonObject.optString( "code" ).equals( "122" )
//                    || jsonObject.optString( "code" ).equals( "124" ))) {//重试
//                message.what = 1053;
//                mHnadler.sendMessage( message );
//            } else if (jsonObject.has( "code" ) && (jsonObject.optString( "code" ).equals( "137" ) || jsonObject.optString( "code" ).equals( "2007" ))) {
//                message.what = 1029;
//                message.obj = "成功";
//                mHnadler.sendMessage( message );
//            } else {
//                message.what = 1029;
//                message.obj = "服务密码错误，请重试";
//                mHnadler.sendMessage( message );
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 用户借款开关
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getBORROW_SWITCH(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            message = new Message();
//            message.what = 1030;
////            message.obj = "1";
//            message.obj = jsonObject.optString( "checking" );
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 点击借款
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getCONFIRM_BORROWING(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            String success;
//            JSONObject jsonObject = new JSONObject( result );
//            JSONObject jsonObject1 = new JSONObject( jsonObject.optString( "data" ) );
//            if (jsonObject1.optString( "success" ).equals( "0" )) {
//                success = "0";
//            } else {
//                success = jsonObject1.optString( "errorMsg" );
//            }
//            message = new Message();
//            message.what = 1031;
//            message.obj = success;
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 充值
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getRECHARGE_HANDLE(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            JSONObject jsonObject1 = new JSONObject( jsonObject.optString( "data" ) );
//            JSONObject jsonObject2 = new JSONObject( jsonObject1.optString( "data" ) );
//            message = new Message();
//            message.what = 1040;
//            message.obj = jsonObject2.toString();
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 升级
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getAPK_UPGRADE(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            String state;
//            JSONObject jsonObject = new JSONObject( result );
//            state = result;
//            if (jsonObject.has( "state" )) {
//                state = jsonObject.optString( "state" );
//            }
//            message = new Message();
//            message.what = 1041;
//            message.obj = state;
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 手机信息
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getPHONE_INFO(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            String state;
//            JSONObject jsonObject = new JSONObject( result );
//            state = result;
//            if (jsonObject.has( "state" )) {
//                state = jsonObject.optString( "state" );
//            }
//            message = new Message();
//            message.what = 1042;
//            message.obj = state;
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 逾期接口
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getOVER_DUE(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            String state;
//            JSONObject jsonObject = new JSONObject( result );
//            if (jsonObject.has( "state" )) {
//                state = jsonObject.optString( "state" );
//                message = new Message();
//                message.what = 1043;
//                message.obj = state;
//                mHnadler.sendMessage( message );
//            } else {
//                JSONObject jsonObject1 = new JSONObject( jsonObject.optString( "data" ) );
//                JSONObject jsonObject2 = new JSONObject( jsonObject1.optString( "data" ) );
//                MINE_BORROWINGdataEntity mine_borrowinGdataEntity = gson.fromJson( jsonObject2.toString(), MINE_BORROWINGdataEntity.class );
//                message = new Message();
//                message.what = 1044;
//                message.obj = mine_borrowinGdataEntity;
//                mHnadler.sendMessage( message );
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 魔盒验证码和图形
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getCHECK_CODE(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            jsonObject = new JSONObject( jsonObject.optString( "data" ) );
//            message = new Message();
//            if (jsonObject.has( "code" ) && jsonObject.optString( "code" ).equals( "100" )) {
//                message.what = 1050;
//                mHnadler.sendMessage( message );
//            } else if (jsonObject.has( "code" ) && jsonObject.optString( "code" ).equals( "101" )) {//图形验证码
//                message.what = 1051;
//                message.obj = jsonObject.toString();
//                mHnadler.sendMessage( message );
//            } else if (jsonObject.has( "code" ) && jsonObject.optString( "code" ).equals( "105" )) {//短信验证码
//                message.what = 1052;
//                message.obj = jsonObject.toString();
//                mHnadler.sendMessage( message );
//            } else if (jsonObject.has( "code" ) && jsonObject.optString( "code" ).equals( "123" )) {//图片+手机验证码
//                message.what = 1054;
//                message.obj = jsonObject.toString();
//                mHnadler.sendMessage( message );
//            } else if (jsonObject.has( "code" ) && (jsonObject.optString( "code" ).equals( "104" ) ||
//                    jsonObject.optString( "code" ).equals( "108" ) || jsonObject.optString( "code" ).equals( "122" )
//                    || jsonObject.optString( "code" ).equals( "124" ))) {//重试
//                message.what = 1053;
//                mHnadler.sendMessage( message );
//            } else if (jsonObject.has( "code" ) && (jsonObject.optString( "code" ).equals( "137" ) || jsonObject.optString( "code" ).equals( "2007" ))) {
//                message.what = 1029;
//                message.obj = "成功";
//                mHnadler.sendMessage( message );
//            } else {
//                message.what = 1029;
//                message.obj = "服务密码错误，请重试";
//                mHnadler.sendMessage( message );
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 魔盒重试验证码和图形
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getCHECK_AGAIN(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            message = new Message();
//            message.what = 1047;
//            message.obj = jsonObject.toString();
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 魔盒重试验证码和图形
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getOPERATOR_SWITCH(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        message = new Message();
//        message.what = 1049;
//        message.obj = result;
//        mHnadler.sendMessage( message );
//    }
//
//    /**
//     * 预订单
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getPRE_ORDER(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            JSONObject jsonObject = new JSONObject( result );
//            message = new Message();
//            message.what = 1060;
//            PRE_ORDEREntity pre_orderEntity = gson.fromJson( jsonObject.toString(), PRE_ORDEREntity.class );
//            message.obj = pre_orderEntity;
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 魔盒 H5
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getMAGIC_BOX(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        try {
//            String state;
//            JSONObject jsonObject = new JSONObject( result );
//            state = result;
//            if (jsonObject.has( "state" )) {
//                state = jsonObject.optString( "state" );
//            }
//            message = new Message();
//            message.what = 1061;
//            message.obj = state;
//            mHnadler.sendMessage( message );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 连连 H5
//     *
//     * @param context
//     * @param result
//     * @param mHnadler
//     */
//    private void getREBACK_H5(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        message = new Message();
//        message.what = 1062;
//        message.obj = result;
//        mHnadler.sendMessage( message );
//    }
//
//    private void getTONGDUN_INFO(Context context, String result, Handler mHnadler) {
//        result = HttpOnekey.getInstance().setAesDecry( result, SharedPreferencesUtils.get( context, "jiemi", "" ).toString() );
//        Log.d( "设备指纹返回", "getTONGDUN_INFO: " + result );
//    }
//
//    private boolean isForeground(Context context, String className) {
//        if (context == null || TextUtils.isEmpty( className )) {
//            return false;
//        }
//
//        ActivityManager am = (ActivityManager) context.getSystemService( Context.ACTIVITY_SERVICE );
//        List<ActivityManager.RunningTaskInfo> list = null;
//        if (am != null) {
//            list = am.getRunningTasks( 1 );
//        }
//        if (list != null && list.size() > 0) {
//            ComponentName cpn = list.get( 0 ).topActivity;
//            if (className.equals( cpn.getClassName() )) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//}
