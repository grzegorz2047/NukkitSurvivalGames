package pl.grzegorz2047.nukkitsurvivalgames.sql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Plik stworzony przez grzegorz2047 30.04.2017.
 */
public interface SQLEngine {

    void createTables() throws SQLException;
    Connection getConnection() throws SQLException;
    String getName();
}
