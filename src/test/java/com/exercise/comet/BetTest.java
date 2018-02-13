package com.exercise.comet;

import com.exercise.comet.bet.Bet;
import com.exercise.comet.bet.BetOutcome;
import com.exercise.comet.bet.BetType;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by harshitha.suresh on 07/12/2017.
 */
public class BetTest {

    public Bet createBet(BetType betType, BigDecimal betAmount){
        String playerName = "PlayerName";
        Player player = new Player(playerName);
        return new Bet(player, betType, betAmount);
    }

    @Test
    public void computeBetOutcomeReturnsWinBetOutComeTypeWhenBetIsMatched(){
        //setup
        int rouletteOutcome = 1;
        BetType betType = mock(BetType.class);
        when(betType.isBetMatched(rouletteOutcome)).thenReturn(true);
        BigDecimal betAmount = BigDecimal.ONE;
        BigDecimal winnings = new BigDecimal(2);
        when(betType.getWinningsForBetAmount(betAmount)).thenReturn(winnings);
        Bet bet = createBet(betType, betAmount);

        //act
        BetOutcome betOutcome = bet.computeBetOutcome(rouletteOutcome);

        //assert
        assertEquals(BetOutcome.BetOutcomeType.WIN, betOutcome.getBetOutcomeType());
        assertEquals(winnings, betOutcome.getWinningsAmount());
    }

    @Test
    public void computeBetOutcomeReturnsLossBetOutComeTypeWhenBetIsNotMatched(){
        //setup
        int rouletteOutcome = 1;
        BetType betType = mock(BetType.class);
        when(betType.isBetMatched(rouletteOutcome)).thenReturn(false);
        BigDecimal betAmount = BigDecimal.ONE;
        BigDecimal winnings = BigDecimal.ZERO;
        Bet bet = createBet(betType, betAmount);

        //act
        BetOutcome betOutcome = bet.computeBetOutcome(rouletteOutcome);

        //assert
        assertEquals(BetOutcome.BetOutcomeType.LOSS, betOutcome.getBetOutcomeType());
        assertEquals(winnings, betOutcome.getWinningsAmount());
    }
}
