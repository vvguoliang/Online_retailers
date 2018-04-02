package net.wexpt.com.wexpt.ui.http;

import android.content.Context;
import android.os.Handler;

import java.util.Map;

/**
 * Created by vvguoliang on 2017/9/21.
 */

public interface HttpOnekeyIm {
    /**
     * 加密过程中的 JSON 拼接
     * @param context
     * @param map1
     * @return
     */
    String setAesJSONEncry(Context context, Map<String, Object> map1);

    String setMD5(Context context);

    /**
     * 解密方法进行操作
     * @param content
     * @param key
     * @return
     */
    String setAesDecry(String content, String key);

    Map<String , Object> setMap(Context context, Map<String, Object> map);

    /**
     * 判断公钥和密钥
     * @param context
     * @param token
     */
    void setTrueActivity(Context context, String token);

    /**
     * 判断code 返回值时候成立
     * @param context
     * @param code
     * @param msg
     * @return
     */
    Boolean setBoolen(Context context, String code, String msg, Handler mHandler);

    /**
     * 加密方法进行操作
     * @param content
     * @param key
     * @return
     */
    String setAesEncry(String content, String key);
}
