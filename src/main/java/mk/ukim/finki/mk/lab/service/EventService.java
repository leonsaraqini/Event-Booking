package mk.ukim.finki.mk.lab.service;
import mk.ukim.finki.mk.lab.model.Category;
import mk.ukim.finki.mk.lab.model.Event;
import mk.ukim.finki.mk.lab.model.Location;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(Long categoryId, String text);
    List<Category> listCategories();
    Optional<Event> findById(Long id);
    void deleteById(Long id);
    Optional<Event> saveEvent(String id,String name, String description, double popularityScore, Long locationId, Long categoryId);
}
