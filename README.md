# Tennis Scoring System with the Java Test Driven Development

- [Overview](#overview)
- [Scenario](#scenario)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
    - [Clone or download this repository](#clone-or-download-this-repository)
- [Running the application](#running-the-application)

## Overview

This Kata goal is to implement a simple tennis score computer using Java Maven in TDD.

## Scenario
The scoring system consist in one game, divided by points :

    Each player starts a game with 0 point.
    If the player wins the 1st ball, he will have 15 points. 2nd balls won : 30 points. 3rd ball won : 40points.
    If a player have 40 points and wins the ball, he wins the game, however there are special rules.
    If both players have 40 points the players are “deuce”.
    If the game is in deuce, the winner of the ball will have advantage
    If the player with advantage wins the ball he wins the game
    If the player without advantage wins the ball they are back at “deuce”.

You can found more details about the rules here : (http://en.wikipedia.org/wiki/Tennis#Scoring )


Here we want you to develop a java method that will take a String as input containing the character ‘A’ or ‘B’. The character ‘A’ corresponding to “player A won the ball”, and ‘B’ corresponding to “player B won the ball”. The java method should print the score after each won ball (for example : “Player A : 15 / Player B : 30”) and print the winner of the game.


For example the following input “ABABAA” should print :

    “Player A : 15 / Player B : 0”
    “Player A : 15 / Player B : 15”
    “Player A : 30 / Player B : 15”
    “Player A : 30 / Player B : 30”
    “Player A : 40 / Player B : 30”
    “Player A wins the game

## Prerequisites

- [JDK Version 11](https://jdk.java.net/11/). This application has been developed on a system with Java 11 but may be compatible with other versions.
- [Maven 3](https://maven.apache.org/download.cgi)
- [Java Extension Pack for Visual Studio Code](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) is recommended for running this application in VSCode.

## Setup

### Clone or download this repository

From your shell or command line:

```console
    git clone https://github.com/telecomparistech/tennis_scoring.git
```

or download and extract the repository .zip file.

> :warning: To avoid path length limitations on Windows, we recommend cloning into a directory near the root of your drive.

## Running the application

1. Open a terminal or the integrated VSCode terminal.
2. In the same directory as this readme file, run `mvn clean compile`.
3. Run `mvn clean test` to run unit tests.
4. Run `mvn checkstyle:checkstyle ` for checking Java code quality following Google Java Development style.