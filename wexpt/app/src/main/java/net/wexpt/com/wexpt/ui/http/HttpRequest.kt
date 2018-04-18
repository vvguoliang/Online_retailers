@file:Suppress("UNREACHABLE_CODE")

package net.wexpt.com.wexpt.ui.http

import android.content.Context
import android.os.Handler
import android.os.Message
import com.google.gson.Gson
import net.wexpt.com.wexpt.ui.Data.HomeData
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException

/**
 * @Time : 2018/4/16 no 下午1:25
 * @USER : vvguoliang
 * @File : HttpRequest.java
 * @Software: Android Studio
 *code is far away from bugs with the god animal protecting
 *   I love animals. They taste delicious.
 * ***┏┓   ┏ ┓
 * **┏┛┻━━━┛ ┻┓
 * **┃   ☃   ┃
 * **┃ ┳┛  ┗┳ ┃
 * **┃    ┻   ┃
 * **┗━┓    ┏━┛
 * ****┃    ┗━━━┓
 * ****┃ 神兽保佑 ┣┓
 * ****┃ 永无BUG！┏┛
 * ****┗┓┓┏━┳┓┏┛┏┛
 * ******┃┫┫  ┃┫┫
 * ******┗┻┛  ┗┻┛
 */
@SuppressWarnings("JavaDoc")
class HttpRequest private constructor() : HttpRequestIn {

    override fun setPublic(context: Context, map: Map<String, Any>, mHnadler: Handler, url: String, name: String) {
        OkHttpManager.postAsync(url, name, map,
                object : DataCallBack {
                    override fun requestFailure(request: Request, name: String, e: IOException) {
                        val message = Message()
                        message.what = 205   // 链接超时
                        mHnadler.handleMessage(message)
                    }

                    @Throws(Exception::class)
                    override fun requestSuccess(result: String, name: String) {
                        when (name) {
                            "LOGIN" -> println("=======$result======$name")
                            "HOME" -> setHOME(context, mHnadler, result)
                        }

                    }
                })
    }

    override fun setHOME(context: Context, mHnadler: Handler, result: String) {
        val gosn = Gson().fromJson(result, HomeData::class.java)
        val message = Message()
        message.what = 1000
        message.obj = gosn
        mHnadler.handleMessage(message)
    }

    /**
     * 单例对象实例
     */
    companion object {
        fun get(): HttpRequest {
            return Inner.httpRequest
        }
    }

    private object Inner {
        val httpRequest = HttpRequest()
    }
}