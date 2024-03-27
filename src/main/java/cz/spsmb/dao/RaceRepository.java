package cz.spsmb.dao;

import cz.spsmb.model.Race;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class RaceRepository implements PanacheRepository<Race> {
    public List<Race> listByName(String type) {
        return find("type", type).list();
    }}
