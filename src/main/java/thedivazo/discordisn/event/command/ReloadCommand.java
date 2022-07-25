package thedivazo.discordisn.event.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import thedivazo.discordisn.util.Config;
import thedivazo.discordisn.util.bots.BotManager;

@CommandAlias("discordisn|disn")
public class ReloadCommand extends BaseCommand {

    @Subcommand("reload")
    @CommandPermission("discordisn.command.reload")
    public void onReload(CommandSender sender) {
        Config.updateValue();
        BotManager.initBots();
        sender.sendMessage("Config has been "+ ChatColor.GREEN + "RELOADED");
    }

}
