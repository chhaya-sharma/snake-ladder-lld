package com.interview.prep.snakeladder.model;

public interface BoardElement {

    boolean isValidPositions();
    int getNextPosition();
    int getStartPosition();
}
