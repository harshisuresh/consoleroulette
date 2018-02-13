package com.exercise.comet.bet;

import com.google.common.primitives.Ints;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by harshitha.suresh on 29/11/2017.
 */
public interface BetType {

    BigDecimal ROULETTE_SLOTS = BigDecimal.valueOf(36);

    public static Optional<BetType> parseBetInput(String bet) {
        if ("ODD".equalsIgnoreCase(bet)) {
            return Optional.of(new OddEvenBetType(1));
        } else if ("EVEN".equalsIgnoreCase(bet)) {
            return Optional.of(new OddEvenBetType(0));
        } else {
            Integer betNumber = Ints.tryParse(bet);
            if (betNumber != null && betNumber > 0 && betNumber <= NumberedBetType.ROULETTE_SLOTS.intValue()) {
                return Optional.of(new NumberedBetType(betNumber));
            } else {
                return Optional.empty();
            }
        }
    }

    boolean isBetMatched(int rouletteNumber);

    BigDecimal getWinningsForBetAmount(BigDecimal betAmount);

    public String asString();
}
