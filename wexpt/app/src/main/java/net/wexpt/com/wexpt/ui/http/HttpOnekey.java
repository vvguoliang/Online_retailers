//package net.wexpt.com.wexpt.ui.http;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Handler;
//import android.text.TextUtils;
//import android.util.Base64;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.UnsupportedEncodingException;
//import java.security.InvalidAlgorithmParameterException;
//import java.security.InvalidKeyException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//
///**
// * Created by vvguoliang on 2017/9/19.
// * <p>
// * 接口 加密揭秘和所有请求方式
// */
//
//public class HttpOnekey implements HttpOnekeyIm {
//
//    @Override
//    public String setAesJSONEncry(Context context, Map<String, Object> map1) {
//        return getMAPJSON( context, map1 );
//    }
//
//    @Override
//    public String setMD5(Context context) {
//        return md5( context );
//    }
//
//    @Override
//    public String setAesDecry(String content, String key) {
//        try {
//            return aesDecryptString( content, key );
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (NoSuchPaddingException e) {
//            e.printStackTrace();
//        } catch (InvalidAlgorithmParameterException e) {
//            e.printStackTrace();
//        } catch (IllegalBlockSizeException e) {
//            e.printStackTrace();
//        } catch (BadPaddingException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public Map<String, Object> setMap(Context context, Map<String, Object> map) {
//        return getMapProt( context, map );
//    }
//
//    @Override
//    public void setTrueActivity(Context context, String token) {
//        getTrue( context, token );
//    }
//
//    @Override
//    public Boolean setBoolen(Context context, String code, String msg, Handler mHandler) {
//        return getObject( context, code, msg, mHandler );
//    }
//
//    @Override
//    public String setAesEncry(String content, String key) {
//        try {
//            return aesEncryptString( content, key );
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (NoSuchPaddingException e) {
//            e.printStackTrace();
//        } catch (InvalidAlgorithmParameterException e) {
//            e.printStackTrace();
//        } catch (IllegalBlockSizeException e) {
//            e.printStackTrace();
//        } catch (BadPaddingException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    /**
//     * 单例对象实例
//     */
//    private static class HttpOnekeyHolder {
//        static final HttpOnekey INSTANCE = new HttpOnekey();
//    }
//
//    public static HttpOnekey getInstance() {
//        return HttpOnekeyHolder.INSTANCE;
//    }
//
//    /**
//     * private的构造函数用于避免外界直接使用new来实例化对象
//     */
//    private HttpOnekey() {
//    }
//
//    private final String IV_STRING = "A-16-Byte-String";
//    private final String charset = "UTF-8";
//
//    private String aesEncryptString(String content, String key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
//        byte[] contentBytes = content.getBytes( charset );
//        byte[] keyBytes = key.getBytes( charset );
//        byte[] encryptedBytes = aesEncryptBytes( contentBytes, keyBytes );
//        return new String( Base64.encode( encryptedBytes, Base64.DEFAULT ) );
//    }
//
//    private String aesDecryptString(String content, String key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
//        byte[] encryptedBytes = Base64.decode( content.getBytes(), Base64.DEFAULT );
//        byte[] keyBytes = key.getBytes( charset );
//        byte[] decryptedBytes = aesDecryptBytes( encryptedBytes, keyBytes );
//        return new String( decryptedBytes, charset );
//    }
//
//    private byte[] aesEncryptBytes(byte[] contentBytes, byte[] keyBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
//        return cipherOperation( contentBytes, keyBytes, Cipher.ENCRYPT_MODE );
//    }
//
//    private byte[] aesDecryptBytes(byte[] contentBytes, byte[] keyBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
//        return cipherOperation( contentBytes, keyBytes, Cipher.DECRYPT_MODE );
//    }
//
//    private byte[] cipherOperation(byte[] contentBytes, byte[] keyBytes, int mode) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
//        SecretKeySpec secretKey = new SecretKeySpec( keyBytes, "AES" );
//
//        byte[] initParam = IV_STRING.getBytes( charset );
//        IvParameterSpec ivParameterSpec = new IvParameterSpec( initParam );
//
//        Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS5Padding" );
//        cipher.init( mode, secretKey, ivParameterSpec );
//
//        return cipher.doFinal( contentBytes );
//    }
//
//    private String getMAPJSON(Context context, Map<String, Object> map1) {
//        if (map1 != null) {
//            return setAesEncry( "{\"base\":" + getJSON( context ) + ",\"data\":" + AppUtil.getInstance().getMap( map1 ).toString() + "}".trim().
//                            replace( "\\", "" ),
//                    SharedPreferencesUtils.get( context, "jiami", "" ).toString() );
//        } else {
//            return setAesEncry( "{\"base\":" + getJSON( context ) + "}".trim().replace( "\\", "" ),
//                    SharedPreferencesUtils.get( context, "jiami", "" ).toString() );
//        }
//
//    }
//
//    private Map<String, Object> getMapProt(Context context, Map<String, Object> objectMap) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "reqData", getMAPJSON( context, objectMap ).trim().replace( "\n", "" ) );
//        return map;
//    }
//
//    private String getJSON(Context context) {
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put( "version", AppUtil.getInstance().getVersionName( 1, context ) );
//            jsonObject.put( "device", Phone.getInstance().setTelephonyManager( context ) );
//            jsonObject.put( "userNumber", SharedPreferencesUtils.get( context, "userNumber", "" ).toString() );
//            jsonObject.put( "timestamp", TimeUtils.getTime( TimeUtils.getCurrentTimeInLong() ) );
//            jsonObject.put( "channelNumber", AppUtil.getInstance().getChannel( context, 0 ) );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return jsonObject.toString();
//    }
//
//
//    private void getTrue(Context context, String token) {
//        if (TextUtils.isEmpty( SharedPreferencesUtils.get( context, "userNumber", "" ).toString() )) {
//            if (TextUtils.isEmpty( SharedPreferencesUtils.get( context, "true", "" ).toString() )) {
//                String strins = md5( context );
//                SharedPreferencesUtils.put( context, "jiami", strins.substring( 0, strins.length() - 16 ) );
//                SharedPreferencesUtils.put( context, "jiemi", strins.substring( strins.length() - 16, strins.length() ) );
//                SharedPreferencesUtils.put( context, "token", strins );
//                SharedPreferencesUtils.put( context, "true", "1" );
//            }
//        } else {
//            SharedPreferencesUtils.put( context, "jiami", token.substring( 0, token.length() - 16 ) );
//            SharedPreferencesUtils.put( context, "jiemi", token.substring( token.length() - 16, token.length() ) );
//            SharedPreferencesUtils.put( context, "token", token );
//        }
//    }
//
//    /**
//     * 32λmd5.
//     * 32位小写md5加密
//     *
//     * @return
//     */
//    private String md5(Context context) {
//        String encrypt = encrypt( Phone.getInstance().setTelephonyManager( context ) );
//        return encrypt.substring( encrypt.length() / 2, encrypt.length() ) + encrypt.substring( 0, encrypt.length() / 2 );
//    }
//
//    private String encrypt(String str) {
//        try {
//            MessageDigest md = MessageDigest.getInstance( "MD5" );
//            md.update( str.getBytes() );
//            StringBuilder sb = new StringBuilder();
//            byte[] bytes = md.digest();
//            for (byte aByte : bytes) {
//                int b = aByte & 0xFF;
//                if (b < 0x10) {
//                    sb.append( '0' );
//                }
//                sb.append( Integer.toHexString( b ) );
//            }
//            return sb.toString();
//        } catch (Exception e) {
//            return "";
//        }
//    }
//
//    private Boolean getObject(Context context, String code, String msg, Handler mHandler) {
//        Boolean boolea = false;
//        switch (code) {
//            case "200":
//                boolea = true;
//                break;
//            case "201":
//                SharedPreferencesUtils.logoutSuccess( context );
//                BaseActivityManager.getActivityManager().finishAll();
//                context.startActivity( new Intent( context, MainActivity.class ) );
//                boolea = false;
//                ToatUtils.showShort1( context, msg );
//                break;
//            case "202":
//                boolea = false;
//                break;
//            case "203":
//                boolea = false;
//                break;
//            case "204":
//                boolea = false;
//                break;
//            case "205":
//                if (msg.contains( "设备登录" )) {
//                    SharedPreferencesUtils.logoutSuccess( context );
//                    BaseActivityManager.getActivityManager().finishAll();
//                    context.startActivity( new Intent( context, MainActivity.class ) );
//                }
//                ToatUtils.showShort1( context, msg );
//                boolea = false;
//                mHandler.sendEmptyMessage( 205 );
//                break;
//        }
//        return boolea;
//    }
//}
