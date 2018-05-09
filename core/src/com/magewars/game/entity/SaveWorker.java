package com.magewars.game.entity;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class SaveWorker {
    private ObjectMapper mapper = new ObjectMapper();
    public String saveModData(ModData data) throws IOException {
        StringWriter writer = new StringWriter();
        mapper.writerWithDefaultPrettyPrinter().writeValue(writer, data);
        return writer.toString();
    }
    public ModData loadModData(String data) throws IOException {
        StringWriter writer = new StringWriter();
        ModData modData = mapper.readValue(data, ModData.class);
        return modData;
    }

    public String saveUserData(UnitData data) throws IOException {
        data.preSave();
        StringWriter writer = new StringWriter();
        mapper.writerWithDefaultPrettyPrinter().writeValue(writer, data);
        return writer.toString();
    }

    public UnitData lodaUserData(String data, ModData modData) throws IOException {
        StringWriter writer = new StringWriter();
        UnitData unitData = mapper.readValue(data, UnitData.class);
        unitData.postLoad(modData.allAbilities(),modData.getSkillsMap());
        return unitData;
    }

}
