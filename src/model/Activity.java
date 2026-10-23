package model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Activity {

    private int id;
    private String title;
    private String description;
    private String type;
    private LocalDateTime dateTime;
    private Set<String> tags;
    private String priority;

    public Activity(int id, String title, String description,
                    String type, LocalDateTime dateTime,
                    Set<String> tags, String priority) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.dateTime = dateTime;
        this.tags = new HashSet<>(tags);
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Set<String> getTags() {
        return tags;
    }

    public String getPriority() {
        return priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void displayActivity() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Type: " + type);
        System.out.println("Date & Time: " + dateTime);
        System.out.println("Tags: " + tags);
        System.out.println("Priority: " + priority);
    }
}