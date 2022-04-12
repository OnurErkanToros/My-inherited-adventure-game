package com.onurerkan.locations.safe;

import com.onurerkan.Player;
import com.onurerkan.locations.Location;

public abstract class NormalLocation extends Location {

    public NormalLocation(int id, Player player, String name) {
        super(id, player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }


}
