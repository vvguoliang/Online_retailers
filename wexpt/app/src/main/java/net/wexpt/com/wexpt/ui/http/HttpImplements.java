package net.wexpt.com.wexpt.ui.http;

import android.content.Context;

import net.wexpt.com.wexpt.ui.utils.SPUtils;

/**
 * Created by vvguoliang on 2017/9/6.
 * 接口调用
 */

public class HttpImplements {

    /**
     * 单例对象实例
     */
    private static class HttpImplementsHolder {
        static final HttpImplements INSTANCE = new HttpImplements();
    }

    public static HttpImplements getInstance() {
        return HttpImplementsHolder.INSTANCE;
    }

    private String HttpV = "https://api.shujumohe.com/octopus/";

    private String HttpS = "https://api.51jinyinhua.com/andMain?";
    //    private String HttpS = "http://39.106.48.135:8082/app/andMain?";
    //    private String HttpS = "http://47.95.231.45:8082/app/andMain?";
//    private String HttpS = "http://192.168.120.29:8080/jyh_UserCenter/andMain?";
    public String Operator = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=";

    public String ExternalIP = "http://pv.sohu.com/cityjson?ie=utf-8";

    //同意协议
    public String Http51reg = "http://51jinyinhua.com/reg_agreement.html";
    //法律知识
    public String Http51lawtext = "http://51jinyinhua.com/lawtext.html";

    // 魔盒运营商 H5
    public String HttpTASK_ID = "https://open.shujumohe.com/box/yys?box_token=A505F5D667B64E61B2B9009CD3E42E6E&cb=com.jyh.com.jyh&";

    public String Http51baifu1 = "http://39.106.48.135:8081/order/otherRepay/repayList";

    public String Http51baifu2 = "http://report.51jinyinhua.com:8081/order/otherRepay/repayList";

    /**
     * private的构造函数用于避免外界直接使用new来实例化对象
     */
    private HttpImplements() {
    }

    /* 注册接口 */
    private final String HttpUSER_REGISTER = HttpS + "serviceName=USER_REGISTER&token=";

    /* 登录*/
    private final String HttpUSER_LOGIN = HttpS + "serviceName=USER_LOGIN&token=";

    /* 验证码*/
    private final String HttpUSER_CODE = HttpS + "serviceName=DYNAMIC_CODE&token=";

    /* 修改密码和忘记密码*/
    private final String HttpMODIFY_PASSWORD = HttpS + "serviceName=MODIFY_PASSWORD&token=";

    /* 修改密码和忘记密码*/
    private final String HttpFORGET_PASSWORD = HttpS + "serviceName=FORGET_PASSWORD&token=";

    /* WIFI 地址接口*/
    private final String HttpWIFI_ADDRESS = HttpS + "serviceName=WIFI_ADDRESS&token=";

    /* 首页接口*/
    private final String HttpHOME_PAGE = HttpS + "serviceName=HOME_PAGE&token=";

    /* 个人信息接口*/
    private final String HttpINDIVIDUAL_INFORMATION = HttpS + "serviceName=INDIVIDUAL_INFORMATION&token=";

    /* 工作信息接口*/
    private final String HttpWORK_INFORMATION = HttpS + "serviceName=WORK_INFORMATION&token=";

    /* 紧急联系人接口*/
    private final String HttpCONTACT_PERSON = HttpS + "serviceName=CONTACT_PERSON&token=";

    /* 个人信息填写接口*/
    private final String HttpFILLIN_INFORMATION_STATE = HttpS + "serviceName=FILLIN_INFORMATION_STATE&token=";

    /* 职业和收入下拉列表接口*/
    private final String HttpOCCUPATION_INCOME_LIST = HttpS + "serviceName=OCCUPATION_INCOME_LIST&token=";

    /* 个人资料填写状态接口*/
    private final String HttpFILLIN_DATA_STATE = HttpS + "serviceName=FILLIN_DATA_STATE&token=";

