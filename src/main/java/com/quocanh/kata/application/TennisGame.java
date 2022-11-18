package com.quocanh.kata.application;

import com.quocanh.kata.tennisplayer.TennisPlayer;

import static com.quocanh.kata.tennisplayer.Constant.ADVANTAGE;
import static com.quocanh.kata.tennisplayer.Constant.BONUS;
import static com.quocanh.kata.tennisplayer.Constant.DEUCE;
import static com.quocanh.kata.tennisplayer.Constant.GAME_ERROR_MSG;
import static com.quocanh.kata.tennisplayer.Constant.GAME_WINNER;
import static com.quocanh.kata.tennisplayer.Constant.MAX_SCORE;

public class TennisGame implements Game {
    private final TennisPlayer player1;
    private final TennisPlayer player2;

    public TennisGame(char playerName1, char playerName2) {
        player1 = new TennisPlayer(playerName1);
        player2 = new TennisPlayer(playerName2);
    }


    private char getWinner() {
        return player1.getScore() < player2.getScore() ?
                player2.getName() : player1.getName();
    }

    private boolean isEndOfGame() {
        if (player1.getScore() > MAX_SCORE
                && player1.getScore() >= player2.getScore() + BONUS * 2) {
            return true;
        }
        return player2.getScore() > MAX_SCORE && player2.getScore() >= player1.getScore() + BONUS * 2;
    }


    private void setNewScoring(final char roundWinner) {
        if (roundWinner == player1.getName()) {
            player1.computeScoringAfterWonABall();
        } else if (roundWinner == player2.getName()) {
            player2.computeScoringAfterWonABall();
        } else {
            throw new IllegalArgumentException(String.format(GAME_ERROR_MSG, roundWinner));
        }
    }

    private String getCurrentScoring() {
        if (player1.getScore() + player2.getScore() < MAX_SCORE * 2) {
            return player1 + " / " + player2;
        }

        if (player1.getScore() == player2.getScore()) {
            return DEUCE;
        }

        return String.format(ADVANTAGE, this.getWinner());
    }

    public String play(final String gameData) {
        final StringBuffer result = new StringBuffer();
        if (gameData != null && !gameData.trim().isEmpty())
            gameData.chars().mapToObj(c -> (char) c)
                    .takeWhile(player -> !this.isEndOfGame())
                    .forEach(roundWinner -> {
                        this.setNewScoring(roundWinner);

                        if (this.isEndOfGame()) {
                            result.append(String.format(GAME_WINNER, getWinner()));
                        } else {
                            result.append(getCurrentScoring()).append("\n");
                        }
                    });

        return result.toString();
    }
}
