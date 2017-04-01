package pl.grzegorz2047.nukkitsurvivalgames.filesmanaging;


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
    public void createConfig() throws IOException {
        File temp = File.createTempFile("config", ".yml");
        String path = temp.getPath().replaceAll(temp.getName(), "");
        //System.out.println("Abs path: " + path);
        String name = temp.getName().replaceAll(".yml", "");
        //System.out.println("Abs name: " + name);

        ConfigCreator configCreator = new ConfigCreator(path, name);
        assertNotNull(configCreator.getConfig());
    }

}