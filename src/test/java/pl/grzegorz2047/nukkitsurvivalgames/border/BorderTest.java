package pl.grzegorz2047.nukkitsurvivalgames.border;

import cn.nukkit.level.Location;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class BorderTest {
    @Test
    public void isInBounds() throws Exception {
        Location location = new Location(0, 0, 0);
        Location l2 = new Location(5, 0, 0);
        Border border = new Border(location, 5);
        assertTrue(border.isInBounds(l2));
    }

    @Test
    public void getCenter() throws Exception {
        Location location = new Location(0, 0, 0);
        Border border = new Border(location, 5);

        assertEquals(location, border.getCenter());
    }

}