package net.wexpt.com.wexpt.ui.Data
import com.google.gson.annotations.SerializedName


/**
 * @Time : 2018/4/17 no 下午5:28
 * @USER : vvguoliang
 * @File : HomeData.java
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

data class HomeData(
		@SerializedName("result") val result: Boolean = false, //true
		@SerializedName("message") val message: String = "", //获取成功
		@SerializedName("status") val status: Int = 0, //200
		@SerializedName("data") val data: Data = Data()
)

data class Data(
		@SerializedName("banner") val banner: List<Banner> = listOf(),
		@SerializedName("category") val category: List<Category> = listOf(),
		@SerializedName("product") val product: List<Product> = listOf(),
		@SerializedName("special_product") val specialProduct: List<SpecialProduct> = listOf()
)

data class Product(
		@SerializedName("product_id") val productId: String = "", //14
		@SerializedName("product_name") val productName: String = "", //纪梵希 GIVENCHY轻盈无痕四宫格散粉7号
		@SerializedName("price") val price: String = "", //390.00
		@SerializedName("has_product") val hasProduct: String = "", //现货
		@SerializedName("count") val count: String = "", //20
		@SerializedName("made_in") val madeIn: String = "", //韩国
		@SerializedName("special_price") val specialPrice: String = "",
		@SerializedName("special_price_flag") val specialPriceFlag: String = "", //0
		@SerializedName("image") val image: String = "", //http://nan.wexpt.net/upload/product/102954551.jpg
		@SerializedName("remark") val remark: String = "",
		@SerializedName("product_unit") val productUnit: String = "" //12g
)

data class Category(
		@SerializedName("category_id") val categoryId: String = "", //1
		@SerializedName("name") val name: String = "", //美妆
		@SerializedName("image") val image: String = "", //http://nan.wexpt.net/upload/category/100417289.png
		@SerializedName("myself") val myself: String = "" //0
)

data class Banner(
		@SerializedName("id") val id: String = "", //1
		@SerializedName("name") val name: String = "",
		@SerializedName("product_id") val productId: String = "",
		@SerializedName("course_id") val courseId: String = "",
		@SerializedName("url") val url: String = "",
		@SerializedName("type") val type: String = "", //1
		@SerializedName("describ") val describ: String = "",
		@SerializedName("content") val content: String = "",
		@SerializedName("created") val created: String = "", //2018-01-11 12:55:16
		@SerializedName("modified") val modified: String = "", //2018-01-11 12:55:16
		@SerializedName("small_image") val smallImage: String = "",
		@SerializedName("large_image") val largeImage: String = "",
		@SerializedName("image") val image: String = "" //http://nan.wexpt.net/upload/banner/125516476.jpg
)

data class SpecialProduct(
		@SerializedName("product_id") val productId: String = "", //17
		@SerializedName("product_name") val productName: String = "", //悦诗风吟 innisfree绿茶洗面奶 150ml
		@SerializedName("price") val price: String = "", //66.00
		@SerializedName("has_product") val hasProduct: String = "", //现货
		@SerializedName("count") val count: String = "", //20
		@SerializedName("made_in") val madeIn: String = "", //韩国
		@SerializedName("special_price") val specialPrice: String = "", //50.00
		@SerializedName("special_price_flag") val specialPriceFlag: String = "", //1
		@SerializedName("image") val image: String = "", //http://nan.wexpt.net/upload/product/053051764.jpg
		@SerializedName("remark") val remark: String = "",
		@SerializedName("product_unit") val productUnit: String = "" //150ml
)