package com.quocanh.kata.tools;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TennisGameAssert {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String  stringToHash = "\n" +
                "    “Player A : 15 / Player B : 0”\n" +
                "    “Player A : 15 / Player B : 15”\n" +
                "    “Player A : 30 / Player B : 15”\n" +
                "    “Player A : 30 / Player B : 30”\n" +
                "    “Player A : 40 / Player B : 30”\n" +
                "    “Player A wins the game";


        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(stringToHash.getBytes());
        String stringHash = new String(messageDigest.digest());

        System.out.println(stringHash);
    }
}
