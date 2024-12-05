package mk.ukim.finki.mk.lab.web.controller;

import mk.ukim.finki.mk.lab.model.Category;
import mk.ukim.finki.mk.lab.model.Event;
import mk.ukim.finki.mk.lab.model.Location;
import mk.ukim.finki.mk.lab.service.EventService;
import mk.ukim.finki.mk.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/edit-events")
public class EditEventController {
    private final EventService eventService;
    private final LocationService locationService;

    public EditEventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model){
        List<Event> events = eventService.listAll();
        model.addAttribute("events", events);
        return "editEvents";
    }

    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        this.eventService.deleteById(id);
        return "redirect:/edit-events";
    }

    @PostMapping("/add")
    public String saveEvent(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String popularityScore,
            @RequestParam Long locationId,
            @RequestParam Long categoryId) {
        this.eventService.saveEvent(id,name,description,Double.parseDouble(popularityScore),locationId,categoryId);
        return "redirect:/edit-events";
    }


    @GetMapping("/edit-form/{id}")
    public String editEventPage(@PathVariable Long id, Model model) {
        if (this.eventService.findById(id).isPresent()) {
            Event event = this.eventService.findById(id).get();
            List<Location> locations = locationService.findAll();
            List<Category> categories = eventService.listCategories();
            model.addAttribute("locations", locations);
            model.addAttribute("categories", categories);
            model.addAttribute("event", event);
            return "addEvent";
        }
        return "redirect:/edit-events";
    }

    @GetMapping("/add-form")
    public String getAddMoviePage(Model model) {
        List<Location> locations = locationService.findAll();
        List<Category> categories = eventService.listCategories();
        model.addAttribute("locations", locations);
        model.addAttribute("categories", categories);
        return "addEvent";
    }

}
