package thedivazo.discordisn.event;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import thedivazo.discordisn.util.Config;
import thedivazo.discordisn.util.bots.BotManager;

public class DiscordEventListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        MessageChannel channel = event.getChannel();
        String message = event.getMessage().getContentRaw();
        if(!channel.getId().equals(Config.DISCORD_NEWS_CHANNEl_ID)) return;
        BotManager.sendMessage(message);
    }
}
