package platform.services.api.users.roles;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.commons.services.GenericService;

@Log4j2
@Service
public class UserRoleService extends GenericService<UserRoleRepository, UserRole, Long> {

    private final UserRoleRepository repository;

    @Autowired
    public UserRoleService(final UserRoleRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
