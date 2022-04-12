package com.onurerkan.locations.battle;

import com.onurerkan.Player;
import com.onurerkan.monsters.Monster;
import com.onurerkan.monsters.Vampire;

public class Forest extends BattleLocation {


    public Forest(Player player) {
        super(2, player, "Orman", new Vampire(), 3);
    }
}
