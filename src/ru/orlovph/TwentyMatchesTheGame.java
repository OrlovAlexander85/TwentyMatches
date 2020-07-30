package ru.orlovph;


import java.util.Scanner;

public class TwentyMatchesTheGame {
    int numberOfMatchesOnTable = 20;

    public void runTheGame() {
        while (!GameIsOver()) {
            printStatus();
            AImove(numberOfMatchesOnTable);
            if (GameIsOver()) {
                break;
            }
            printStatus();
            playerInput();
        }
    }

    private boolean GameIsOver() {
        if (numberOfMatchesOnTable == 1) {
            System.out.println("Для игрока осталась последняя спичка. Игрок проиграл!");
            return true;
        } else {
            return false;
        }
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
