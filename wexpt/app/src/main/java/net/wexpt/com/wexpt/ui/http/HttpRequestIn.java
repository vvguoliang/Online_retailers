package net.wexpt.com.wexpt.ui.http;

import android.content.Context;
import android.os.Handler;

import java.util.Map;

/**
 * Created by vvguoliang on 2017/9/22.
 * <p>
 * 返回数据接口
 */

public interface HttpRequestIn {

    void setPublic(Context context, Map<String, Object> map, Handler mHnadler, String url, String name);

    void setWIFI_ADDRESS(Context context, Handler mHandler);
}
