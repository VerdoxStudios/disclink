package org.verdox.disclink;

import org.bukkit.plugin.java.JavaPlugin;

public class DiscLink extends JavaPlugin {
    private static DiscLink instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        getLogger().info("DiscLink has been enabled!");
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public static DiscLink getInstance() {
        return instance;
    }
}
