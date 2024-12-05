package mk.ukim.finki.mk.lab.model.exceptions;

public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException(Long locationId) {
        super(String.format("Location with id %d does not exist.", locationId));
    }
}
