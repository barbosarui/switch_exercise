package com.ppbf.sandbox;

import com.ppbf.solutions.models.Bet;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Sandbox {

    // Ex1: Given a List of lines on the file;
    //      Given a marketId;
    //      Write a function that finds the corresponding value of marketId in the list.
    // TIP: print the whole line
    public static List<Bet> ex1(List<String> lines, long marketId) {
        System.out.println("Not implemented yet");
        return null;
    }

    // Ex2: Given a List of lines on the file;
    //      Write a function that sorts the competitions by reversed alphabetical order.
    // TIP: sort the whole line
    public static List<Bet> ex2(List<String> lines) {
        System.out.println("Not implemented yet");
        return null;
    }

    // Ex3: Given a List of lines on the file;
    //      Given the total money;
    //      While you still have money available:
    //      Write a function that lets you bet on one or more markets.
    //
    // TIP: use validateAndUpdateTotalMoney to validate all data and update totalMoney.
    //      use addMarketAndStateToMap to return a Map with the marketId and the stake.
    public static BigDecimal validateAndUpdateTotalMoney(List<String> lines, BigDecimal totalMoney, long marketId, BigDecimal stake) {
        System.out.println("Not implemented yet");
        return null;
    }

    public static Map<Long, BigDecimal> addMarketAndStateToMap(Map<Long, BigDecimal> bets, long marketId, BigDecimal stake) {
        System.out.println("Not implemented yet");
        return null;
    }

    // Ex3_2: Given a List of lines on the file;
    //        Given a List of bets (List of marketId and the stake of the bet);
    //        Write a function that calculates the possible profit for each bet
    // TIP: return a list of profit values
    public static List<BigDecimal> ex3_2(List<String> lines, Map<Long, BigDecimal> bets) {
        System.out.println("Not implemented yet");
        return null;
    }
}
