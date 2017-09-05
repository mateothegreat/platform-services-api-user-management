package platform.services.api.common.jpa.repositories;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import platform.services.api.common.utilities.Tracing;

//public class BasePageable implements Pageable {
public class BasePageable extends PageImpl {

//    public BasePageable() {

//        super();

//    }

    public BasePageable(final List content, final Pageable pageable, final long total) {

        super(content, pageable, total);

        Tracing.trace("BasePageable(final List content, final Pageable pageable, final long total): {}, {}, {}", content.toString(),pageable.toString(), total);

    }

    public BasePageable(final List content) {

        super(content);

        Tracing.trace("BasePageable(final List content): {}", content.toString());
    }

}
