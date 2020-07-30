package ru.orlovph.ai;

public class DecisionBadMaker implements IDecisionMaker {

    @Override
    public int calculateMove(int matchesOnTable) {
        int currentAIMove;
        final int i = matchesOnTable % 4;
        if (i == 0) {
            currentAIMove = 3;
        } else if (i == 3) {
            currentAIMove = 2;
        } else {
            currentAIMove = 1;
        }

        if (Math.random() > 0.7) {
            return currentAIMove;
        } else {
            return 1;
        }
    }

}
