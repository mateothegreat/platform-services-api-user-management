package platform.services.api.users;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.FieldDefinitionBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.github.benas.randombeans.randomizers.EmailRandomizer;
import io.github.benas.randombeans.randomizers.range.LongRangeRandomizer;
import io.github.benas.randombeans.randomizers.text.StringRandomizer;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.users.User;

@Log4j2
public class EntityRandomizer {

    private final EnhancedRandomBuilder builder;

    //region Custom Randomizers

    protected LongRangeRandomizer id       = new LongRangeRandomizer(BaseEntity.ID_RANGE_MIN, BaseEntity.ID_RANGE_MAX);
    protected LongRangeRandomizer status   = new LongRangeRandomizer(BaseEntity.STATUS_RANGE_MIN, BaseEntity.STATUS_RANGE_MAX);
    protected EmailRandomizer     email    = new EmailRandomizer(EntityRandomizerSeed.getLong());
    protected StringRandomizer    username = new StringRandomizer(User.USERNAME_LENGTH_MIN, User.USERNAME_LENGTH_MAX,
                                                                  EntityRandomizerSeed.getLong());
    protected StringRandomizer    password = new StringRandomizer(User.PASSWORD_LEGNTH_MIN, User.PASSWORD_LEGNTH_MAX,
            EntityRandomizerSeed.getLong());

    //endregion

    public EntityRandomizer() {

        builder = new EnhancedRandomBuilder();


    }

    public EnhancedRandom setUp() {

        // region [Exclusions]
        builder.exclude(FieldDefinitionBuilder.field()
                                              .named("id")
                                              .ofType(Long.class)
                                              .get());

        builder.exclude(FieldDefinitionBuilder.field()
                                              .named("createdBy")
                                              .ofType(String.class)
                                              .get());

        builder.exclude(FieldDefinitionBuilder.field()
                                              .named("createdDate")
                                              .ofType(Date.class)
                                              .get());

        builder.exclude(FieldDefinitionBuilder.field()
                                              .named("lastModifiedBy")
                                              .ofType(String.class)
                                              .get());

        builder.exclude(FieldDefinitionBuilder.field()
                                              .named("lastModifiedDate")
                                              .ofType(Date.class)
                                              .get());

        builder.exclude(FieldDefinitionBuilder.field()
                                              .named("operation")
                                              .ofType(String.class)
                                              .get());

        builder.exclude(FieldDefinitionBuilder.field()
                                              .named("parentId")
                                              .ofType(Long.class)
                                              .get());
        // endregion
        // region [Fields]
        builder.randomize(FieldDefinitionBuilder.field()
                                                .named("parentId")
                                                .ofType(Long.class)
                                                .get(), id);

        builder.randomize(FieldDefinitionBuilder.field()
                                                .named("status")
                                                .ofType(Long.class)
                                                .get(), status);

        builder.randomize(FieldDefinitionBuilder.field()
                                                .named("email")
                                                .ofType(String.class)
                                                .get(), email);

        builder.randomize(FieldDefinitionBuilder.field()
                                                .named("username")
                                                .ofType(String.class)
                                                .get(), username);

        builder.randomize(FieldDefinitionBuilder.field()
                                                .named("password")
                                                .ofType(String.class)
                                                .get(), password);
        // endregion

        return builder.build();

    }

    public <T> T get(final Class<T> type, final String... excludedFields) {

        return setUp().nextObject(type, excludedFields);

    }

    public <T> List<T> getList(final int max, final Class<T> type, final String... excludedFields) {

        final List<T> list = new ArrayList<>(max);

        for(int i = 1; i < max; i++) {

            final T t = get(type, excludedFields);

            log.trace("i: {}, t: {}", i, t.toString());

            list.add(t);

        }

        return list;

    }

}
