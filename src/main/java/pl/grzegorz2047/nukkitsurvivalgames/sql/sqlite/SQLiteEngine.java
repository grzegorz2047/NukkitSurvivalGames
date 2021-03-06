package pl.grzegorz2047.nukkitsurvivalgames.sql.sqlite;

import com.zaxxer.hikari.HikariDataSource;
import pl.grzegorz2047.nukkitsurvivalgames.sql.SQLEngine;
import pl.grzegorz2047.nukkitsurvivalgames.sql.SQLTableCreator;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Plik stworzony przez grzegorz2047 30.04.2017.
 */
public class SQLiteEngine implements SQLEngine {

    private HikariDataSource hikari;
    private final String databaseName;

    public SQLiteEngine(String databaseName) {
        this.databaseName = databaseName;

        this.hikari = new HikariDataSource();
        this.hikari.setDataSourceClassName("org.sqlite.SQLiteDataSource");
        this.hikari.addDataSourceProperty("databaseName", this.databaseName + ".sqlite3");
        this.hikari.setConnectionTestQuery("SELECT 1");
    }



    @Override
    public void createTables(SQLTableCreator tableCreator) throws SQLException {
        tableCreator.generateTables();
    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.hikari.getConnection();
    }


    @Override
    public String getName() {
        return "sqlite";
    }

    public String getDatabaseName() {
        return databaseName;
    }
}
