package pl.grzegorz2047.nukkitsurvivalgames.arena;

import cn.nukkit.level.Location;
import pl.grzegorz2047.nukkitsurvivalgames.border.Border;
import pl.grzegorz2047.nukkitsurvivalgames.spawns.SpawnPointController;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class Arena {

    private final String arenaName;
    private SpawnPointController spawnPointController = new SpawnPointController();
    private int maxPlayers = 10;
    private boolean allowSpectators = true;
    private Border border;

    public Arena(String name, int maxPlayers, Location location) {
        this.arenaName = name;
        this.maxPlayers = maxPlayers;
        this.border = new Border(location, Integer.MAX_VALUE);
    }

    public void addSpawnPoint(Location loc) {
        spawnPointController.addSpawnPoint(loc);
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public boolean areSpectatorsAllowed() {
        return allowSpectators;
    }

    public void allowSpectatorsToJoin(boolean allowSpectators) {
        this.allowSpectators = allowSpectators;
    }

    public Border getBorder() {
        return border;
    }


}
