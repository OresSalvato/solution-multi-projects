package Configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.Console;

@Configuration
@EnableConfigurationProperties(Api.class)
public class ApiConfiguration {
  private Api apiConfiguration;

  public ApiConfiguration(Api apiConfiguration) {
    this.apiConfiguration = apiConfiguration;
  }

  @Profile("dev")
  @Bean
  public String devApi() {
    System.out.println("API server for Dev");
    System.out.println(apiConfiguration.toString());
    return "API server for Dev";
  }

  @Profile("test")
  @Bean
  public String testApi() {
    System.out.println("API server for Test");
    System.out.println(apiConfiguration.toString());
    return "API server for Test";
  }

  @Profile("prod")
  @Bean
  public String prodApi() {
    System.out.println("API server for Prod");
    System.out.println(apiConfiguration.toString());
    return "API server for Prod";
  }
}
