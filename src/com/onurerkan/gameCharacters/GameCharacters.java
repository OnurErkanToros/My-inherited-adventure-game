package com.onurerkan.gameCharacters;

public abstract class GameCharacters {
    private int id;
    private String name;
    private int health;
    private int damage;
    private int coin;

    public GameCharacters(int id, String name, int health, int damage, int coin) {
        this.id = id;
        this.name=name;
        this.health = health;
        this.damage = damage;
        this.coin = coin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getCoin() {
        return coin;
    }
}
