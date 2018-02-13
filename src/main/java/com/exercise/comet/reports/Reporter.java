package com.exercise.comet.reports;

import com.exercise.comet.bet.BetOutcome;

import java.util.List;

/**
 * Created by harshitha.suresh on 01/12/2017.
 */
public interface Reporter {
    public void onBetOutcomes(int rouletteOutcome, List<BetOutcome> betOutcomes);
}
