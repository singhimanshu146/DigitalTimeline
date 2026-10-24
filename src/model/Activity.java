package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Activity {
    private String title;
    private String description;
    private LocalDateTime timestamp;

    public Activity(String title, String description) {
        this.title = title;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Time: " + timestamp.format(formatter));
    }
}
