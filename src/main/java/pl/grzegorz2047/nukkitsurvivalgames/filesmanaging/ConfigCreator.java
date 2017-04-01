package pl.grzegorz2047.nukkitsurvivalgames.filesmanaging;

import cn.nukkit.utils.Config;

import java.io.File;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class ConfigCreator {

    private Config config;

    public ConfigCreator(String path, String name, int type) {
        config = createConfig(path, name, type);
    }

    private Config createConfig(String path, String name, int type) {
        new File(path).mkdirs();
        File file = new File(path, name + ".yml");
        //System.out.println("cc file: "+ file.getName() + "  pat "+ file.getAbsolutePath());
        Config config = new Config(file, type);
        config.save();
        return config;
    }

    public Config getConfig() {
        return config;
    }
}
