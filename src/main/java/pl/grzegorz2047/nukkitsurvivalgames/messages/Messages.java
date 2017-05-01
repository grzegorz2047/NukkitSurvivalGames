package pl.grzegorz2047.nukkitsurvivalgames.messages;

import cn.nukkit.utils.Config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class Messages {

    private final Config config;
    private static HashMap<String, String> messages = new HashMap<>();

    public Messages(Config config) {
        this.config = config;
        loadMessages();
    }

    private void loadMessages() {
        Set<Map.Entry<String, Object>> all = config.getAll().entrySet();
        for (Map.Entry<String, Object> entry : all) {
            messages.put(entry.getKey(), (String) entry.getValue());
        }
    }

    public static String get(String message) {
        String msg = messages.get(message);
        if (msg != null) {
            return msg;
        } else {
            return "Message not found for " + message;
        }
    }
}
