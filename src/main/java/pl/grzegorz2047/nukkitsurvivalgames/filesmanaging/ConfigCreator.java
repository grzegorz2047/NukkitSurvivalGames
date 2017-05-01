package pl.grzegorz2047.nukkitsurvivalgames.filesmanaging;

import cn.nukkit.utils.Config;

import java.io.*;
import java.net.URL;
import java.security.CodeSource;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class ConfigCreator {

    private Config config;


    public ConfigCreator(String path, String name, int type) throws Exception {
        config = createConfig(path, name, type);
    }

    private Config createConfig(String path, String name, int type) throws Exception {
        new File(path).mkdirs();
        File file = new File(path, name + ".yml");
        if (file.canRead()) {
            //System.out.println("cc file: "+ file.getName() + "  pat "+ file.getAbsolutePath());
            return new Config(file, type);
        }
        copyFile(file);

        //System.out.println("cc file: "+ file.getName() + "  pat "+ file.getAbsolutePath());
        Config config = new Config(file, type);
        config.save();
        return config;
    }

    private void copyFile(File file) throws Exception {
        file.getParentFile().mkdirs();
        if (searchJarForFile(file.getName()) != null) {
            copyFileFromJar(searchJarForFile(file.getName()), file);
        } else {
            file.createNewFile();
            System.out.println("Plik " + file.getName() + " nie jest dolaczony do pluginu. Zostanie utworzony przy zapisie danych");
        }

    }

    private ZipInputStream searchJarForFile(String name) throws IOException {
        CodeSource src = ConfigCreator.class.getProtectionDomain().getCodeSource();
        if (src != null) {
            URL jar = src.getLocation();
            ZipInputStream zip = new ZipInputStream(jar.openStream());
            while (true) {
                ZipEntry e = zip.getNextEntry();
                if (e == null)
                    break;
                String nextFileName = e.getName();
                if (nextFileName.startsWith(name)) {
                    return zip;
                }
            }
        }
        return null;
    }

    private void copyFileFromJar(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Config getConfig() {
        return config;
    }
}
