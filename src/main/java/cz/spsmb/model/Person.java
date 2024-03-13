package cz.spsmb.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test-person-table")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long person_id;
    String name;
    int age;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Car> cars = new ArrayList<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Dog> dogs = new ArrayList<>();

    public Person(){};

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public long getId() {
        return person_id;
    }

    public void setId(long id) {
        this.person_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + person_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
