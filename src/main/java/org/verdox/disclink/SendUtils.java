package org.verdox.disclink;

import org.bukkit.Bukkit;

public class SendUtils {

    public static void sendToMinecraft(String author, String message) {
        if (DiscLink.getInstance().getConfig().getBoolean("settings.bot.send_to_minecraft")) {
            String formattedMessage = String.format("§7[§bDiscord§7] §f%s: %s", author, message);
            Bukkit.broadcastMessage(formattedMessage);
        }
    }

    public static void sendToDiscord(String author, String message) {
        switch (DiscLink.getInstance().getSendType()) {
            case BOT -> {
                // Implement the logic to send a message using the bot
                String formattedMessage = String.format("§7[§bMinecraft§7] §f%s: %s", author, message);
                DiscLink.getInstance().getBot().getJda()
                        .getTextChannelById(
                                DiscLink.getInstance().getConfig().getString("settings.bot.channel_id"))
                        .sendMessage(formattedMessage).queue();
            }

            case WEBHOOK -> {
                // Implement the logic to send a message using a webhook
                System.out.println("Sending message to Discord using webhook: " + message);
            }
        }
    }
}
