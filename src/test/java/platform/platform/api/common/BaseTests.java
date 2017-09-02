package platform.platform.api.common;

import platform.services.api.common.jpa.entities.*;
import platform.services.api.common.jpa.repositories.*;
import platform.services.api.common.utilities.Tracing;
import platform.services.api.users.services.*;

import static org.assertj.core.api.Assertions.*;

public class BaseTests {

    private GenericService genericService;

    protected void baseEntity_deleteByObj(BaseEntity entity) {

        Tracing.trace("baseEntity_deleteByObj: {}", Tracing.toString(entity));

        baseEntity_isValid(entity);

        getGenericService().delete(entity);

    }

    protected void baseEntity_isValid(BaseEntity baseEntity) {

        Tracing.trace("baseEntity_isValid: {}", Tracing.toString(baseEntity));

        assertThat(baseEntity.getId()).isNotNull();
        assertThat(baseEntity.getId()).isGreaterThan(0);

    }

    protected void getEntity_CompareEntity(BaseEntity left, BaseEntity right) {

        Tracing.trace("getEntity_CompareEntity: LEFT: {}, RIGHT: {}", Tracing.toString(left), Tracing.toString(right));

        assertThat(left).isEqualToIgnoringGivenFields(right);

    }

    protected void baseRepository_isValid(BaseRepository baseRepository) {

        Tracing.trace("baseRepository_isValid: {}", Tracing.toString(baseRepository));

    }

    public GenericService getGenericService() {

        return genericService;
    }

    public void setGenericService(GenericService genericService) {

        this.genericService = genericService;
    }
}
