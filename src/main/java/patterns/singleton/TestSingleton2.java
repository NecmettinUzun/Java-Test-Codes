package patterns.singleton;

import java.util.function.Supplier;

public class TestSingleton2 {

    public static void main(String[] args) {
        
        System.out.println(Singleton2.getInstance().getCounter());
        
        System.out.println(Singleton2.getInstance().getCounter());
        
        System.out.println(Singleton2.getInstance().getCounter());

        Supplier<Singleton2> supplier = Singleton2::getInstance;
        System.out.println(supplier.get().getCounter());
    }

}
