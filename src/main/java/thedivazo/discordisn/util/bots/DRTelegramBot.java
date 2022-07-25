package thedivazo.discordisn.util.bots;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.GetMe;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.security.auth.login.LoginException;
import java.util.Objects;


public class DRTelegramBot extends DRBot {

    private class AbsSender extends DefaultAbsSender {

        protected AbsSender(DefaultBotOptions options) {
            super(options);
        }

        @Override
        public String getBotToken() {
            return DRTelegramBot.this.getBotToken();
        }
    }

    private DefaultAbsSender absSender = new AbsSender(new DefaultBotOptions());

    public DRTelegramBot(String token) throws LoginException {
        super(Objects.requireNonNull(token));
        try {
            absSender.execute(GetMe.builder().build());
        } catch (TelegramApiException e) {
            throw new LoginException("Failed to connect to telegram api. Please check the validity of the token. Integration with Telegram api is disabled");

        }
    }


    public void sendMessage(String channelId, String message) {
        try {
            absSender.execute(SendMessage.builder().chatId(channelId).text(message).parseMode("MarkdownV2").build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
