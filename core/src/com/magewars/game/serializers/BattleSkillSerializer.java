package com.magewars.game.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.magewars.game.entity.stats.BattleSkill;
import com.magewars.game.entity.stats.Skill;

import java.io.IOException;
import java.io.StringWriter;

import static com.fasterxml.jackson.core.JsonToken.START_OBJECT;

public class BattleSkillSerializer extends JsonSerializer<Skill> {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public void serialize(Skill value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
     //   StringWriter writer = new StringWriter();
      //  mapper.writeValue(writer, value.getId());

        gen.writeStartObject();
        gen.writeStringField("id", value.getId());
        gen.writeEndObject();
    }

    @Override
    public void serializeWithType(Skill value, JsonGenerator gen,
                                  SerializerProvider provider, TypeSerializer typeSer)
            throws IOException, JsonProcessingException {

        WritableTypeId typeId = typeSer.typeId(value, START_OBJECT);
        typeSer.writeTypePrefix(gen, typeId);
        serialize(value, gen, provider); // call your customized serialize method
        typeSer.writeTypeSuffix(gen, typeId);
    }
}
