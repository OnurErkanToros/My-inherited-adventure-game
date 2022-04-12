package com.onurerkan.locations.safe;

import com.onurerkan.Player;

public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player) {
        super(1,player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz.");
        getPlayer().setHealthy(getPlayer().getDefaultHeath());
        System.out.println("Canınız fullendi.");
        return true;
    }
}
