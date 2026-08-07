package io.github.sree.state;

import io.github.sree.MolecorePlugin;
import io.github.sree.state.settings.Role;
import io.github.sree.state.settings.GameSettings;
import io.github.sree.state.settings.Objective;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.*;

public class GameManager {
    private final MolecorePlugin plugin;
    private GameSettings settings = new GameSettings(2, Objective.WITHER, "world");
    private final Map<UUID, Role> roleMap = new HashMap<>();
    private final Set<UUID> alivePlayers = new HashSet<>();
    private boolean gameStarted;

    public GameManager(MolecorePlugin plugin) {
        this.plugin = plugin;
    }

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
        alivePlayers.clear();
        List<Player> shuffledPlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        Collections.shuffle(shuffledPlayers);

        for(int i = 0; i < shuffledPlayers.size(); i++) {
            UUID id = shuffledPlayers.get(i).getUniqueId();
            alivePlayers.add(id);
            shuffledPlayers.get(i).teleportAsync(Bukkit.getWorld(settings.worldName()).getSpawnLocation());

            if(i < settings.moleCount()) {
                roleMap.put(shuffledPlayers.get(i).getUniqueId(), Role.MOLE);
                continue;
            }

            roleMap.put(shuffledPlayers.get(i).getUniqueId(), Role.SURVIVOR);
        }

        gameStarted = true;
    }

    public void handlePlayerDeath(PlayerDeathEvent event) {
        Component deathComponent = event.deathMessage();
        Player player = event.getPlayer();

        if (deathComponent != null) {
            plugin.getLogger().info(PlainTextComponentSerializer.plainText().serialize(deathComponent));
        }

        player.sendMessage(Component.text("Good game!", NamedTextColor.LIGHT_PURPLE));
        player.setGameMode(GameMode.SPECTATOR);
        alivePlayers.remove(player.getUniqueId());

        event.deathMessage(null);
    }
}
