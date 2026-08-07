package io.github.sree.listeners;

import io.github.sree.MolecorePlugin;
import io.github.sree.state.GameManager;
import io.github.sree.state.player.Role;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    private final GameManager gameManager;
    private final MolecorePlugin plugin;

    public PlayerDeathListener(GameManager gameManager, MolecorePlugin plugin) {
        this.gameManager = gameManager;
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (!gameManager.getGameStarted()) {
            return;
        }

        Component deathComponent = event.deathMessage();
        Player player = event.getPlayer();

        if (deathComponent != null) {
            plugin.getLogger().info(PlainTextComponentSerializer.plainText().serialize(deathComponent));
        }

        player.sendMessage(Component.text("Good game!", NamedTextColor.LIGHT_PURPLE));
        player.setGameMode(GameMode.SPECTATOR);

        event.deathMessage(null);



    }
}