package net.wexpt.com.wexpt.ui.http

/**
 * @Time : 2018/4/16 no 下午2:17
 * @USER : vvguoliang
 * @File : AfferentMap.java
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
interface AfferentMap {

    abstract fun setUSER_NUll(inStr: String): Map<String, Any>

    abstract fun setUSER_LONG(inStr: String, telephone: String, code: String): Map<String, Any>

    abstract fun setSUANFA(itSF: String): String

    abstract fun setString2MD5(inStr: String): String

    abstract fun setTimeMillis(): String
}