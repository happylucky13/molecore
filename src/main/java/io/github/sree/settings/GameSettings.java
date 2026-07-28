package io.github.sree.settings;

import java.util.UUID;

public class GameSettings {
    private int moleCount;
    private Objective objective;
    private UUID worldUUID;

    public GameSettings(int moleCount, Objective objective, UUID worldUUID) {
        this.moleCount = moleCount;
        this.objective = objective;
        this.worldUUID = worldUUID;
    }
}
