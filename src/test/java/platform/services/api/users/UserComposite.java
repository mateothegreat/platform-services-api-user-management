package platform.services.api.users;

import platform.services.api.commons.validation.ValidationError;
import platform.services.api.organizations.Organization;

public interface UserComposite {

    //    User persistFixtures() throws ValidationError;
    User persistFixtures(final Organization organization, final Long parentId, final String username, final String password) throws ValidationError;

}
