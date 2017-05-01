package pl.grzegorz2047.nukkitsurvivalgames.filesmanaging;


import cn.nukkit.utils.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ConfigCreatorTest {

    @Test
    public void createConfig() throws Exception {
        File temp = File.createTempFile("config", ".yml");
        ConfigCreator configCreator = createConfigCreator(temp);
        assertNotNull(configCreator.getConfig());
        temp.delete();
    }

    private ConfigCreator createConfigCreator(File temp) throws Exception {
        String path = temp.getPath().replaceAll(temp.getName(), "");
        //System.out.println("Abs path: " + path);
        String name = temp.getName().replaceAll(".yml", "");
        //System.out.println("Abs name: " + name);
        return new ConfigCreator(path, name, Config.YAML);
    }
}