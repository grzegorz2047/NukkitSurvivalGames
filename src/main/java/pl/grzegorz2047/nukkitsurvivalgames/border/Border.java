package pl.grzegorz2047.nukkitsurvivalgames.border;

import cn.nukkit.Server;
import cn.nukkit.level.Location;
import cn.nukkit.math.MathHelper;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public interface Border {
    boolean isInBounds(Location loc);

    void generateBoundaries();
}
