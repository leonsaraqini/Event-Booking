package mk.ukim.finki.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.mk.lab.model.Category;
import mk.ukim.finki.mk.lab.model.Event;
import mk.ukim.finki.mk.lab.service.EventBookingService;
import mk.ukim.finki.mk.lab.service.EventService;
import mk.ukim.finki.mk.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final EventBookingService eventBookingService;
    private final LocationService locationService;

    public EventController(EventService eventService, EventBookingService eventBookingService, LocationService locationService) {
        this.eventService = eventService;
        this.eventBookingService = eventBookingService;
        this.locationService = locationService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model){
        List<Event> events = eventService.listAll();
        model.addAttribute("events", events);
        return "listEvents";
    }

    @PostMapping("/event-booking")
    public String bookEvent(
            @RequestParam Long eventId,
            @RequestParam Long numOfTickets,
            HttpServletRequest request) {
        Event event = eventService.findById(eventId).get();
        this.eventBookingService.addBooking(event.getName(), request.getRemoteAddr(), "Leon" , numOfTickets);
        return "redirect:/event-booking";
    }

}
