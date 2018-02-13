package com.exercise.comet.reports;

import com.exercise.comet.bet.BetOutcome;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by harshitha.suresh on 01/12/2017.
 */
@Service
public class WinningsReporter implements Reporter {
    @Override
    public void onBetOutcomes(int rouletteOutcome, List<BetOutcome> betOutcomes) {
        System.out.println("rouletteOutcome: " + rouletteOutcome );
        System.out.println("Player       Bet     Outcome    Winnings ");
        System.out.println("-------------------------------------------");

        for (BetOutcome betOutcome : betOutcomes) {
            System.out.format("%s %s %s %s\n", betOutcome.getBet().getPlayer().getName() , betOutcome.getBet().getBetType().asString(), betOutcome.getBetOutcomeType().name(), betOutcome.getWinningsAmount());
        }

    }
}
