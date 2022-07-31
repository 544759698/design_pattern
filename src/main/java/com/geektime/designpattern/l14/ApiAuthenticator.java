package com.geektime.designpattern.l14;

/**
 * @Author: yangguojun01
 * @Date: 2022/7/31
 */
public interface ApiAuthenticator {
    void auth(String url);

    void auth(ApiRequest apiRequest);
}
