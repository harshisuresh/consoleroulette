package com.exercise.comet;

import com.exercise.comet.bet.Bet;
import com.exercise.comet.bet.BetOutcome;
import com.exercise.comet.bet.BetType;
import com.exercise.comet.reports.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

/**
 * Created by harshitha.suresh on 29/11/2017.
 */
@Service
public class CometRouletteEngine implements RouletteEngine {
    private BlockingQueue<Bet> bets = new ArrayBlockingQueue<>(1000);
    private final SecureRandom rand = new SecureRandom();
    private Map<Player, List<BetOutcome>> playerBetOutcomes = new HashMap<>();

    @Autowired
    private Reporter reporter;
    public CometRouletteEngine() {
        scheduleRandomNumberGeneration();
    }

    @Override
    public void placeBet(Bet bet) {
        try {
            bets.put(bet);
        } catch (InterruptedException e) {
            throw new RuntimeException("Unable to place bet: " + bet);
        }
    }

    public void rouletteLanded(int rouletteOutcome) {
        Collection<Bet> placedBets = new ArrayList<>();
        bets.drainTo(placedBets);
        List<BetOutcome> betOutcomeList = placedBets.stream()
                .map(bet -> bet.computeBetOutcome(rouletteOutcome)).collect(toList());
        betOutcomeList.forEach(this::updatePlayerBetOutcomes);
        reporter.onBetOutcomes(rouletteOutcome, betOutcomeList);
    }

    private void updatePlayerBetOutcomes(BetOutcome bo) {
        playerBetOutcomes.computeIfAbsent(bo.getBet().getPlayer(), p -> new ArrayList<>()).add(bo);
    }

    private void scheduleRandomNumberGeneration() {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> rouletteLanded(rand.nextInt(BetType.ROULETTE_SLOTS.intValue()) + 1), 30, 30, TimeUnit.SECONDS);
    }

}
