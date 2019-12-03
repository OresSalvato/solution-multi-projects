package Configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableConfigurationProperties(DBConfiguration.class)
public class DBConnectionConfiguration {
  private DBConfiguration dbConfiguration;

  public DBConnectionConfiguration(DBConfiguration dbConfiguration) {
    this.dbConfiguration = dbConfiguration;
  }

  @Profile("dev")
  @Bean
  public String devDBConnection() {
    System.out.println("DB Connection for Dev");
    System.out.println(dbConfiguration.toString());
    return "DB Connection for Dev";
  }

  @Profile("test")
  @Bean
  public String testDBConnection() {
    System.out.println("DB Connection for Test");
    System.out.println(dbConfiguration.toString());
    return "DB Connection for Test";
  }

  @Profile("prod")
  @Bean
  public String prodDBConnection() {
    System.out.println("DB Connection for Prod");
    System.out.println(dbConfiguration.toString());
    return "DB Connection for Prod";
  }
}
