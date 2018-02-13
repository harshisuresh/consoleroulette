package com.exercise.comet.bet;

import com.exercise.comet.Player;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

/**
 * Created by harshitha.suresh on 29/11/2017.
 */
public class Bet {
    private final BigDecimal amount;
    private final BetType betType;
    private final Player player;

    public Bet(Player player, BetType betType, BigDecimal amount) {
        this.amount = requireNonNull(amount);
        checkArgument(amount.signum() > 0);
        this.betType = requireNonNull(betType);
        this.player = requireNonNull(player);
    }

    private boolean isBetMatched(int rouletteOutcome) {
        return betType.isBetMatched(rouletteOutcome);
    }

    public BetOutcome computeBetOutcome(int rouletteOutcome) {
        if (isBetMatched(rouletteOutcome)) {
            return new BetOutcome(this, BetOutcome.BetOutcomeType.WIN, getBetType().getWinningsForBetAmount(getAmount()));
        } else {
            return new BetOutcome(this, BetOutcome.BetOutcomeType.LOSS, BigDecimal.ZERO);
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BetType getBetType() {
        return betType;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "amount=" + amount +
                ", betType=" + betType +
                ", player=" + player +
                '}';
    }
}
