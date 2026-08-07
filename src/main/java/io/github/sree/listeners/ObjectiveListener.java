package io.github.sree.listeners;

import io.github.sree.state.GameManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class ObjectiveListener implements Listener {
    private final GameManager gameManager;

    public ObjectiveListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player player) {
            gameManager.checkObjectiveCompletion(player);
        }
    }
}
