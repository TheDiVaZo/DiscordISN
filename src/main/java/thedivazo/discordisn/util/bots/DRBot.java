package thedivazo.discordisn.util.bots;

import java.util.Objects;

public abstract class DRBot {
    private String token;
    public DRBot(String token) {
        this.token = token;
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
