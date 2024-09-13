package com.interview.prep.snakeladder;

import java.util.Random;

public class DiceService {
    private static final Random random = new Random();

    public int rollDice() {
        return 1 + random.nextInt(6);
    }
}
