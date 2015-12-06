package lab;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by eugeny on 03.12.2015.
 */
public class Toy implements Serializable {
    private String name;
    private String type;
    private int price;
    private int parameter;

    public Toy(String name, String type, int price, int parameter) {
        this.setName(name);
        this.setType(type);
        this.setPrice(price);
        this.setParameter(parameter);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getParameter() {
        return parameter;
    }

    public void setParameter(int parameter) {
        this.parameter = parameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return price == toy.price &&
                parameter == toy.parameter &&
                Objects.equals(name, toy.name) &&
                Objects.equals(type, toy.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, price, parameter);
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", parameter=" + parameter +
                '}';
    }
}
