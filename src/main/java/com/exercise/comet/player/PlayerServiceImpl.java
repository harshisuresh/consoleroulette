package com.exercise.comet.player;

import com.exercise.comet.Player;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by harshitha.suresh on 30/11/2017.
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    @Override
    public Optional<Player> findPlayerByName(String playerName) {
        return Optional.of(new Player(playerName));
    }
}
