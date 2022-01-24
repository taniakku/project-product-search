package domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String brand;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String brand) {
        super(id, name, price);
        this.brand = brand;

    }

    public String getBrand() {
        return brand;
    }

    public void setAuthor(String author) {
        this.brand = brand;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone smartphone = (Smartphone) o;
        return Objects.equals(brand, smartphone.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "brand='" + brand + '}';
    }
}