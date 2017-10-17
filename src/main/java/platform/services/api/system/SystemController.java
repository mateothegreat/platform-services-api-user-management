/**
 * ====
 *     Copyright 2017 Pivotal Software, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 * ====
 *
 * Copyright 2017 Pivotal Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
