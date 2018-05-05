package com.magewars.game;

import com.magewars.game.entity.UnitWrapper;
import com.magewars.game.entity.ability.AbilityCheck;
import com.magewars.game.entity.ability.AbilityDamage;
import com.magewars.game.entity.ability.UnitAbilityWrapper;

import java.util.List;
import java.util.Random;

public class Utils {
    private static Random random = new Random();

    public static UnitAbilityWrapper maxDmgAbility(UnitAbilityWrapper first, UnitAbilityWrapper last) {
        if (first == null) {
            return last;
        }
        if (last == null) {
            return first;
        }
        Double dmgSum1 = 0d;
        Double dmgSum2 = 0d;

        for (AbilityDamage dmg : first.getFinalDamage()) {
            dmgSum1 += dmg.getDamage();
        }
        for (AbilityDamage dmg : last.getFinalDamage()) {
            dmgSum2 += dmg.getDamage();
        }

        return dmgSum1 > dmgSum2 ? first : last;
    }

    public static UnitAbilityWrapper maxDmgAbility(List<UnitAbilityWrapper> abilityWrapperList) {
        UnitAbilityWrapper max = null;
        for (int i = 0; i < abilityWrapperList.size(); i++) {
            max = maxDmgAbility(max, abilityWrapperList.get(i));
        }
        return max;
    }

    public static HitResult processAbility(com.magewars.game.entity.UnitWrapper attacker, UnitWrapper defender, UnitAbilityWrapper ability) {
        HitResult result = new HitResult();
        result.addAttackerCost(ability.getCost());
        for (AbilityDamage damage : ability.getFinalDamage()) {
            double hit = 0d;
            for (AbilityCheck check : ability.getAbility().getChecks()) {
                //чисто оборонительный бросок, например на скорость
                if (check.getAttack() == null) {
                    double def = defender.getAllStat().containsKey(check.getDefend()) ?
                            attacker.getAllStat().get(check.getDefend()) : 0d;
                    hit -= Math.min(def * check.getModificator(), 50);
                } else {
                    double at = attacker.getAllStat().containsKey(check.getAttack()) ?
                            attacker.getAllStat().get(check.getAttack()) : 0d;
                    double def = defender.getAllStat().containsKey(check.getDefend()) ?
                            attacker.getAllStat().get(check.getDefend()) : 0d;
                    if (at == 0) {
                        hit += 0;
                    } else if (def == 0) {
                        hit += 50;
                    } else {
                        hit += at > def ? Math.min((at / def-1) * check.getModificator(), 50) : -Math.min((def / at-1) * check.getModificator(), 50);
                    }
                }
            }
            if (hit < -80) {
                hit = -80;
            }
            hit = random.nextInt(100) + hit;
            double dmg = 0;
            double evasion = 0d;
            if (hit < 10) {
                evasion = 1;
            } else if (hit < 20) {
                evasion = 2;
            } else if (hit < 30) {
                evasion = 3;
            } else if (hit < 40) {
                evasion = 4;
            } else if (hit < 50) {
                evasion = 5;
            } else if (hit < 60) {
                dmg = damage.getDamage() / 3;
                evasion = 6;
            } else if (hit < 95) {
                dmg = damage.getDamage();
            } else {
                dmg = damage.getDamage() * 1.5;
            }
            result.addDefenderCost(evasion);
            result.addDmg(dmg);
        }
        return result;
    }


}
