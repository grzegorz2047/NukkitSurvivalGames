package pl.grzegorz2047.nukkitsurvivalgames.commands.arena;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import pl.grzegorz2047.nukkitsurvivalgames.SurvivalGames;
import pl.grzegorz2047.nukkitsurvivalgames.arena.ArenaManager;
import pl.grzegorz2047.nukkitsurvivalgames.arena.exceptions.ArenaAlreadyExistsException;
import pl.grzegorz2047.nukkitsurvivalgames.commands.ChatCommand;
import pl.grzegorz2047.nukkitsurvivalgames.messages.Messages;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class ArenaCommand extends ChatCommand {

    private final ArenaManager arenaManager;

    public ArenaCommand(String name, ArenaManager arenaManager) {
        super(name);
        this.arenaManager = arenaManager;
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player)) {
            SurvivalGames.msg(Messages.get("messageOnlyForPlayerOnServer"));
            return true;
        }
        Player p = (Player) sender;
        if (args.length >= 2) {
            String param = args[0];
            String arenaName = args[1];
            int maxPlayers = Integer.parseInt(args[2]);

            if (param.equals("add")) {
                Location location = p.getPlayer().getLocation();
                if (args.length != 3) {
                    p.sendMessage(Messages.get("wrongnumberofarguments"));
                    return true;
                }
                try {
                    arenaManager.addArena(arenaName, maxPlayers, location);
                    p.sendMessage(Messages.get("arenaHasBeenCreated"));
                } catch (ArenaAlreadyExistsException e) {
                    p.sendMessage(Messages.get("arenaAlreadyExists"));
                }
            }
        }
        return true;
    }
}
