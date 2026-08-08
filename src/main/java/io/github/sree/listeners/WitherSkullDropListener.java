package io.github.sree.listeners;

import io.github.sree.enums.Objective;
import io.github.sree.state.GameManager;
import org.bukkit.Material;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class WitherSkullDropListener implements Listener {
    private final GameManager gameManager;

    public WitherSkullDropListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onWitherSkeletonDeath(EntityDeathEvent event) {
        if (!gameManager.isGameStarted()) {
            return;
        }

        if (gameManager.getSettings().objective() != Objective.WITHER) {
            return;
        }

        if (!(event.getEntity() instanceof WitherSkeleton)) {
            return;
        }

        if (Math.random() < 0.25) {
            event.getDrops().add(new ItemStack(Material.WITHER_SKELETON_SKULL));
        }
    }
}
