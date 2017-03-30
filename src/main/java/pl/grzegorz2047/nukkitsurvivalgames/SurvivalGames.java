package pl.grzegorz2047.nukkitsurvivalgames;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import pl.grzegorz2047.nukkitsurvivalgames.listeners.ServerCommandListener;
import pl.grzegorz2047.nukkitsurvivalgames.tasks.BroadcastTask;

import java.io.File;
import java.util.LinkedHashMap;

/**
 * Plik stworzony przez grzegorz2047 26.03.2017.
 */
public class SurvivalGames extends PluginBase {

    @Override
    public void onLoad() {
        this.getLogger().info(TextFormat.WHITE + "onLoad!");
    }

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.DARK_GREEN + " enabled");

        this.getLogger().info(String.valueOf(this.getDataFolder().mkdirs()));

        //Register the EventListener
        this.getServer().getPluginManager().registerEvents(new ServerCommandListener(this), this);

        //PluginTask
        this.getServer().getScheduler().scheduleRepeatingTask(new BroadcastTask(this), 200);

        //Save resources

        //Config reading and writing
        Config config = new Config(
                new File(this.getDataFolder(), "config.yml"),
                Config.YAML,
                //Default values (not necessary)
                new LinkedHashMap<String, Object>() {
                    {
                        put("this-is-a-key", "Hello! Config!");
                        put("another-key", true); //you can also put other standard objects!
                    }
                });
        //Now try to get the value, the default value will be given if the key isn't exist!
        this.getLogger().info(String.valueOf(config.get("this-is-a-key", "this-is-default-value")));
        //Don't forget to save it!
        config.save();
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "I've been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.getName()) {
            case "example":

        }
        return true;
    }

}