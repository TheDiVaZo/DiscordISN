package thedivazo.discordisn;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;


public class Config {
    private static Main plugin;

    public static boolean DISCORD_ENABLED = true;
    public static String TELEGRAM_NEWS_CHANNEL_ID;
    public static String TELEGRAM_BOT_TOKEN;
    public static boolean TELEGRAM_ENABLED;
    public static String VKONTAKTE_NEWS_CHANNEL_ID;
    public static String VKONTAKTE_GROUP_TOKEN;
    public static String VKONTAKTE_GROUP_ID;
    public static boolean VK_ENABLED;
    public static String DISCORD_BOT_TOKEN;
    public static String DISCORD_NEWS_CHANNEl_ID;
    private static boolean isPapiLoaded = false;


    public static void initConfig(Main main) {
        plugin = main;
        plugin.saveDefaultConfig();
        updateValue();
    }

    public static void dependPluginChecked() {
        if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            isPapiLoaded = true;
        }

    }

    public static boolean isPapiLoaded() {
        return isPapiLoaded;
    }

    public static void updateValue() {
        plugin.saveConfig();
        FileConfiguration config = plugin.getConfig();
        TELEGRAM_NEWS_CHANNEL_ID = config.getString("telegram_api_news_channel_id");
        TELEGRAM_BOT_TOKEN = config.getString("telegram_api_bot_token");
        TELEGRAM_ENABLED = config.getBoolean("telegram_api_enabled");
        VKONTAKTE_NEWS_CHANNEL_ID = config.getString("vk_api_news_channel_id");
        VKONTAKTE_GROUP_TOKEN = config.getString("vk_api_group_token");
        VKONTAKTE_GROUP_ID = config.getString("vk_api_group_id");
        VK_ENABLED = config.getBoolean("vk_api_enabled");
        DISCORD_BOT_TOKEN = config.getString("discord_api_bot_token");
        DISCORD_NEWS_CHANNEl_ID = config.getString("discord_api_news_channel_id");
        dependPluginChecked();
    }


}
