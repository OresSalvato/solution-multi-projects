package repositories;


import com.ores.salvato.interfaces.proxy.IProxyRepository;
import com.ores.salvato.interfaces.proxy.ProxyRepositoryImpl;
import io.jsondb.JsonDBTemplate;

public class JsonDbRepository implements IProxyRepository {
  public JsonDBTemplate dbTemplate;

  private static IProxyRepository object;
  private static String dbFilesLocation = "C:\\Projects\\Private\\demo\\src\\main\\dbfiles";

  //@Override
  public void initialize(String baseScanPackage) {
    if (object == null) {
      object = new ProxyRepositoryImpl();
      /** any db initialisation */{
        dbTemplate = new JsonDBTemplate(dbFilesLocation, baseScanPackage);
      }
    }
    object.initialize(baseScanPackage);
  }

  //@Override
  public void setCollection(Class clas){
    System.out.println(clas.getSimpleName());
    if (!dbTemplate.collectionExists(clas)) dbTemplate.createCollection(clas.getSimpleName());
  }
}
