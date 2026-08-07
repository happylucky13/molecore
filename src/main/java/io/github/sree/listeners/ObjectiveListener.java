package io.github.sree.listeners;

import io.github.sree.state.GameManager;
import org.bukkit.event.Listener;

public class ObjectiveListener implements Listener {
    private final GameManager gameManager;

    public ObjectiveListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }
}
