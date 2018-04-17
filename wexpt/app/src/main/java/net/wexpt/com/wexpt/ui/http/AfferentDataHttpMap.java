//package net.wexpt.com.wexpt.ui.http;
//
//import android.text.TextUtils;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by vvguoliang on 2017/9/21.
// * 传入数据分装
// */
//
//public class AfferentDataHttpMap implements AfferentMap {
//
//    @Override
//    public Map<String, Object> setUSER_REGISTER(String phoneNumber, String password, String identifyCode) {
//        return getUSER_REGISTER( phoneNumber, password, identifyCode );
//    }
//
//    @Override
//    public Map<String, Object> setUSER_CODE(String phone) {
//        return getUSER_CODE( phone );
//    }
//
//    @Override
//    public Map<String, Object> setUSER_LOGIN(String phoneNumber, String password) {
//        return getUSER_LOGIN( phoneNumber, password );
//    }
//
//    @Override
//    public Map<String, Object> setMODIFY_PASSWORD(String phoneNumber, String identifyCode, String newPassword, String password, int type) {
//        return getMODIFY_PASSWORD( phoneNumber, identifyCode, newPassword, password, type );
//    }
//
//    @Override
//    public Map<String, Object> setWIFI_ADDRESS(String IPAddress, String WiFiAddress, String locationAddress, String innerIP, String networkType, String APPLongitude, String APPLatitude, String WiFiNameUse, String WiFiNameNear, String AppName) {
//        return getWIFI_ADDRESS( IPAddress, WiFiAddress, locationAddress, innerIP, networkType, APPLongitude, APPLatitude, WiFiNameUse, WiFiNameNear, AppName );
//    }
//
//    @Override
//    public Map<String, Object> setINDIVIDUAL_INFORMATION(String QQNo, Long educational, String livingProvinces, String livingCity, String detailedAddress, Long marriage, int infoState) {
//        return getINDIVIDUAL_INFORMATION( QQNo, educational, livingProvinces, livingCity, detailedAddress, marriage, infoState );
//    }
//
//    @Override
//    public Map<String, Object> setWORK_INFORMATION(String companyName, String companyProvinces, String companyCity, String companyAddress, Long occupation, Long monthIncome, Long salaryDay, String companyTelephone, int infoState) {
//        return getWORK_INFORMATION( companyName, companyProvinces, companyCity, companyAddress, occupation, monthIncome, salaryDay, companyTelephone, infoState );
//    }
//
//    @Override
//    public Map<String, Object> setCONTACT_PERSON(Long directRelatives, String RelativesName, String RelativesPhoneNo, Long friendColleague, String friendName, String friendPhoneNo, int infoState) {
//        return getCONTACT_PERSON( directRelatives, RelativesName, RelativesPhoneNo, friendColleague, friendName, friendPhoneNo, infoState );
//    }
//
//    @Override
//    public Map<String, Object> setSESAME_CERTIFICATION(String userName, String idCard) {
//        return getSESAME_CERTIFICATION( userName, idCard );
//    }
//
//    @Override
//    public Map<String, Object> setMOBILE_PHONE_CARRIER(String phoneNumber, String servicePassword, int operatorNumber) {
//        return getMOBILE_PHONE_CARRIER( phoneNumber, servicePassword, operatorNumber );
//    }
//
//    @Override
//    public Map<String, Object> setSIGN_CARD(String content) {
//        return getSIGN_CARD( content );
//    }
//
//    @Override
//    public Map<String, Object> setGER_CODE(String phoneNo, String password, String smsCode, String captcha, String name, String idCardNo, String userNo) {
//        if (TextUtils.isEmpty( userNo )) {
//            return getGER_CODE1( phoneNo, password, smsCode, captcha, name, idCardNo );
//        } else {
//            return getGER_CODE( phoneNo, password, smsCode, captcha, name, idCardNo, userNo );
//        }
//    }
//
//    @Override
//    public Map<String, Object> setCREATE_LOGIN(String userName, String userCard, String userMobile, String userpass) {
//        return getCREATE_LOGIN( userName, userCard, userMobile, userpass );
//    }
//
//    @Override
//    public Map<String, Object> setCHECK_CODE(String data) {
//        return getCHECK_CODE( data );
//    }
//
//    @Override
//    public Map<String, Object> setFACE_PLUS(String idcard_name, String idcard_number, String userAddress, String userPolice, String userTime,
//                                            String gender, String race, String image_ref, String image, String imageA, String imageB, String imageC,
//                                            String imageD, String cardimgu, String cardimgd, String orderNo) {
//        return getFACE_PLUS( idcard_name, idcard_number, userAddress, userPolice, userTime, gender, race, image_ref, image, imageA, imageB,
//                imageC, imageD, cardimgu, cardimgd, orderNo );
//    }
//
//    @Override
//    public Map<String, Object> setMINE_BORROWING(String orderNO) {
//        return getMINE_BORROWING( orderNO );
//    }
//
//    @Override
//    public Map<String, Object> setCONFIRM_BORROWING(String money, String loanTerm, String userNO, String putBankCard) {
//        return getCONFIRM_BORROWING( money, loanTerm, userNO, putBankCard );
//    }
//
//    @Override
//    public Map<String, Object> setRECHARGE_HANDLE(String orderNO, String bankCardNO, String bankCode, String bankName, String loginAccount, String payMoney, String rechargeType, String channel, String userName, String userNO) {
//        return getRECHARGE_HANDLE( orderNO, bankCardNO, bankCode, bankName, loginAccount, payMoney, rechargeType, channel, userName, userNO );
//    }
//
//    @Override
//    public Map<String, Object> setPHONE_INFO(String contactList, String messageList, String contactName) {
//        return getPHONE_INFO( contactList, messageList, contactName );
//    }
//
//    @Override
//    public Map<String, Object> setMAGIC_BOX(String task_id) {
//        return getMAGIC_BOX( task_id );
//    }
//
//    @Override
//    public Map<String, Object> setMAGICBOX_STATE(String phoneNo, String phoneState) {
//        return getMAGICBOX_STATE( phoneNo, phoneState );
//    }
//
//    @Override
//    public Map<String, Object> setCOLLECTION_CARD(String cardholder, String idCard, Long accountBank, String cardPhoneNo, String bankCard) {
//        return getCOLLECTION_CARD( cardholder, idCard, accountBank, cardPhoneNo, bankCard );
//    }
//
//    /**
//     * 单例对象实例
//     */
//    private static class AfferentDataHttpMapHolder {
//        static final AfferentDataHttpMap INSTANCE = new AfferentDataHttpMap();
//    }
//
//    public static AfferentDataHttpMap getInstance() {
//        return AfferentDataHttpMapHolder.INSTANCE;
//    }
//
//    /**
//     * private的构造函数用于避免外界直接使用new来实例化对象
//     */
//    private AfferentDataHttpMap() {
//    }
//
//    private Map<String, Object> getUSER_REGISTER(String phoneNumber, String password, String identifyCode) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "phoneNumber", phoneNumber );
//        map.put( "password", password );
//        map.put( "identifyCode", identifyCode );
//        return map;
//    }
//
//
//    private Map<String, Object> getUSER_CODE(String phone) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "phone", phone );
//        return map;
//    }
//
//    private Map<String, Object> getUSER_LOGIN(String phoneNumber, String password) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "phoneNumber", phoneNumber );
//        map.put( "password", password );
//        return map;
//    }
//
//    private Map<String, Object> getMODIFY_PASSWORD(String phoneNumber, String identifyCode, String newPassword, String password, int type) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "phoneNumber", phoneNumber );
//        map.put( "identifyCode", identifyCode );
//        map.put( "newPassword", newPassword );
//        map.put( "password", password );
//        map.put( "type", type );
//        return map;
//    }
//
//    private Map<String, Object> getWIFI_ADDRESS(String IPAddress, String WiFiAddress, String locationAddress, String innerIP, String networkType, String APPLongitude, String APPLatitude, String WiFiNameUse, String WiFiNameNear, String AppName) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "IPAddress", IPAddress );
//        map.put( "WiFiAddress", WiFiAddress );
//        map.put( "locationAddress", locationAddress );
//        map.put( "innerIP", innerIP );
//        map.put( "networkType", networkType );
//        map.put( "APPLongitude", APPLongitude );
//        map.put( "APPLatitude", APPLatitude );
//        map.put( "WiFiNameUse", WiFiNameUse );
//        map.put( "WiFiNameNear", WiFiNameNear );
//        map.put( "AppName", AppName );
//        return map;
//    }
//
//    private Map<String, Object> getINDIVIDUAL_INFORMATION(String QQNo, Long educational, String livingProvinces, String livingCity, String detailedAddress, Long marriage, int infoState) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "QQNo", QQNo );
//        map.put( "educational", educational );
//        map.put( "livingProvinces", livingProvinces );
//        map.put( "livingCity", livingCity );
//        map.put( "detailedAddress", detailedAddress );
//        map.put( "marriage", marriage );
//        map.put( "infoState", infoState );
//        return map;
//    }
//
//    private Map<String, Object> getWORK_INFORMATION(String companyName, String companyProvinces, String companyCity, String companyAddress, Long occupation, Long monthIncome, Long salaryDay, String companyTelephone, int infoState) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "companyName", companyName );
//        map.put( "companyProvinces", companyProvinces );
//        map.put( "companyCity", companyCity );
//        map.put( "companyAddress", companyAddress );
//        map.put( "occupation", occupation );
//        map.put( "monthIncome", monthIncome );
//        map.put( "salaryDay", salaryDay );
//        map.put( "companyTelephone", companyTelephone );
//        map.put( "infoState", infoState );
//        return map;
//    }
//
//    private Map<String, Object> getCONTACT_PERSON(Long directRelatives, String RelativesName, String RelativesPhoneNo, Long friendColleague, String friendName, String friendPhoneNo, int infoState) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "directRelatives", directRelatives );
//        map.put( "RelativesName", RelativesName );
//        map.put( "RelativesPhoneNo", RelativesPhoneNo );
//        map.put( "friendColleague", friendColleague );
//        map.put( "friendName", friendName );
//        map.put( "friendPhoneNo", friendPhoneNo );
//        map.put( "infoState", infoState );
//        return map;
//    }
//
//    private Map<String, Object> getSESAME_CERTIFICATION(String userName, String idCard) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "userName", userName );
//        map.put( "idCard", idCard );
//        return map;
//    }
//
//    private Map<String, Object> getMOBILE_PHONE_CARRIER(String phoneNumber, String servicePassword, int operatorNumber) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "phoneNumber", phoneNumber );
//        map.put( "servicePassword", servicePassword );
//        map.put( "operatorNumber", operatorNumber );
//        return map;
//    }
//
//    private Map<String, Object> getCOLLECTION_CARD(String cardholder, String idCard, Long accountBank, String cardPhoneNo, String bankCard) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "cardholder", cardholder );
//        map.put( "idCard", idCard );
//        map.put( "accountBank", accountBank );
//        map.put( "cardPhoneNo", cardPhoneNo );
//        map.put( "bankCard", bankCard );
//        return map;
//    }
//
//    private Map<String, Object> getSIGN_CARD(String content) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "content", content );
//        return map;
//    }
//
//    private Map<String, Object> getCREATE_LOGIN(String userName, String userCard, String userMobile, String userpass) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "userName", userName );
//        map.put( "userCard", userCard );
//        map.put( "userMobile", userMobile );
//        map.put( "userpass", userpass );
//        return map;
//    }
//
//    private Map<String, Object> getCHECK_CODE(String data) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "data", data );
//        return map;
//    }
//
//    private Map<String, Object> getGER_CODE(String phoneNo, String password, String smsCode, String captcha, String name, String idCardNo, String userNo) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "phoneNo", phoneNo );
//        map.put( "servicePassword", password );
//        if (!TextUtils.isEmpty( smsCode )) {
//            map.put( "smsCode", smsCode );
//        }
//        if (!TextUtils.isEmpty( captcha )) {
//            map.put( "captcha", captcha );
//        }
//        map.put( "name", name );
//        map.put( "idCardNo", idCardNo );
//        map.put( "userNo", userNo );
//        return map;
//    }
//
//    private Map<String, Object> getGER_CODE1(String phoneNo, String password, String smsCode, String captcha, String name, String idCardNo) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "phoneNo", phoneNo );
//        map.put( "servicePassword", password );
//        if (!TextUtils.isEmpty( smsCode )) {
//            map.put( "smsCode", smsCode );
//        }
//        if (!TextUtils.isEmpty( captcha )) {
//            map.put( "captcha", captcha );
//        }
//        map.put( "name", name );
//        map.put( "idCardNo", idCardNo );
//        return map;
//    }
//
//    private Map<String, Object> getFACE_PLUS(String idcard_name, String idcard_number, String userAddress, String userPolice, String userTime, String gender, String race, String image_ref, String image, String imageA, String imageB, String imageC, String imageD, String cardimgu, String cardimgd, String orderNo) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "idcard_name", idcard_name );
//        map.put( "idcard_number", idcard_number );
//        map.put( "userAddress", userAddress );
//        map.put( "userPolice", userPolice );
//        map.put( "userTime", userTime );
//        map.put( "gender", gender );
//        map.put( "race", race );
//        map.put( "image_ref", image_ref );
//        map.put( "image", image );
//        map.put( "imageA", imageA );
//        map.put( "imageB", imageB );
//        map.put( "imageC", imageC );
//        map.put( "imageD", imageD );
//        map.put( "cardimgu", cardimgu );
//        map.put( "cardimgd", cardimgd );
//        map.put( "orderNo", orderNo );
//        return map;
//    }
//
//    private Map<String, Object> getMINE_BORROWING(String orderNO) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "orderNO", orderNO );
//        return map;
//    }
//
//    private Map<String, Object> getCONFIRM_BORROWING(String money, String loanTerm, String userNO, String putBankCard) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "money", money );
//        map.put( "loanTerm", loanTerm );
//        map.put( "userNO", userNO );
//        map.put( "putBankCard", putBankCard );
//        return map;
//    }
//
//    private Map<String, Object> getRECHARGE_HANDLE(String orderNO, String bankCardNO, String bankCode, String bankName, String loginAccount, String payMoney, String rechargeType, String channel, String userName, String userNO) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "orderNO", orderNO );
//        map.put( "bankCardNO", bankCardNO );
//        map.put( "bankCode", bankCode );
//        map.put( "bankName", bankName );
//        map.put( "loginAccount", loginAccount );
//        map.put( "payMoney", payMoney );
//        map.put( "rechargeType", rechargeType );
//        map.put( "channel", channel );
//        map.put( "userName", userName );
//        map.put( "userNO", userNO );
//        return map;
//    }
//
//    private Map<String, Object> getPHONE_INFO(String contactList, String messageList, String contactName) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "contactList", contactList );
//        map.put( "messageList", messageList );
//        map.put( "contactName", contactName );
//        return map;
//    }
//
//    private Map<String, Object> getMAGIC_BOX(String task_id) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "task_id", task_id );
//        return map;
//    }
//
//    private Map<String, Object> getMAGICBOX_STATE(String phoneNo, String phoneState) {
//        Map<String, Object> map = new HashMap<>();
//        map.put( "phoneNo", phoneNo );
//        map.put( "phoneState", phoneState );
//        return map;
//    }
//}
