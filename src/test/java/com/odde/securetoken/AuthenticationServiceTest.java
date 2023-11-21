package com.odde.securetoken;

//import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class AuthenticationServiceTest {

//    @Test
//    public void is_valid_test() {
//        AuthenticationService target = new AuthenticationService();
//
//        boolean actual = target.isValid("joey", "91000000");
//
//        assertTrue(actual);
////        assertFalse(actual);
//    }
    public class RsaToken extends RsaTokenDao {
        private  String random =  "password";
        @Override
        public String getRandom(String account) {
            return random;
        }

        public void setRandom(String account) {
            random = account;
        }
    }

    @Test
    public void is_valid_test_valid() {
        RsaToken rasToken = new RsaToken();
        AuthenticationService target = new AuthenticationService(rasToken);
        String password = rasToken.getRandom("joey");
        boolean actual = target.isValid("joey", "91"+password);

        assertTrue(actual);
    }

    @Test
    public void is_valid_test_invalid() {
        RsaToken token = new RsaToken();
        AuthenticationService target = new AuthenticationService(token);

        boolean actual = target.isValid("joey", "91000000");

        assertFalse(actual);
    }


}
