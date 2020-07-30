package ru.orlovph;

import ru.orlovph.ai.DecisionBadMaker;
import ru.orlovph.game.MatchesGame;

public class Main {

    public static void main(String[] args) {
        MatchesGame game = new MatchesGame(20, new DecisionBadMaker());
        game.run();
    }

}
