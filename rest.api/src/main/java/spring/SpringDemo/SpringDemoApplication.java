package spring.SpringDemo;

import com.ores.salvato.interfaces.model.AnyRecordType;
import com.ores.salvato.interfaces.proxy.IProxyRepository;

import io.jsondb.JsonDBTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = {"controllers"})
public class SpringDemoApplication extends SpringBootServletInitializer {
  public static IProxyRepository repo;

  //private static JsonDBConfig config;
  public static JsonDBTemplate jsonDBTemplate;
  private static String dbFilesLocation = "C:\\Projects\\Private\\solution_DEMO\\rest.api\\src\\main\\dbfiles";

  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder
        .sources(SpringDemoApplication.class);
  }

  public static void main(String[] args) {

    AnyRecordType rec;
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

		//jsonDBTemplate = jsonRepository.getInstance();
    /* User db initialisation */{
    //  String baseScanPackage = "beans.student.model";
    //  jsonDBTemplate = new JsonDBTemplate(dbFilesLocation, baseScanPackage);
     // String collectionName = User.class.getAnnotation(Document.class).collection();
     // if (!jsonDBTemplate.collectionExists(collectionName))
     //   jsonDBTemplate.createCollection(collectionName);
    }
    SpringApplication.run(SpringDemoApplication.class);
  }
}