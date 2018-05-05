package com.magewars.game;

import com.magewars.game.entity.TeamWrapper;

public interface Tactic {
    String getId();
    void process(Battle battle, TeamWrapper team);
}
