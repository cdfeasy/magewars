package com.magewars.game;

import com.magewars.game.entity.*;
import com.magewars.game.entity.ability.Ability;
import com.magewars.game.entity.ability.AbilityCheck;
import com.magewars.game.entity.ability.AbilityCost;
import com.magewars.game.entity.ability.AbilityDamage;
import com.magewars.game.entity.stats.Skill;
import com.magewars.game.tactics.FrontalAssault;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainGame {
    private Battle battle;
    private ModData modData;
    private UnitData unitData;

    public MainGame() throws IOException {
        Skill agility = new Skill("agility","stat");
        Skill control = new Skill("control","stat");
        Skill speed =new Skill("speed","stat");
        modData = new ModData();
        Skill melee = new Skill();
        melee.setId("melee");
        melee.setDescription("melee");
        melee.setName("melee");

        Skill throwing = new Skill();
        throwing.setId("throwing");
        throwing.setDescription("throwing");
        throwing.setName("throwing");
        throwing.setCategory("battle");

        Skill sword = new Skill();
        sword.setId("sword");
        sword.setDescription("sword");
        sword.setName("sword");
        throwing.setCategory("battle");
        Skill fire = new Skill();
        fire.setId("fire");
        fire.setDescription("fire");
        fire.setName("fire");
        throwing.setCategory("magic");

        Skill water = new Skill();
        water.setId("water");
        water.setDescription("water");
        water.setName("water");
        throwing.setCategory("magic");

        Skill earth = new Skill();
        earth.setId("earth");
        earth.setDescription("earth");
        earth.setName("earth");
        throwing.setCategory("magic");

        Skill air = new Skill();
        air.setId("air");
        air.setDescription("air");
        air.setName("air");
        throwing.setCategory("magic");

        Skill lighting = new Skill();
        lighting.setId("lighting");
        lighting.setDescription("lighting");
        lighting.setName("lighting");
        throwing.setCategory("magic");

        modData.setSkills(new ArrayList<Skill>());
        modData.getSkills().add(melee);
        modData.getSkills().add(sword);
        modData.getSkills().add(throwing);

        modData.getSkills().add(air);
        modData.getSkills().add(earth);
        modData.getSkills().add(water);
        modData.getSkills().add(fire);
        modData.getSkills().add(lighting);

        Ability meleeHit = new Ability("melee_hit", new AbilityCost(10d), "melee hit", melee, 1d, new AbilityCheck(melee, melee), new AbilityDamage(melee, 0.5d, Damage.HIT, 50d));
        Ability uppercut = new Ability("melee_uppercut", new AbilityCost(1d, 20d), "uppercut", melee, 2d, new AbilityCheck(melee, melee), new AbilityDamage(melee, 1d, Damage.STUN, 100d));

        Ability fireBullet = new Ability("fire_bullet", new AbilityCost(20d), "fire bullet", fire, 1d, new AbilityCheck(control, agility), new AbilityDamage(fire, 0.5d, Damage.HIT, 50d));

        modData.setAbilityList(new ArrayList<Ability>());
        modData.getAbilityList().add(meleeHit);
        modData.getAbilityList().add(uppercut);
        modData.getAbilityList().add(fireBullet);


        SaveWorker worker=new SaveWorker();
        //   SimpleModule  module=new SimpleModule();
        //    module.addSerializer(Skill.class,new BattleSkillSerializer());
        // mapper.registerModule(module);
        //     StringWriter writer = new StringWriter();
        //    mapper.writerWithDefaultPrettyPrinter().writeValue(writer, modData);
        System.out.println(worker.saveModData(modData));

        Team team1 = new Team("team1");
        Team team2 = new Team("team2");

        Unit u1 = createUnit("unit1");
        u1.getSkills().put(melee, 1d);
        u1.getAbilities().add(meleeHit);
        Unit u2 = createUnit("unit2");
        u2.getSkills().put(fire, 1d);
        u2.getAbilities().add(fireBullet);
        Unit u3 = createUnit("unit3");
        u3.getSkills().put(melee, 1d);
        u3.getAbilities().add(meleeHit);
        Unit u4 = createUnit("unit4");
        u4.getSkills().put(melee, 1d);
        u4.getAbilities().add(meleeHit);
        Unit u5 = createUnit("unit5");
        u5.getSkills().put(fire, 1d);
        u5.getAbilities().add(fireBullet);
        Unit u6 = createUnit("unit6");
        u6.getSkills().put(melee, 1d);
        u6.getAbilities().add(meleeHit);

        team1.addUnit(new UnitWrapper(u1));
        team1.addUnit(new UnitWrapper(u2));
        team1.addUnit(new UnitWrapper(u3));
        team2.addUnit(new UnitWrapper(u4));
        team2.addUnit(new UnitWrapper(u5));
        team2.addUnit(new UnitWrapper(u6));

        BattleField battleField=new BattleField(6);
        TeamWrapper teamWrapper1 = new TeamWrapper(team1, battleField.getTiles().get(0));
        teamWrapper1.setTactic(new FrontalAssault());
        TeamWrapper teamWrapper2 = new TeamWrapper(team2, battleField.getTiles().get(5));
        teamWrapper2.setTactic(new FrontalAssault());
        battle=new Battle(battleField,teamWrapper1,teamWrapper2);
        //   battle.processBattle();

        UnitData unitData=new UnitData();
        List<UnitWrapper> wrappers=new ArrayList<UnitWrapper>();
        List<Unit> units=new ArrayList<Unit>();
        wrappers.addAll(team1.getUnits());
        wrappers.addAll(team2.getUnits());
        units.add(u1);
        units.add(u2);
        units.add(u3);
        units.add(u4);
        units.add(u5);
        units.add(u6);
        unitData.setUnitWrappers(wrappers);
        List<TeamWrapper> wrappers1=new ArrayList<TeamWrapper>();
        wrappers1.add(teamWrapper1);
        wrappers1.add(teamWrapper2);
        unitData.setTeamWrappers(wrappers1);
        String str = worker.saveUserData(unitData);
        System.out.println(str);

        unitData=worker.lodaUserData(str, modData);

    }

    public UnitData getUnitData() {
        return unitData;
    }

    public Battle getBattle() {
        return battle;
    }

    public ModData getModData() {
        return modData;
    }

    private static Unit createUnit(String name) {
        Random random=new Random();
        Unit unit = new Unit();
        unit.setHp(1000d+random.nextInt(1000));
        unit.setEnergy(1000d);
        unit.getSkills().put(new Skill("control","stat"),1d+random.nextInt(200)/100d);
        unit.getSkills().put(new Skill("agility","stat"),1d+random.nextInt(200)/100d);
        unit.getSkills().put(new Skill("endurance","stat"),1d+random.nextInt(200)/100d);
        unit.getSkills().put(new Skill("intelligence","stat"),1d+random.nextInt(200)/100d);
        unit.getSkills().put(new Skill("speed","stat"),1d+random.nextInt(200)/100d);
        unit.getSkills().put(new Skill("strength","stat"),1d+random.nextInt(200)/100d);
        unit.setName(name);
        unit.setId(name);
        return unit;
    }
}
