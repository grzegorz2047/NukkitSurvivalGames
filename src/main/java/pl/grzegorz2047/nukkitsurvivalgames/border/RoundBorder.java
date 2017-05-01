package pl.grzegorz2047.nukkitsurvivalgames.border;

import cn.nukkit.level.Location;

/**
 * Plik stworzony przez grzegorz2047 01.05.2017.
 */
public class RoundBorder implements Border {
    private final Location center;
    private final int radius;

    public RoundBorder(Location center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean isInBounds(Location loc) {
        return center.distance(loc) <= radius;
    }

    @Override
    public void generateBoundaries() {
        
    }
}
