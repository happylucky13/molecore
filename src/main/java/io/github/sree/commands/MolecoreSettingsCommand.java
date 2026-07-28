package io.github.sree.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;

public class MolecoreSettingsCommand {

    public LiteralArgumentBuilder<CommandSourceStack> createCommand() {
        return Commands.literal("settings")
                .then(Commands.literal("goal")
                        .then(Commands.literal("beacon"))
                        .then(Commands.literal("dragon_egg"))
                )
                .then(Commands.literal("mole_count")
                        .then(Commands.argument("count", IntegerArgumentType.integer()))
                )
                .then(Commands.literal("world")
                        .then(Commands.argument("world_name", ArgumentTypes.world()))
                );
    }
}
