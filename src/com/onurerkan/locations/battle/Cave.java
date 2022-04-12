package com.onurerkan.locations.battle;

import com.onurerkan.Player;
import com.onurerkan.monsters.Monster;
import com.onurerkan.monsters.Zombie;

public class Cave extends BattleLocation {
    public Cave(Player player) {
        super(1, player, "Mağara", new Zombie(), 2);
    }


}
