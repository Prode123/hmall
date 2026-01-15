package com.hmall.common.desensitize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

import java.io.IOException;
/**
 * @Description
 * @Author LiTong(Prode)
 * @Data 2026/01/15 09:24
 */

public class DesensitizeSerializer extends JsonSerializer<String>
        implements ContextualSerializer {

    private DesensitizeType type;

    public DesensitizeSerializer() {}

    public DesensitizeSerializer(DesensitizeType type) {
        this.type = type;
    }

    @Override
    public void serialize(String value, JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        gen.writeString(DesensitizeUtil.desensitize(value, type));
    }

    @Override
    public JsonSerializer<?> createContextual(
            SerializerProvider prov, BeanProperty property) throws JsonMappingException {

        if (property != null) {
            Desensitize ann = property.getAnnotation(Desensitize.class);
            if (ann != null && property.getType().getRawClass() == String.class) {
                return new DesensitizeSerializer(ann.type());
            }
        }
        return prov.findValueSerializer(String.class);
    }
}
