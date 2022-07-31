package com.geektime.designpattern.l14;

import java.util.Map;

/**
 * @Author: yangguojun01
 * @Date: 2022/7/31
 */
public class ApiAuthenticatorDefaultImpl implements ApiAuthenticator {

    private CredentialStorage credentialStorage;

    public ApiAuthenticatorDefaultImpl() {
        this.credentialStorage = new CredentialStorageMysqlImpl();
    }

    public ApiAuthenticatorDefaultImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    // 权限验证
    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String baseUrl = apiRequest.getBaseUrl();
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        Map<String, String> params = apiRequest.getParams();
        // 客户端
        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if (clientAuthToken.isExpired()) {
            throw new RuntimeException("Token is expired.");
        }
        // 服务端 获取密码，生成AuthToken
        String password = credentialStorage.getPwdByAppId(appId);
        AuthToken serverAuthToken = AuthToken.create(baseUrl, appId, password, timestamp, params);
        // 校验
        if (!serverAuthToken.match(clientAuthToken)) {
            throw new RuntimeException("Token verfication failed.");
        }
    }
}
