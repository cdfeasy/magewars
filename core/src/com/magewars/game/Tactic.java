package com.magewars.game;

import com.magewars.game.battle.Battle;
import com.magewars.game.entity.TeamWrapper;
import com.magewars.game.battle.TurnResult;

import java.util.List;

public interface Tactic {
    String getId();
    List<TurnResult> process(Battle battle, TeamWrapper team);
}
