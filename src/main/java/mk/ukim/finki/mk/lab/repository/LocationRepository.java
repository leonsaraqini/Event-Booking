package mk.ukim.finki.mk.lab.repository;

import mk.ukim.finki.mk.lab.bootstrap.DataHolder;
import mk.ukim.finki.mk.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LocationRepository {
    public List<Location> findAll(){
        return DataHolder.locations;
    }

    public Optional<Location> findById(Long locationId) {
        return DataHolder.locations.stream()
                .filter(i -> i.getId().equals(locationId))
                .findFirst();
    }


}
