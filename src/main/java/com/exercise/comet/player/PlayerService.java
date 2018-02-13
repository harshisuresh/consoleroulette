package com.exercise.comet.player;

import com.exercise.comet.Player;

import java.util.Optional;

/**
 * Created by harshitha.suresh on 30/11/2017.
 */
public interface PlayerService {
    Optional<Player> findPlayerByName(String playerName);
}
