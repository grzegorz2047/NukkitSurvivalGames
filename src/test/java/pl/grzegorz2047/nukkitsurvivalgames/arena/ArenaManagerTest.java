package pl.grzegorz2047.nukkitsurvivalgames.arena;

import cn.nukkit.level.Location;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class ArenaManagerTest {

    @Test
    public void addArena() throws Exception {
        ArenaManager arenaManager = new ArenaManager();
        Location loc = new Location(3, 3, 3);
        arenaManager.addArena("test", 20, loc);
        Arena taskAdded = arenaManager.addArena("Task", 20, loc);
        Arena a = arenaManager.getArenaByName("test");
        Arena b = arenaManager.getArenaByName("Task");
        assertNotNull(a);
        assertEquals(loc, a.getBorder().getCenter());
        assertEquals(taskAdded, b);
    }

    @Test
    public void getArenaByName() throws Exception {
        ArenaManager arenaManager = new ArenaManager();
        arenaManager.addArena("test", 20, new Location(3, 3, 3));
        arenaManager.addArena("Atest", 30, new Location(3, 3, 3));
        Arena a = arenaManager.getArenaByName("test");
        Arena b = arenaManager.getArenaByName("Atest");
        assertNotNull(a);
        assertNotNull(b);
        assertEquals(20, a.getMaxPlayers());
        assertEquals(30, b.getMaxPlayers());
    }

    @Test
    public void addSpawnPointToArena() throws Exception {
        ArenaManager arenaManager = new ArenaManager();
        String arenaName = "Test";
        arenaManager.addArena(arenaName, 20, new Location(3, 5, 2));
        boolean result = arenaManager.addSpawnPointToArena(new Location(3, 3, 3), "TestMap", arenaName);
        assertTrue(result);
        Arena a = arenaManager.getArenaByName("Test");

    }


}