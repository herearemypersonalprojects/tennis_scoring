package com.quocanh.kata.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TennisGameTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void isEmpty_ShouldReturnTrueForAllTypesOfBlankStrings(final String input) {
        // given
        final Game tennisGame = new TennisGame('A', 'B');

        // when
        final String result = tennisGame.play(input);

        // then
        assertTrue(result.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("provideTennisGameData")
    public void testGameShouldFinishWithSuccess(final String gameData, final String expected) {
        // given
        final TennisGame tennisGame = new TennisGame('A', 'B');

        // when
        final String result = tennisGame.play(gameData);

        // then
        assertEquals(result, expected);
    }

    @Test
    public void testSystemFailsWhenGettingWrongGameData() {
        // given
        final Game tennisGame = new TennisGame('A', 'B');

        // when
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> tennisGame.play("ABCD"));

        // then
        assertEquals(exception.getMessage(),
                "The player C is not found in the game!");
    }

    private static Stream<Arguments> provideTennisGameData() {
        return Stream.of(
                Arguments.of("AAAAA",
                        "Player A: 15 / Player B: 0\n" +
                                "Player A: 30 / Player B: 0\n" +
                                "Player A: 40 / Player B: 0\n" +
                                "Player A wins the game"),
                Arguments.of("ABABABABAA",
                        "Player A: 15 / Player B: 0\n" +
                                "Player A: 15 / Player B: 15\n" +
                                "Player A: 30 / Player B: 15\n" +
                                "Player A: 30 / Player B: 30\n" +
                                "Player A: 40 / Player B: 30\n" +
                                "Players are deuce\n" +
                                "Player A has advantage\n" +
                                "Players are deuce\n" +
                                "Player A has advantage\n" +
                                "Player A wins the game"),
                Arguments.of("ABABAA",
                        "Player A: 15 / Player B: 0\n" +
                                "Player A: 15 / Player B: 15\n" +
                                "Player A: 30 / Player B: 15\n" +
                                "Player A: 30 / Player B: 30\n" +
                                "Player A: 40 / Player B: 30\n" +
                                "Player A wins the game"),
                Arguments.of("BABBBB",
                        "Player A: 0 / Player B: 15\n" +
                                "Player A: 15 / Player B: 15\n" +
                                "Player A: 15 / Player B: 30\n" +
                                "Player A: 15 / Player B: 40\n" +
                                "Player B wins the game")
        );
    }
}
