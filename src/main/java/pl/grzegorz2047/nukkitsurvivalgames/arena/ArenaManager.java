package pl.grzegorz2047.nukkitsurvivalgames.arena;

import cn.nukkit.Player;
import cn.nukkit.level.Location;
import pl.grzegorz2047.nukkitsurvivalgames.arena.exceptions.ArenaAlreadyExistsException;
import pl.grzegorz2047.nukkitsurvivalgames.arena.exceptions.ArenaDoesntExistsException;

import java.util.HashMap;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class ArenaManager {

    private HashMap<String, Arena> arenas = new HashMap<>();

    public Arena getArenaByName(String arenaname) throws ArenaDoesntExistsException {
        Arena arena = arenas.get(arenaname);
        if (arena != null) {
            return arena;
        }
        throw new ArenaDoesntExistsException("Arena with this name doesn't exists!");
    }


    public boolean addSpawnPointToArena(Location loc, String arenaname) {
        Arena arena;
        try {
            arena = getArenaByName(arenaname);
        } catch (ArenaDoesntExistsException e) {
            return false;
        }
        arena.addSpawnPoint(loc);
        return true;
    }

    public Arena addArena(String name, int maxPlayers, Location location) throws ArenaAlreadyExistsException {
        Arena arena = new Arena(name, maxPlayers, location);
        try {
            getArenaByName(name.toLowerCase());
        } catch (ArenaDoesntExistsException e) {
            throw new ArenaAlreadyExistsException("Arena " + name + " already exists!");
        }
        return arenas.put(name, arena);
    }
}
