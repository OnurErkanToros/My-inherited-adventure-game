package com.onurerkan.items.Armors;

public abstract class Armor {
    private int id;
    private String armorName;
    private int armorDefence;
    private int price;
    public Armor(int id, String armorName, int armorDefence, int price) {
        this.id=id;
        this.armorName = armorName;
        this.armorDefence = armorDefence;
        this.price=price;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
