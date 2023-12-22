package patterns.singleton;


public class Singleton2 {

    private static final Singleton2 INSTANCE = new Singleton2();
    private int counter = 0;
    
    private Singleton2() {
        System.out.println("Singleton2 cons. called");
    }
    
    public static Singleton2 getInstance() {
        return INSTANCE;
    }
    
    public int getCounter() {
        return counter++;
    }
}
