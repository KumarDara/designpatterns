package patterns.creational;
/*
Singleton is a creational pattern.
It provides single instance of the class and single point of access to get the instance
Different Approaches
Eager initialization: instance of a class is created long before it is actually required
Lazy initialization: instance of a class is created when the client sends a request
Static block initialization: is similar to eager initialization, except that the instance of the class is created in the static block 
                             that provides the option for exception handling
Thread safe singleton: is to make the global access method is synchronized so that only one thread can execute this method at a time
Bill Pugh singleton: implementation using the static inner helper class. Static inner classes are not loaded into memory until their getInstance() methods are called
Enum singleton: provides implicit support for thread safety and only one instance is guaranteed
*/
//https://dzone.com/articles/prevent-breaking-a-singleton-class-pattern
public class Singleton implements Serializable, Cloneable {
  private static volatile Singleton instance;
  private Singleton() {
    if(instance != null) {
      
    }
  }
  public static Singleton getInstance() {
    Singleton localInst = instance;
    if(localInst == null) {
      synchronized(Singleton.class) {
        if(instance == null) {
          instance = new Singleton();
          localInst = instance;
        }
      }
    }
    return localInst;
  }
  
  protected Object readResolve() {
      return getInstance();
  }
  
  @Override
  protected Object clone() throws CloneNotSupportedException {
      /*
       * Here forcibly throws the exception for preventing to be cloned
       */
      throw new CloneNotSupportedException();
  }
}

class SingletonBillPugh {
  private SingletonBillPugh() {
  }
  private static class SinletonHelper {
      private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
  }
  
  public static SingletonBillPugh getInstance() {
    rerurn SinletonHelper.INSTANCE;
  }
}
