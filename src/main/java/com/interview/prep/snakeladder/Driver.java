package com.interview.prep.snakeladder;

import com.interview.prep.snakeladder.model.Ladder;
import com.interview.prep.snakeladder.model.Player;
import com.interview.prep.snakeladder.model.Snake;
import com.interview.prep.snakeladder.model.SnakeAndLadderBoard;

import java.util.*;

// This class is responsible for taking input from user.
public class Driver {
    public static void main(String[] args) {
        Driver d = new Driver();
        Scanner s = new Scanner(System.in);
        int boardSize = d.getBoardDetails(s);
        SnakeAndLadderBoard board = new SnakeAndLadderBoard(boardSize);
        board.setSnakes(d.getSnakeDetails(s));
        board.setLadders(d.getLadderDetails(s));

        DiceService dice = new DiceService();
        Queue<Player> players = d.getPlayersDetails(s);
        SnakeAndLadderGameService gameService = new SnakeAndLadderGameService(board, dice, players);
        gameService.startGame();
    }

    int getBoardDetails(Scanner s) {
        System.out.print("Kindly Select Board Size ( multiple of 10) ");
        String boardSize = s.nextLine();
        try {
            return Integer.parseInt(boardSize);
        } catch(Exception e) {
            System.out.println("Entered Value is incorrect. Pls try again!");
        }
        return getBoardDetails(s);
    }

    List<Snake> getSnakeDetails(Scanner s) {
        int scount = getSnakeCount(s);
        List<Snake> snakes = new ArrayList<Snake>(scount);
        for(int i = 0; i < scount; i++) {
            Snake snake = getSnakeCoordinates(s);
            snakes.add(snake);
        }
        return snakes;
    }

    int getSnakeCount(Scanner s) {
        System.out.println("How many snakes you want to place in Game ? ");
        try {
            return Integer.parseInt(s.nextLine());
        } catch(Exception e) {
            System.out.println("Entered Value is incorrect. Pls try again!");
        }
        return getSnakeCount(s);
    }

    Snake getSnakeCoordinates(Scanner s) {
        System.out.println("Enter Snake's start and end position (comma separated)");
        String sd = s.nextLine();
        try {
            String[] snakeDetails = sd.split(",");
            if (snakeDetails.length != 2) {
                throw new Exception("Failed! Need to enter only start and end positions.");
            }
            Snake snake = new Snake(Integer.parseInt(snakeDetails[0]), Integer.parseInt(snakeDetails[1]));
            if (snake.isValidPositions()) {
                return snake;
            }
            throw new Exception("Coordinates are failing validations.");
        } catch(Exception e) {
            System.out.println("Entered Values are incorrect. Pls try again!");
        }
        return getSnakeCoordinates(s);
    }


    List<Ladder> getLadderDetails(Scanner s) {
        int ladderCount = getLadderCount(s);
        List<Ladder> ladders = new ArrayList<Ladder>(ladderCount);
        for(int i = 0; i < ladderCount; i++) {
             Ladder l = getLadderCoordinates(s);
             ladders.add(l);
        }
        return ladders;
    }

    int getLadderCount(Scanner s) {
        System.out.println("How many ladders you want to place in Game ? ");
        try {
            return Integer.parseInt(s.nextLine());
        } catch(Exception e) {
            System.out.println("Entered Value is incorrect. Pls try again!");
        }
        return getLadderCount(s);
    }

    Ladder getLadderCoordinates(Scanner s) {
        System.out.println("Enter Ladder's start and end position (comma separated)");
        String ld = s.nextLine();
        try {
            String[] ladderDetails = ld.split(",");
            if (ladderDetails.length != 2) {
                throw new Exception("Failed! Need to enter only start and end positions.");
            }
            Ladder ladder = new Ladder(Integer.parseInt(ladderDetails[0]), Integer.parseInt(ladderDetails[1]));
            if (ladder.isValidPositions()) {
                return ladder;
            }
            throw new Exception("Coordinates are failing validations.");
        } catch(Exception e) {
            System.out.println("Entered Values are incorrect. Pls try again!");
        }
        return getLadderCoordinates(s);
    }

    int getPlayerCount(Scanner s) {
        System.out.println("Enter Number of Player : ");
        try {
            return Integer.parseInt(s.nextLine());
        } catch(Exception e) {
            System.out.println("Entered Value is incorrect. Pls try again!");
        }
        return getPlayerCount(s);
    }


    Queue<Player> getPlayersDetails(Scanner s) {
        int playerCount = getPlayerCount(s);
        Queue<Player> players = new LinkedList<Player>();
        for(int i = 0; i < playerCount; i++) {
            Player p = getPlayerDetails(s);
            players.add(p);
        }
        return players;
    }

    Player getPlayerDetails(Scanner s) {
        System.out.println("Enter Player's Name:");
        String name = s.nextLine();
        return new Player(name);
    }


}