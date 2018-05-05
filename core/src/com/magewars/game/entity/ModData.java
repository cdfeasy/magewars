package com.magewars.game.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.magewars.game.*;
import com.magewars.game.entity.ability.Ability;
import com.magewars.game.entity.ability.AbilityCheck;
import com.magewars.game.entity.ability.AbilityCost;
import com.magewars.game.entity.ability.AbilityDamage;
import com.magewars.game.entity.stats.BattleSkill;
import com.magewars.game.entity.stats.CommonSkill;
import com.magewars.game.entity.stats.MagicSkill;
import com.magewars.game.entity.stats.Skill;
import com.magewars.game.entity.stats.stat.*;
import com.magewars.game.tactics.FrontalAssault;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

public class ModData {
    private String modName;
    private String author;
    private String description;
    private String url;

    private List<BattleSkill> battleSkills;
    private List<MagicSkill> magicSkills;
    private List<CommonSkill> commonSkills;
    private List<Ability> abilityList;

    public String getModName() {
        return modName;
    }

    public void setModName(String modName) {
        this.modName = modName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<BattleSkill> getBattleSkills() {
        return battleSkills;
    }

    public void setBattleSkills(List<BattleSkill> battleSkills) {
        this.battleSkills = battleSkills;
    }

    public List<MagicSkill> getMagicSkills() {
        return magicSkills;
    }

    public void setMagicSkills(List<MagicSkill> magicSkills) {
        this.magicSkills = magicSkills;
    }

    public List<CommonSkill> getCommonSkills() {
        return commonSkills;
    }

    public void setCommonSkills(List<CommonSkill> commonSkills) {
        this.commonSkills = commonSkills;
    }

    public List<Ability> getAbilityList() {
        return abilityList;
    }

    public void setAbilityList(List<Ability> abilityList) {
        this.abilityList = abilityList;
    }

    public Map<String,Skill> allSkills(){
        Map<String,Skill> allSkills=new HashMap<String, Skill>();
        for(BattleSkill skill:battleSkills){
            allSkills.put(skill.getId(),skill);
        }
        for(MagicSkill skill:magicSkills){
            allSkills.put(skill.getId(),skill);
        }
        for(CommonSkill skill:commonSkills){
            allSkills.put(skill.getId(),skill);
        }
        return allSkills;

    }

    public Map<String,Ability> allAbilities(){
        Map<String,Ability> allSkills=new HashMap<String, Ability>();
        for(Ability ability:abilityList){
            allSkills.put(ability.getId(),ability);
        }
        return allSkills;

    }

    public static void main(String[] args) throws IOException {
        Agility agility = new Agility();
        Control control = new Control();
        Speed speed = new Speed();
        ModData modData = new ModData();
        BattleSkill melee = new BattleSkill();
        melee.setId("melee");
        melee.setDescription("melee");
        melee.setName("melee");

        BattleSkill throwing = new BattleSkill();
        throwing.setId("throwing");
        throwing.setDescription("throwing");
        throwing.setName("throwing");

        BattleSkill sword = new BattleSkill();
        sword.setId("sword");
        sword.setDescription("sword");
        sword.setName("sword");

        com.magewars.game.entity.stats.MagicSkill fire = new com.magewars.game.entity.stats.MagicSkill();
        fire.setId("fire");
        fire.setDescription("fire");
        fire.setName("fire");

        com.magewars.game.entity.stats.MagicSkill water = new com.magewars.game.entity.stats.MagicSkill();
        water.setId("water");
        water.setDescription("water");
        water.setName("water");

        com.magewars.game.entity.stats.MagicSkill earth = new com.magewars.game.entity.stats.MagicSkill();
        earth.setId("earth");
        earth.setDescription("earth");
        earth.setName("earth");

        com.magewars.game.entity.stats.MagicSkill air = new com.magewars.game.entity.stats.MagicSkill();
        air.setId("air");
        air.setDescription("air");
        air.setName("air");

        MagicSkill lighting = new MagicSkill();
        lighting.setId("lighting");
        lighting.setDescription("lighting");
        lighting.setName("lighting");

        modData.setBattleSkills(new ArrayList<BattleSkill>());
        modData.setCommonSkills(new ArrayList<CommonSkill>());
        modData.setMagicSkills(new ArrayList<MagicSkill>());
        modData.getBattleSkills().add(melee);
        modData.getBattleSkills().add(sword);
        modData.getBattleSkills().add(throwing);

        modData.getMagicSkills().add(air);
        modData.getMagicSkills().add(earth);
        modData.getMagicSkills().add(water);
        modData.getMagicSkills().add(fire);
        modData.getMagicSkills().add(lighting);

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
     //   System.out.println(writer.toString());

        Team team1 = new Team("team1");
        Team team2 = new Team("team2");

        Unit u1 = createUnit("unit1");
        u1.getBattleSkills().put(melee, 1d);
        u1.getAbilities().add(meleeHit);
        Unit u2 = createUnit("unit2");
        u2.getMagicSkills().put(fire, 1d);
        u2.getAbilities().add(fireBullet);
        Unit u3 = createUnit("unit3");
        u3.getBattleSkills().put(melee, 1d);
        u3.getAbilities().add(meleeHit);
        Unit u4 = createUnit("unit4");
        u4.getBattleSkills().put(melee, 1d);
        u4.getAbilities().add(meleeHit);
        Unit u5 = createUnit("unit5");
        u5.getMagicSkills().put(fire, 1d);
        u5.getAbilities().add(fireBullet);
        Unit u6 = createUnit("unit6");
        u6.getBattleSkills().put(melee, 1d);
        u6.getAbilities().add(meleeHit);

        u1.refreshAllStat();
        u2.refreshAllStat();
        u3.refreshAllStat();
        u4.refreshAllStat();
        u5.refreshAllStat();
        u6.refreshAllStat();

        team1.addUnit(new UnitWrapper(u1));
        team1.addUnit(new UnitWrapper(u2));
        team1.addUnit(new UnitWrapper(u3));
        team2.addUnit(new UnitWrapper(u4));
        team2.addUnit(new UnitWrapper(u5));
        team2.addUnit(new UnitWrapper(u6));

        BattleField battleField=new BattleField(10);
        TeamWrapper teamWrapper1 = new TeamWrapper(team1, battleField.getTiles().get(0));
        teamWrapper1.setTactic(new FrontalAssault());
        TeamWrapper teamWrapper2 = new TeamWrapper(team2, battleField.getTiles().get(9));
        teamWrapper2.setTactic(new FrontalAssault());
        Battle battle=new Battle(battleField,teamWrapper1,teamWrapper2);
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

        UnitData data1=worker.lodaUserData(str, modData);
//        System.out.println(str2);











    }

    private static Unit createUnit(String name) {
        Random random=new Random();
        Unit unit = new Unit();
        unit.setHp(new HP(1000d+random.nextInt(1000)));
        unit.setEnergy(new Energy(1000d));
        unit.setControl(new Control(1d+random.nextInt(200)/100d));
        unit.setAgility(new Agility(1d+random.nextInt(200)/100d));
        unit.setEndurance(new Endurance(1d+random.nextInt(200)/100d));
        unit.setIntelligence(new Intelligence(1d+random.nextInt(200)/100d));
        unit.setSpeed(new Speed(1d+random.nextInt(200)/100d));
        unit.setStrength(new Strength(1d+random.nextInt(200)/100d));
        unit.setName(name);
        unit.setId(name);
        return unit;
    }

}
