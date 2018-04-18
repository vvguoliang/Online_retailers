package net.wexpt.com.wexpt.ui.http

import android.content.Context

/**
 * @Time : 2018/4/16 no 下午1:18
 * @USER : vvguoliang
 * @File : HttpImplements.java
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
class HttpImplements private constructor() {

    /**
     * 单例对象实例
     */
    companion object {
        fun get(): HttpImplements {
            return Inner.httpImplements
        }
    }

    private object Inner {
        val httpImplements = HttpImplements()
    }

    private val HttpS = "http://nan.wexpt.net"

    /**
     * private的构造函数用于避免外界直接使用new来实例化对象
     */
    private fun HttpImplements() = Unit

    /* 首页分类 */
    private val HttpUSER_HOME = "$HttpS/front/home"

    /* 客服 */
    private val HttpUSER_kefu = "$HttpS/customer/kefu_list"

    /* 登入+注册*/
    private val HttpUSER_LOGIN = "$HttpS/customer/login"


    fun getHttp(context: Context, publicString: String): String {
        var publicS = ""
        when (publicString) {
            "HOME" -> publicS = HttpUSER_HOME
            "KEFU" -> publicS = HttpUSER_kefu
            "LOGIN" -> publicS = HttpUSER_LOGIN
        }
        return publicS //+ SPUtils.getInstance(context, "token")
    }
}