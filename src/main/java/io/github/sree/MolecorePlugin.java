package io.github.sree;

import com.mojang.brigadier.tree.LiteralCommandNode;
import io.github.sree.commands.MolecoreSettingsCommand;
import io.github.sree.state.GameManager;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.java.JavaPlugin;

public class MolecorePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin started.");
        GameManager gameManager = new GameManager();


        MolecoreSettingsCommand settingsCommand = new MolecoreSettingsCommand(gameManager);

        LiteralCommandNode<CommandSourceStack> molecoreCommand = Commands.literal("molecore")
                .then(settingsCommand.createCommand())
                .build();

        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            commands.registrar().register(molecoreCommand);
        });
    }
}