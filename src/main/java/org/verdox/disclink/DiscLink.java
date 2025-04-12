package org.verdox.disclink;

import org.bukkit.plugin.java.JavaPlugin;
import org.verdox.disclink.discord.Bot;
import org.verdox.disclink.discord.Webhook;

public class DiscLink extends JavaPlugin {
    private static DiscLink instance;
    private SendType sendType;
    private Bot bot;
    private Webhook webhook;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        if (getConfig().getString("settings.type") == null) {
            getLogger().warning("No send type specified in config.yml. Defaulting to WEBHOOK.");
            getConfig().set("settings.type", "WEBHOOK");
            saveConfig();
        }
        sendType = SendType.valueOf(getConfig().getString("settings.type").toUpperCase());

        getLogger().info("DiscLink has been enabled!");
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public static DiscLink getInstance() {
        return instance;
    }

    public SendType getSendType() {
        return sendType;
    }

    public Bot getBot() {
        return bot;
    }

    public Webhook getWebhook() {
        return webhook;
    }

    public enum SendType {
        WEBHOOK,
        BOT
    }
}
