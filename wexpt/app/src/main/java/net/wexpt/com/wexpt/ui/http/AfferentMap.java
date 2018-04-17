//package net.wexpt.com.wexpt.ui.http;
//
//import java.util.Map;
//
///**
// * Created by vvguoliang on 2017/9/21.
// * <p>
// * 传入数据接口
// */
//
//public interface AfferentMap {
//
//    /**
//     * 注册
//     *
//     * @param phoneNumber
//     * @param password
//     * @param identifyCode
//     */
//    Map<String, Object> setUSER_REGISTER(String phoneNumber, String password, String identifyCode);
//
//    /**
//     * 手机验证码
//     *
//     * @param phone
//     * @return
//     */
//    Map<String, Object> setUSER_CODE(String phone);
//
//    /**
//     * 登入
//     *
//     * @param phoneNumber
//     * @param password
//     * @return
//     */
//    Map<String, Object> setUSER_LOGIN(String phoneNumber, String password);
//
//    /**
//     * 修改密码和忘记密码
//     *
//     * @param phoneNumber
//     * @param identifyCode
//     * @param newPassword
//     * @param password
//     * @param type
//     */
//    Map<String, Object> setMODIFY_PASSWORD(String phoneNumber, String identifyCode, String newPassword, String password, int type);
//
//    /**
//     * WIFI 信息
//     *
//     * @param IPAddress       用户IP地址(外网IP)
//     * @param WiFiAddress     用户WiFi地址
//     * @param locationAddress 用户地理位置
//     * @param innerIP         用户IP地址(内网IP)
//     * @param networkType     申请人使用设备的网络类型  1 WiFi 2移动蜂窝网络 3有线
//     * @param APPLongitude    申请人经度
//     * @param APPLatitude     申请人维度
//     * @param WiFiNameUse     当前使用WiFi名称
//     * @param WiFiNameNear    附近WiFi名称
//     * @param AppName         手机安装过的APP (Android)
//     * @return
//     */
//    Map<String, Object> setWIFI_ADDRESS(String IPAddress, String WiFiAddress, String locationAddress, String innerIP, String networkType, String APPLongitude, String APPLatitude, String WiFiNameUse, String WiFiNameNear, String AppName);
//
//    /**
//     * 个人信息
//     *
//     * @param QQNo
//     * @param educational
//     * @param livingProvinces
//     * @param livingCity
//     * @param detailedAddress
//     * @param marriage
//     * @param infoState
//     * @return
//     */
//    Map<String, Object> setINDIVIDUAL_INFORMATION(String QQNo, Long educational, String livingProvinces, String livingCity, String detailedAddress, Long marriage, int infoState);
//
//    /**
//     * 工作信息接口
//     *
//     * @param companyName
//     * @param companyProvinces
//     * @param companyCity
//     * @param companyAddress
//     * @param occupation
//     * @param monthIncome
//     * @param salaryDay
//     * @param companyTelephone
//     * @param infoState
//     * @return
//     */
//    Map<String, Object> setWORK_INFORMATION(String companyName, String companyProvinces, String companyCity, String companyAddress, Long occupation, Long monthIncome, Long salaryDay, String companyTelephone, int infoState);
//
//    /**
//     * 紧急联系人
//     *
//     * @param directRelatives
//     * @param RelativesName
//     * @param RelativesPhoneNo
//     * @param friendColleague
//     * @param friendName
//     * @param friendPhoneNo
//     * @param infoState
//     * @return
//     */
//    Map<String, Object> setCONTACT_PERSON(Long directRelatives, String RelativesName, String RelativesPhoneNo, Long friendColleague, String friendName, String friendPhoneNo, int infoState);
//
//    /**
//     * 芝麻认证
//     *
//     * @param userName
//     * @param idCard
//     * @return
//     */
//    Map<String, Object> setSESAME_CERTIFICATION(String userName, String idCard);
//
//    /**
//     * 手机运营商
//     *
//     * @param phoneNumber
//     * @param servicePassword
//     * @param operatorNumber
//     * @return
//     */
//    Map<String, Object> setMOBILE_PHONE_CARRIER(String phoneNumber, String servicePassword, int operatorNumber);
//
//    /**
//     * 收款银行卡
//     *
//     * @param cardholder
//     * @param idCard
//     * @param accountBank
//     * @param cardPhoneNo
//     * @return
//     */
//    Map<String, Object> setCOLLECTION_CARD(String cardholder, String idCard, Long accountBank, String cardPhoneNo, String bankCard);
//
//    /**
//     * sign
//     *
//     * @return
//     */
//    Map<String, Object> setSIGN_CARD(String content);
//
//    /**
//     * 算话 验证码
//     *
//     * @return
//     */
//    Map<String, Object> setGER_CODE(String phoneNo, String password, String smsCode, String captcha, String name, String idCardNo, String userNo);
//
//    /**
//     * 魔盒 创建 + 登入
//     *
//     * @return
//     */
//    Map<String, Object> setCREATE_LOGIN(String userName, String userCard, String userMobile, String userpass);
//
//    /**
//     * 魔盒 code
//     *
//     * @return
//     */
//    Map<String, Object> setCHECK_CODE(String data);
//
//    /**
//     * FACE_PLUS
//     *
//     * @param idcard_name   姓名
//     * @param idcard_number 身份证号
//     * @param userAddress   地址
//     * @param userPolice    公安局
//     * @param userTime      公安局时间
//     * @param gender        性别
//     * @param race          民族
//     * @param image_ref     //身份证头像照
//     * @param image         //活体高清照
//     * @param imageA        //活体动作A
//     * @param imageB        //活体动作B
//     * @param imageC        //活体动作C
//     * @param imageD        //活体动作D
//     * @param cardimgu      //身份证正面照
//     * @param cardimgd      //身份证反面照
//     * @return
//     */
//    Map<String, Object> setFACE_PLUS(String idcard_name, String idcard_number, String userAddress, String userPolice, String userTime, String gender, String race, String image_ref, String image, String imageA, String imageB, String imageC, String imageD, String cardimgu, String cardimgd, String orderNo);
//
//    /**
//     * 某个订单
//     *
//     * @param orderNO
//     * @return
//     */
//    Map<String, Object> setMINE_BORROWING(String orderNO);
//
//    /**
//     * 点击借款
//     *
//     * @param money
//     * @param loanTerm
//     * @param userNO
//     * @param putBankCard
//     * @return
//     */
//    Map<String, Object> setCONFIRM_BORROWING(String money, String loanTerm, String userNO, String putBankCard);
//
//    /**
//     * 充值
//     *
//     * @param orderNO      订单编号
//     * @param bankCardNO   银行卡号
//     * @param bankCode     银行编码
//     * @param bankName     银行名称
//     * @param loginAccount 登录账户
//     * @param payMoney     充值金额
//     * @param rechargeType 充值方式
//     * @param channel      充值渠道
//     * @param userName     用户名称
//     * @param userNO       用户编号
//     * @return
//     */
//    Map<String, Object> setRECHARGE_HANDLE(String orderNO, String bankCardNO, String bankCode, String bankName, String loginAccount, String payMoney, String rechargeType, String channel, String userName, String userNO);
//
//
//    /**
//     * 手机信息
//     *
//     * @param contactList
//     * @param messageList
//     * @return
//     */
//    Map<String, Object> setPHONE_INFO(String contactList, String messageList, String contactName);
//
//    /**
//     * 魔盒 H5
//     *
//     * @param task_id
//     * @return
//     */
//    Map<String, Object> setMAGIC_BOX(String task_id);
//
//    /**
//     * 魔盒 H5
//     *
//     * @param phoneNo
//     * @param phoneState
//     * @return
//     */
//    Map<String, Object> setMAGICBOX_STATE(String phoneNo, String phoneState);
//
//}
