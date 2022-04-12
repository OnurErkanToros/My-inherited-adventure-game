package com.onurerkan;

import com.onurerkan.gameCharacters.Archer;
import com.onurerkan.gameCharacters.GameCharacters;
import com.onurerkan.gameCharacters.Knight;
import com.onurerkan.gameCharacters.Samurai;

import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private String charName;
    private int damage;
    private int healthy;
    private int defaultHeath;
    private int coin;
    private String name;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory(false, false, false);
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefaultHeath() {
        return defaultHeath;
    }

    public void selectCharacter() {
        showCharacters();
        System.out.print("Lütfen bir karakter giriniz: ");
        int selectChar = input.nextInt();
        while (selectChar > 3 || selectChar < 0) {
            System.out.print("Geçersiz seçim tekrar deneyin: ");
            selectChar = input.nextInt();
        }
        switch (selectChar) {
            case 1 -> initPlayer(new Samurai());
            case 2 -> initPlayer(new Archer());
            case 3 -> initPlayer(new Knight());
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("Seçilen karakter: " + this.charName);
    }

    private void showCharacters() {
        GameCharacters[] gameCharacters = {new Samurai(), new Archer(), new Knight()};
        for (GameCharacters character : gameCharacters) {
            System.out.println(
                    "ID: " + character.getId() +
                            "\t Karakter:" + character.getName() +
                            "\t Hasar: " + character.getDamage() +
                            "\t Sağlık: " + character.getHealth() +
                            "\t Para: " + character.getCoin());
        }
        System.out.println("------------------------------------");
    }

    private void initPlayer(GameCharacters gameCharacters) {
        this.setDamage(gameCharacters.getDamage());
        this.setHealthy(gameCharacters.getHealth());
        this.setCoin(gameCharacters.getCoin());
        this.setCharName(gameCharacters.getName());
        this.defaultHeath = gameCharacters.getHealth();
    }

    public void printInfo() {
        System.out.println(
                "************************ Oyuncu Bilgileri *************************"
                        + "\nKarakter: " + this.getCharName()
                        + "\nSağlık: " + this.getHealthy()
                        + "\nPara: " + this.getCoin()
                        + "\nSilahınız: " + inventory.getWeapon().getWeaponName()
                        + "\nVerebileceğiniz hasar: " + this.getDamage()
                        + "\nZırhınız: " + inventory.getArmor().getArmorName()
                        + "\nZırh koruma kuvveti: " + inventory.getArmor().getArmorDefence()
        );
    }
}
