
import java.util.Scanner;
import model.Activity;
import model.TaskActivity;
import service.FileStorage;
import service.Timeline;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timeline timeline = new Timeline();

        FileStorage.loadActivities(
                timeline.getActivities(),
                "activities.txt"
        );

        boolean running = true;

        System.out.println("===== DIGITAL TIMELINE =====");

        while (running) {
            System.out.println("\n1. Add activity");
            System.out.println("2. Display timeline");
            System.out.println("3. Search activity");
            System.out.println("4. Show completed tasks");
            System.out.println("5. Show pending tasks");
            System.out.println("6. Mark task as completed");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n1. Ordinary activity");
                    System.out.println("2. Task");
                    System.out.print("Choose type: ");

                    String type = scanner.nextLine();

                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    if (type.equals("1")) {
                        Activity activity =
                                new Activity(title, description);

                        timeline.addActivity(activity);
                        System.out.println("Activity added successfully!");

                    } else if (type.equals("2")) {
                        TaskActivity task =
                                new TaskActivity(title, description);

                        System.out.print(
                                "Is this task already completed? (yes/no): "
                        );

                        String status = scanner.nextLine();

                        if (status.equalsIgnoreCase("yes")) {
                            task.markCompleted();
                        }

                        timeline.addActivity(task);
                        System.out.println("Task added successfully!");

                    } else {
                        System.out.println("Invalid activity type.");
                    }
                    break;

                case "2":
                    System.out.println("\n===== YOUR TIMELINE =====");
                    timeline.sortChronologically();
                    timeline.displayTimeline();

                    System.out.println(
                            "Total activities: "
                                    + timeline.getActivityCount()
                    );
                    break;

                case "3":
                    System.out.print("Enter title keyword: ");
                    String keyword = scanner.nextLine();

                    timeline.searchByTitle(keyword);
                    break;

                case "4":
                    System.out.println("\n===== COMPLETED TASKS =====");
                    timeline.filterTasksByStatus(true);
                    break;

                case "5":
                    System.out.println("\n===== PENDING TASKS =====");
                    timeline.filterTasksByStatus(false);
                    break;

                case "6":
                    System.out.print("Enter the task title: ");
                    String taskTitle = scanner.nextLine();

                    boolean taskFound = false;

                    for (Activity item : timeline.getActivities()) {
                        if (item instanceof TaskActivity
                                && item.getTitle().equalsIgnoreCase(taskTitle)) {

                            TaskActivity task = (TaskActivity) item;

                            if (task.isCompleted()) {
                                System.out.println(
                                        "This task is already completed."
                                );
                            } else {
                                task.markCompleted();

                                FileStorage.saveActivities(
                                        timeline.getActivities(),
                                        "activities.txt"
                                );

                                System.out.println(
                                        "Task marked as completed!"
                                );
                            }

                            taskFound = true;
                            break;
                        }
                    }

                    if (!taskFound) {
                        System.out.println("Task not found.");
                    }
                    break;

                case "7":
                    FileStorage.saveActivities(
                            timeline.getActivities(),
                            "activities.txt"
                    );

                    running = false;
                    System.out.println(
                            "Exiting DigitalTimeline. Goodbye!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid option. Please try again."
                    );
            }
        }

        scanner.close();
    }
}
