package platform.services.api.commons.audit;

import java.time.ZonedDateTime;


public interface DateTimeService {

    /**
     * Returns the current date and time.
     * @return ZonedDateTime
     */
    ZonedDateTime getCurrentDateAndTime();

}
