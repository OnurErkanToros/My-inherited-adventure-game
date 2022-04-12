package com.onurerkan.locations;

import com.onurerkan.Player;

public abstract class Location {
    private int id;
    private Player player;
    private String name;

    public Location(int id, Player player, String name) {
        this.id=id;
        this.player = player;
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public abstract boolean onLocation();
}
