package cz.spsmb.dao;

import cz.spsmb.model.Car;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {
    public List<Car> listByBrand(String brand) {
        return find("brand", brand).list();
    }
    public Optional<Car> listOp(String brand) {
        return find("brand", brand).singleResultOptional();
    }

}