package com.geektime.designpattern.l14;

/**
 * @Author: yangguojun01
 * @Date: 2022/7/31
 */
public class CredentialStorageMysqlImpl implements CredentialStorage {
    @Override
    public String getPwdByAppId(String appId) {
        return "mysql_password";
    }
}
