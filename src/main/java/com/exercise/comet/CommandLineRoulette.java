package com.exercise.comet;

import com.exercise.comet.bet.Bet;
import com.exercise.comet.bet.BetType;
import com.exercise.comet.exceptions.UserInputException;
import com.exercise.comet.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

/**
 * Created by harshitha.suresh on 30/11/2017.
 */
@Service
public class CommandLineRoulette {
    @Autowired
    private RouletteEngine rouletteEngine;

    @Autowired
    private PlayerService playerService;

    public Thread startGame() {
        //runAsync(this::readUserInput);

        Thread t = new Thread(this::readUserInput);
        t.start();
        return t;
    }

    private void readUserInput() {
        while (true) {
            System.out.println("Please enter your name, bet and bet amount");
            System.out.println("Example 1: Name, bet number(1-36 or ODD or EVEN), amount");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            if ("EXIT".equalsIgnoreCase(userInput)) {
                break;
            }
            Bet bet = parseUserInput(userInput);
            rouletteEngine.placeBet(bet);
        }
    }

    private Bet parseUserInput(String userInput){
        String[] splitUserInput = userInput.split(",");
        String playerName = splitUserInput[0];
        Optional<Player> player = playerService.findPlayerByName(playerName);
        if(!player.isPresent()) {
            throw new UserInputException("Invalid player name: " + playerName);
        }
        //check player is valid
        String bet = splitUserInput[1];

        BigDecimal betAmount = new BigDecimal(splitUserInput[2]);
        Optional<BetType> betType = BetType.parseBetInput(bet);
        if(!betType.isPresent()){
            throw new UserInputException("Invalid bet type:" + betType);
        }
        return new Bet(player.get(), betType.get(), betAmount);
    }

}
