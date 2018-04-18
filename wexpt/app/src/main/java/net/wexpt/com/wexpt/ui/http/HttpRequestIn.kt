package net.wexpt.com.wexpt.ui.http

import android.content.Context
import android.os.Handler

/**
 * @Time : 2018/4/17 no 下午4:21
 * @USER : vvguoliang
 * @File : HttpRequestIn.kt
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
interface HttpRequestIn {

    abstract fun setPublic(context: Context, map: Map<String, Any>, mHnadler: Handler, url: String, name: String)

    abstract fun setHOME(context: Context, mHnadler: Handler, result: String)
}