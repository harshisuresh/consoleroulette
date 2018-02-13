package com.exercise.comet.bet;

import java.math.BigDecimal;

/**
 * Created by harshitha.suresh on 29/11/2017.
 */
public class OddEvenBetType implements BetType {
    private static final BigDecimal MULTIPLICAND = BigDecimal.valueOf(2);
    private final int remainder;

    public OddEvenBetType(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public boolean isBetMatched(int rouletteNumber) {
        return rouletteNumber % 2 == remainder;
    }

    @Override
    public BigDecimal getWinningsForBetAmount(BigDecimal betAmount) {
        return betAmount.multiply(MULTIPLICAND);
    }

    @Override
    public String asString() {
        return remainder == 0 ? "EVEN" : "ODD";
    }

    @Override
    public String toString() {
        return "OddEvenBetType{" +
                "remainder=" + remainder +
                '}';
    }

}
