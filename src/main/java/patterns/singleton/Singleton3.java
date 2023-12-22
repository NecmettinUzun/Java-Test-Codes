package patterns.singleton;


public enum Singleton3 {

    INSTANCE;
    
    private int counter;
    
    public int getCounter() {
        return counter++;
    }
    
    
}
