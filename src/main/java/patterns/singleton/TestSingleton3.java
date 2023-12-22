package patterns.singleton;


public class TestSingleton3 {

    public static void main(String[] args) {
        
        System.out.println(Singleton3.INSTANCE.getCounter());

        System.out.println(Singleton3.INSTANCE.getCounter());

    }

}
