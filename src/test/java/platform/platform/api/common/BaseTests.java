package platform.platform.api.common;

import lombok.extern.log4j.Log4j2;

import platform.services.api.common.jpa.entities.BaseEntity;
import platform.services.api.common.jpa.repositories.BaseRepository;
import platform.services.api.common.utilities.Tracing;
import platform.services.api.users.services.GenericService;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class BaseTests<T> implements BaseTest<T> {

    private GenericService genericService;

    protected static void baseRepository_isValid(final BaseRepository baseRepository) {

        Tracing.trace("baseRepository_isValid: {}", Tracing.toString(baseRepository));

    }

    protected static void baseEntity_isValidAndCompare(final BaseEntity left, final BaseEntity right) {

//        Tracing.trace("baseEntity_isValidAndCompare: LEFT: {}, RIGHT: {}", Tracing.toString(left), Tracing.toString(right));

        assertThat(left).isEqualToIgnoringGivenFields(right, "createdDate", "createdBy", "lastModifiedBy", "lastModifiedDate", "operation");

    }

    public GenericService getGenericService() {

        return genericService;

    }

    public void setGenericService(final GenericService genericService) {

        assertThat(genericService).isNotNull();

        this.genericService = genericService;

    }

    public void baseEntity_getById_exists(final Long id) {

        final boolean exists = genericService.existsById(id);

        Tracing.trace("baseEntity_getById_exists: (id: {}) = {}", id, String.valueOf(exists));

        assertThat(exists).isTrue();

    }

    public void baseEntity_getById_doesNotExist(final Long id) {

        final boolean exists = genericService.existsById(id);

        Tracing.trace("baseEntity_getById_doesNotExist: (id: {}) = {}", id, String.valueOf(exists));

        assertThat(exists).isFalse();

    }

    public String getUrl(final int localServerPort, final String path) {

        return "http://localhost:" + localServerPort + path;

    }

    //    protected BaseEntity<T> baseEntity_save(final BaseEntity baseEntity) {
//    protected BaseEntity<? extends User> baseEntity_save(final BaseEntity baseEntity) {
//    protected <T> T baseEntity_save(final BaseEntity baseEntity) {
//
//        final BaseEntity<T> result = (BaseEntity<T>) genericService.saveEntity(baseEntity);
//
//        baseEntity_isValid(result);
//
//        return (T) result;
//
//    }

    protected void baseEntity_deleteByObj(final BaseEntity<T> entity) {

        baseEntity_isValid(entity);

        genericService.delete(entity);

    }

    protected static void baseEntity_isValid(final BaseEntity<?> baseEntity) {

        assertThat(baseEntity.getId()).isGreaterThanOrEqualTo(0L);

        Tracing.trace("baseEntity_isValid: {}", Tracing.toString(baseEntity));

    }

    protected void baseEntity_getById_existsIsValidEntity(final Long id) {

        Tracing.trace("BaseTests->baseEntity_getById: {}", id);

        final BaseEntity entity = genericService.getById(id);
        baseEntity_isValid(entity);

        genericService.delete(entity);

    }

}
