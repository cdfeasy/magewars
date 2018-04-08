package com.magewars.game.entity;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.magewars.game.entity.ability.Ability;
import com.magewars.game.entity.ability.AbilityCheck;
import com.magewars.game.entity.ability.AbilityCost;
import com.magewars.game.entity.ability.AbilityDamage;
import com.magewars.game.entity.stats.BattleSkill;
import com.magewars.game.entity.stats.CommonSkill;
import com.magewars.game.entity.stats.MagicSkill;
import com.magewars.game.entity.stats.Skill;
import com.magewars.game.entity.stats.stat.Agility;
import com.magewars.game.entity.stats.stat.Control;
import com.magewars.game.entity.stats.stat.Speed;
import com.magewars.game.serializers.BattleSkillSerializer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) throws IOException {
        Agility agility=new Agility();
        Control control=new Control();
        Speed speed=new Speed();
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

        Ability meleeHit=new Ability("melee_hit",new AbilityCost(10d),"melee hit",melee,1d,new AbilityCheck(melee,melee),new AbilityDamage(melee,1d,Damage.HIT,50d));
        Ability uppercut=new Ability("melee_uppercut",new AbilityCost(1d,20d),"uppercut",melee,2d,new AbilityCheck(melee,melee),new AbilityDamage(melee,1d,Damage.STUN,100d));

        Ability fireBuller=new Ability("fire_bullet",new AbilityCost(20d),"fire buller",fire,1d,new AbilityCheck(control,agility),new AbilityDamage(melee,1d,Damage.HIT,50d));

        modData.setAbilityList(new ArrayList<Ability>());
        modData.getAbilityList().add(meleeHit);
        modData.getAbilityList().add(uppercut);
        modData.getAbilityList().add(fireBuller);


        ObjectMapper mapper=new ObjectMapper();
     //   SimpleModule  module=new SimpleModule();
    //    module.addSerializer(Skill.class,new BattleSkillSerializer());
       // mapper.registerModule(module);
        StringWriter writer=new StringWriter();
        mapper.writerWithDefaultPrettyPrinter().writeValue(writer,modData);
        System.out.println(writer.toString());



    }
}