    /* 芝麻认证接口*/
    private final String HttpSESAME_CERTIFICATION = HttpS + "serviceName=SESAME_CERTIFICATION&token=";

    /* 运营商接口*/
    private final String HttpMOBILE_PHONE_CARRIER = HttpS + "serviceName=MOBILE_PHONE_CARRIER&token=";

    /* 收款银行卡接口*/
    private final String HttpCOLLECTION_CARD = HttpS + "serviceName=COLLECTION_CARD&token=";

    /* 开户行下拉列表接口*/
    private final String HttpACCOUNT_BANK_CARD = HttpS + "serviceName=ACCOUNT_BANK_CARD&token=";

    /* 借款记录接口*/
    private final String HttpBORROWING_RECORD = HttpS + "serviceName=BORROWING_RECORD&token=";

    /* 我的借款接口*/
    private final String HttpMINE_BORROWING = HttpS + "serviceName=MINE_BORROWING&token=";

    /* 我的借款详情接口*/
    private final String HttpMINE_BORROWING_CONFIRM_DETAILS = HttpS + "serviceName=MINE_BORROWING_CONFIRM_DETAILS&token=";

    /* 借款状态接口*/
    private final String HttpMINE_BORROWING_DETAILS = HttpS + "serviceName=MINE_BORROWING_DETAILS&token=";

    /* 启动页面接口*/
    private final String HttpLAUNCH_PAGE = HttpS + "serviceName=LAUNCH_PAGE&token=";

    /* 借款审核状态*/
    private final String HttpBORROWING_AUDIT_STATUS = HttpS + "serviceName=BORROWING_AUDIT_STATUS&token=";

    /* 借款银行界面*/
    private final String HttpNEXT_BORROW = HttpS + "serviceName=NEXT_BORROW&token=";

    /* 添加银行卡*/
    private final String HttpBIND_CARD = HttpS + "serviceName=BIND_CARD&token=";

    /* 生成 SIGN_CARD*/
    private final String HttpSIGN_CARD = HttpS + "serviceName=SIGN_CARD&token=";

    /* 退出*/
    private final String HttpEXIT_LOGIN = HttpS + "serviceName=EXIT_LOGIN&token=";

    /*  算话 创建*/
    private final String HttpCREATE_TASK = HttpS + "serviceName=CREATE_TASK&token=";

    /*  算话 登入*/
    private final String HttpLOGIN_FORM = HttpS + "serviceName=LOGIN_FORM&token=";

    /*  算话 */
    private final String HttpGER_CODE = HttpS + "serviceName=GER_CODE&token=";

    /*  算话 验证表单*/
    private final String HttpCOMMIT_FORM = HttpS + "serviceName=COMMIT_FORM&token=";

    /*  算话 图片验证*/
    private final String HttpREFRESH_CODE = HttpS + "serviceName=REFRESH_CODE&token=";

    /*  Face ++*/
    private final String HttpFACE_PLUS = HttpS + "serviceName=FACE_PLUS&token=";

    /*  算话与魔盒 ++*/
    private final String HttpOPERATOR_SWITCH = HttpS + "serviceName=OPERATOR_SWITCH&token=";

    /*  魔盒*/
    private final String HttpCREATE_LOGIN = HttpS + "serviceName=CREATE_LOGIN&token=";

    /*  魔盒验证码和图形验证码*/
    private final String HttpCHECK_CODE = HttpS + "serviceName=CHECK_CODE&token=";

    /*  魔盒重试验证码和图形验证码*/
    private final String HttpCHECK_AGAIN = HttpS + "serviceName=CHECK_AGAIN&token=";

    /* 开关*/
    private final String HttpBORROW_SWITCH = HttpS + "serviceName=BORROW_SWITCH&token=";

    /* 开关*/
    private final String HttpCONFIRM_BORROWING = HttpS + "serviceName=CONFIRM_BORROWING&token=";

