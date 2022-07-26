package thedivazo.discordisn;

import net.dv8tion.jda.api.utils.MarkdownSanitizer;
import thedivazo.discordisn.bot.DRBot;
import thedivazo.discordisn.bot.DRDiscordBot;
import thedivazo.discordisn.bot.DRTelegramBot;
import thedivazo.discordisn.bot.DRVkBot;
import thedivazo.discordisn.util.MessageManager;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class BotManager {
    public static DRBot discordBot = null;
    public static DRBot telegramBot = null;
    public static DRBot vkBot = null;

    public static void initBots() {
        try {
            discordBot = new DRDiscordBot(Config.DISCORD_BOT_TOKEN);
        } catch (LoginException | NullPointerException e) {
            e.printStackTrace();
            Config.DISCORD_ENABLED = false;
            return;
        }
        if(Config.VK_ENABLED) {
            try {
                vkBot = new DRVkBot(Config.VKONTAKTE_GROUP_TOKEN, Config.VKONTAKTE_GROUP_ID);
            } catch (LoginException | NullPointerException e) {
                e.printStackTrace();
                Config.VK_ENABLED = false;
            }
        }
        if(Config.TELEGRAM_ENABLED) {
            try {
                telegramBot = new DRTelegramBot(Config.TELEGRAM_BOT_TOKEN);
            } catch (LoginException | NullPointerException e) {
                e.printStackTrace();
                Config.TELEGRAM_ENABLED = false;
            }
        }
    }

    public static void sendMessage(String message) {
            if(Config.VK_ENABLED) {
                vkBot.sendMessage(Config.VKONTAKTE_NEWS_CHANNEL_ID, MarkdownSanitizer.sanitize(message));
            }
            if(Config.TELEGRAM_ENABLED) {
                try {
                    telegramBot.sendMessage(Config.TELEGRAM_NEWS_CHANNEL_ID, MessageManager.discordMDToTelegramMD(message));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

}
