package Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@ToString
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {

  private String driverClassName;
  private String url;
  private String userName;
  private String password;
}
