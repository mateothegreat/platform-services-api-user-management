//package platform.services.api.streams;
//
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import platform.services.api.commons.configuration.CommonsConfig;
//
////@ClassPreamble(
////    author = "John Doe",
////    date = "3/17/2002",
////    currentRevision = 6,
////    lastModified = "4/12/2004",
////    lastModifiedBy = "Jane Doe",
////    // Note array notation
////    reviewers = { "Alice", "Bob", "Cindy" }
////)
////@Log4j2
////@Configuration
////@ComponentScan(basePackages = { CommonsConfig.PLATFORM_SERVICES_API, StreamConfig.PLATFORM_SERVICES_API_STREAMS })
//@Configuration
////@EnableJpaRepositories(basePackages = { CommonsConfig.PLATFORM_SERVICES_API, StreamConfig.PLATFORM_SERVICES_API_STREAMS })
////@EntityScan(basePackages = { StreamConfig.PLATFORM_SERVICES_API_STREAMS })
//@ComponentScan(basePackages = {
//
//        StreamConfig.PLATFORM_SERVICES_API_STREAMS,
//
//        CommonsConfig.PLATFORM_SERVICES_API_COMMONS,
//        CommonsConfig.PLATFORM_SERVICES_API,
//
//})
//public class StreamConfig {
//
//    public static final String PLATFORM_SERVICES_API_STREAMS = "platform.services.api.streams.streams";
//
//    public static final int NAME_LENGTH_MIN = 1;
//
//    public static final int NAME_LENGTH_MAX = 32;
//
//    public static final int DESCRIPTION_LENGTH_MAX = 32;
//
//    public static final int PROTOCOL_MAX_LENGTH = 4;
//
//    public static final int DESCRIPTION_LENGTH_MIN = 1;
//
//    public static final int PROTOCOL_MIN_LENGTH = 4;
//
//}
