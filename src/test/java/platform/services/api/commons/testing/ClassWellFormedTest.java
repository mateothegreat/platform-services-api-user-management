package platform.services.api.commons.testing;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassWellFormedTest extends ClassWellFormed {

    @Test
    public void publicClassWithOnePublicConstructorTest() throws ReflectiveOperationException {

        assertThat(classHasOneConstructor(PublicClassWithOnePublicConstructor.class)).isTrue();
        assertThat(classHasPublicConstructor(PublicClassWithOnePublicConstructor.class)).isTrue();

    }

    @Test
    public void publicFinalClassOnePublicConstructorStaticMethodsTest() throws ReflectiveOperationException {

        assertThat(classHasOneConstructor(PublicFinalClassOnePublicConstructorStaticMethods.class)).isTrue();

        assertThat(classHasPublicConstructor(PublicFinalClassOnePublicConstructorStaticMethods.class)).isTrue();

        assertThat(classHasAllStaticMethods(PublicFinalClassOnePublicConstructorStaticMethods.class)).isTrue();

    }

    @Test
    public void privateFinalClassWithOnePrivateFinalConstructorTest() throws Exception {

        assertThat(classHasOneConstructor(PrivateFinalClassPrivateConstructor.class)).isTrue();

        assertThat(classHasFinalConstructor(PrivateFinalClassPrivateConstructor.class)).isTrue();
        assertThat(classHasPrivateConstructor(PrivateFinalClassPrivateConstructor.class)).isTrue();

        assertThat(classHasAllStaticMethods(PrivateFinalClassPrivateConstructor.class)).isTrue();

    }

    @Test
    public void publicFinalClassWithMultiplePrivateFinalConstructorsTest() throws Exception {

        assertThat(classHasMoreThanOneConstructor(PublicFinalClassMultiplePrivateConstructors.class)).isTrue();

        assertThat(classHasFinalConstructor(PublicFinalClassMultiplePrivateConstructors.class)).isTrue();
        assertThat(classHasPrivateConstructor(PublicFinalClassMultiplePrivateConstructors.class)).isTrue();

        assertThat(classHasAllStaticMethods(PublicFinalClassMultiplePrivateConstructors.class)).isTrue();

    }

}

