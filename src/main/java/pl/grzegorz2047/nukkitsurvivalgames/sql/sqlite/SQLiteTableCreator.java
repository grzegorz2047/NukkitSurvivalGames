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
        Statement statement = connection.createStatement();
        statement.execute(
                "CREATE TABLE IF NOT EXISTS arena (" +
                        "  arenaid INTEGER PRIMARY KEY," +
                        "  maxPlayers INTEGER," +
                        "  enabled INTEGER," +
                        "  allowSpectators INTEGER" +
                        ");");

        statement.execute(
                "CREATE TABLE IF NOT EXISTS border (" +
                        "  borderId INTEGER PRIMARY KEY," +
                        "  centerX INTEGER," +
                        "  centerY INTEGER," +
                        "  centerZ INTEGER," +
                        "  pos1X INTEGER," +
                        "  pos1Y INTEGER," +
                        "  pos1Z INTEGER," +
                        "  pos2X INTEGER," +
                        "  pos2Y INTEGER," +
                        ");");
        statement.execute(
                "CREATE TABLE IF NOT EXISTS assignedBorderToArena (" +
                        "  assignId INTEGER PRIMARY KEY," +
                        "  arenaId INTEGER," +
                        "  borderId INTEGER," +
                        "  FOREIGN KEY(arenaId) REFERENCES arenas(arenaId)," +
                        "  FOREIGN KEY(borderId) REFERENCES borders(borderId)" +
                        ");");
        statement.close();
    }
}
