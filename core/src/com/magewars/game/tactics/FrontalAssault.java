package com.magewars.game.tactics;

import com.magewars.game.*;
import com.magewars.game.entity.TeamWrapper;
import com.magewars.game.entity.UnitWrapper;
import com.magewars.game.entity.ability.AbilityDamage;
import com.magewars.game.entity.ability.UnitAbilityWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrontalAssault implements Tactic {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getId() {
        return "FrontalAssault";
    }

    @Override
    public void process(Battle battle, com.magewars.game.entity.TeamWrapper team) {
        com.magewars.game.entity.TeamWrapper current = team;
        TeamWrapper opp = battle.getAttackers().equals(team) ? battle.getDefenders() : battle.getAttackers();
        for (com.magewars.game.entity.UnitWrapper unit : current.getTeam().getUnits()) {
            UnitAbilityWrapper ability = Utils.maxDmgAbility(unit.getProcessedAbilities());
            if (unit.getEnergy().getValue() < ability.getCost() || unit.getHp().getValue() <= 0) {
                continue;
            }
            boolean attacked = false;
            for (com.magewars.game.entity.UnitWrapper enemy : unit.getTile().getUnits()) {
                if(enemy.getHp().getValue()<=0){
                    continue;
                }
                boolean isEnemy = !enemy.getUnit().getTeam().equals(unit.getUnit().getTeam());
                if (isEnemy) {
                    attacked = true;
                    for (AbilityDamage dmg : ability.getFinalDamage()) {
                        HitResult result = Utils.processAbility(unit, enemy, ability);
                        enemy.getHp().setValue(enemy.getHp().getValue() - result.getDmg());
                        enemy.getEnergy().setValue(enemy.getHp().getValue()-result.getDefenderCost());
                        unit.getEnergy().setValue(unit.getEnergy().getValue()-result.getAttackerCost());
                        logger.info("{} inflict to {}- {} damage {} ability", unit.getUnit().getName(), enemy.getUnit().getName(), result.getDmg(), ability.getAbility().getName());
                    }
                    break;
                }
            }
            if (!attacked) {
                com.magewars.game.entity.UnitWrapper closest = null;
                int diff = 10000;
                for (UnitWrapper enemy : opp.getTeam().getUnits()) {
                    if (enemy.getHp().getValue() <= 0) {
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
                    } else {
                        battle.getBattleField().getTiles().get(unit.getTile().getId()).getUnits().remove(unit);
                        unit.setTile(battle.getBattleField().getTiles().get(unit.getTile().getId() - 1));
                        battle.getBattleField().getTiles().get(unit.getTile().getId()).getUnits().add(unit);
                    }
                    logger.info("{} goto tile {}", unit.getUnit().getName(), unit.getTile().getId());
                }
            }
        }

    }
}
