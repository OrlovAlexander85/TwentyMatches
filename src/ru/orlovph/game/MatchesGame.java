package ru.orlovph.game;


import java.util.Scanner;

import ru.orlovph.ai.IDecisionMaker;
import ru.orlovph.presentation.Displayer;

public class MatchesGame {
    private boolean isComputerTurn;
    private int numberOfMatchesOnTable;
    private IDecisionMaker dm;
    private Displayer displayer = new Displayer();

    Scanner scanner;

    public MatchesGame(int numberOfMatchesOnTable, IDecisionMaker dm) {
        this.numberOfMatchesOnTable = numberOfMatchesOnTable;
        this.dm = dm;
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

    private void makeMove(boolean isComputerTurn) {
        if (isComputerTurn) {
            makeComputerMove();
        } else {
            makePlayerMove();
        }
    }

    private boolean isGameOver() {
        return numberOfMatchesOnTable == 1;
    }

    private void showStatusToPlayer() {
        if (isGameOver()) {
            displayer.displayGameOver();
        } else {
            System.out.println("На столе осталось " + numberOfMatchesOnTable + " спичек");
        }
    }

    private void makeComputerMove() {
        int currentAIMove = dm.calculateMove(numberOfMatchesOnTable);
        System.out.println(" - Количество выбранных компьютером спичек = " + currentAIMove);
        numberOfMatchesOnTable -= currentAIMove;
    }

    private void makePlayerMove() {
        int playerTakeMatchesCount = getPlayerMove();
        numberOfMatchesOnTable -= playerTakeMatchesCount;
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
            System.out.print(" - Ход Игрока. Введите количество спичек: ");
            scanner.next();
        }
        playerMove = scanner.nextInt();
        return playerMove;
    }

    private boolean isValidPlayerInput(int playerMove) {
        return playerMove >= 1 && playerMove <= 3;
    }

}