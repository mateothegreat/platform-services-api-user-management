package platform.platform.api.common;

import platform.services.api.users.services.GenericService;

public interface BaseTest {

    GenericService getGenericService();
    void setGenericService(final GenericService genericService);


}