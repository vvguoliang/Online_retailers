package net.wexpt.com.wexpt.ui.http

import android.content.Context
import android.os.Handler
import java.util.HashMap

/**
 * @Time : 2018/4/16 no 下午1:34
 * @USER : vvguoliang
 * @File : HttpOneKey.java
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
class HttpOnekey private constructor(): HttpOnekeyIM {

    override fun setMap(context: Context, map: Map<String, Any>): Map<String, Any> {
        return getMapProt(context, map)

    }

    override fun setBoolen(context: Context, code: String, msg: String, mHandler: Handler): Boolean? {
        return getObject(context, code, msg, mHandler)
    }

    private fun getMapProt(context: Context, objectMap: Map<String, Any>): Map<String, Any> {
        val map = HashMap<String, Any>()
        return map
    }

    private fun getObject(context: Context, code: String, msg: String, mHandler: Handler): Boolean? {
        var boolea: Boolean? = false
        when (code) {
            "200" -> boolea = true
            "201" -> {
            }
            "202" -> boolea = false
            "203" -> boolea = false
            "204" -> boolea = false
            "205" -> {
            }
        }
        return boolea
    }

    /**
     * 单例对象实例
     */
    companion object {
        fun get():HttpOnekey{
            return Inner.httpOnekey
        }
    }
    private object Inner{
        val httpOnekey = HttpOnekey()
    }

}