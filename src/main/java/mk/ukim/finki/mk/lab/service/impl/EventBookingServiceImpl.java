package mk.ukim.finki.mk.lab.service.impl;

import mk.ukim.finki.mk.lab.model.EventBooking;
import mk.ukim.finki.mk.lab.repository.EventBookingRepository;
import mk.ukim.finki.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventBookingServiceImpl implements EventBookingService {
    private final EventBookingRepository eventBookingRepository;

    public EventBookingServiceImpl(EventBookingRepository eventBookingRepository) {
        this.eventBookingRepository = eventBookingRepository;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        return new EventBooking(eventName, attendeeName, attendeeAddress, numberOfTickets);
    }

    @Override
    public void addBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        eventBookingRepository.addBooking(new EventBooking(eventName, attendeeName, attendeeAddress, numberOfTickets));
    }

    @Override
    public List<EventBooking> listAll() {
        return eventBookingRepository.findAll();
    }
}
