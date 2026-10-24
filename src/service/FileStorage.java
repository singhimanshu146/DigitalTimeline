package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.Activity;
import model.TaskActivity;

public class FileStorage {

    public static void saveActivities(List<Activity> activities, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            for (Activity activity : activities) {
                String type = "ACTIVITY";
                String completed = "false";

                if (activity instanceof TaskActivity) {
                    type = "TASK";
                    completed = String.valueOf(
                            ((TaskActivity) activity).isCompleted()
                    );
                }

                writer.println(
                        type + "|"
                        + activity.getTitle() + "|"
                        + activity.getDescription() + "|"
                        + activity.getTimestamp() + "|"
                        + completed
                );
            }

            System.out.println("Activities saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving activities: " + e.getMessage());
        }
    }


    
public static void loadActivities(
            List<Activity> activities, String filename) {

        try (BufferedReader reader =
                    new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", -1);

                if (parts.length != 5) {
                    System.out.println("Skipping invalid activity record.");
                    continue;
                }

                String type = parts[0];
                String title = parts[1];
                String description = parts[2];
                LocalDateTime timestamp =
                        LocalDateTime.parse(parts[3]);
                boolean completed = Boolean.parseBoolean(parts[4]);

                Activity activity;

                if (type.equals("TASK")) {
                    TaskActivity task =
                            new TaskActivity(title, description);

                    if (completed) {
                        task.markCompleted();
                    }

                    activity = task;
                } else if (type.equals("ACTIVITY")) {
                    activity = new Activity(title, description);
                } else {
                    System.out.println("Skipping unknown activity type.");
                    continue;
                }

                activity.setTimestamp(timestamp);
                activities.add(activity);
            }

            System.out.println("Activities loaded successfully!");

        } catch (java.io.FileNotFoundException e) {
            System.out.println("No saved activities found. Starting fresh.");
        } catch (java.io.IOException | java.time.format.DateTimeParseException e) {
            System.out.println("Error loading activities: " + e.getMessage());
        }
    }

}
