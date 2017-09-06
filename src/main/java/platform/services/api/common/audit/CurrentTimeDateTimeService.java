package platform.services.api.common.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;

public class CurrentTimeDateTimeService implements DateTimeService {

    private static final Logger logger = LoggerFactory.getLogger(CurrentTimeDateTimeService.class);

    @Override
    public ZonedDateTime getCurrentDateAndTime() {
        ZonedDateTime currentDateAndTime =  ZonedDateTime.now();
        return currentDateAndTime;
    }
}
