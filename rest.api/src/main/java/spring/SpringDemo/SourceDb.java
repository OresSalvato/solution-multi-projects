package spring.SpringDemo;

public class SourceDb {
  private static SourceDb _instance;

  private static SourceDb getInstance() {
    if (null == _instance) {
      _instance = new SourceDb();
    }
    return _instance;
  }

  public SourceDb get() {
    return getInstance();
  }
}
