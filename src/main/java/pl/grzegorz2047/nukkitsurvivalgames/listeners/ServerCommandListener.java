package pl.grzegorz2047.nukkitsurvivalgames.listeners;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.server.ServerCommandEvent;
import pl.grzegorz2047.nukkitsurvivalgames.SurvivalGames;

/**
 * Plik stworzony przez grzegorz2047 26.03.2017.
 */
public class ServerCommandListener implements Listener {
    private SurvivalGames plugin;

    public ServerCommandListener(SurvivalGames plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onServerCommand(ServerCommandEvent e) {
        this.plugin.getLogger().info("ServerCommandEvent is called!");
        //you can do more here!
    }
}