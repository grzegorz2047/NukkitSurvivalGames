package pl.grzegorz2047.nukkitsurvivalgames.sql;

import org.junit.Test;
import pl.grzegorz2047.nukkitsurvivalgames.sql.sqlite.SQLiteEngine;

import static org.junit.Assert.*;

/**
 * Plik stworzony przez grzegorz2047 30.04.2017.
 */
public class SQLEngineTest {
    @Test
    public void getDriver() throws Exception {
        SQLiteEngine sqLiteEngine = new SQLiteEngine("testDB");
        assertNotNull(sqLiteEngine.getConnection());
        assertEquals("testDB", sqLiteEngine.getDatabaseName());
    }

}