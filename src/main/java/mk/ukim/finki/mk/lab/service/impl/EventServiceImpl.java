package mk.ukim.finki.mk.lab.service.impl;

import mk.ukim.finki.mk.lab.model.Category;
import mk.ukim.finki.mk.lab.model.Event;
import mk.ukim.finki.mk.lab.model.Location;
import mk.ukim.finki.mk.lab.model.exceptions.LocationNotFoundException;
import mk.ukim.finki.mk.lab.repository.EventRepository;
import mk.ukim.finki.mk.lab.repository.LocationRepository;
import mk.ukim.finki.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.nio.InvalidMarkException;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> searchEvents(Long categoryId,String text) {
        return eventRepository.searchEvents(categoryId, text);
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }


    @Override
    public List<Category> listCategories() {
        return eventRepository.findAllCategories();
    }

    @Override
    public Optional<Event> findById(Long id) {
        return this.eventRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.eventRepository.deleteById(id);
    }

    @Override
    public Optional<Event> saveEvent(String id, String name, String description, double popularityScore, Long locationId, Long categoryId) {

        Location location = this.locationRepository
                .findById(locationId)
                .orElseThrow(() -> new LocationNotFoundException(locationId));

        Category category = this.eventRepository
                .findCategoryById(categoryId)
                .orElseThrow(() -> new LocationNotFoundException(locationId));

        return id.isEmpty() ?
                this.eventRepository.saveEvent(name, description, popularityScore, location, category) :
                this.eventRepository.editEvent(id, name, description, popularityScore, location, category);
    }
}
