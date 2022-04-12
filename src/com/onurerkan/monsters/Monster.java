package com.onurerkan.monsters;

public abstract class Monster {
    private int id;
    private String monsterName;
    private int monsterDamage;
    private int mosterHealth;
    private int coin;


    public Monster(int id, int monsterDamage, int mosterHealth, int coin, String monsterName) {
        this.id = id;
        this.monsterDamage = monsterDamage;
        this.mosterHealth = mosterHealth;
        this.monsterName = monsterName;
        this.coin = coin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterDamage() {
        return monsterDamage;
    }

    public void setMonsterDamage(int monsterDamage) {
        this.monsterDamage = monsterDamage;
    }

    public int getMosterHealth() {
        return mosterHealth;
    }

    public void setMosterHealth(int mosterHealth) {
        this.mosterHealth = mosterHealth;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}
