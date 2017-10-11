package platform.services.api.system;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("sample")
@Data
public class SampleProperties {

    private String prop = "default value";
}
