package Entities;

public class Player {
    String simbol;
    int number;

    public Player(String simbol, int number) {
        this.simbol = simbol;
        this.number = number;
    }

    public String getSimbol() {
        return simbol;
    }

    public int getNumber() {
        return number;
    }
}
