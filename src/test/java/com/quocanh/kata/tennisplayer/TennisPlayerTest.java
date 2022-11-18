package com.quocanh.kata.tennisplayer;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TennisPlayerTest {

    @Test
    void testScoringForTheFirstBallWon() {
        TennisPlayer tennisPlayer = Mockito.spy(new TennisPlayer('P'));

        assertEquals(tennisPlayer.getScore(), 0);

        tennisPlayer.computeScoringAfterWonABall();

        assertEquals(tennisPlayer.getScore(), 15);
        Mockito.verify(tennisPlayer).setScore(15);
    }

    @Captor
    ArgumentCaptor<Integer> score = ArgumentCaptor.forClass(Integer.class);

    @Test
    void testScoringAfterThreeBallsWon() {
        TennisPlayer tennisPlayer = Mockito.spy(new TennisPlayer('P'));

        assertEquals(tennisPlayer.getScore(), 0);

        for (int i = 0; i < 3; i++) {
            tennisPlayer.computeScoringAfterWonABall();
        }
        Mockito.verify(tennisPlayer, Mockito.atLeast(3))
                .setScore(score.capture());


        assertEquals(tennisPlayer.getScore(), 40);

        tennisPlayer.computeScoringAfterWonABall();
        Mockito.verify(tennisPlayer, Mockito.atLeast(4))
                .setScore(score.capture());
        Mockito.verify(tennisPlayer, Mockito.atLeast(3))
                .getScore();
        assertEquals(tennisPlayer.getScore(), 41);
    }
}