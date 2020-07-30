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
            showStatusToPlayer();
            makeComputerMove();
            if (isGameOver()) {
                break;
            }
            showStatusToPlayer();
            makePlayerMove();
        }
    }

    private boolean isGameOver() {
        return numberOfMatchesOnTable == 1;
    }

    private void showStatusToPlayer() {
        if (numberOfMatchesOnTable == 1) {
            System.out.println("Для игрока осталась последняя спичка. Игрок проиграл!");
        } else {
            System.out.println("На столе осталось " + numberOfMatchesOnTable + " спичек");
        }
    }

    // тут нет AI, это просто ход компьютера. Он может быть и по AI и по алгоритму, который
    // не считается AI
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

    // метод делает 2 действия + название неконсистентно с ходом компьютера
    private void makePlayerMove() {
        System.out.print(" - Ход Игрока. Введите количество спичек: ");
        int playerMove;
        Scanner scanner = new Scanner(System.in);
        try {
            playerMove = scanner.nextInt();
            if (playerMove < 1 || playerMove > 3) {
                System.out.println("Некорректное количество спичек!");
                showStatusToPlayer();
                makePlayerMove();
            } else {
                numberOfMatchesOnTable -= playerMove;
            }
        } catch (Exception e) {
            System.out.println("Некорректное количество спичек!");
            showStatusToPlayer();
            makePlayerMove();
        }
    }
}
