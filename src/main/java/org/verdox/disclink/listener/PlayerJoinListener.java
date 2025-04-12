package org.verdox.disclink.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.verdox.disclink.SendUtils;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();
        String message = String.format("§7[§bDiscord§7] §f%s has joined the game.", playerName);
        SendUtils.sendToDiscord(playerName, message);
    }
}
