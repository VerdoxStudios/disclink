package org.verdox.disclink.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;
import org.verdox.disclink.DiscLink;
import org.verdox.disclink.SendUtils;

public class Bot extends ListenerAdapter {
    private JDA jda;
    private FileConfiguration config;

    public Bot() {
        jda = net.dv8tion.jda.api.JDABuilder.createDefault(DiscLink.getInstance().getConfig().getString("settings.bot.token"))
                .setActivity(net.dv8tion.jda.api.entities.Activity.playing("DiscLink"))
                .build();
        jda.addEventListener(this);

        config = DiscLink.getInstance().getConfig();
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if (event.getChannel().getId().equals(config.getString("settings.discord.channel"))) {
            String message = event.getMessage().getContentRaw();
            String user = event.getAuthor().getName();
            // Handle the message received from Discord
            if (config.getBoolean("settings.bot.send_to_minecraft"))
                SendUtils.sendToMinecraft(user, message);
        }
    }

    public JDA getJda() {
        return jda;
    }
}
