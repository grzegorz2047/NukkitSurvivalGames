package pl.grzegorz2047.nukkitsurvivalgames;

import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import pl.grzegorz2047.nukkitsurvivalgames.arena.ArenaManager;
import pl.grzegorz2047.nukkitsurvivalgames.commands.ChatCommand;
import pl.grzegorz2047.nukkitsurvivalgames.commands.CommandController;
import pl.grzegorz2047.nukkitsurvivalgames.commands.arena.ArenaCommand;
import pl.grzegorz2047.nukkitsurvivalgames.commands.spawnpoint.SpawnPointCommand;
import pl.grzegorz2047.nukkitsurvivalgames.filesmanaging.ConfigCreator;
import pl.grzegorz2047.nukkitsurvivalgames.listeners.ServerCommandListener;
import pl.grzegorz2047.nukkitsurvivalgames.spawns.SpawnPointController;
import pl.grzegorz2047.nukkitsurvivalgames.tasks.BroadcastTask;

/**
 * Plik stworzony przez grzegorz2047 26.03.2017.
 */
public class SurvivalGames extends PluginBase {


    private Server server;
    private CommandController commandController;
    private ArenaManager arenaManager;

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
        Config config = createConfig();
        if (config.exists("welcomeMsg")) {
            System.out.println("DZIALA config!");
        }

        registerEvents();
        registerCommands();
        msg(TextFormat.DARK_GREEN + this.getName() + " enabled!");
    }

    private void createThreads() {
        server.getScheduler().scheduleRepeatingTask(new BroadcastTask(this), 200);
    }

    private void registerCommands() {
        commandController = new CommandController();
        commandController.registerCommand(new SpawnPointCommand("spawnpoint", arenaManager), server.getCommandMap());
        commandController.registerCommand(new ArenaCommand("arena", arenaManager), server.getCommandMap());
    }

    private Config createConfig() {
        Config config = new ConfigCreator(this.getDataFolder().getPath(), "config", Config.YAML).getConfig();
        config.set("welcomeMsg", "Hi!");
        config.save();
        return config;
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