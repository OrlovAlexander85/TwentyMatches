package ru.orlovph;

public class Displayer {
    public void displayGameOver() {
        System.out.println("Для игрока осталась последняя спичка. Игрок проиграл!");
    }

    public void displayPlayerMove() {
        System.out.print(" - Ход Игрока. Введите количество спичек: ");
    }

    public void displayComputerMove(int matchesTaken) {
        System.out.println(" - Количество выбранных компьютером спичек = " + matchesTaken);
    }

    public void displayError() {
        System.out.println("Некорректное количество спичек!");
    }

    public void displayCurrentMatches(int matchesOnTable) {
        System.out.println("На столе осталось " + matchesOnTable + " спичек");
    }
}
