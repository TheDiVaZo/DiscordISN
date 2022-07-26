package thedivazo.discordisn.bot;

import javax.security.auth.login.LoginException;
import java.util.Objects;

public abstract class DRBot {
    private String token;
    public DRBot(String token, String botName) throws LoginException {
        if(Objects.nonNull(token)) this.token = token;
        else throw new LoginException(botName+"No token specified. Please specify the token in the config and restart the plugin");
    }

    public abstract void sendMessage(String channel, String message);
    public String getBotToken() {
        return this.token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DRBot)) return false;
        DRBot drBot = (DRBot) o;
        return Objects.equals(token, drBot.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
