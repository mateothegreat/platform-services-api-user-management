package platform.services.api.common.utilities;

import org.apache.commons.lang3.builder.*;
import org.apache.logging.log4j.*;

public class Tracing {


//    public static Logger log = LogManager.getLogger(BaseEntity.class);

    public static String toString(Object o) {

        return ToStringBuilder.reflectionToString(o, RecursiveToStringStyle.MULTI_LINE_STYLE);

    }

    public static void trace(String str, Object... args ) {

        LogManager.getLogger().trace(str, args);

    }
}
