//package platform.services.api.system;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.env.Environment;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//import platform.services.api.commons.controller.BaseController;
//
//@RestController
//@RequestMapping("/system")
//public class SystemController extends BaseController<SystemService, SystemRepository, System> {
//
//    @Autowired
//    private LoadBalancerClient loadBalancer;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @Autowired
//    private Environment env;
//
//    @Autowired
//    private SampleClient sampleClient;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    private final SystemService service;
//
//    @Autowired public SystemController(final SystemService service) {
//
//        super(service);
//
//        this.service = service;
//
//    }
//    @Value("${spring.application.name:testConsulApp}")
//    private String appName;
//
//    @RequestMapping("/me")
//    public ServiceInstance me() {
//
//        return discoveryClient.getLocalServiceInstance();
//    }
//
//    @RequestMapping("/")
//    public ServiceInstance lb() {
//
//        return loadBalancer.choose(appName);
//    }
//
//    @RequestMapping("/rest")
//    public String rest() {
//
//        return this.restTemplate.getForObject("http://" + appName + "/me", String.class);
//    }
//
//    @RequestMapping("/choose")
//    public String choose() {
//
//        return loadBalancer.choose(appName).getUri().toString();
//    }
//
//    @RequestMapping("/myenv")
//    public String env(@RequestParam("prop") String prop) {
//
//        return env.getProperty(prop, "Not Found");
//    }
//
//    @RequestMapping("/prop")
//    public String prop() {
//
//        return sampleProperties().getProp();
//    }
//
//    @RequestMapping("/instances")
//    public List<ServiceInstance> instances() {
//
//        return discoveryClient.getInstances(appName);
//    }
//
//    @RequestMapping("/feign")
//    public String feign() {
//
//        return sampleClient.choose();
//    }
//
//	/*@Bean
//	public SubtypeModule sampleSubtypeModule() {
//		return new SubtypeModule(SimpleRemoteEvent.class);
//	}*/
//
//    @Bean
//    public SampleProperties sampleProperties() {
//
//        return new SampleProperties();
//    }
//
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//
//        return new RestTemplate();
//    }
//
//
//	/*@Override
//	public void onApplicationEvent(SimpleRemoteEvent event) {
//		log.info("Received event: {}", event);
//	}*/
//
//    @FeignClient("testConsulApp")
//    public interface SampleClient {
//
//        @RequestMapping(value = "/choose", method = RequestMethod.GET)
//        String choose();
//    }
//}
