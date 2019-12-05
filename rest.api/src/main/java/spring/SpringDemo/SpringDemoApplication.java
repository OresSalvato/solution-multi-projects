package spring.SpringDemo;

import com.ores.salvato.interfaces.model.AnyRecord;

import controllers.RestProductServiceController;
import controllers.RestStudentServiceController;
import controllers.RestUserServiceController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.ProductRepository;
import repositories.StudentRepository;
import repositories.UserRepository;


@Configuration
@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackageClasses = {
    RestProductServiceController.class,
    RestStudentServiceController.class,
    RestUserServiceController.class
})
@EntityScan(basePackages = {"com.ores.salvato.entities"})
@EnableJpaRepositories(basePackageClasses = {
    ProductRepository.class,
    StudentRepository.class,
    UserRepository.class
})
public class SpringDemoApplication extends SpringBootServletInitializer {

  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder
        .sources(SpringDemoApplication.class);
  }

  public static void main(String[] args) {

    AnyRecord rec;
    // rec = new User();
    // repo = new JsonDbRepository();
    // repo.initialize("com.ores.salvato.entities");
    // repo.setCollection(User.class);
    //
//    rec = new Student();
//    repo2 = new JsonDbRepository();
//    repo2.initialize("beans.student.model");
//    repo2.setCollection(Student.class);
//    //
//    rec = new Product();
//    repo3 = new JsonDbRepository();
//    repo3.initialize("beans.product.model");
//    repo3.setCollection(Product.class);

    // repo.initialize("User");
    // repo.repo
    //SourceDb db = spring.SpringDemo.SourceDb.get();

    SpringApplication.run(SpringDemoApplication.class);
  }
}