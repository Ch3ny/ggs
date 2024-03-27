package cz.spsmb.dao;

import cz.spsmb.model.Brand;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class BrandRepository implements PanacheRepository<Brand> {


    public List<Brand> listByBrand(String name) {

        return find("name", name).list();
    }
    public Optional<Brand> listByOpBrand(String name){

        return find("name", name).firstResultOptional();
    }

}