    /* 充值*/
    private final String HttpRECHARGE_HANDLE = HttpS + "serviceName=RECHARGE_HANDLE&token=";

    /* 充值*/
    private final String HttpAPK_UPGRADE = HttpS + "serviceName=APK_UPGRADE&token=";

    /* 手机信息接口*/
    private final String HttpPHONE_INFO = HttpS + "serviceName=PHONE_INFO&token=";

    /* 逾期接口*/
    private final String HttpOVER_DUE = HttpS + "serviceName=OVER_DUE&token=";

    private final String TONGDUN_INFO = HttpS + "serviceName=TONGDUN_INFO&token=";
    /* 预订单*/
    private final String HttpPRE_ORDER = HttpS + "serviceName=PRE_ORDER&token=";

    /* 魔盒 H5*/
    private final String HttpMAGIC_BOX = HttpS + "serviceName=MAGIC_BOX&token=";

    /* 连连H5 H5*/
    private final String HttpREBACK_H5 = HttpS + "serviceName=REBACK_H5&token=";

    /* 连连H5 H5*/
    private final String HttpMAGICBOX_STATE = HttpS + "serviceName=MAGICBOX_STATE&token=";

    /* 身份证验证返回参数 */
    public final String HTTPOcridCard = "https://api.faceid.com/faceid/v1/ocridcard";

    /* 身份证验证返回参数 */
    public final String HTTPImageVerify = "http://192.168.120.42:8080/jyh_ThreeInterfaceService/face/verify";

    /* 运营商  创建*/
    public final String HTTPTask = HttpV + "task.unify.create/v3?partner_code=jinyinhua_mohe&partner_key=759305633dac4f2091e0df3100890bab";
    /* 登入验证*/
    public final String HTTPYys = HttpV + "yys.unify.acquire/v3?partner_code=jinyinhua_mohe&partner_key=759305633dac4f2091e0df3100890bab";
    /* 查询任务接口*/
    public final String HTTPQuery = HttpV + "task.unify.query/v3?partner_code=jinyinhua_mohe&partner_key=759305633dac4f2091e0df3100890bab";
    /* 查询运营商状态*/
    public final String HTTPChannel = HttpV + "task.unify.channel/v3?partner_code=jinyinhua_mohe&partner_key=759305633dac4f2091e0df3100890bab";
    /* 查询任务列表*/
    public final String HTTPList = HttpV + "task.unify.list/v3?partner_code=jinyinhua_mohe&partner_key=759305633dac4f2091e0df3100890bab";
    /* 重试验证码*/
    public final String HTTPRetry = HttpV + "task.unify.retry/v3?partner_code=jinyinhua_mohe&partner_key=759305633dac4f2091e0df3100890bab";


