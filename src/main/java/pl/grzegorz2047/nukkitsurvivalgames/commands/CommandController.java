package pl.grzegorz2047.nukkitsurvivalgames.commands;

import cn.nukkit.command.*;

import java.util.HashMap;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class CommandController {

    private HashMap<String, ChatCommand> commands = new HashMap<>();

    public void registerCommand(ChatCommand command, CommandMap commandMap) {
        commands.put(command.getName(), command);
        commandMap.register(command.getName(), command);
    }

    public boolean passCommand(String commandName, CommandSender sender, String label, String[] args) {
        return commands.get(commandName).execute(sender, label, args);
    }
}
