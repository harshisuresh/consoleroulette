package com.exercise.comet.bet;

import java.math.BigDecimal;

/**
 * Created by harshitha.suresh on 29/11/2017.
 */
class NumberedBetType implements BetType {
    private int chosenNumber;

    public NumberedBetType(int chosenNumber) {
        this.chosenNumber = chosenNumber;
    }

    @Override
    public boolean isBetMatched(int rouletteNumber) {
        return rouletteNumber == chosenNumber;
    }

    @Override
    public BigDecimal getWinningsForBetAmount(BigDecimal betAmount) {
        return betAmount.multiply(ROULETTE_SLOTS);
    }

    @Override
    public String asString() {
        return String.valueOf(chosenNumber);
    }

    @Override
    public String toString() {
        return "NumberedBetType{" + "chosenNumber=" + chosenNumber +
                '}';
    }
}
