package pl.grzegorz2047.nukkitsurvivalgames.sql;

import pl.grzegorz2047.nukkitsurvivalgames.sql.mysql.MySQLEngine;

import java.sql.SQLException;

/**
 * Plik stworzony przez grzegorz2047 30.04.2017.
 */
public class SQLManager {

    private SQLEngine engine;

    public void connect(SQLEngine engine) throws SQLException {
        this.engine = engine;
        this.engine.createTables();
    }

    public SQLEngine getEngine() {
        return engine;
    }
}
