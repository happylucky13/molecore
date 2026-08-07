package io.github.sree.state;

import io.github.sree.state.player.Role;
import io.github.sree.state.settings.GameSettings;
import io.github.sree.state.settings.Objective;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class GameManager {
    private GameSettings settings = new GameSettings(2, Objective.WITHER, "world");
    private final Map<UUID, Role> roleMap = new HashMap<>();
    private boolean gameStarted;

    public GameSettings getSettings() {
        return settings;
    }

    public boolean getGameStarted() {
        return gameStarted;
    }

    public void setSettings(int moleCount, Objective objective, String worldName) {
        settings = new GameSettings(moleCount, objective, worldName);
    }

    public Role getRole(Player player) {
        return roleMap.get(player.getUniqueId());
    }

    public void startGame() {
        roleMap.clear();
        List<Player> shuffledPlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        Collections.shuffle(shuffledPlayers);

        for(int i = 0; i < shuffledPlayers.size(); i++) {
            if(i < settings.moleCount()) {
                roleMap.put(shuffledPlayers.get(i).getUniqueId(), Role.MOLE);
                continue;
            }

            roleMap.put(shuffledPlayers.get(i).getUniqueId(), Role.SURVIVOR);
        }

        gameStarted = true;
    }
}
