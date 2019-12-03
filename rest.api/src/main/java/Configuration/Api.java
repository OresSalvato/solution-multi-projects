package Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter
@Setter
@ToString
@ConfigurationProperties("server")
public class Api {
  private String port;
}
