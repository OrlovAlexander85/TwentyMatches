package ru.orlovph;


import java.util.Scanner;

public class MatchesGame {
    private boolean isComputerTurn;
    private int numberOfMatchesOnTable;

    // мы реально хотим создавать каждый раз  новый сканер, тяжелый объект внутри метода?
    Scanner scanner;

    public MatchesGame(int numberOfMatchesOnTable) {
        this.numberOfMatchesOnTable = numberOfMatchesOnTable;
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
            System.out.println("Для игрока осталась последняя спичка. Игрок проиграл!");
        } else {
            System.out.println("На столе осталось " + numberOfMatchesOnTable + " спичек");
        }
    }

    // makes 3 actions: calculate the move, display computer decision, make move
    private void makeComputerMove() {
        int currentAIMove;
        final int i = numberOfMatchesOnTable % 4;
        if (i == 0) {
            currentAIMove = 3;
        } else if (i == 3) {
            currentAIMove = 2;
        } else {
            currentAIMove = 1;
        }
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
            System.out.print(" - Ход Игрока. Введите количество спичек: ");
            playerMove = readIntFromConsole();
            if (!isValidPlayerInput(playerMove)) {
                System.out.println("Некорректное количество спичек!");
            } else {
                break;
            }
        } while (true);
        return playerMove;
    }

    private int readIntFromConsole() {
        int playerMove;
        while (!scanner.hasNextInt()) {
            System.out.println("Некорректное количество спичек!");
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