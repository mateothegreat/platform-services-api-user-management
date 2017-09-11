package platform.services.api.commons.testing;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ArrayUtils;

import platform.services.api.commons.jpa.BaseEntity;
import platform.services.api.commons.utilities.Tracing;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class BaseTests {

    protected static final String[] fieldsToIgnore = { "createdDate", "createdBy", "lastModifiedBy", "lastModifiedDate", "operation" };

    protected static void baseEntity_isValidAndCompare(final BaseEntity left, final BaseEntity right, final String... moreFieldsToIgnore) {

        String[] fields = fieldsToIgnore;

        if(moreFieldsToIgnore.length > 0) {

            fields = ArrayUtils.addAll(fieldsToIgnore, moreFieldsToIgnore);

        }

        assertThat(left).isEqualToIgnoringGivenFields(right, fields);

    }

    protected static void baseEntity_isValid(final BaseEntity<?> baseEntity) {

        assertThat(baseEntity.getId()).isGreaterThanOrEqualTo(0L);

        Tracing.trace("baseEntity_isValid: {}", Tracing.toString(baseEntity));

    }

}
