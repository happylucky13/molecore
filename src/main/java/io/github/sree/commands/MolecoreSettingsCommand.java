package io.github.sree.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;

public class MolecoreSettingsCommand {

    public LiteralArgumentBuilder<CommandSourceStack> createCommand() {
        return Commands.literal("state")
                .then(Commands.argument("mole_count", IntegerArgumentType.integer(1, 3))
                        .then(Commands.argument("world", ArgumentTypes.world())
                                .then(Commands.literal("beacon"))
                                .then(Commands.literal("dragon_egg"))
                        )
                );
    }
}
