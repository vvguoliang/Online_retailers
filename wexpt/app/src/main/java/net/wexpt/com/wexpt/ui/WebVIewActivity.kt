@file:Suppress("OverridingDeprecatedMember")

package net.wexpt.com.wexpt.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import kotlinx.android.synthetic.main.act_webview.*
import kotlinx.android.synthetic.main.view_title.*
import net.wexpt.com.wexpt.R
import net.wexpt.com.wexpt.base.BaseActivity
import net.wexpt.com.wexpt.statusBar.ImmersionBar

@Suppress("DEPRECATION")
/**
 * @Time : 2018/4/19 no 上午2:08
 * @USER : vvguoliang
 * @File : WebVIewActivity.java
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
class WebVIewActivity : BaseActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.title_button_return -> banner_webView.goBack()// 返回前一个页面
            R.id.title_button_fork -> finish()
        }
    }

    private var url: String = ""

    override fun initParams(arguments: Bundle?) {
    }

    override fun bindLayout(): Int {
        return R.layout.act_webview
    }

    override fun initView(rootView: View) {
    }

    override fun setListener() {
        title_button_return.visibility = View.VISIBLE
        title_button_fork.visibility = View.VISIBLE
        url = intent.getStringExtra("url")
        getSettings()

        banner_webView.webViewClient = webViewClient
        banner_webView.webChromeClient = webChromeClient
        if (!TextUtils.isEmpty(url) && "null" != url) {
            banner_linear.visibility = View.VISIBLE
            banner_webView.loadUrl(url)
        } else {
            text_title.text = ""
            banner_linear.visibility = View.GONE
        }

        title_button_return.setOnClickListener(this)
        title_button_fork.setOnClickListener(this)
    }

    override fun doBusiness() {
    }

    override fun initImmersionBar() {
        super.initImmersionBar()
        mImmersionBar?.statusBarView(top_view)?.init()
        ImmersionBar.with(this@WebVIewActivity)
                .statusBarDarkFont(true, 0.1f)
                .init()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && banner_webView.canGoBack()) {
            banner_webView.goBack()// 返回前一个页面
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


    private val webViewClient = object : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            if (TextUtils.isEmpty(view.title) || view.title.contains("404") || view.title.contains("找不到") ||
                    view.title.contains("about:")) {
                text_title.text = ""
                banner_linear.visibility = View.GONE
            } else {
                text_title.text = view.title
                banner_linear.visibility = View.VISIBLE
            }
        }
    }

    private val webChromeClient = object : WebChromeClient() {
        override fun onProgressChanged(view: WebView, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
            banner_progressBar.progress = newProgress
            if (newProgress == 100) {
                banner_progressBar.visibility = View.GONE
            } else {
                banner_progressBar.visibility = View.VISIBLE
            }
        }
    }


    @SuppressLint("SetJavaScriptEnabled", "AddJavascriptInterface")
    private fun getSettings() {
        banner_webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null) //渲染加速器
        banner_webView.settings.setRenderPriority(WebSettings.RenderPriority.HIGH) //提高渲染的优先级
        banner_webView.removeJavascriptInterface("searchBoxJavaBridge_") //防止360
        val settings = banner_webView.settings

        settings.blockNetworkImage = false
        settings.saveFormData = false
        settings.allowContentAccess = true
        settings.defaultTextEncodingName = "utf-8"
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH)

        settings.javaScriptEnabled = true  //支持js
        settings.useWideViewPort = true  //将图片调整到适合webview的大小
        settings.setSupportZoom(false)  //支持缩放
        settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN //支持内容重新布局
        settings.supportMultipleWindows()  //多窗口
        settings.cacheMode = WebSettings.LOAD_NO_CACHE  //关闭webview中缓存
        settings.allowFileAccess = true  //设置可以访问文件
        settings.setNeedInitialFocus(true) //当webview调用requestFocus时为webview设置节点
        settings.builtInZoomControls = true //设置支持缩放
        settings.javaScriptCanOpenWindowsAutomatically = true //支持通过JS打开新窗口
        settings.loadWithOverviewMode = true // 缩放至屏幕的大小
        settings.loadsImagesAutomatically = true  //支持自动加载图片

        settings.databaseEnabled = false//开启数据库形式存储
        settings.domStorageEnabled = false//开启DOM形式存储
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
    }
}