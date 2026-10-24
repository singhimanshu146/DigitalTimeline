package service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Activity;
import model.TaskActivity;

public class Timeline {
    private List<Activity> activities;

    public Timeline() {
        activities = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void displayTimeline() {
        if (activities.isEmpty()) {
            System.out.println("No activities in the timeline.");
            return;
        }

        for (Activity activity : activities) {
            activity.display();
            System.out.println("--------------------");
        }
    }

    public int getActivityCount() {
        return activities.size();
    }

    public void searchByTitle(String keyword) {
        boolean found = false;

        for (Activity activity : activities) {
            if (activity.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                activity.display();
                System.out.println("--------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No activities found.");
        }
    }


    public void filterTasksByStatus(boolean completed) {
        boolean found = false;

        for (Activity activity : activities) {
            if (activity instanceof TaskActivity) {
                TaskActivity task = (TaskActivity) activity;

                if (task.isCompleted() == completed) {
                    task.display();
                    System.out.println("--------------------");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No matching tasks found.");
        }
    }

    public List<Activity> getActivities() {
        return activities;
    }

    
    public void sortChronologically() {
        activities.sort(
            Comparator.comparing(Activity::getTimestamp)
        );
    }

}
