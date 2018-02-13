package com.exercise.comet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by harshitha.suresh on 27/11/2017.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private CommandLineRoulette commandLineRoulette;
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        System.exit(0);
    }

    @Override
    public void run(String... strings) throws Exception {
        Thread thread = commandLineRoulette.startGame();
        thread.join();

    }
}
