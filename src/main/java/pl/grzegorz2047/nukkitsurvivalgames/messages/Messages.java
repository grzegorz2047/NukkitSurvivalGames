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

    private static HashMap<String, String> messages = new HashMap<>();

    public static void loadMessages(Config config) {
        messages.clear();
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
