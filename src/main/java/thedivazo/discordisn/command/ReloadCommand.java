package thedivazo.discordisn.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import thedivazo.discordisn.Config;
import thedivazo.discordisn.BotManager;

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
