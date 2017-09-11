package platform.services.api.commons;

import platform.services.api.commons.services.GenericService;

public interface BaseTest<T> {

    GenericService getGenericService();
    void setGenericService(final GenericService genericService);


}
