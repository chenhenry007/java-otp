package com.odde.securetoken;

//import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertFalse;

import com.odde.Tennis;

import org.junit.Assert;
import org.junit.Test;


public class TennisTest {

    Tennis tennis = new Tennis("Joseph");

    @Test
    public void testTennis_0_0_score() {
        String score = tennis.getScore();

        Assert.assertEquals("Love All", score);
    }

    @Test
    public void testTennis_1_0_score() {
        firstWin(1);
        String score = tennis.getScore();

        Assert.assertEquals("Fifteen Love", score);
    }

    @Test
    public void testTennis_2_0_score() {
        firstWin(2);
        String score = tennis.getScore();

        Assert.assertEquals("Thirty Love", score);
    }

    @Test
    public void testTennis_3_0_score() {
        firstWin(3);
        String score = tennis.getScore();

        Assert.assertEquals("Forty Love", score);
    }

    @Test
    public void testTennis_0_1_score() {
        secondWin(1);
        String score = tennis.getScore();

        Assert.assertEquals("Love Fifteen", score);
    }

    @Test
    public void testTennis_0_2_score() {
        secondWin(2);
        String score = tennis.getScore();

        Assert.assertEquals("Love Thirty", score);
    }

    @Test
    public void testTennis_0_3_score() {
        secondWin(3);
        String score = tennis.getScore();

        Assert.assertEquals("Love Forty", score);
    }
    @Test
    public void testTennis_1_1_score() {
        secondWin(1);
        firstWin(1);
        String score = tennis.getScore();

        Assert.assertEquals("Fifteen All", score);
    }
    @Test
    public void testTennis_2_2_score() {
        secondWin(2);
        firstWin(2);
        String score = tennis.getScore();

        Assert.assertEquals("Thirty All", score);
    }

    @Test
    public void testTennis_3_3_score() {
        secondWin(3);
        firstWin(3);
        String score = tennis.getScore();

        Assert.assertEquals("Deuce", score);
    }

    @Test
    public void testTennis_4_4_score() {
        secondWin(3);
        firstWin(3);
        secondWin(1);
        firstWin(1);

        String score = tennis.getScore();

        Assert.assertEquals("Deuce", score);
    }

    @Test
    public void testTennis_4_3_score() {
        secondWin(3);
        firstWin(3);
        firstWin(1);

        tennis = new Tennis("Joseph");
        String score = tennis.getScore();

        Assert.assertEquals("Joseph AD", score);
    }

    private void firstWin(int times) {
        for (int i = 0; i < times; i++) {
            tennis.firstWin();
        }
    }
    private void secondWin(int times) {
        for (int i = 0; i < times; i++) {
            tennis.secondWin();
        }
    }
}
