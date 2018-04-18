package net.wexpt.com.wexpt.ui.http

import android.text.TextUtils
import java.security.MessageDigest
import java.util.*


/**
 * @Time : 2018/4/16 no 下午2:19
 * @USER : vvguoliang
 * @File : AfferentDataMap.java
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
class AfferentDataHttpMap private constructor() : AfferentMap {

    override fun setUSER_LONG(inStr: String, telephone: String, code: String): Map<String, Any> {
        return getUSER_LONG(inStr, telephone, code)
    }

    /**
     * 登入
     */
    private fun getUSER_LONG(inStr: String, telephone: String, code: String): Map<String, Any> {
        val timeMillis: String = setTimeMillis()
        val map = HashMap<String, Any>()
        map["api_token"] = setSUANFA(inStr, timeMillis)
        map["t"] = timeMillis
        map["telephone"] = telephone
        map["code"] = code
        return map
    }

    override fun setUSER_NUll(inStr: String): Map<String, Any> {
        return getUSER_NULL(inStr)
    }

    private fun getUSER_NULL(inStr: String): Map<String, Any> {
        val timeMillis: String = setTimeMillis()
        val map = HashMap<String, Any>()
        map["api_token"] = setSUANFA(inStr, timeMillis)
        map["t"] = timeMillis
        return map
    }

    /**
     * 最终算法 user_token + String + 时间戳
     */
    override fun setSUANFA(itSF: String, timeMillis: String): String {
        if (TextUtils.isEmpty(itSF)) {
            return setString2MD5(strings, timeMillis)
        } else {
            return setString2MD5(itSF + strings, timeMillis)
        }
    }

    /**
     * 时间戳
     */
    override fun setTimeMillis(): String {
        val dt = Date()
        val time = dt.time
        return time.toString()
    }

    private val strings = "fjsadhfkjashfhwruefhijoishfeu"

    override fun setString2MD5(inStr: String, timeMillis: String): String {
        return string2MD5(inStr + timeMillis)
    }

    /***
     * MD5加码 生成32位md5 ?
     */
    private fun string2MD5(inStr: String): String {
        var md5: MessageDigest?
        try {
            md5 = MessageDigest.getInstance("MD5")
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }

        val charArray = inStr.toCharArray()
        val byteArray = ByteArray(charArray.size)

        for (i in charArray.indices)
            byteArray[i] = charArray[i].toByte()
        val md5Bytes = md5!!.digest(byteArray)
        val hexValue = StringBuffer()
        for (i in md5Bytes.indices) {
            val `val` = md5Bytes[i].toInt() and 0xff
            if (`val` < 16)
                hexValue.append("0")
            hexValue.append(Integer.toHexString(`val`))
        }
        return hexValue.toString()
    }

    /**
     * 单例对象实例
     */
    companion object {
        fun get(): AfferentDataHttpMap {
            return Inner.afferentMap
        }
    }

    private object Inner {
        val afferentMap = AfferentDataHttpMap()
    }
}
