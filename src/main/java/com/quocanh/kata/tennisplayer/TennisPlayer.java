package com.quocanh.kata.tennisplayer;

import static com.quocanh.kata.tennisplayer.Constant.BONUS;
import static com.quocanh.kata.tennisplayer.Constant.ROUND_SCORING;

public class TennisPlayer extends Player implements Scoring {
    private int ballNumber;

    public TennisPlayer(char playerName) {
        super(playerName);
    }

    private void addAdvantage() {
        setScore(getScore() + BONUS);
    }

    public void computeScoringAfterWonABall() {
        if (++ballNumber < 4) {
            setScore(ROUND_SCORING.get(ballNumber));
        } else {
            addAdvantage();
        }
    }


}
