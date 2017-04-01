package pl.grzegorz2047.nukkitsurvivalgames.spawns;

import cn.nukkit.level.Location;
import pl.grzegorz2047.nukkitsurvivalgames.spawns.exceptions.NoFreeSpawnPointAvailable;

import java.util.ArrayList;
import java.util.List;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class SpawnPointController {

    private List<SpawnPoint> spawnPoints = new ArrayList<>();

    public void addSpawnPoint(Location loc) {
        SpawnPoint sp = new SpawnPoint(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch(), loc.getLevel().getName());
        spawnPoints.add(sp);
    }

    public boolean isThereAnyFreeSpawnPoint() {
        for (SpawnPoint sp : spawnPoints) {
            if (sp.isFree()) {
                return true;
            }
        }
        return false;
    }

    private SpawnPoint getFirstFreeSpawnPoint() throws NoFreeSpawnPointAvailable {
        for (SpawnPoint sp : spawnPoints) {
            if (sp.isFree()) {
                return sp;
            }
        }
        throw new NoFreeSpawnPointAvailable("There is no free spawnpoint available!");
    }

    public boolean assignPlayerToSpawnPoint(String player) {
        if (isThereAnyFreeSpawnPoint()) {
            try {
                SpawnPoint firstFreeSpawnPoint = getFirstFreeSpawnPoint();
                firstFreeSpawnPoint.setOccupiedBy(player);
                return true;
            } catch (NoFreeSpawnPointAvailable noFreeSpawnPointAvailable) {
                return false;
            }
        }
        return false;
    }

    public void resetAssignedSpawnPoints() {
        for (SpawnPoint sp : spawnPoints) {
            sp.setFree(true);
        }
    }

}
