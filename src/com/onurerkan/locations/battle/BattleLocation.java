package com.onurerkan.locations.battle;

import com.onurerkan.Game;
import com.onurerkan.Player;
import com.onurerkan.locations.Location;
import com.onurerkan.monsters.Monster;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public abstract class BattleLocation extends Location {
    private Monster monster;
    private int maxMonster;
    private boolean continueCombat = true;

    public BattleLocation(int id, Player player, String name, Monster monster, int maxMonster) {
        super(id, player, name);
        this.monster = monster;
        this.maxMonster = maxMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int randomNumber = getRandomMonsterNumber();
        System.out.println(
                "Bulunduğunuz bölge: " + this.getName()
                        + "\nBurada " + randomNumber + " tane "
                        + getMonster().getMonsterName() + " var. Dikkatli ol!"
        );
        System.out.println("savaş(S) veya kaç(K) : ");
        Scanner scanner = new Scanner(System.in);
        String selectedChar = scanner.nextLine().toUpperCase();

        if (selectedChar.equals("S")) {
            System.out.println("Savaş başladııı");
            Monster[] monsters = new Monster[randomNumber];
            for (int i = 0; i < randomNumber; i++) {
                monsters[i] = monster;
            }
            boolean isLife = combat(monsters);
            if (isLife) {
                int totalCoin = monster.getCoin() * randomNumber;
                System.out.println("Tebrikler bütün " + monster.getMonsterName() + "leri temizlediniz."
                        + "\nkazancınız: " + totalCoin + " tane coin"
                );

                getPlayer().setCoin(getPlayer().getCoin() + totalCoin);

            }
            return isLife;
        } else {
            System.out.println("Kaç kaç kaç");
            return true;
            //kaçma işlemi gerçekleşecek
        }

    }

    public boolean combat(Monster[] monsters) {
        Scanner input = new Scanner(System.in);
        int monsterCount = 1;
        int defence = getPlayer().getInventory().getArmor().getArmorDefence();
        for (Monster monster : monsters) {
            while (continueCombat & (monster.getMosterHealth() > 0 || getPlayer().getHealthy() > 0)) {
                //adamımız vuruyor
                System.out.println(monsterCount + ". " + monster.getMonsterName()
                        + "'a/e (v)uracak mısın? yada (k)açacak mısın?");
                String selectedChar = input.nextLine().toUpperCase();
                if (selectedChar.equals("V")) {
                    monster.setMosterHealth(Math.max((monster.getMosterHealth() - getPlayer().getDamage()), 0));
                    System.out.println(monster.getMonsterName() + "'a bir tane vurdun" + monster.getMosterHealth());
                    System.out.println(monster.getMonsterName() + " kalan canı: " + monster.getMonsterDamage());
                } else if (selectedChar.equals("K")) {
                    System.out.println("Tabana kuvvet :)");
                    continueCombat = false;
                } else {
                    System.out.println("Yanlış tuşladın!");
                }
                if (monster.getMosterHealth() == 0) {
                    System.out.println(monsterCount + ". " + monster.getMonsterName() + " alt etmeyi başardın.");
                }
                //canavar vuruyor

                if (defence > 0) {
                    defence--;
                    System.out.println(getMonster().getMonsterName()
                            + "vurdu ama zırhından dolayı sana etki etmedi."
                            + "\nzırhın " + defence + " vuruşluk hakkı var. Bitince canın azalmaya başlayacak."
                    );

                } else {
                    System.out.println("Şimdi " + monster.getMonsterName() + " vurdu.");
                    getPlayer().setHealthy(Math.max((getPlayer().getHealthy() - monster.getMonsterDamage()), 0));
                    System.out.println(getPlayer().getCharName() + " kalan canı: " + getPlayer().getHealthy());
                    if (getPlayer().getHealthy() == 0) {
                        System.out.println("Öldün.");
                        return false;
                    }
                }

            }
            int monstersHealths = 0;
            for (Monster monsterr : monsters) {
                monstersHealths += monster.getMosterHealth();
            }
            if (monstersHealths == 0) {
                return true;
            }
            if (!continueCombat)
                break;
        }
        return false;
    }

    private int getRandomMonsterNumber() {
        Random random = new Random();
        return random.nextInt(this.getMaxMonster()) + 1;
    }

}
