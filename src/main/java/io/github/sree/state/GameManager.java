package io.github.sree.state;

import io.github.sree.state.player.Role;
import io.github.sree.state.settings.GameSettings;
import io.github.sree.state.settings.Objective;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameManager {
    private GameSettings settings = new GameSettings(2, Objective.WITHER, "world");
    private final Map<UUID, Role> roleMap = new HashMap<>();

    public GameSettings getSettings() {
        return settings;
    }

    public void setSettings(int moleCount, Objective objective, String worldName) {
        settings = new GameSettings(moleCount, objective, worldName);
    }


}
