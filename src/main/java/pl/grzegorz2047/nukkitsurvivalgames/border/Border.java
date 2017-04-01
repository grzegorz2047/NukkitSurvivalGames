package pl.grzegorz2047.nukkitsurvivalgames.border;

import cn.nukkit.Server;
import cn.nukkit.level.Location;
import cn.nukkit.math.MathHelper;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class Border {

    private final Location location;
    private final int radius;

    public Border(Location location, int radius) {
        this.location = location;
        this.radius = radius;

    }

    public boolean isInBound(Location loc) {
        return location.distance(loc) <= radius;
    }

}
