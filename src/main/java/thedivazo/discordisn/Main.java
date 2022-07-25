package thedivazo.discordisn;

import co.aikar.commands.PaperCommandManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import thedivazo.discordisn.event.command.ReloadCommand;
import thedivazo.discordisn.util.Config;
import thedivazo.discordisn.util.bots.BotManager;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin loading...");
        Config.initConfig(this);
        getLogger().info("Config loaded!");
        BotManager.initBots();
        if(!Config.DISCORD_ENABLED) {
            getLogger().info("Plugin disabled");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        if(Config.TELEGRAM_ENABLED) getLogger().info("Integration with Telegram api has been enabled");
        if(Config.VKONTAKTE_ENABLED) getLogger().info("Integration with Vkontakte api has been enabled");
        getLogger().info("Integration with Discord api has been enabled");
        registerCommands();
    }


    public void registerCommands() {
        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new ReloadCommand());

        manager.setDefaultExceptionHandler((command, registeredCommand, sender, args, t)-> {
            getLogger().warning("Error occurred while executing command "+command.getName());
            return true;
        });
    }
}
