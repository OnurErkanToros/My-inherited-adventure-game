package com.onurerkan.items.Weapons;

public abstract class Weapon {
    private int id;
    private String weaponName;
    private int weaponDamage;
    private int price;

    public Weapon(int id, String weaponName, int weaponDamage, int price) {
        this.id=id;
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;
        this.price= price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
