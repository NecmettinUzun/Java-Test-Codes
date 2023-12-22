package patterns.builder;


public class TestCar {

    public static void main(String[] args) {
        
        Car car = new Car.Builder("Renult", "Megane").color("Beyaz").build();
        System.out.println(car);

    }

}
