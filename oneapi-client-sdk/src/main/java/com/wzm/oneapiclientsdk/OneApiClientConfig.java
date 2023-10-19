package com.wzm.oneapiclientsdk;

import com.wzm.oneapiclientsdk.client.OneApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * OneApi Client configuration
 *
 * @author wzm
 *
 */
@Configuration
@ConfigurationProperties("oneapi.client")
@Data
@ComponentScan
public class OneApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public OneApiClient oneApiClient() {
        return new OneApiClient(accessKey, secretKey);
    }

}
