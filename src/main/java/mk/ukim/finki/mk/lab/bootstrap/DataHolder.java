package mk.ukim.finki.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.mk.lab.model.Category;
import mk.ukim.finki.mk.lab.model.Event;
import mk.ukim.finki.mk.lab.model.EventBooking;
import mk.ukim.finki.mk.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = null;
    public static List<EventBooking> eventBookings = null;
    public static List<Category> categories = null;
    public static List<Location> locations = null;

    @PostConstruct
    public void init() {
        events = new ArrayList<>();
        eventBookings = new ArrayList<>();
        categories = new ArrayList<>();
        locations = new ArrayList<>();

        categories.add(new Category("Music"));
        categories.add(new Category("Art"));
        categories.add(new Category("Film"));

        locations.add(new Location("Sunset Art Gallery", "123 Art Lane, Cityville", "50", "A cozy gallery featuring local artists."));
        locations.add(new Location("Heritage Museum", "456 History Ave, Townsville", "200", "A museum showcasing the history and culture of the region."));
        locations.add(new Location("Vineyard View Winery", "789 Vineyard Rd, Countryside", "100", "A scenic winery offering wine tastings and tours."));
        locations.add(new Location("Cultural Center", "101 Arts St, Metropolis", "150", "A community center hosting cultural events and workshops."));
        locations.add(new Location("Old Town Library", "202 Knowledge Blvd, Smalltown", "80", "A historic library with a vast collection of rare books."));

        events.add(new Event("Concert", "A live music performance featuring popular artists.", 85, new Category("Music"), locations.get(0)));
        events.add(new Event("Art Exhibition", "An exhibition showcasing contemporary art from local artists.", 75, new Category("Film"), locations.get(1)));
        events.add(new Event("Food Festival", "A festival celebrating diverse cuisines and local food vendors.", 90, new Category("Art"), locations.get(2)));
        events.add(new Event("Tech Conference", "A conference for tech enthusiasts to discuss the latest innovations.", 78, new Category("Music"), locations.get(3)));
        events.add(new Event("Marathon", "A long-distance running event for athletes of all levels.", 88, new Category("Film"), locations.get(4)));
        events.add(new Event("Theater Play", "A dramatic performance featuring a talented cast.", 80, new Category("Art"), locations.get(0)));
        events.add(new Event("Film Screening", "A special screening of an indie film followed by a Q&A with the director.", 82, new Category("Music"), locations.get(1)));
        events.add(new Event("Book Fair", "A fair featuring authors, publishers, and book signings.", 70, new Category("Film"), locations.get(2)));
        events.add(new Event("Charity Gala", "A formal event to raise funds for a charitable cause.", 91, new Category("Art"), locations.get(3)));
        events.add(new Event("Science Fair", "An exhibition of student projects showcasing scientific research and innovations.", 76, new Category("Music"), locations.get(4)));
    }
}
