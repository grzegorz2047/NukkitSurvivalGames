package pl.grzegorz2047.nukkitsurvivalgames.sql;

import cn.nukkit.utils.Config;
import pl.grzegorz2047.nukkitsurvivalgames.sql.mysql.MySQLEngine;
import pl.grzegorz2047.nukkitsurvivalgames.sql.mysql.MySQLTableCreator;
import pl.grzegorz2047.nukkitsurvivalgames.sql.sqlite.SQLiteEngine;
import pl.grzegorz2047.nukkitsurvivalgames.sql.sqlite.SQLiteTableCreator;

import java.sql.SQLException;

/**
 * Plik stworzony przez grzegorz2047 30.04.2017.
 */
public class SQLManager {

    private final Config config;
    private SQLEngine engine;

    public SQLManager(Config config) throws SQLException {
        this.config = config;
        chooseSQLEngine();
    }

    private void chooseSQLEngine() throws SQLException {
        boolean useMysql = config.getBoolean("useMysql");
        if (useMysql) {
            String host = config.getString("sql.host");
            int port = config.getInt("sql.port");
            String user = config.getString("sql.user");
            String password = config.getString("sql.password");
            String databaseName = config.getString("sql.databaseName");

            engine = new MySQLEngine(host, port, databaseName, user, password);

            engine.createTables(new MySQLTableCreator(engine.getConnection()));
        } else {
            String databaseName = config.getString("sql.databaseName");
            engine = new SQLiteEngine(databaseName);
            engine.createTables(new SQLiteTableCreator(engine.getConnection()));
        }
    }

    public SQLEngine getEngine() {
        return engine;
    }
}
