package com.geektime.designpattern.l14;

import java.util.Map;

/**
 * @Author: yangguojun01
 * @Date: 2022/7/31
 */
public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(String baseUrl, String appId, String password, long timestamp,
                                   Map<String, String> params) {
        String token = baseUrl + appId + password + params.toString();
        return new AuthToken(token, timestamp);
    }

    public String getToken() {
        return "";
    }

    public boolean isExpired() {
        return false;
    }

    public boolean match(AuthToken authToken) {
        return !isExpired() && authToken.getToken() == "";
    }

}
