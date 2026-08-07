package io.github.sree.state;

import io.github.sree.MolecorePlugin;
import io.github.sree.state.settings.Role;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.time.Duration;

public class GameAnimationManager {
    private final MolecorePlugin plugin;

    public GameAnimationManager(MolecorePlugin plugin) {
        this.plugin = plugin;
    }

    public void revealRole(Player player, Role role) {
        int[] delays = {0, 5, 10, 15, 25, 40, 60, 90};

        for (int i = 0; i < delays.length; i++) {
            int animationStep = i;
            int delay = delays[i];

            // Fake role cycling
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                Role fakeRole = animationStep % 2 == 0 ? Role.SURVIVOR : Role.MOLE;
                NamedTextColor color = fakeRole == Role.SURVIVOR ? NamedTextColor.GREEN : NamedTextColor.RED;
                float pitch = 0.8f + (animationStep * 0.1f);

                player.showTitle(
                        Title.title(
                                Component.text("You are a ")
                                        .color(NamedTextColor.WHITE)
                                        .append(Component.text(fakeRole.name(), color)),
                                Component.empty(),
                                Title.Times.times(
                                        Duration.ZERO,
                                        Duration.ofMillis(100),
                                        Duration.ZERO
                                )
                        )
                );

                player.playSound(
                        player.getLocation(),
                        Sound.UI_BUTTON_CLICK,
                        1.0f,
                        pitch
                );
            }, delay);

            // Reveal real role
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                NamedTextColor color = role == Role.SURVIVOR ? NamedTextColor.GREEN : NamedTextColor.RED;
                Sound sound = role == Role.SURVIVOR ? Sound.ENTITY_PLAYER_LEVELUP : Sound.ENTITY_WITHER_SPAWN;
                player.showTitle(
                        Title.title(
                                Component.text("You are a ")
                                        .append(Component.text(role.name(), color)),
                                Component.empty(),
                                Title.Times.times(
                                        Duration.ofMillis(250),
                                        Duration.ofSeconds(4),
                                        Duration.ofMillis(750)
                                )
                        )
                );

                player.playSound(
                        player.getLocation(),
                        sound,
                        1.0f,
                        1.0f
                );
            }, 120L);
        }
    }
}
