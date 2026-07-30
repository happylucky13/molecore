package io.github.sree.state.player;

import java.util.UUID;

public class PlayerState {
    private final Role role;
    private int kills;

    public PlayerState(Role role) {
        this.role = role;
    }

    public void incrementKills() {
        if (this.role == Role.MOLE) {
            kills ++;
        }
    }
}