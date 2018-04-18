package net.wexpt.com.wexpt.ui.Data
import com.google.gson.annotations.SerializedName


/**
 * @Time : 2018/4/19 no 上午3:50
 * @USER : vvguoliang
 * @File : LoginData.java
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
data class LoginData(
		@SerializedName("result") var result: Boolean = false, //true
		@SerializedName("message") var message: String = "", //登录成功。
		@SerializedName("status") var status: Int = 0, //200
		@SerializedName("data") var data: Data = Data()
) {
	data class Data(
			@SerializedName("name") var name: String = "", //13717578792
			@SerializedName("telephone") var telephone: String = "", //13717578792
			@SerializedName("vip") var vip: String = "", //0
			@SerializedName("is_black") var isBlack: String = "", //0
			@SerializedName("is_admin") var isAdmin: String = "", //0
			@SerializedName("user_token") var userToken: String = "", //1857adf8d2a83633ef0cc0c75b3e2709
			@SerializedName("rongyun_token") var rongyunToken: String = "", //OOR+GpuBlozq93MY8UVEpLuOR3u/zCj10cNJLbrgk13te6Yx9A1y1QvJYKu60xKKNTHe242OxMCN6pYzQOE39o6bUCoC7u6B37isLox+gKXspGL7xKe71aJUFe3YqgiL
			@SerializedName("created") var created: String = "", //2018-03-31 20:47:41
			@SerializedName("modified") var modified: String = "", //2018-03-31 21:04:00
			@SerializedName("image") var image: String = "" //http://nan.wexpt.net/user/logo.png
	)
}