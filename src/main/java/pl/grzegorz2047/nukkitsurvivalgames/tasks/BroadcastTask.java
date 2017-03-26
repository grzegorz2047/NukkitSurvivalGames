package pl.grzegorz2047.nukkitsurvivalgames.tasks;

import cn.nukkit.scheduler.PluginTask;
import pl.grzegorz2047.nukkitsurvivalgames.SurvivalGames;

/**
 * Plik stworzony przez grzegorz2047 26.03.2017.
 */
public class BroadcastTask extends PluginTask<SurvivalGames> {

    public BroadcastTask(SurvivalGames owner) {
        super(owner);
    }

    @Override
    public void onRun(int currentTick) {
        this.getOwner().getLogger().info("I've run on tick " + currentTick);
    }
}
