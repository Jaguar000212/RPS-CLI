package Objs.Players;

import Objs.Weapons.Weapon;

public interface Player<T extends Weapon> {
    String getName();

    T getWeapon();
}
