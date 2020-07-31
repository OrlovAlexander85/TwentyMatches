package ru.orlovph;

public class DecisionMaker {
    public int calculateMove(int matchesOnTable) {
        int currentAIMove;
        final int restOfDivision = matchesOnTable % 4;
        if (restOfDivision == 0) {
            currentAIMove = 3;
        } else if (restOfDivision == 3) {
            currentAIMove = 2;
        } else {
            currentAIMove = 1;
        }
        return currentAIMove;
    }
}
