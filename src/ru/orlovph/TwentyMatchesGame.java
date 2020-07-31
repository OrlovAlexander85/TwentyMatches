package ru.orlovph;

import java.util.Scanner;

public class TwentyMatchesGame {
    private int numberOfMatchesOnTable;
    boolean isComputerTurn;
    private DecisionMaker dm = new DecisionMaker();
    Displayer displayer = new Displayer();
    Scanner scanner;

    public TwentyMatchesGame(int numberOfMatchesOnTable) {
        this.numberOfMatchesOnTable = numberOfMatchesOnTable;
    }

    public TwentyMatchesGame() {
        this.numberOfMatchesOnTable = 20;
    }

    public void run() {
        prepareGame();
        showStatusToPlayer();
        while (!isGameOver()) {
            makeMove(isComputerTurn);
            showStatusToPlayer();
            isComputerTurn = !isComputerTurn;
        }
        closeGame();
    }

    private void prepareGame() {
        isComputerTurn = true;
        scanner = new Scanner(System.in);
    }

    private void closeGame() {
        scanner.close();
    }

    private boolean isGameOver() {
        return numberOfMatchesOnTable == 1;
    }

    private void showStatusToPlayer() {
        if (isGameOver()) {
            displayer.displayGameOver();
        } else {
            displayer.displayCurrentMatches(numberOfMatchesOnTable);
        }
    }

    private void makeComputerMove() {
        int currentAIMove = dm.calculateMove(numberOfMatchesOnTable);
        displayer.displayComputerMove(currentAIMove);
        numberOfMatchesOnTable -= currentAIMove;
    }

    private void makePlayerMove() {
        int playerMove = getPlayerMove();
        numberOfMatchesOnTable -= playerMove;
    }

    private int getPlayerMove() {
        int playerMove = 0;
        do {
            displayer.displayPlayerMove();
            playerMove = readIntFromConsole();
            if (!isValidPlayerInput(playerMove)) {
                displayer.displayError();
            } else {
                break;
            }
        } while (true);
        return playerMove;
    }

    private int readIntFromConsole() {
        int playerMove;
        while (!scanner.hasNextInt()) {
            displayer.displayError();
            displayer.displayPlayerMove();
            scanner.next();
        }
        playerMove = scanner.nextInt();
        return playerMove;
    }

    private boolean isValidPlayerInput(int playerMove) {
        return playerMove >= 1 && playerMove <= 3;
    }

    private void makeMove(boolean isComputerTurn) {
        if (isComputerTurn) {
            makeComputerMove();
        } else {
            makePlayerMove();
        }
    }
}
