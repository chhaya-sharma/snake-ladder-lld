package com.interview.prep.snakeladder.model;

import java.util.List;

public class SnakeAndLadderBoard {
    int size;
    List<Snake> snakes;
    List<Ladder> ladders;
    private static final int DEFAULT_SIZE = 100;

    public SnakeAndLadderBoard() {
        this(DEFAULT_SIZE);
    }

    public SnakeAndLadderBoard(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }


    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public void movePlayerToNextPosition(Player player, int diceValue) {
        int currentPosition = player.getPosition();
        int nextPosition = currentPosition + diceValue;
        if (nextPosition > size) {
            nextPosition = currentPosition;
        } else if (nextPosition == size) {
            // Player has finished the game.
        } else {
            nextPosition = fetchfinalPosition(nextPosition);
        }
        player.setPosition(nextPosition);
    }

    private int fetchfinalPosition(int nextPosition) {
        int currentPosition;
        do {
            currentPosition = nextPosition;
            for(Snake snake: snakes) {
                if (snake.getStartPosition() == nextPosition) {
                    System.out.println("Bitten By Snake at :" + nextPosition);
                    nextPosition = snake.getNextPosition();
                }
            }

            for(Ladder ladder: ladders) {
                if (ladder.getStartPosition() == nextPosition) {
                    System.out.println("Took Ladder at: " + nextPosition);
                    nextPosition = ladder.getNextPosition();
                }
            }

        } while(nextPosition != currentPosition);
        return nextPosition;

    }

}
