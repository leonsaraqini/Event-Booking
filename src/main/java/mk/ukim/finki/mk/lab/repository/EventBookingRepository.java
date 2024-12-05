package mk.ukim.finki.mk.lab.repository;

import mk.ukim.finki.mk.lab.bootstrap.DataHolder;
import mk.ukim.finki.mk.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventBookingRepository {
    public List<EventBooking> findAll() {
        return DataHolder.eventBookings;
    }

    public void addBooking(EventBooking eventBooking) {
        DataHolder.eventBookings.add(eventBooking);
    }
}
