package io.github.sree.listeners;

import io.github.sree.state.GameManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

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

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player player) {
            gameManager.checkObjectiveCompletion(player);
        }
    }

    @EventHandler
    public void onItemCraft(CraftItemEvent event) {
        if (event.getWhoClicked() instanceof Player player) {
            gameManager.checkObjectiveCompletion(player);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getPlayer() instanceof Player player) {
            gameManager.checkObjectiveCompletion(player);
        }
    }
}
