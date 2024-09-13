package com.interview.prep.snakeladder.model;

import java.util.UUID;

public class Player {
    String playerId;
    String playerName;
    int position;

    public Player(String playerName) {
        this.playerName = playerName;
        this.playerId = UUID.randomUUID().toString();
        this.position = 0;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
