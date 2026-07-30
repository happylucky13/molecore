package io.github.sree.state.settings;

import java.util.UUID;

public record GameSettings(int moleCount, Objective objective, UUID worldId) { }
