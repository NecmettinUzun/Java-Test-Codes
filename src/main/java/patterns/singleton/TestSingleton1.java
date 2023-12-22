package patterns.singleton;


public class TestSingleton1 {

    public static void main(String[] args) {
       
        System.out.println(Singleton1.INSTANCE.getCounter());

        System.out.println(Singleton1.INSTANCE.getCounter());
        
        System.out.println(Singleton1.INSTANCE.getCounter());
    }

}
