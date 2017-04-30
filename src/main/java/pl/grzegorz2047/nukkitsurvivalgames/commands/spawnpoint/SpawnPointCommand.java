package pl.grzegorz2047.nukkitsurvivalgames.commands.spawnpoint;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import pl.grzegorz2047.nukkitsurvivalgames.SurvivalGames;
import pl.grzegorz2047.nukkitsurvivalgames.arena.ArenaManager;
import pl.grzegorz2047.nukkitsurvivalgames.commands.ChatCommand;
import pl.grzegorz2047.nukkitsurvivalgames.messages.Messages;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */
public class SpawnPointCommand extends ChatCommand {

    private final ArenaManager arenaManager;

    public SpawnPointCommand(String name, ArenaManager arenaManager) {
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
        Location loc = p.getLocation();
        if (args.length >= 2) {
            String arenaname = args[0];
            String param = args[1];
            if (param.equals("next")) {
                if (arenaManager.addSpawnPointToArena(loc, loc.getLevel().getName(), arenaname)) {
                    p.sendMessage(Messages.get("addedSpawnPointToArena"));
                    return true;
                } else {
                    p.sendMessage(Messages.get("couldntAddSpawnPointToArena"));
                }
            } else {
                p.sendMessage(Messages.get("argumentdoesntexists"));

            }
        } else {
            p.sendMessage(Messages.get("wrongnumberofarguments"));

        }
        return true;
    }

}
