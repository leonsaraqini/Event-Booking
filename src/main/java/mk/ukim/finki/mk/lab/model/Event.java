package mk.ukim.finki.mk.lab.model;

import lombok.Data;

@Data
public class Event {
    private Long id;
    private String name;
    private String description;
    private double popularityScore;
    private Category category;
    private Location location;

    public Event(String name, String description, double popularityScore, Category category, Location location) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.category = category;
        this.location = location;
    }

    public void setEvent(String name, String description, double popularityScore, Location location, Category category){
        this.setName(name);
        this.setDescription(description);
        this.setPopularityScore(popularityScore);
        this.setLocation(location);
        this.setCategory(category);
    }
}
