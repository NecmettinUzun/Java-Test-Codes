package patterns.builder;

public class Car {

    private final String model;
    private final String name;

    private String       color = "";
    
    public static class Builder {

        private final String model;
        private final String name;

        private String       color = "";

        public Builder(String model, String name) {
            this.model = model;
            this.name = name;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    private Car(Builder builder) {
        this.name = builder.name;
        this.model = builder.model;
        this.color = builder.color;
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", name=" + name + ", color=" + color + "]";
    }

    
    
}
