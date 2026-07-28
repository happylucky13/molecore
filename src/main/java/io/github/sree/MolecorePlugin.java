package io.github.sree;

import com.mojang.brigadier.tree.LiteralCommandNode;
import io.github.sree.commands.MolecoreSettingsCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.plugin.java.JavaPlugin;

public class MolecorePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin started.");


        MolecoreSettingsCommand settingsCommand = new MolecoreSettingsCommand();

        LiteralCommandNode<CommandSourceStack> molecoreCommand = Commands.literal("molecore")
                .then(settingsCommand.createCommand())
                .build();
    }
}