package io.github.sree.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;

public class MolecoreSettingsCommand {

    public LiteralArgumentBuilder<CommandSourceStack> createCommand() {
        return Commands.literal("settings");
    }
}
