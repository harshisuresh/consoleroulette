package com.exercise.comet.bet;

import java.math.BigDecimal;
import java.util.Collection;

import static java.util.Objects.requireNonNull;

/**
 * Created by harshitha.suresh on 29/11/2017.
 */
public class BetOutcome {
    public enum BetOutcomeType {
        WIN, LOSS, UNMATCHED
    }
    private final BigDecimal winningsAmount;
    private final BetOutcomeType betOutcomeType;
    private final Bet bet;

    public BetOutcome(Bet bet, BetOutcomeType betOutcomeType, BigDecimal winningsAmount) {
        this.bet = requireNonNull(bet);
        this.winningsAmount = requireNonNull(winningsAmount);
        this.betOutcomeType = requireNonNull(betOutcomeType);
    }

    public static BigDecimal computeTotalWinnings(Collection<BetOutcome> betOutcomes){
        return betOutcomes.stream().map(BetOutcome::getWinningsAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static BigDecimal computeTotalBetAmount(Collection<BetOutcome> betOutcomes){
        return betOutcomes.stream().map(bo -> bo.bet.getAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Bet getBet() {
        return bet;
    }

    public BigDecimal getWinningsAmount() {
        return winningsAmount;
    }

    public BetOutcomeType getBetOutcomeType() {
        return betOutcomeType;
    }
}
