package mk.ukim.finki.mk.lab.repository;

import mk.ukim.finki.mk.lab.bootstrap.DataHolder;
import mk.ukim.finki.mk.lab.model.Category;
import mk.ukim.finki.mk.lab.model.Event;
import mk.ukim.finki.mk.lab.model.Location;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class EventRepository {

    public List<Event> findAll() {
        return DataHolder.events;
    }

    public List<Category> findAllCategories() {
        return DataHolder.categories;
    }

    public Optional<Event> findById(Long id){
        return DataHolder.events.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public List<Event> searchEvents(Long categoryId,String text){
        return DataHolder.events
                .stream()
                .filter(e -> Objects.equals(e.getCategory().getId(), categoryId))
                .toList();
    }


    public void deleteById(Long id) {
        DataHolder.events.removeIf(i -> i.getId().equals(id));
    }

    public Optional<Event> saveEvent(String name, String description, double popularityScore, Location location, Category category) {
        if(location == null) {
            throw new IllegalArgumentException();
        }

        Event event = new Event(name, description, popularityScore, category,location);
        DataHolder.events.add(event);

        return Optional.of(event);
    }

    public Optional<Event> editEvent(String id,String name, String description, double popularityScore, Location location, Category category) {
        if(location == null) {
            throw new IllegalArgumentException();
        }

        Long eventId = Long.parseLong(id);
        Event event = DataHolder.events.stream().filter(e-> e.getId().equals(eventId)).findFirst().get();
        event.setEvent(name, description, popularityScore, location, category);

        return Optional.of(event);
    }

    public Optional<Category> findCategoryById(Long categoryId) {
        return DataHolder.categories.stream()
                .filter(i -> i.getId().equals(categoryId))
                .findFirst();
    }
}
