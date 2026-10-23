
package service;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import model.Activity;

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

    
    public void sortChronologically() {
        activities.sort(
            Comparator.comparing(Activity::getTimestamp)
        );
    }

}
