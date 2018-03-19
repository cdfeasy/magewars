package com.magewars.game.entity;

import com.magewars.game.entity.stats.BattleSkill;
import com.magewars.game.entity.stats.CommonSkill;
import com.magewars.game.entity.stats.MagicSkill;
import com.magewars.game.entity.stats.stat.*;

import java.util.List;

public class Unit {
    private String name;

    private Agility agility;
    private HP hp;
    private Energy energy;
    private Strength strength;
    private Control control;
    private Speed speed;
    private Endurance endurance;
    private Intelligence intelligence;

    private List<MagicSkill> magicSkills;
    private List<BattleSkill> battleSkills;
    private List<CommonSkill> commonSkills;


}
