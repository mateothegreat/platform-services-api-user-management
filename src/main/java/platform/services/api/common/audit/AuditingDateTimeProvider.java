package platform.services.api.common.audit;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.auditing.DateTimeProvider;

import java.time.temporal.TemporalAccessor;
import java.util.GregorianCalendar;
import java.util.Optional;

@Log4j2
public class AuditingDateTimeProvider implements DateTimeProvider {

    private final DateTimeService dateTimeService;

    public AuditingDateTimeProvider(DateTimeService dateTimeService) {

        log.error("AuditingDateTimeProvider(DateTimeService dateTimeService): {}", dateTimeService.toString());

        this.dateTimeService = dateTimeService;

    }

    @Override
    public Optional<TemporalAccessor> getNow() {

        log.trace("getNow(): {}",  GregorianCalendar.from(dateTimeService.getCurrentDateAndTime()).toString());

       return Optional.of(GregorianCalendar.from(dateTimeService.getCurrentDateAndTime()).toZonedDateTime().toLocalDate());

    }

}
