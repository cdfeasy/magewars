package com.magewars.game.entity;

import com.magewars.game.entity.ability.Ability;
import com.magewars.game.entity.stats.BattleSkill;
import com.magewars.game.entity.stats.CommonSkill;

import java.util.List;

public class ModData {
    private String modName;
    private String author;
    private String description;
    private String url;

    private List<BattleSkill> battleSkills;
    private List<WeaponSkills> weaponSkills;
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

    public List<WeaponSkills> getWeaponSkills() {
        return weaponSkills;
    }

    public void setWeaponSkills(List<WeaponSkills> weaponSkills) {
        this.weaponSkills = weaponSkills;
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
}
