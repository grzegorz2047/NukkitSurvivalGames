package pl.grzegorz2047.nukkitsurvivalgames.sql.sqlite;

import pl.grzegorz2047.nukkitsurvivalgames.sql.SQLTableCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Plik stworzony przez grzegorz2047 30.04.2017.
 */
public class SQLiteTableCreator implements SQLTableCreator {

    private final Connection connection;

    public SQLiteTableCreator(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void generateTables() throws SQLException {
        PreparedStatement arenaCreateStatement = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS arenas (" +
                "  arenaid INTEGER PRIMARY KEY," +
                "  maxPlayers INTEGER," +
                "  enabled INTEGER," +
                "  allowSpectators INTEGER," +
                "  borderId INTEGER," +
                "  FOREIGN KEY(customer_id) REFERENCES customers(id)" +
                ");");
        arenaCreateStatement.execute();

        PreparedStatement borderCreateStatement = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS borders (" +
                "  arenaid INTEGER PRIMARY KEY," +
                "  maxPlayers INTEGER," +
                "  enabled INTEGER," +
                "  allowSpectators INTEGER," +
                "  borderId INTEGER," +
                "  FOREIGN KEY(customer_id) REFERENCES customers(id)" +
                ");");
        borderCreateStatement.execute();
    }
}
