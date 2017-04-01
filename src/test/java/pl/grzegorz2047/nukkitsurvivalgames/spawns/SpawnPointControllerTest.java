package pl.grzegorz2047.nukkitsurvivalgames.spawns;

import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SpawnPointControllerTest {
    @Test
    public void addSpawnPoint() throws Exception {
        SpawnPointController spawnPointController = new SpawnPointController();

        Level l = Mockito.mock(Level.class);
        Location loc1 = new Location(0, 0, 0, l);
        Location loc2 = new Location(2, 2, 3, l);

        spawnPointController.addSpawnPoint(loc1);
        spawnPointController.addSpawnPoint(loc2);

        when(loc1.getLevel().getName()).thenReturn("TestWorld");
        when(loc2.getLevel().getName()).thenReturn("TestWorld");

        assertTrue(spawnPointController.isThereAnyFreeSpawnPoint());
        spawnPointController.assignPlayerToSpawnPoint("grzegorz");
        assertTrue(spawnPointController.isThereAnyFreeSpawnPoint());
    }

    @Test
    public void isThereAnyFreeSpawnPoint() throws Exception {
        SpawnPointController spawnPointController = new SpawnPointController();

        Level l = Mockito.mock(Level.class);
        Location loc1 = new Location(0, 0, 0, l);
        Location loc2 = new Location(2, 2, 3, l);

        when(loc1.getLevel().getName()).thenReturn("TestWorld");
        when(loc2.getLevel().getName()).thenReturn("TestWorld");

        spawnPointController.addSpawnPoint(loc1);

        assertTrue(spawnPointController.isThereAnyFreeSpawnPoint());

        spawnPointController.assignPlayerToSpawnPoint("grzegorz");
        assertFalse(spawnPointController.isThereAnyFreeSpawnPoint());

        spawnPointController.addSpawnPoint(loc2);
        assertTrue(spawnPointController.isThereAnyFreeSpawnPoint());
    }

    @Test
    public void assignPlayerToSpawnPoint() throws Exception {
        SpawnPointController spawnPointController = new SpawnPointController();
        assertFalse(spawnPointController.assignPlayerToSpawnPoint("grzegorz"));

        Level l = Mockito.mock(Level.class);
        Location loc = new Location(0, 3, 2, l);

        when(loc.getLevel().getName()).thenReturn("TestWorld");

        spawnPointController.addSpawnPoint(loc);
        assertTrue(spawnPointController.assignPlayerToSpawnPoint("Adam"));
    }

}