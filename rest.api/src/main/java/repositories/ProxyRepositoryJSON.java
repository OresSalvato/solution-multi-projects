package repositories;

//OLD


import com.ores.salvato.interfaces.proxy.IProxyRepository;

/**
 *
 */
public class ProxyRepositoryJSON {
  private IProxyRepository _proxy;
  private ProxyRepositoryJSON() { }

  private static ProxyRepositoryJSON _instance;
  private static ProxyRepositoryJSON getInstance() {
    if (null == _instance) {
      _instance = new ProxyRepositoryJSON();
    }
    return _instance;
  }

  public static <T> ProxyRepositoryJSON get() {
    return (ProxyRepositoryJSON) getInstance()._proxy;
  }

  public static void register(final ProxyRepositoryJSON proxy) {
    getInstance()._proxy = (IProxyRepository) proxy;
  }

}