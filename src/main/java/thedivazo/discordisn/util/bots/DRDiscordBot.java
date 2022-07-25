package thedivazo.discordisn.util.bots;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import thedivazo.discordisn.event.DiscordEventListener;

import javax.security.auth.login.LoginException;
import java.util.Objects;

public class DRDiscordBot extends DRBot {
    public JDA jda;

    public DRDiscordBot(String token) throws LoginException {
        super(Objects.requireNonNull(token));
        jda = JDABuilder.createDefault(token).build();
        jda.addEventListener(new DiscordEventListener());
        try {
            jda.awaitReady();
        } catch (InterruptedException e) {
            throw new LoginException("Failed to connect to Discord api. Please check the validity of the token. Integration with Discord api is disabled");
        }
    }

    public void sendMessage(String channelId, String message) {
        jda.getTextChannelById(channelId).sendMessage(message).queue();
    }


}
