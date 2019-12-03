package com.ores.salvato.interfaces.proxy;

public class ProxyRepositoryImpl implements IProxyRepository {


  public ProxyRepositoryImpl() {
    repositoryConfiguration();
  }

 // @Override
  public void initialize(String baseScanPackage) {
    System.out.println (baseScanPackage);
  }

 // @Override
  public void setCollection(Class clas) {

  }

  // @Override
 // public void initialize(String collectionName) {
 //   System.out.println ("processing complete.");
 // }

  private void repositoryConfiguration() {
    System.out.println ("if Object not exists then ...");
    System.out.println ("Loading initial Repository configuration...");
  }

}
