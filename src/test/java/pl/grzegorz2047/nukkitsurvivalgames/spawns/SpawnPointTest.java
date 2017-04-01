package pl.grzegorz2047.nukkitsurvivalgames.spawns;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class SpawnPointTest {

    @Test
    public void isFree() throws Exception {
        SpawnPoint spawnPoint = new SpawnPoint(1, 2, 3, 4, 5, "SG1");
        assertTrue(spawnPoint.isFree());
        spawnPoint.setOccupiedBy("TheMolkaPL");
        assertFalse(spawnPoint.isFree());
    }

    @Test
    public void getOccupiedBy() throws Exception {
        SpawnPoint spawnPoint = new SpawnPoint(1, 2, 3, 4, 5, "SG1");
        spawnPoint.setOccupiedBy("grzegorz2047");
        assertEquals("grzegorz2047", spawnPoint.getOccupiedBy());
    }

    @Test
    public void getWorldName() throws Exception {
        SpawnPoint spawnPoint = new SpawnPoint(1, 2, 3, 4, 5, "SG1");
        assertEquals("SG1", spawnPoint.getWorldName());
    }

}