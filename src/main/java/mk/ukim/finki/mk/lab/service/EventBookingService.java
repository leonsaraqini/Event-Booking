package mk.ukim.finki.mk.lab.service;

import mk.ukim.finki.mk.lab.model.Event;
import mk.ukim.finki.mk.lab.model.EventBooking;

import java.util.List;

public interface EventBookingService{
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets);
    void addBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets);
    List<EventBooking> listAll();
}
