package io.github.sree.listeners;

import io.github.sree.MolecorePlugin;
import io.github.sree.state.GameManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener extends GameListener {

    public PlayerDeathListener(GameManager gameManager) {
        super(gameManager);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (!gameManager.isGameStarted()) {
            return;
        }

        gameManager.handlePlayerDeath(event);
    }
}