package com.magewars.game;

import com.magewars.game.entity.Mage;

import java.util.Random;

public class Battle {
    public void battle(Mage mage1, Mage mage2) {
        Mage cur = mage1;
        Mage def = mage2;
        Random random = new Random();
        while (true) {
            if (cur.getEnergy() < 5) {
                cur.setEnergy(cur.getEnergy() + 5);
                continue;
            } else {
                cur.setEnergy(cur.getEnergy() - 5);
            }

            double aglDiff = (cur.getAgility() - def.getAgility()) / 2;
            double speedDiff = (cur.getSpeed() - def.getSpeed()) / 2;
            double wpnDiff = cur.getWeapons() - def.getWeapons();
            double _hit =
                    aglDiff +
                            speedDiff +
                            wpnDiff;
            if(_hit<-40){
                _hit=-40;
            }
            double hit = random.nextInt(100) + _hit;
            double dmg = (cur.getStr() * (1 + (double)cur.getWeapons() / 10));
            if (hit < 50) {
                dmg = 0;
                String msg = String.format("%s miss %.0f hp left", cur.getName(), def.getHp());
                System.out.println(msg);
            } else if (hit < 60) {
                dmg = dmg / 3;
                String msg = String.format("%s glance hit  %.0f dmg %.0f hp left", cur.getName(), dmg, def.getHp());
                System.out.println(msg);
            } else if (hit < 95) {
                String msg = String.format("%s hit %.2f dmg %.0f hp left", cur.getName(), dmg, def.getHp());
                System.out.println(msg);
            } else {
                dmg = dmg * 1.5;
                String msg = String.format("%s crit hit %.2f dmg %.0f hp left", cur.getName(), dmg, def.getHp());
                System.out.println(msg);
            }
            def.setHp((int) (def.getHp() - dmg));
            if (def.getHp() <= 0) {
                String msg = String.format("Mage %s lose", def.getName());
                System.out.println(msg);
                break;
            }
            Mage tmp = cur;
            cur = def;
            def = tmp;
        }
    }

    public static void main(String[] args) {
        Mage mage1 = new Mage("Mage1", 3000, 1000, 100, 100, 100, 100, 100, 7, 7);
        Mage mage2 = new Mage("Mage2", 1000, 1000, 110, 120, 100, 120, 100, 2, 2);
        Battle battle = new Battle();
        battle.battle(mage1, mage2);


    }

}
