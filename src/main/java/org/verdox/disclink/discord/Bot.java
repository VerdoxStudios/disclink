package org.verdox.disclink.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;
import org.verdox.disclink.DiscLink;

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
        if (config.getBoolean("settings.bot.enabled")) {
            if (event.getChannel().getId().equals(config.getString("settings.discord.channel"))) {
                String message = event.getMessage().getContentRaw();
                // Handle the message received from Discord
                // For example, send it to the Minecraft server or log it
                System.out.println("Received message from Discord: " + message);
            }
        }
    }
}
