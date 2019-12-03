package repositories;

import com.ores.salvato.interfaces.proxy.IProxyRepository;
import com.ores.salvato.interfaces.proxy.ProxyRepositoryImpl;

public class JsonProxyRepository implements IProxyRepository {
  private static IProxyRepository object;

 // @Override
  public void initialize(String baseScanPackage) {
    if (object == null) {
      object = new ProxyRepositoryImpl();
    }
    object.initialize("beans.any");
  }



 // @Override
  public void setCollection(Class clas) {

  }

//  @Override
//  public void initialize(String collectionName) {
//    if (object == null) {
//      object = new ProxyRepositoryImpl();
//    }
//    object.initialize();
//  }
}
