package com.yc.common.constant;

/**
 * 常量类<br>
 * @author 村子里最好的剑
 */
public class Constant {

    public static final int NUM_0 = 0;

    public static final int NUM_1 = 1;

    public static final int NUM_2 = 2;

    public static final int NUM_3 = 3;

    public static final int NUM_4 = 4;

    public static final int NUM_5 = 5;

    public static final int NUM_6 = 6;

    public static final int NUM_7 = 7;

    public static final int NUM_8 = 8;

    public static final int NUM_9 = 9;

    public static final int NUM_10 = 10;

    public static final int NUM_11 = 11;

    public static final int NUM_12 = 12;

    public static final int NUM_13 = 13;

    public static final int NUM_14 = 14;

    public static final int NUM_15 = 15;

    public static final int NUM_16 = 16;

    public static final int NUM_17 = 17;

    public static final int NUM_18 = 18;

    public static final int NUM_19 = 19;

    public static final int NUM_20 = 20;

    public static final int NUM_21 = 21;

    public static final int NUM_24 = 24;

    public static final int NUM_30 = 30;

    public static final int NUM_49 = 49;

    public static final int NUM_50 = 50;

    public static final int NUM_60 = 60;

    public static final int NUM_75 = 75;

    public static final int NUM_80 = 80;

    public static final int NUM_100 = 100;

    public static final int NUM_139 = 139;

    public static final int NUM_140 = 140;

    public static final int NUM_200 = 200;

    public static final int NUM_256 = 256;

    public static final int NUM_350 = 350;

    public static final int NUM_500 = 500;

    public static final int NUM_539 = 539;

    public static final int NUM_540 = 540;

    public static final int NUM_629 = 629;

    public static final int NUM_630 = 630;

    public static final int NUM_679 = 679;

    public static final int NUM_680 = 680;

    public static final int NUM_719 = 719;

    public static final int NUM_720 = 720;

    public static final int NUM_900 = 900;

    public static final int NUM_1000 = 1000;

    public static final int NUM_1001 = 1001;

    public static final int NUM_1024 = 1024;

    public static final int NUM_1200 = 1200;

    public static final int NUM_1800 = 1800;

    public static final int NUM_2000 = 2000;

    public static final int NUM_2020 = 2020;

    public static final int NUM_60000 = 60000;

    public static final int NUM_999999999 = 999999999;

    public static final String STR_0 = "0";

    public static final String STR_1 = "1";

    public static final String STR_2 = "2";

    public static final String STR_3 = "3";

    public static final String STR_4 = "4";

    public static final String STR_5 = "5";

    public static final String STR_7 = "7";

    public static final String STR_8 = "8";

    public static final String STR_9 = "9";

    public static final String STR_10 = "10";

    public static final int HOUR_SECONDS = 3600;

    public static final int DAY_SECONDS = 24 * 60 * 60;

    public static final long DAY_MILL_SECONDS = 24 * 60 * 60 * 1000L;

    public static final String ZERO = "0";

    public static final String SEMICOLON = ";";

    public static final String COMMA = ",";

    /**
     * TOKEN 状态
     * 0-在线
     * 1-在其他设备登录
     */
    public static final int TOKEN_STATUS_ZERO = 0;
    public static final int TOKEN_STATUS_ONE = 1;

    /**
     * 基站的申请类型
     * 1-新开户  2-过户
     */
    public static final int APPLY_TYPE_ONE = 1;
    public static final String APPLY_TYPE_ONE_VIEW = "新开户";
    public static final int APPLY_TYPE_TWO = 2;
    public static final String APPLY_TYPE_TWO_VIEW = "过户";

    /**
     * 基站的站点类型
     * 1-基站 2-室分
     */
    public static final int STATION_TYPE_ONE = 1;
    public static final String STATION_TYPE_ONE_VIEW = "基站";
    public static final int STATION_TYPE_TWO = 2;
    public static final String STATION_TYPE_TWO_VIEW = "室分";

    /**
     * 基站的施工状态
     * 1-未施工 2-施工中 3-已施工
     */
    public static final int CONSTRUCTION_STATUS_ONE = 1;
    public static final String CONSTRUCTION_STATUS_ONE_VIEW = "未施工";
    public static final int CONSTRUCTION_STATUS_TWO = 2;
    public static final String CONSTRUCTION_STATUS_TWO_VIEW = "施工中";
    public static final int CONSTRUCTION_STATUS_THREE = 3;
    public static final String CONSTRUCTION_STATUS_THREE_VIEW = "已施工";

    /**
     * HTTP降级开关
     */
    public static final String HTTPKEY = "httpSwitch";

    public static final String HTTPPREDEF = "http:";

    public static final String HTTPS = "https:";

    /**
     * 初始密码123456
     */
    public static final String INITIAL_PWD = "123456";
    /**
     * CORS跨域
     */
    public static final String CORS_REQ_ORIGIN = "Origin";
    public static final String CORS_RES_ORIGIN = "Access-Control-Allow-Origin";
    public static final String CORS_RES_ORIGIN_VALUE = "*";
    public static final String CORS_CREDENTIALS = "Access-Control-Allow-Credentials";
    public static final String CORS_RES_METHODS = "Access-Control-Allow-Methods";
    public static final String CORS_RES_METHODS_VALUE = "POST,GET,OPTIONS";
    public static final String CORS_RES_HEADER = "Access-Control-Allow-Headers";
    public static final String CORS_RES_HEADER_VALUE =
            "x-requested-with,content-type,token,cookies";
    public static final String CORS_RES_MAX_AGE = "Access-Control-Max_Age";
    public static final String CORS_RES_MAX_AGE_VALUE = "3600";
    public static final String CORS_TRUE = "true";

    private Constant() {
        super();
    }
}
