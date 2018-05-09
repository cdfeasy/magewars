package com.magewars.game.tactics;

import com.magewars.game.HitResult;
import com.magewars.game.entity.Unit;
import com.magewars.game.entity.UnitWrapper;

public class TurnResult {
    private UnitWrapper attacker;
    private UnitWrapper defender;
    private HitResult result;
    private UnitAction action;
    private int moveFrom;
    private int moveTo;

    public TurnResult(UnitWrapper attacker, UnitWrapper defender, HitResult result, UnitAction action, int moveFrom, int moveTo) {
        this.attacker = attacker;
        this.defender = defender;
        this.result = result;
        this.action = action;
        this.moveFrom = moveFrom;
        this.moveTo = moveTo;
    }

    public static TurnResult move(UnitWrapper attacker, int moveFrom, int moveTo) {
        return new TurnResult(attacker, null, null, UnitAction.MOVE, moveFrom, moveTo);
    }

    public static TurnResult hit(UnitWrapper attacker, UnitWrapper defender, HitResult result) {
        return new TurnResult(attacker, defender, result, UnitAction.HIT, 0, 0);
    }

    public static TurnResult wait(UnitWrapper attacker) {
        return new TurnResult(attacker, null, null, UnitAction.WAIT, 0, 0);
    }

}
