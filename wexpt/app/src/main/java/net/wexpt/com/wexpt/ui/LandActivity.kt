package net.wexpt.com.wexpt.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Message
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.act_land.*
import kotlinx.android.synthetic.main.view_title.*
import net.wexpt.com.wexpt.R
import net.wexpt.com.wexpt.base.BaseActivity
import net.wexpt.com.wexpt.statusBar.ImmersionBar
import net.wexpt.com.wexpt.ui.Data.LoginData
import net.wexpt.com.wexpt.ui.http.AfferentDataHttpMap
import net.wexpt.com.wexpt.ui.http.HttpImplements
import net.wexpt.com.wexpt.ui.http.HttpRequest
import net.wexpt.com.wexpt.ui.utils.AppUtil
import net.wexpt.com.wexpt.ui.utils.CountDownTimerUtils
import net.wexpt.com.wexpt.ui.utils.SPUtils

/**
 * @Time : 2018/4/9 no 下午7:44
 * @USER : vvguoliang
 * @File : LandActivity.java
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
 *
 * 登陆
 */
class LandActivity : BaseActivity(), View.OnClickListener {

    lateinit var countDownTimer: CountDownTimerUtils

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.login_code_button -> {
                if (TextUtils.isEmpty(login_phone.text)) {
                    Toast.makeText(this, R.string.login_no_phton, Toast.LENGTH_SHORT).show()
                } else if (!AppUtil.instance.isChinaPhoneLegal(login_phone.text.toString())) {
                    login_errer_text.text = getString(R.string.login_no_correct)
                    login_errer_text.setTextColor(resources.getColor(R.color.colorAccent))
                } else {
                    countDownTimer = CountDownTimerUtils(login_code_button, 60 * 1000, 1000)
                    countDownTimer.start()
                }
            }

            R.id.login_button -> {
                if (TextUtils.isEmpty(login_phone.text)) {
                    Toast.makeText(this, R.string.login_no_phton, Toast.LENGTH_SHORT).show()
                } else if (!AppUtil.instance.isChinaPhoneLegal(login_phone.text.toString())) {
                    login_errer_text.text = getString(R.string.login_no_correct)
                    login_errer_text.setTextColor(resources.getColor(R.color.colorAccent))
                } else if (TextUtils.isEmpty(login_code.text)) {
                    Toast.makeText(this, R.string.login_no_code, Toast.LENGTH_SHORT).show()
                } else {
                    HttpRequest.Companion.get().setPublic(this, AfferentDataHttpMap.Companion.get().setUSER_LONG(
                            "", login_phone.text.toString(), login_code.text.toString()),
                            mHandler, HttpImplements.Companion.get().getHttp(this, "LOGIN"), "LOGIN");
                }
            }
            R.id.title_button_return -> {
                finish()
            }
        }
    }

    override fun initParams(arguments: Bundle?) {
    }

    override fun bindLayout(): Int {
        return R.layout.act_land

    }

    override fun initView(rootView: View) {
    }

    override fun setListener() {
        title_button_return.visibility = View.VISIBLE
        title_button_return.setOnClickListener(this)
        login_code_button.setOnClickListener(this)
        login_button.setOnClickListener(this)
        login_phone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                if (TextUtils.isEmpty(s)) {
                    login_errer_text.text = getString(R.string.phone_hint)
                    login_errer_text.setTextColor(resources.getColor(R.color.gray))
                }

            }
        })
        login_code.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
    }

    override fun doBusiness() {
    }

    override fun initImmersionBar() {
        super.initImmersionBar()
        super.initImmersionBar()
        mImmersionBar?.statusBarView(top_view)?.init()
        ImmersionBar.with(this@LandActivity)
                .statusBarDarkFont(true, 0.2f)
                .init()
    }

    private val mHandler: Handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when (msg?.what) {
                1001 -> {
                    val loginData = msg.obj as LoginData
                    SPUtils.getInstance(this@LandActivity, "userToken").put("userToken", loginData.data.userToken)
                    SPUtils.getInstance(this@LandActivity, "telephone").put("telephone", loginData.data.telephone)
                    SPUtils.getInstance(this@LandActivity, "image").put("image", loginData.data.image)
                    SPUtils.getInstance(this@LandActivity, "rongyunToken").put("rongyunToken", loginData.data.rongyunToken)
                }
            }
        }
    }

}
