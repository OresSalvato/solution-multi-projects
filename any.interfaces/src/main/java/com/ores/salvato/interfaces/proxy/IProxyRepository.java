package com.ores.salvato.interfaces.proxy;

/**
 *
 */
public interface IProxyRepository {
  void initialize(String baseScanPackage);

  void setCollection(Class clas);
  //void initialize(String collectionName);
  //T getDB(final String dbname) throws Exception;

  //T getDBMain() throws Exception;

}