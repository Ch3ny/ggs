package cz.spsmb.dao;

import cz.spsmb.model.Dog;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class DogRepository implements PanacheRepository<Dog> {

    public List<Dog> listByBrand(String name){

        return find("name", name).list();
    }

    public Dog listById(Long id){
        return findById(id);
    }

}