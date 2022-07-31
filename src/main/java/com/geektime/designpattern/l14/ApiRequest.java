package com.geektime.designpattern.l14;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangguojun01
 * @Date: 2022/7/31
 */
public class ApiRequest {
    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;
    private Map<String, String> params;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp, Map<String, String> params) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
        this.params = params;
    }

    public static ApiRequest createFromFullUrl(String url) {
        return new ApiRequest("baseUrl", "token", "appId", 12345678,new HashMap<>());
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
