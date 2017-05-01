package pl.grzegorz2047.nukkitsurvivalgames.sql.mysql;

import pl.grzegorz2047.nukkitsurvivalgames.sql.SQLEngine;
import pl.grzegorz2047.nukkitsurvivalgames.sql.SQLTableCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Plik stworzony przez grzegorz2047 30.04.2017.
 */
public class MySQLEngine implements SQLEngine {

    private final String host;
    private final int port;
    private final String user;
    private final String password;
    private final String databaseName;

    public MySQLEngine(String host, int port, String databaseName, String user, String password) {
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
        this.user = user;
        this.password = password;
    }

    @Override
    public void createTables(SQLTableCreator tableCreator) throws SQLException {

    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?autoReconnect=true", user, password);
        } catch(SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    @Override
    public String getName() {
        return "mysql";
    }
}
