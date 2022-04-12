package com.onurerkan;

import com.onurerkan.items.Armors.Armor;
import com.onurerkan.items.Armors.DefaultZirh;
import com.onurerkan.items.Weapons.DefaultSilah;
import com.onurerkan.items.Weapons.Weapon;

import java.nio.file.Watchable;

public class Inventory {
    private boolean haveWater;
    private boolean haveFood;
    private boolean haveFireWood;
    private Weapon weapon;
    private Armor armor;

    public Inventory(boolean haveWater, boolean haveFood, boolean haveFireWood) {
        this.haveWater = haveWater;
        this.haveFood = haveFood;
        this.haveFireWood = haveFireWood;
        this.weapon = new DefaultSilah();
        this.armor = new DefaultZirh();
    }

    public boolean isHaveWater() {
        return haveWater;
    }

    public void setHaveWater(boolean haveWater) {
        this.haveWater = haveWater;
    }

    public boolean isHaveFood() {
        return haveFood;
    }

    public void setHaveFood(boolean haveFood) {
        this.haveFood = haveFood;
    }

    public boolean isHaveFireWood() {
        return haveFireWood;
    }

    public void setHaveFireWood(boolean haveFireWood) {
        this.haveFireWood = haveFireWood;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
