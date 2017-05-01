package pl.grzegorz2047.nukkitsurvivalgames.sql.mysql;

import pl.grzegorz2047.nukkitsurvivalgames.sql.SQLTableCreator;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Plik stworzony przez grzegorz2047 01.05.2017.
 */
public class MySQLTableCreator implements SQLTableCreator {
    private final Connection connection;

    public MySQLTableCreator(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void generateTables() throws SQLException {

    }
}
