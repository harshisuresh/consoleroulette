package com.exercise.comet;


import static com.google.common.base.Preconditions.checkArgument;
import static org.springframework.util.StringUtils.hasText;

/**
 * Created by harshitha.suresh on 29/11/2017.
 */
public class Player {
    private String name;

    public Player(String playerName) {
        checkArgument(hasText(playerName));
        this.name = playerName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
