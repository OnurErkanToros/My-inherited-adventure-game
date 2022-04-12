package com.onurerkan.locations.battle;

import com.onurerkan.Player;
import com.onurerkan.monsters.Bear;

public class River extends BattleLocation {
    public River(Player player) {
        super(3,player,"Nehir", new Bear(),2);
    }
}
