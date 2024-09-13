package com.interview.prep.snakeladder;

import com.interview.prep.snakeladder.model.Player;
import com.interview.prep.snakeladder.model.SnakeAndLadderBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SnakeAndLadderGameService {
    SnakeAndLadderBoard board;
    DiceService dice;
    Queue<Player> players;
    private List<Player> result;

    public SnakeAndLadderGameService(SnakeAndLadderBoard board, DiceService dice, Queue<Player> players) {
        this.board = board;
        this.dice = dice;
        this.players = players;
        result = new ArrayList<Player>();
    }

    public void startGame() {

        while(result.size() != 3 && !players.isEmpty()) {
            Player player = players.poll();
            System.out.println(player.getPlayerName()+ " turn. Old Position: "+ player.getPosition());
            int diceValue = dice.rollDice();
            System.out.println("Dice Roll: "+ diceValue);
            board.movePlayerToNextPosition(player, diceValue);
            System.out.println(player.getPlayerName() + " new position:"+ player.getPosition());
            if (player.getPosition() == board.getSize()) {
                result.add(player);
            } else {
                players.add(player);
            }
        }
        System.out.println("Game Ended!!");
        System.out.println("Winner List");
        int i = 1;
        for ( Player player: result ) {
            System.out.println(i+". "+ player.getPlayerName());
        }
    }

}
