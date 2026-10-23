
import model.Activity;
import model.TaskActivity;
import service.Timeline;

public class Main {
    public static void main(String[] args) {
        Timeline timeline = new Timeline();

        Activity activity1 = new Activity(
            "Project Planning",
            "Plan the DigitalTimeline project"
        );

        TaskActivity task1 = new TaskActivity(
            "Learn Java Inheritance",
            "Understand extends and super"
        );

        TaskActivity task2 = new TaskActivity(
            "Build Timeline Service",
            "Store multiple activities"
        );

        task1.markCompleted();

        timeline.addActivity(activity1);
        timeline.addActivity(task1);
        timeline.addActivity(task2);
        timeline.sortChronologically();

        System.out.println("DIGITAL TIMELINE");
        System.out.println("================");

        timeline.displayTimeline();

        System.out.println("Total activities: " + timeline.getActivityCount());
    }
}
