package com.ppbf.sandbox;

import com.ppbf.solutions.models.Bet;
import com.ppbf.solutions.models.Event;
import com.ppbf.solutions.models.Market;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Sandbox {

    // Ex1: Given a List of lines on the file;
    //      Given a marketId;
    //      Write a function that finds the corresponding value of marketId in the list.
    // TIP: print the whole line
	public static List<Bet> ex1(List<String> lines, long marketId) {
		List<Bet> results = new ArrayList<>();
		String marketIdString = String.valueOf(marketId);
		for (String eachLine : lines) {
			String[] lineParts = eachLine.split(";");
			if (lineParts[3].equals(marketIdString)) {
				Bet resultBet = createBet(lineParts[0], lineParts[1],
						lineParts[2], marketIdString, lineParts[4]);
				results.add(resultBet);
			}
		}
		return results;
	}

    // Ex2: Given a List of lines on the file;
    //      Write a function that sorts the competitions by reversed alphabetical order.
    // TIP: sort the whole line
    public static List<Bet> ex2(List<String> lines) {
    	// remove header of eventsWithDuplicates.csv
    	lines.remove(0);
    	
    	List<Bet> betList = getListOfBets(lines);
		
    	// sort
		Collections.sort(betList, new Comparator<Bet>() {
            @Override
            public int compare(Bet left, Bet right) {
                return right.event.market.name.compareTo(left.event.market.name);
            }
        });
		
        return betList;
    }
    
	private static Bet createBet(String competitionName, String eventName,
			String marketName, String marketId, String odd) {
		long marketIdLong = Long.parseLong(marketId);
		BigDecimal resultOdd = new BigDecimal(odd);
		Market resultMarket = new Market(marketName, marketIdLong,
				resultOdd);
		Event resultEvent = new Event(eventName, resultMarket);
		return new Bet(competitionName, resultEvent);
    }
	
	private static List<Bet> getListOfBets(List<String> lines) {
    	List<Bet> betList = new ArrayList<>();
		for (String eachLine : lines) {
			String[] lineParts = eachLine.split(";");
			if (lineParts.length >= 5) {
				Bet resultBet = createBet(lineParts[0], lineParts[1],
						lineParts[2], lineParts[3], lineParts[4]);
				betList.add(resultBet);
			}
		}
		return betList;
	}

    // Ex3: Given a List of lines on the file;
    //      Given the total money;
    //      While you still have money available:
    //      Write a function that lets you bet on one or more markets.
    //
    // TIP: use validateAndUpdateTotalMoney to validate all data and update totalMoney.
    //      use addMarketAndStateToMap to return a Map with the marketId and the stake.
	public static BigDecimal validateAndUpdateTotalMoney(List<String> lines,
			BigDecimal totalMoney, long marketId, BigDecimal stake) {
		// validates that stake is possible within the totalMoney available
		if (stake.compareTo(totalMoney) == 1) {
			System.out.println("Invalid Stake, your maximum Stake is " + totalMoney);
			return totalMoney;
		}
		
		List<Bet> placedBet = ex1(lines, marketId);
		// validates that marketId exists in lines (eventsWihtoutDuplicates.csv)
		if(placedBet.size()==0) {
			System.out.println("Invalid marketId. Market not found.");
			return totalMoney;
		}
		
		return totalMoney.subtract(stake);

	}

	public static Map<Long, BigDecimal> addMarketAndStateToMap(
			Map<Long, BigDecimal> bets, long marketId, BigDecimal stake) {
		bets.put(marketId, stake);
		return bets;
	}
	
	public static BigDecimal calculateWinners(List<String> lines,
			Map<Long, BigDecimal> bets) {
		BigDecimal totalPL = new BigDecimal(0);
        for (Entry<Long, BigDecimal> bet : bets.entrySet()){
        	Long marketId = bet.getKey();
        	BigDecimal stake = bet.getValue();
        	Bet betObject = ex1(lines, marketId).get(0);
        	String outcome;
        	BigDecimal profit; 
        	if(Math.random()<0.5) {
        		outcome = "LOSS";
        		profit = stake.negate();
        	} else {
        		outcome = "WON";
				BigDecimal oddsProfit = betObject.event.market.odds
						.subtract(new BigDecimal(1));
        		profit = stake.multiply(oddsProfit);
        	}
        	
        	totalPL.add(profit);
			System.out.println(outcome + betObject.event.name
					+ betObject.event.market.name + "Profit=" + profit);
	
        }
        return totalPL;
        
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
