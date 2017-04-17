package pl.grzegorz2047.nukkitsurvivalgames.arena;

import cn.nukkit.Player;
import cn.nukkit.level.Location;
import org.junit.Test;
import org.mockito.Mockito;
import pl.grzegorz2047.nukkitsurvivalgames.arena.exceptions.PlayerIsntAssignedToSpawnPointException;
import pl.grzegorz2047.nukkitsurvivalgames.spawns.SpawnPoint;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Plik stworzony przez grzegorz2047 17.04.2017.
 */
public class ArenaTest {

    @Test(expected = PlayerIsntAssignedToSpawnPointException.class)
    public void whenYouGetUnassigedPlayerToSpawnPointShouldTrowException() throws Exception {
        Arena arena = new Arena("Test", 20, new Location(20, 30, 20));
        arena.getSpawnPointOccupiedByPlayer("grzegorz2047");
    }

    @Test
    public void addSpawnPoint() throws Exception {
        Arena arena = new Arena("Test", 20, new Location(20, 30, 20));
    }

    @Test
    public void getMaxPlayers() throws Exception {
        Arena arena = new Arena("Test", 20, new Location(20, 30, 20));
        assertTrue(arena.getMaxPlayers() == 20);
    }

    @Test
    public void setMaxPlayers() throws Exception {
        Arena arena = new Arena("Test", 20, new Location(20, 30, 20));
        arena.setMaxPlayers(30);
        assertTrue(arena.getMaxPlayers() == 30);
    }

    @Test
    public void areSpectatorsAllowed() throws Exception {
        Arena arena = new Arena("Test", 20, new Location(20, 30, 20));
        arena.allowSpectatorsToJoin(true);
        assertTrue(arena.areSpectatorsAllowed());
    }

    @Test
    public void allowSpectatorsToJoin() throws Exception {
        Arena arena = new Arena("Test", 20, new Location(20, 30, 20));
        arena.allowSpectatorsToJoin(true);
        assertTrue(arena.areSpectatorsAllowed());
    }

    @Test
    public void getBorder() throws Exception {
        Location loc = new Location(20, 30, 20);
        Arena arena = new Arena("Test", 20, loc);
        assertNotNull(arena.getBorder());
        assertTrue(arena.getBorder().getCenter().equals(loc));
    }

    @Test
    public void assignPlayerToSpawnPoint() throws Exception {
        Arena arena = new Arena("Test", 20, new Location(20, 30, 20));
        Player p = Mockito.mock(Player.class);
        when(p.getName()).thenReturn("grzegorz2047");
        arena.addSpawnPoint(new Location(2, 3, 4), "TestMap");
        boolean result = arena.assignPlayerToSpawnPoint(p.getName());
        assertTrue(result);
        SpawnPoint sp = arena.getSpawnPointOccupiedByPlayer(p.getName());
        assertNotNull(sp);
    }

}