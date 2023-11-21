package com.odde.securetoken;

public class AuthenticationService {

    private RsaTokenDao rsaToken;
    public AuthenticationService(RsaTokenDao rsaTokenDao) {
        rsaToken = rsaTokenDao;
    }

    public boolean isValid(String account, String password) {
        // 根據 account 取得自訂密碼
        ProfileDao profileDao = new ProfileDao();
        String passwordFromDao = profileDao.getPassword(account);


        // 根據 account 取得 RSA token 目前的亂數
//        RsaTokenDao rsaToken = new RsaTokenDao();
        String randomCode = rsaToken.getRandom(account);


        // 驗證傳入的 password 是否等於自訂密碼 + RSA token亂數
        String validPassword = passwordFromDao + randomCode;
        boolean isValid = password.equals(validPassword);

        if (isValid) {
            System.out.println("valid");
            return true;
        } else {
            System.out.println("in valid");
            return false;
        }
    }
}
