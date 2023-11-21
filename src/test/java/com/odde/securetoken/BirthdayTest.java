package com.odde.securetoken;

//import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.Test;

import java.time.LocalDate;


public class BirthdayTest {


    @Test
    public void is_birthday_test() {
        Birthday birthday = new Birthday();

        boolean actual = birthday.isBirthday();

//        assertTrue(actual);
        assertFalse(actual);
    }

    @Test
    public void is_birthday_test_1() {
        Birthday birthday = new Birthday();

        boolean actual = birthday.isBirthday();

//        assertTrue(actual);
        assertFalse(actual);
    }

}
