package platform.services.api.users.roles;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import platform.services.api.commons.services.GenericService;

@Log4j2
@Service
@Transactional
public class UserRoleService extends GenericService<UserRoleRepository, UserRole> {

    private final UserRoleRepository repository;

    @Autowired
    public UserRoleService(final UserRoleRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
