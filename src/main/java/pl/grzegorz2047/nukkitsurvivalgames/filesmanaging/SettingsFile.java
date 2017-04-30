package pl.grzegorz2047.nukkitsurvivalgames.filesmanaging;

import cn.nukkit.utils.Config;

/**
 * Plik stworzony przez grzegorz2047 30.04.2017.
 */
public class SettingsFile {

    private Config configCreator;

    public SettingsFile(Config creator) {
        configCreator = creator;
    }

    public Config getConfig() {
        return configCreator;
    }
}
