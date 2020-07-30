package ru.orlovph;


import java.util.Scanner;

public class MatchesGame {
    private int numberOfMatchesOnTable = 20;

    public MatchesGame() {
    }

    public MatchesGame(int numberOfMatchesOnTable) {
        this.numberOfMatchesOnTable = numberOfMatchesOnTable;
    }

    public void run() {
        while (!isGameOver()) {
            printStatus();
            AImove(numberOfMatchesOnTable);
            if (isGameOver()) {
                break;
            }
            printStatus();
            playerInput();
        }
    }

    private boolean isGameOver() {
        if (numberOfMatchesOnTable == 1) {
            // сайд эффект, метод делает 2 действия вместо 1 заявленного
            System.out.println("Для игрока осталась последняя спичка. Игрок проиграл!");
            return true;
        } else {
            return false;
        }
        // правильный вариант метода
        // return numberOfMatchesOnTable != 1;
    }

    private void printStatus() {
        System.out.println("На столе осталось " + numberOfMatchesOnTable + " спичек");
    }

    private void AImove(int matchesOnTable) {
        int currentAIMove;
        if (matchesOnTable % 4 == 0) {
            currentAIMove = 3;
        } else if (matchesOnTable % 4 == 3) {
            currentAIMove = 2;
        } else currentAIMove = 1;
        System.out.println(" - Количество выбранных компьютером спичек = " + currentAIMove);
        numberOfMatchesOnTable -= currentAIMove;
    }

    // метод делает 2 действия + название неконсистентно с ходом компьютера
    private void playerInput() {
        System.out.print(" - Ход Игрока. Введите количество спичек: ");
        int playerMove;
        Scanner scanner = new Scanner(System.in);
        try {
            playerMove = scanner.nextInt();
            if (playerMove < 1 || playerMove > 3) {
                System.out.println("Некорректное количество спичек!");
                printStatus();
                playerInput();
            } else {
                numberOfMatchesOnTable -= playerMove;
            }
        } catch (Exception e) {
            System.out.println("Некорректное количество спичек!");
            printStatus();
            playerInput();
        }
    }
}
