package cz.spsmb.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "car")
public class Car implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String model;
    String brand;
    double price;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
