package com.onurerkan;

import com.onurerkan.locations.Location;
import com.onurerkan.locations.battle.Cave;
import com.onurerkan.locations.battle.Forest;
import com.onurerkan.locations.battle.River;
import com.onurerkan.locations.safe.SafeHouse;
import com.onurerkan.locations.safe.Toolstore;

import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;
    public static Scanner input = new Scanner(System.in);

    public void start() {
        System.out.print("Bir oyuncu ismi giriniz:");
        String playerName = input.nextLine();
        player = new Player(playerName);
        System.out.println(player.getName() + " hoşgeldin.");
        player.selectCharacter();

        while (true) {
            player.printInfo();
            System.out.println("------------------------------------------------------------");
            System.out.println("Bölgeler");
            Location[] locations = {new SafeHouse(player), new Toolstore(player),
                    new Cave(player), new River(player), new Forest(player)};
            for (Location location : locations) {
                System.out.println(
                        "ID: " + location.getId()
                                + "\t Bölge: " + location.getName()
                );
            }
            System.out.print("Bir bölge seçiniz: ");
            int selectLocationID = input.nextInt();
            while (selectLocationID < 0 || selectLocationID > 5) {
                System.out.print("Geçersiz tuşlama yaptınız, tekrar giriniz: ");
                selectLocationID = input.nextInt();
            }
            location = locations[selectLocationID-1];
            if (!location.onLocation()) {
                System.out.println("Game Over");
                break;
            }
            System.out.println("------------------------------------------------------------");
        }
    }
}
