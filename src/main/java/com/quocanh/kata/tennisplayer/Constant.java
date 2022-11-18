package com.quocanh.kata.tennisplayer;

import java.util.Map;

public final class Constant {
    public static int BONUS = 1;
    public static int MAX_SCORE = 40;
    public static String DEUCE = "Players are deuce";
    public static String ADVANTAGE = "Player %s has advantage";
    public static String GAME_WINNER = "Player %s wins the game";
    public static String GAME_ERROR_MSG = "The player %s is not found in the game!";
    public static Map<Integer, Integer> ROUND_SCORING = Map.of(
            1, 15,
            2, 30,
            3, MAX_SCORE
    );
}
