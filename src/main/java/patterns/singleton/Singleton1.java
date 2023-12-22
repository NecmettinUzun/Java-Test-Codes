package patterns.singleton;


public class Singleton1 {

    public static final Singleton1 INSTANCE = new Singleton1();
    private int counter = 0;
    
    private Singleton1() {
        System.out.println("Singleton1 cons. called");
    }
    
    public int getCounter() {
        return counter++;
    }
}
