package com.odde;

import java.util.HashMap;
import java.util.Map;

public class Tennis {

    private String firstPlayer;

    private int oneScore = 0;
    private int twoScore = 0;

    private Map<Integer, String> scoreMap = new HashMap() {
        {
            put(0, "Love");
            put(1, "Fifteen");
            put(2, "Thirty");
            put(3, "Forty");
        }
    };

    public Tennis(String firstPlayer1) {
        firstPlayer = firstPlayer1;
    }

    public String getScore() {
        if  (oneScore == 4 && twoScore == 3) {
            return firstPlayer+" AD";
        }
        if (oneScore == twoScore) {
            if (oneScore < 3) {
                return scoreMap.get(oneScore) + " All";
            } else {
                return "Deuce";
            }
        } else {
            return scoreMap.get(oneScore) + " " + scoreMap.get(twoScore);
        }

    }

    public void firstWin() {
        oneScore += 1;
    }

    public void secondWin() {
        twoScore += 1;
    }
}
