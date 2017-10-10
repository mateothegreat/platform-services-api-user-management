package platform.services.api.users;

import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.jpa.entities.BaseEntityFixtureFunction;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.commons.testing.BaseControllerTest;
import platform.services.api.commons.testing.BaseTestConfig;
import platform.services.api.commons.testing.RestAssuredFactory;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.organizations.Organization;

import static org.assertj.core.api.Assertions.assertThat;

@Getter @Setter
public class UserAuthenticationTestSetup<E extends BaseEntity> extends BaseControllerTest<E> {

    private final UserComposite userComposite;
    private       User          userFixture;

    public UserAuthenticationTestSetup(final BaseEntityFixtureFunction<E> fn, final Class<E> entityClass, final String pathBase, final UserComposite userComposite) {

        super(fn, entityClass, pathBase);

        assertThat(pathBase).isNotNull();
        assertThat(userComposite).isNotNull();

        this.userComposite = userComposite;
        this.userFixture = null;

        try {

            this.userFixture = userComposite.persistFixtures(Organization.create(), BaseTestConfig.USER_VALID_PARENT_ID, BaseTestConfig.USER_VALID_USERNAME, BaseTestConfig.USER_VALID_PASSWORD);

        } catch(final ValidationError error) {

            error.printStackTrace();

        }

    }

    @BeforeMethod
    public void beforeUserAuthenticationFixturesEach() {

        assertThat(userFixture.getId()).isNotZero();
        assertThat(userFixture.getPasswordNotEncrypted()).isNotEmpty();
        assertThat(SecurityCryptor.isEncoded(userFixture.getPasswordNotEncrypted())).isFalse();

        RestAssuredFactory.auth(userFixture.getUsername(), userFixture.getPasswordNotEncrypted());
        RestAssuredFactory.port(getServerPort());

    }

}
