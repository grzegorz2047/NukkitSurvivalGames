package pl.grzegorz2047.nukkitsurvivalgames;

import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import pl.grzegorz2047.nukkitsurvivalgames.filesmanaging.ConfigCreator;
import pl.grzegorz2047.nukkitsurvivalgames.listeners.ServerCommandListener;
import pl.grzegorz2047.nukkitsurvivalgames.tasks.BroadcastTask;

/**
 * Plik stworzony przez grzegorz2047 26.03.2017.
 */
public class SurvivalGames extends PluginBase {


    private Server server;

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
        msg(TextFormat.DARK_GREEN + " enabled!");

//        msg(String.valueOf());

        //PluginTask
        server.getScheduler().scheduleRepeatingTask(new BroadcastTask(this), 200);
        Config config = new ConfigCreator(this.getDataFolder().getPath(), "config").getConfig();
        config.set("welcomeMsg", "Hi!");
        config.save();

        if(config.exists("welcomeMsg")) {
            System.out.println("DZIALA config!");
        }
    }

    private void registerEvents() {
        PluginManager pm = server.getPluginManager();
        pm.registerEvents(new ServerCommandListener(this), this);
    }


    @Override
    public void onDisable() {
        msg(TextFormat.DARK_GREEN + " disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.getName()) {
            case "example":

        }
        return true;
    }

}