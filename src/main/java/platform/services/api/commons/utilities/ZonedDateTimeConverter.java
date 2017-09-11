package platform.services.api.commons.utilities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Converter(autoApply = true)
public class ZonedDateTimeConverter implements AttributeConverter<ZonedDateTime, Timestamp> {

    @Override
    public java.sql.Timestamp convertToDatabaseColumn(final ZonedDateTime attribute) {

        return Timestamp.from(attribute.toInstant());

    }

    @Override
    public ZonedDateTime convertToEntityAttribute(final java.sql.Timestamp dbData) {

        final LocalDateTime localDateTime = dbData.toLocalDateTime();

        return localDateTime.atZone(ZoneId.systemDefault());

    }

}
