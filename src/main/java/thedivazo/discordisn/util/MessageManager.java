package thedivazo.discordisn.util;


import net.dv8tion.jda.api.utils.MarkdownSanitizer;
import net.md_5.bungee.api.ChatColor;

import java.io.IOException;
import java.util.regex.Pattern;

public class MessageManager {
    private static final Pattern HEX_PAT = Pattern.compile("&#[a-fA-F0-9]{6}");
    private static final Pattern COLOR_PAT = Pattern.compile("&[0-9a-flnrkmo]");
    private static final Pattern CHAT_COLOR_PAT = Pattern.compile(ChatColor.COLOR_CHAR +"[0-9a-fxlnrkmo]");

    //TODO: write a convert markdown in unicode symbols (~~text~~ to t̶e̶x̶t̶)
    public static final char UNDERLINE = '\u0332';
    public static final char STRIKETHROUGH = '\u0336';

    public static String insertBetween(String between, String insert) {
        return String.join(between,insert.split(""));
    }

    //TODO: rewrite the method for a more competent implementation
    public static String discordMDToTelegramMD(String markdown) throws IOException {
        return MarkdownSanitizer.escape(markdown.replaceAll("\\\\", "\\\\\\\\")).replaceAll("\\\\\\*\\\\\\*\\\\\\*", "*")
                .replaceAll("\\\\\\*\\\\\\*", "*")
                .replaceAll("\\\\\\*", "_")
                .replaceAll("(\\\\~~)|(~~\\\\)", "~")
                .replaceAll("\\\\", "");
    }
}
