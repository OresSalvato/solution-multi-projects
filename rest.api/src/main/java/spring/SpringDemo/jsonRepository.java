package spring.SpringDemo;

import io.jsondb.JsonDBTemplate;
import io.jsondb.annotation.Document;

public class jsonRepository extends ProxyRepository<JsonDBTemplate> {
  private static String dbFilesLocation = "C:\\Projects\\Private\\demo\\src\\main\\dbfiles";

  private static JsonDBTemplate repo2;

  public jsonRepository() {
    /** User db initialisation */{
      String baseScanPackage = "beans.user.model";
      repo2 = new JsonDBTemplate(dbFilesLocation, baseScanPackage);
      //String collectionName = User.class.getAnnotation(Document.class).collection();
      //if (!jsonDBTemplate.collectionExists(collectionName))
      //  jsonDBTemplate.createCollection(collectionName);
    }
  }
}
