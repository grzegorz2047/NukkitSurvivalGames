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
        Arena arena = arenas.get(arenaname.toLowerCase());
        if (arena != null) {
            return arena;
        }
        throw new ArenaDoesntExistsException("Arena with this name doesn't exists!");
    }


    public boolean addSpawnPointToArena(Location loc, String arenaname) {
        Arena arena;
        try {
            arena = getArenaByName(arenaname.toLowerCase());
        } catch (ArenaDoesntExistsException e) {
            return false;
        }
        arena.addSpawnPoint(loc);
        return true;
    }

    public Arena addArena(String name, int maxPlayers, Location location) throws ArenaAlreadyExistsException {
        Arena arena;
        String arenaName = name.toLowerCase();
        try {
            arena = getArenaByName(arenaName);
            if (arena != null) {
                throw new ArenaAlreadyExistsException("Arena " + arenaName + " already exists!");
            }

            System.out.println("Arena istnieje");
        } catch (ArenaDoesntExistsException e) {
            System.out.println("Arena nie istnieje");
            arena = new Arena(arenaName, maxPlayers, location);
        }
        arenas.put(arenaName, arena);
        return arena;
    }
}
