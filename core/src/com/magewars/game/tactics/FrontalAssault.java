package com.magewars.game.tactics;

import com.magewars.game.*;
import com.magewars.game.entity.TeamWrapper;
import com.magewars.game.entity.UnitWrapper;
import com.magewars.game.entity.ability.UnitAbilityWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FrontalAssault implements Tactic {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getId() {
        return "FrontalAssault";
    }

    @Override
    public List<TurnResult> process(Battle battle, com.magewars.game.entity.TeamWrapper team) {
        TeamWrapper current = team;
        TeamWrapper opp = battle.getAttackers().equals(team) ? battle.getDefenders() : battle.getAttackers();
        List<TurnResult> results = new ArrayList<TurnResult>();
        for (UnitWrapper unit : current.getTeam().getUnits()) {
            if (unit.getHp() <= 0) {
                continue;
            }

            UnitAbilityWrapper ability = Utils.maxDmgAbility(unit.getProcessedAbilities());
            if (unit.getEnergy() < ability.getCost() || unit.getHp() <= 0) {
                results.add(TurnResult.wait(unit));
                continue;
            }

            boolean attacked = false;
            for (UnitWrapper enemy : unit.getTile().getUnits()) {
                if (enemy.getHp() <= 0) {
                    continue;
                }
                boolean isEnemy = !enemy.getUnit().getTeam().equals(unit.getUnit().getTeam());
                if (isEnemy) {
                    attacked = true;
                    HitResult result = Utils.processAbility(unit, enemy, ability);
                    enemy.setHp(enemy.getHp() - result.getDmg());
                    enemy.setEnergy(enemy.getHp() - result.getDefenderCost());
                    unit.setEnergy(unit.getEnergy() - result.getAttackerCost());
                    logger.info("{} inflict to {}- {} damage {} ability", unit.getUnit().getName(), enemy.getUnit().getName(), result.getDmg(), ability.getAbility().getName());
                    results.add(TurnResult.hit(unit, enemy, result));
                    break;
                }
            }
            if (!attacked) {
                UnitWrapper closest = null;
                int diff = 10000;
                for (UnitWrapper enemy : opp.getTeam().getUnits()) {
                    if (enemy.getHp() <= 0) {
                        continue;
                    }
                    if (Math.abs(enemy.getTile().getId() - unit.getTile().getId()) < diff) {
                        diff = Math.abs(enemy.getTile().getId() - unit.getTile().getId());
                        closest = enemy;
                    }
                }
                if (closest != null) {
                    if (unit.getTile().getId() < closest.getTile().getId()) {
                        battle.getBattleField().getTiles().get(unit.getTile().getId()).getUnits().remove(unit);
                        unit.setTile(battle.getBattleField().getTiles().get(unit.getTile().getId() + 1));
                        battle.getBattleField().getTiles().get(unit.getTile().getId()).getUnits().add(unit);
                        results.add(TurnResult.move(unit, unit.getTile().getId() - 1, unit.getTile().getId()));
                    } else {
                        battle.getBattleField().getTiles().get(unit.getTile().getId()).getUnits().remove(unit);
                        unit.setTile(battle.getBattleField().getTiles().get(unit.getTile().getId() - 1));
                        battle.getBattleField().getTiles().get(unit.getTile().getId()).getUnits().add(unit);
                        results.add(TurnResult.move(unit, unit.getTile().getId() + 1, unit.getTile().getId()));
                    }
                    logger.info("{} goto tile {}", unit.getUnit().getName(), unit.getTile().getId());
                }else {
                    results.add(TurnResult.wait(unit));
                }
            }
        }
        return results;
    }
}
