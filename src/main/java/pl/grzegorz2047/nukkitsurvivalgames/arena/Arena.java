package pl.grzegorz2047.nukkitsurvivalgames.arena;

import cn.nukkit.level.Location;
import pl.grzegorz2047.nukkitsurvivalgames.spawns.SpawnPointController;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class Arena {

    private SpawnPointController spawnPointController = new SpawnPointController();

    public Arena() {

    }

    public void addSpawnPoint(Location loc) {
        spawnPointController.addSpawnPoint(loc);
    }
}
