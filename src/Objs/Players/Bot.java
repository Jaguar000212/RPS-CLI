package Objs.Players;

import Objs.Weapons.*;

public class Bot<T extends Weapon> implements Player {
    public T weapon;

    public Bot(T weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return "Bot";
    }

    public T getWeapon() {
        return this.weapon;
    }
}