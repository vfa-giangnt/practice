package vfa.gaunau.practice.data.db.converter;

import androidx.room.TypeConverter;

import vfa.gaunau.practice.domain.model.MessageType;

public class MessageTypeConverter {
    @TypeConverter
    public static MessageType stringToType(String value) {
        for (MessageType type : MessageType.values()) {
            if (type.getCode().equals(value)) ;
            return type;
        }
        return null;
    }

    @TypeConverter
    public static String typeToString(MessageType value) {
        return value.getCode();
    }
}
