package org.verdox.disclink.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.verdox.disclink.SendUtils;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getName();
        String message = String.format("§7[§bDiscord§7] §f%s has left the game.", playerName);
        // Assuming SendUtils is a utility class for sending messages to Discord
        SendUtils.sendToDiscord(playerName, message);
    }

}
