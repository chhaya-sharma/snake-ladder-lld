package com.interview.prep.snakeladder.model;

public class Snake extends BoardElementBase {

    public Snake(int start, int end) {
        this.startPosition = start;
        this.endPosition = end;
    }

    @Override
    public boolean isValidPositions() {
        return endPosition < startPosition;
    }

    @Override
    public int getNextPosition() {
        return endPosition;
    }

    @Override
    public int getStartPosition() {
        return startPosition;
    }


}