    public final String getHttp(Context context, String publicString) {
        String publicS = "";
        switch (publicString) {
            case "USER_REGISTER":
                publicS = HttpUSER_REGISTER;
                break;
            case "MODIFY_PASSWORD":
                publicS = HttpMODIFY_PASSWORD;
                break;
            case "USER_CODE":
                publicS = HttpUSER_CODE;
                break;
            case "WIFI_ADDRESS":
                publicS = HttpWIFI_ADDRESS;
                break;
            case "HOME_PAGE":
                publicS = HttpHOME_PAGE;
                break;
            case "INDIVIDUAL_INFORMATION":
                publicS = HttpINDIVIDUAL_INFORMATION;
                break;
            case "WORK_INFORMATION":
                publicS = HttpWORK_INFORMATION;
                break;
            case "CONTACT_PERSON":
                publicS = HttpCONTACT_PERSON;
                break;
            case "FILLIN_INFORMATION_STATE":
                publicS = HttpFILLIN_INFORMATION_STATE;
                break;
            case "OCCUPATION_INCOME_LIST":
                publicS = HttpOCCUPATION_INCOME_LIST;
                break;
            case "FILLIN_DATA_STATE":
                publicS = HttpFILLIN_DATA_STATE;
                break;
            case "SESAME_CERTIFICATION":
                publicS = HttpSESAME_CERTIFICATION;
                break;
            case "MOBILE_PHONE_CARRIER":
                publicS = HttpMOBILE_PHONE_CARRIER;
                break;
            case "COLLECTION_CARD":
                publicS = HttpCOLLECTION_CARD;
                break;
            case "ACCOUNT_BANK_CARD":
                publicS = HttpACCOUNT_BANK_CARD;
                break;
            case "BORROWING_RECORD":
                publicS = HttpBORROWING_RECORD;
                break;
            case "MINE_BORROWING":
                publicS = HttpMINE_BORROWING;
                break;
            case "MINE_BORROWING_CONFIRM_DETAILS":
                publicS = HttpMINE_BORROWING_CONFIRM_DETAILS;
                break;
            case "MINE_BORROWING_DETAILS":
                publicS = HttpMINE_BORROWING_DETAILS;
                break;
            case "LAUNCH_PAGE":
                publicS = HttpLAUNCH_PAGE;
                break;
            case "USER_LOGIN":
                publicS = HttpUSER_LOGIN;
                break;
            case "BORROWING_AUDIT_STATUS":
                publicS = HttpBORROWING_AUDIT_STATUS;
                break;
            case "FORGET_PASSWORD":
                publicS = HttpFORGET_PASSWORD;
                break;
            case "NEXT_BORROW":
                publicS = HttpNEXT_BORROW;
                break;
            case "BIND_CARD":
                publicS = HttpBIND_CARD;
                break;
            case "SIGN_CARD":
                publicS = HttpSIGN_CARD;
                break;
            case "EXIT_LOGIN":
                publicS = HttpEXIT_LOGIN;
                break;
            case "CREATE_TASK":
                publicS = HttpCREATE_TASK;
                break;
            case "LOGIN_FORM":
                publicS = HttpLOGIN_FORM;
                break;
            case "GER_CODE":
                publicS = HttpGER_CODE;
                break;
            case "COMMIT_FORM":
                publicS = HttpCOMMIT_FORM;
                break;
            case "REFRESH_CODE":
                publicS = HttpREFRESH_CODE;
                break;
            case "FACE_PLUS":
                publicS = HttpFACE_PLUS;
                break;
            case "CREATE_LOGIN":
                publicS = HttpCREATE_LOGIN;
                break;
            case "BORROW_SWITCH":
                publicS = HttpBORROW_SWITCH;
                break;
            case "CONFIRM_BORROWING":
                publicS = HttpCONFIRM_BORROWING;
                break;
            case "RECHARGE_HANDLE":
                publicS = HttpRECHARGE_HANDLE;
                break;
            case "APK_UPGRADE":
                publicS = HttpAPK_UPGRADE;
                break;
            case "PHONE_INFO":
                publicS = HttpPHONE_INFO;
                break;
            case "OVER_DUE":
                publicS = HttpOVER_DUE;
                break;
            case "TONGDUN_INFO":
                publicS = TONGDUN_INFO;
                break;
            case "CHECK_CODE":
                publicS = HttpCHECK_CODE;
                break;
            case "CHECK_AGAIN":
                publicS = HttpCHECK_AGAIN;
                break;
            case "OPERATOR_SWITCH":
                publicS = HttpOPERATOR_SWITCH;
                break;
            case "PRE_ORDER":
                publicS = HttpPRE_ORDER;
                break;
            case "MAGIC_BOX":
                publicS = HttpMAGIC_BOX;
                break;
            case "REBACK_H5":
                publicS = HttpREBACK_H5;
                break;
            case "MAGICBOX_STATE":
                publicS = HttpMAGICBOX_STATE;
                break;
        }
        return publicS + SPUtils.Companion.getInstance(context, "token");
    }
}
