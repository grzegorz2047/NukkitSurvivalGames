package pl.grzegorz2047.nukkitsurvivalgames;

import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import pl.grzegorz2047.nukkitsurvivalgames.arena.ArenaManager;
import pl.grzegorz2047.nukkitsurvivalgames.commands.CommandController;
import pl.grzegorz2047.nukkitsurvivalgames.commands.arena.ArenaCommand;
import pl.grzegorz2047.nukkitsurvivalgames.commands.spawnpoint.SpawnPointCommand;
import pl.grzegorz2047.nukkitsurvivalgames.filesmanaging.ConfigCreator;
import pl.grzegorz2047.nukkitsurvivalgames.listeners.ServerCommandListener;
import pl.grzegorz2047.nukkitsurvivalgames.messages.Messages;
import pl.grzegorz2047.nukkitsurvivalgames.sql.SQLManager;
import pl.grzegorz2047.nukkitsurvivalgames.sql.mysql.MySQLEngine;
import pl.grzegorz2047.nukkitsurvivalgames.sql.sqlite.SQLiteEngine;
import pl.grzegorz2047.nukkitsurvivalgames.tasks.BroadcastTask;

import java.sql.SQLException;

/**
 * Plik stworzony przez grzegorz2047 26.03.2017.
 */
public class SurvivalGames extends PluginBase {


    private Server server;
    private CommandController commandController;
    private ArenaManager arenaManager;
    private SQLManager sqlManager;
    private Messages messages;

    public static void msg(String msg) {
        Server.getInstance().getLogger().info(msg);
    }

    @Override
    public void onLoad() {
        this.getLogger().info(TextFormat.WHITE + "onLoad!");
    }

    @Override
    public void onEnable() {
        server = this.getServer();
        arenaManager = new ArenaManager();
        createThreads();
        Config config = null;
        try {
            config = createConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Config messageConfig = null;
        try {
            messageConfig = createMessageConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
        messages = new Messages(messageConfig);
        try {
            prepareDatabase(config);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        registerEvents();
        registerCommands();

        msg(TextFormat.DARK_GREEN + this.getName() + " enabled!");
    }

    private void prepareDatabase(Config config) throws SQLException {
        sqlManager = new SQLManager();
        boolean useMysql = config.getBoolean("useMysql");

        if (useMysql) {
            String host = config.getString("sql.host");
            int port = config.getInt("sql.port");
            String user = config.getString("sql.user");
            String password = config.getString("sql.password");
            String databaseName = config.getString("sql.databaseName");
            sqlManager.connect(new MySQLEngine(host, port, databaseName, user, password));
        } else {
            String databaseName = config.getString("sql.databaseName");
            sqlManager.connect(new SQLiteEngine(databaseName));
        }
    }

    private void createThreads() {
        server.getScheduler().scheduleRepeatingTask(new BroadcastTask(this), 200);
    }

    private void registerCommands() {
        commandController = new CommandController();
        commandController.registerCommand(new SpawnPointCommand("spawnpoint", arenaManager), server.getCommandMap());
        commandController.registerCommand(new ArenaCommand("arena", arenaManager), server.getCommandMap());

    }

    private Config createConfig() throws Exception {
        Config config = new ConfigCreator(this.getDataFolder().getPath(), "config", Config.YAML).getConfig();
/*        config.set("welcomeMsg", "Hi!");
        config.save();*/
        return config;
    }
    private Config createMessageConfig() throws Exception {
        return new ConfigCreator(this.getDataFolder().getPath(), "messages", Config.YAML).getConfig();
    }

    private void registerEvents() {
        PluginManager pm = server.getPluginManager();
        pm.registerEvents(new ServerCommandListener(this), this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        commandController.passCommand(command.getName(), commandSender, label, args);
        return true;
    }

    @Override
    public void onDisable() {
        msg(TextFormat.DARK_GREEN + " disabled!");
    }

}