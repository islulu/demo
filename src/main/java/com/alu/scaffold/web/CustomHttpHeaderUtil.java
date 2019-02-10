package com.alu.scaffold.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CustomHttpHeaderUtil {

    private static final String X_SERIALNUM = "X-Serialnum";

    private static final String X_CLIENT_HASH = "X-Client-Hash";

    private static final String X_CLIENT_AGENT = "X-Client-Agent";

    private static final String X_NETWORK_TYPE = "X-Network-Type";

    private static final String X_PROJECT_ID = "X-Project-ID";
    
    private static final String X_PROJECT_Type = "X-Project-Type";

    private static final String X_CLIENT_VERSION = "X-Client-Version";

    private static final String X_PLATFORM_VERSION = "X-Platform-Version";

    private static final String X_APIVERSION = "X-APIVersion";

    private static final String X_CHANNEL_CODE = "X-Channel-Code";

    private static final String X_USER_ID = "X-User-ID";

    private static final String X_CUSTOMER_ID = "X-Customer-ID";

    private static final String X_LONG_TOKEN = "X-Long-Token";
    
    private static final String X_SYSTEM_ID = "X-System-ID";

    private static final String X_RESULT_CODE = "X-Result-Code";

    private static String getRequestHeader(String headerName) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes()).getRequest();
        return request.getHeader(headerName);
    }

    private static void setResponseHeader(String headerName, String headerValue) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes()).getResponse();
        response.setHeader(headerName, headerValue);
    }

    /**
     * 获取手机直播推流网络类型
     */
    public static String getXNetworkType() {
        return getRequestHeader(X_NETWORK_TYPE);
    }

    public static String getXNetworkType(HttpServletRequest request) {
        return request.getHeader(X_NETWORK_TYPE);
    }

    /**
     * 请求串号，时间戳
     */
    public static String getSerialnum() {
        return getRequestHeader(X_SERIALNUM);
    }

    /**
     * 请求串号，时间戳
     */
    public static String getSerialnum(HttpServletRequest request) {
        return request.getHeader(X_SERIALNUM);
    }

    /**
     * 基于serialnum等数据的数字摘要
     */
    public static String getClientHash() {
        return getRequestHeader(X_CLIENT_HASH);
    }

    /**
     * 基于serialnum等数据的数字摘要
     */
    public static String getClientHash(HttpServletRequest request) {
        return request.getHeader(X_CLIENT_HASH);
    }

    /**
     * 客户端UA:1024x768_samsung
     */
    public static String getClientAgent() {
        return getRequestHeader(X_CLIENT_AGENT);
    }

    /**
     * 客户端UA:1024x768_samsung
     */
    public static String getClientAgent(HttpServletRequest request) {
        return request.getHeader(X_CLIENT_AGENT);
    }

    /**
     * 取的项目ID
     */
    public static String getProjectId() {
        return getRequestHeader(X_PROJECT_ID);
    }
    
    public static String getSystemId() {
        return getRequestHeader(X_SYSTEM_ID);
    }

    
    public static String getProjectType() {
        return getRequestHeader(X_PROJECT_Type);
    }

    /**
     * 取的项目ID
     *      
     */
    
    public static String getProjectId(HttpServletRequest request) {
        return request.getHeader(X_PROJECT_ID);
    }

    
    public static String getSystemId(HttpServletRequest request) {
        return request.getHeader(X_SYSTEM_ID);
    }
    
    public static String getProjectType(HttpServletRequest request) {
        return request.getHeader(X_PROJECT_Type);
    }
    /**
     * 客户端版本号
     */
    public static String getClientVersion() {
        return getRequestHeader(X_CLIENT_VERSION);
    }

    /**
     * 客户端版本号
     */
    public static String getClientVersion(HttpServletRequest request) {
        return request.getHeader(X_CLIENT_VERSION);
    }

    /**
     * 客户端平台:android_422
     */
    public static String getPlatformVersion() {
        return getRequestHeader(X_PLATFORM_VERSION);
    }

    /**
     * 客户端平台:android_422
     */
    public static String getPlatformVersion(HttpServletRequest request) {
        return request.getHeader(X_PLATFORM_VERSION);
    }

    /**
     * API版本号：v1
     */
    public static String getAPIVersion() {
        return getRequestHeader(X_APIVERSION);
    }

    /**
     * API版本号：v1
     */
    public static String getAPIVersion(HttpServletRequest request) {
        return request.getHeader(X_APIVERSION);
    }

    /**
     * 渠道号：HB00001
     */
    public static String getChannelCode() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes()).getRequest();
        return getChannelCode(request);
    }

    /**
     * 渠道号：HB00001
     */
    public static String getChannelCode(HttpServletRequest request) {
        return StringUtils.defaultString(request.getHeader(X_CHANNEL_CODE),
            request.getParameter("cm"));
    }

    /**
     * 用户ID
     */
    public static String getUserId() {
        return getRequestHeader(X_USER_ID);
    }

    /**
     * 用户ID
     */
    public static String getUserId(HttpServletRequest request) {
        return request.getHeader(X_USER_ID);
    }

    /**
     * app用户id
     * @param request
     * @return
     */
    public static String getCustomerId(HttpServletRequest request) {
        return request.getHeader(X_CUSTOMER_ID);
    }

    /**
     * 长效Token
     */
    public static String getLongToken() {
        return getRequestHeader(X_LONG_TOKEN);
    }

    /**
     * 长效Token
     */
    public static String getLongToken(HttpServletRequest request) {
        return request.getHeader(X_LONG_TOKEN);
    }

    /**
     * 在消息头中返回请求串号
     */
    public static void setSerialnum(String value) {
        setResponseHeader(X_SERIALNUM, value);
    }

    /**
     * 在消息头中返回请求串号
     */
    public static void setSerialnum(HttpServletResponse response, String value) {
        response.setHeader(X_SERIALNUM, value);
    }

    /**
     * 在消息头中返回结果码
     */
    public static void setResultCode(String value) {
        setResponseHeader(X_RESULT_CODE, value);
    }

    /**
     * 在消息头中返回结果码
     */
    public static void setResultCode(HttpServletResponse response, String value) {
        response.setHeader(X_RESULT_CODE, value);
    }

    /**
     * 获取在消息头中返回的结果码
     */
    public static String getResultCode(HttpServletResponse response) {
        return response.getHeader(X_RESULT_CODE);
    }

    /**
     * 在消息头中返回长效Token
     */
    public static void setLongToken(String value) {
        setResponseHeader(X_LONG_TOKEN, value);
    }

    /**
     * 在消息头中返回长效Token
     */
    public static void setLongToken(HttpServletResponse response, String value) {
        response.setHeader(X_LONG_TOKEN, value);
    }

    /**
     * 在消息头中返回用户Id
     */
    public static void setUserId(String value) {
        setResponseHeader(X_USER_ID, value);
    }

    
    /**
     * 在消息头中返回项目ID
     */
    public static void setProjectId(String value) {
        setResponseHeader(X_PROJECT_ID, value);
    }
    
    public static void setSystemId(String value) {
        setResponseHeader(X_SYSTEM_ID, value);
    }
    
    public static void setProjectType(String value) {
        setResponseHeader(X_PROJECT_Type, value);
    }
    
    /**
     * 在消息头中返回用户Id
     */
    public static void setUserId(HttpServletResponse response, String value) {
        response.setHeader(X_USER_ID, value);
    }

    
    /**
     * 在消息头中返回项目ID
     */
    public static void setProjectId(HttpServletResponse response, String value) {
        response.setHeader(X_PROJECT_ID, value);
    }

    
    public static void setProjectType(HttpServletResponse response, String value) {
        response.setHeader(X_PROJECT_Type, value);
    }

    public static String getRemoteIp(HttpServletRequest request) {
        String remoteIp = request.getHeader("X-Forwarded-For");
        if (StringUtils.isBlank(remoteIp) || StringUtils.equalsIgnoreCase("unknown", remoteIp)) {
            remoteIp = request.getHeader("X-Real-IP");
        }
        if (StringUtils.isBlank(remoteIp) || StringUtils.equalsIgnoreCase("unknown", remoteIp)) {
            remoteIp = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(remoteIp) || StringUtils.equalsIgnoreCase("unknown", remoteIp)) {
            remoteIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(remoteIp) || StringUtils.equalsIgnoreCase("unknown", remoteIp)) {
            remoteIp = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(remoteIp) || StringUtils.equalsIgnoreCase("unknown", remoteIp)) {
            remoteIp = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(remoteIp) || StringUtils.equalsIgnoreCase("unknown", remoteIp)) {
            remoteIp = request.getRemoteAddr();
        }
        if (StringUtils.isBlank(remoteIp) || StringUtils.equalsIgnoreCase("unknown", remoteIp)) {
            remoteIp = request.getRemoteHost();
        }
        return remoteIp;
    }

}
