package Objs.Players;

import Objs.Weapons.*;

public class Human<T extends Weapon> implements Player {
    private final String name;
    private T weapon;
    private int wins = 0;
    private int losses = 0;
    private int streak = 0;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public T getWeapon() {
        return this.weapon;
    }

    public void setWeapon(T weapon) {
        this.weapon = weapon;
    }

    public int getWins() {
        return this.wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public int getStreak() {
        return this.streak;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public <P extends Player> Player fight(P p2) {
        if (this.getWeapon().getEnemy().compareToIgnoreCase(p2.getWeapon().getName()) == 0) {
            return p2;
        } else if (p2.getWeapon().getEnemy().compareToIgnoreCase(this.getWeapon().getName()) == 0) {
            return this;
        } else return null;
    }
}