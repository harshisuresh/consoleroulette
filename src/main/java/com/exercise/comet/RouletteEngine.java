package com.exercise.comet;

import com.exercise.comet.bet.Bet;
import org.springframework.stereotype.Service;

/**
 * Created by harshitha.suresh on 29/11/2017.
 */
@Service
public interface RouletteEngine {
    void placeBet(Bet bet);
}
