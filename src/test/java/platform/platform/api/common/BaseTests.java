package platform.platform.api.common;

import platform.services.api.common.jpa.entities.BaseEntity;
import platform.services.api.common.jpa.repositories.BaseRepository;
import platform.services.api.common.utilities.Tracing;
import platform.services.api.users.services.GenericService;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseTests implements BaseTest {

    protected GenericService genericService;

    protected static void baseEntity_compare(final BaseEntity left, final BaseEntity right) {

        Tracing.trace("baseEntity_compare: LEFT: {}, RIGHT: {}", Tracing.toString(left), Tracing.toString(right));

        assertThat(left).isEqualToIgnoringGivenFields(right);

    }

    protected static void baseRepository_isValid(final BaseRepository baseRepository) {

        Tracing.trace("baseRepository_isValid: {}", Tracing.toString(baseRepository));

    }

    protected void baseEntity_deleteByObj(final BaseEntity entity) {

        Tracing.trace("baseEntity_deleteByObj: {}", Tracing.toString(entity));

        baseEntity_isValid(entity);

        genericService.delete(entity);

    }

    protected static void baseEntity_isValid(final BaseEntity baseEntity) {

        Tracing.trace("baseEntity_isValid: {}", Tracing.toString(baseEntity));

        assertThat(baseEntity.getId()).isNotNull();
        assertThat(baseEntity.getId()).isGreaterThan(0L);

    }

    public GenericService getGenericService() {

        return genericService;

    }

    public void setGenericService(final GenericService genericService) {

        this.genericService = genericService;

    }

}
